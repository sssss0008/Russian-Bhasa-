package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Locale

class TtsHelper(private val context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    var isInitialized by mutableStateOf(false)
        private set

    var speechRate by mutableFloatStateOf(0.9f) // Slightly slow for language learners

    init {
        try {
            tts = TextToSpeech(context.applicationContext, this)
        } catch (e: Exception) {
            Log.e("TtsHelper", "Error initializing TTS", e)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val russianLocale = Locale("ru", "RU")
            val result = tts?.setLanguage(russianLocale)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Try generic Russian or fallback
                val genericRu = Locale("ru")
                tts?.setLanguage(genericRu)
            }
            tts?.setSpeechRate(speechRate)
            isInitialized = true
        } else {
            Log.e("TtsHelper", "TextToSpeech initialization failed with status $status")
        }
    }

    fun updateSpeechRate(rate: Float) {
        speechRate = rate
        tts?.setSpeechRate(rate)
    }

    fun speakRussian(text: String) {
        if (!isInitialized || tts == null) return
        val cleanText = text.replace("́", "") // remove stress accents if any
        tts?.setLanguage(Locale("ru", "RU"))
        tts?.setSpeechRate(speechRate)
        tts?.speak(cleanText, TextToSpeech.QUEUE_FLUSH, null, "ru_${System.currentTimeMillis()}")
    }

    fun speakEnglish(text: String) {
        if (!isInitialized || tts == null) return
        tts?.setLanguage(Locale.US)
        tts?.setSpeechRate(speechRate)
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "en_${System.currentTimeMillis()}")
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}
