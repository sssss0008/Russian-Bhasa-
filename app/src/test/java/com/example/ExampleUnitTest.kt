package com.example

import com.example.data.AlphabetData
import com.example.data.CultureData
import com.example.data.GrammarData
import com.example.data.PracticeData
import com.example.data.VocabularyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun russianAlphabet_hasExactly33Letters() {
        assertEquals("Russian Cyrillic alphabet must contain exactly 33 letters", 33, AlphabetData.letters.size)
        // Verify each letter has Russian, English, and Nepali phonetics
        AlphabetData.letters.forEach { letter ->
            assertFalse("Letter representation must not be empty", letter.letter.isEmpty())
            assertFalse("Nepali phonetic must not be empty", letter.nepaliPhonetic.isEmpty())
            assertFalse("English phonetic must not be empty", letter.englishPhonetic.isEmpty())
            assertFalse("Sample word must not be empty", letter.sampleWordRu.isEmpty())
        }
    }

    @Test
    fun vocabularyData_hasComprehensiveBilingualEntries() {
        assertTrue("Vocabulary must have 10 or more categories", VocabularyData.categories.size >= 10)
        assertTrue("Vocabulary words count must exceed 50", VocabularyData.words.size >= 50)
        
        VocabularyData.words.forEach { word ->
            assertFalse("Russian word cannot be empty", word.russian.isEmpty())
            assertFalse("Nepali translation cannot be empty", word.nepali.isEmpty())
            assertFalse("English translation cannot be empty", word.english.isEmpty())
            assertFalse("Transliteration cannot be empty", word.transliteration.isEmpty())
            assertNotNull("Category must exist", VocabularyData.categories.find { it.id == word.categoryId })
        }
    }

    @Test
    fun grammarData_containsCoreRussianTopics() {
        assertTrue("Grammar topics must be present", GrammarData.topics.isNotEmpty())
        GrammarData.topics.forEach { topic ->
            assertFalse("Grammar title Ru must not be empty", topic.titleRu.isEmpty())
            assertFalse("Grammar title Np must not be empty", topic.titleNp.isEmpty())
            assertTrue("Grammar must have examples", topic.examples.isNotEmpty())
        }
    }

    @Test
    fun cultureArticles_includeNepalRussiaAndTraditions() {
        assertTrue("Culture articles must exist", CultureData.articles.size >= 5)
        val hasNepalRussia = CultureData.articles.any { it.id == "c_nepal_russia" }
        assertTrue("Culture must contain Nepal-Russia article", hasNepalRussia)
        val hasMatryoshka = CultureData.articles.any { it.id == "c_matryoshka" }
        assertTrue("Culture must contain Matryoshka article", hasMatryoshka)
    }

    @Test
    fun practiceData_hasValidQuizOptions() {
        assertTrue("Quiz questions must be populated", PracticeData.quizQuestions.isNotEmpty())
        PracticeData.quizQuestions.forEach { q ->
            assertTrue("Correct index must be within options range", q.correctIndex in q.options.indices)
            assertFalse("Explanation Np cannot be empty", q.explanationNp.isEmpty())
        }
    }
}
