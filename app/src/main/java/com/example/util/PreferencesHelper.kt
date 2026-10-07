package com.example.util

import android.content.Context
import android.content.SharedPreferences
import com.example.model.AppLanguageMode

class PreferencesHelper(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("russian_bhasa_prefs", Context.MODE_PRIVATE)

    fun getLanguageMode(): AppLanguageMode {
        val name = prefs.getString("language_mode", AppLanguageMode.TRILINGUAL.name)
        return try {
            AppLanguageMode.valueOf(name ?: AppLanguageMode.TRILINGUAL.name)
        } catch (e: Exception) {
            AppLanguageMode.TRILINGUAL
        }
    }

    fun setLanguageMode(mode: AppLanguageMode) {
        prefs.edit().putString("language_mode", mode.name).apply()
    }

    fun getBookmarkedWordIds(): Set<String> {
        return prefs.getStringSet("bookmarked_words", emptySet()) ?: emptySet()
    }

    fun toggleBookmark(wordId: String): Boolean {
        val current = getBookmarkedWordIds().toMutableSet()
        val isAdded: Boolean
        if (current.contains(wordId)) {
            current.remove(wordId)
            isAdded = false
        } else {
            current.add(wordId)
            isAdded = true
        }
        prefs.edit().putStringSet("bookmarked_words", current).apply()
        return isAdded
    }

    fun isBookmarked(wordId: String): Boolean {
        return getBookmarkedWordIds().contains(wordId)
    }

    fun getLearningStreak(): Int {
        return prefs.getInt("learning_streak", 3)
    }

    fun incrementStreak() {
        val current = getLearningStreak()
        prefs.edit().putInt("learning_streak", current + 1).apply()
    }

    fun getQuizzesCompleted(): Int {
        return prefs.getInt("quizzes_completed", 5)
    }

    fun recordQuizCompletion(score: Int) {
        val count = getQuizzesCompleted() + 1
        val totalScore = prefs.getInt("total_quiz_points", 35) + score
        prefs.edit()
            .putInt("quizzes_completed", count)
            .putInt("total_quiz_points", totalScore)
            .apply()
    }

    fun getTotalQuizPoints(): Int {
        return prefs.getInt("total_quiz_points", 35)
    }
}
