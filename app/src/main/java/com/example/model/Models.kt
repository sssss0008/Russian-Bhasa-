package com.example.model

enum class LetterType {
    VOWEL, CONSONANT, SIGN
}

data class AlphabetLetter(
    val letter: String,
    val lowerCase: String,
    val nameRussian: String,
    val englishPhonetic: String,
    val nepaliPhonetic: String,
    val type: LetterType,
    val nepaliSoundTip: String,
    val englishSoundTip: String,
    val sampleWordRu: String,
    val sampleWordEn: String,
    val sampleWordNp: String,
    val sampleWordTranslit: String
)

data class VocabularyItem(
    val id: String,
    val russian: String,
    val transliteration: String,
    val nepaliPhonetics: String = "",
    val nepali: String,
    val english: String,
    val categoryId: String,
    val exampleRussian: String = "",
    val exampleNepali: String = "",
    val exampleEnglish: String = ""
)

data class VocabularyCategory(
    val id: String,
    val titleRu: String,
    val titleNp: String,
    val titleEn: String,
    val iconName: String,
    val itemCount: Int = 0
)

data class DialogueLine(
    val speaker: String,
    val russian: String,
    val transliteration: String,
    val nepali: String,
    val english: String
)

data class Dialogue(
    val id: String,
    val titleRu: String,
    val titleNp: String,
    val titleEn: String,
    val situationNp: String,
    val situationEn: String,
    val lines: List<DialogueLine>
)

data class GrammarExample(
    val russian: String,
    val nepali: String,
    val english: String,
    val note: String = ""
)

data class GrammarTopic(
    val id: String,
    val titleRu: String,
    val titleNp: String,
    val titleEn: String,
    val level: String, // Beginner, Elementary, Intermediate
    val overviewNp: String,
    val overviewEn: String,
    val keyPointsNp: List<String>,
    val keyPointsEn: List<String>,
    val examples: List<GrammarExample>
)

enum class CultureCategory {
    TRADITIONS, LANDMARKS, LITERATURE, FESTIVALS, NEPAL_RUSSIA
}

data class CultureWord(
    val russian: String,
    val transliteration: String,
    val nepali: String,
    val english: String
)

data class CultureArticle(
    val id: String,
    val titleRu: String,
    val titleNp: String,
    val titleEn: String,
    val category: CultureCategory,
    val bannerType: String,
    val summaryNp: String,
    val summaryEn: String,
    val contentNp: String,
    val contentEn: String,
    val funFactNp: String,
    val funFactEn: String,
    val keyWords: List<CultureWord>
)

enum class AppLanguageMode {
    TRILINGUAL, // Show Russian + Nepali + English
    NEPALI_FOCUSED, // Focus on Russian + Nepali
    ENGLISH_FOCUSED // Focus on Russian + English
}
