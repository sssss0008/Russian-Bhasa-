package com.example.data

data class QuizQuestion(
    val id: String,
    val questionRu: String,
    val questionNp: String,
    val questionEn: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationNp: String,
    val explanationEn: String,
    val audioSnippet: String = ""
)

data class MatchPair(
    val id: String,
    val russian: String,
    val transliteration: String,
    val meaningNp: String,
    val meaningEn: String
)

object PracticeData {
    val quizQuestions = listOf(
        QuizQuestion(
            id = "q1",
            questionRu = "Что означает «Здравствуйте»?",
            questionNp = "रुसी शब्द «Здравствуйте» को नेपाली अर्थ के हो?",
            questionEn = "What does the Russian word 'Здравствуйте' mean?",
            options = listOf("धन्यवाद (Thank you)", "नमस्ते / नमस्कार (Hello)", "शुभ रात्री (Good night)", "अलविदा (Goodbye)"),
            correctIndex = 1,
            explanationNp = "«Здравствуйте» (Zdrastvuyte) भनेको रुसी भाषामा औपचारिक 'नमस्ते' हो।",
            explanationEn = "'Здравствуйте' (Zdrastvuyte) is the formal Russian greeting meaning 'Hello'.",
            audioSnippet = "Здравствуйте"
        ),
        QuizQuestion(
            id = "q2",
            questionRu = "Какая русская буква звучит как «Р» (र)?",
            questionNp = "नेपाली 'र' (Rolled R) ध्वनि जनाउने रुसी सिरिलिक अक्षर कुन हो?",
            questionEn = "Which Cyrillic letter produces the rolled 'R' sound?",
            options = listOf("П", "Р", "В", "Б"),
            correctIndex = 1,
            explanationNp = "सिरिलिक अक्षर 'Р' (हेरौँदा अंग्रेजी P जस्तो) ले 'र' को आवाज दिन्छ!",
            explanationEn = "The Cyrillic letter 'Р' looks like Latin 'P' but sounds like rolled 'R'.",
            audioSnippet = "Россия"
        ),
        QuizQuestion(
            id = "q3",
            questionRu = "Как по-русски будет «Чай»?",
            questionNp = "नेपालीमा 'चिया' लाई रुसी भाषामा के भनिन्छ?",
            questionEn = "How do you say 'Tea' in Russian?",
            options = listOf("Кофе (Kofe)", "Вода (Voda)", "Чай (Chay)", "Хлеб (Khleb)"),
            correctIndex = 2,
            explanationNp = "रुसी र नेपाली दुवै भाषामा 'चाय' (Chay) भनिन्छ!",
            explanationEn = "In Russian, tea is 'Чай' (Chay), very similar to Nepali 'Chiya'!",
            audioSnippet = "Чай"
        ),
        QuizQuestion(
            id = "q4",
            questionRu = "Какое число означает «Пять»?",
            questionNp = "रुसी शब्द «Пять» ले कुन संख्यालाई जनाउँछ?",
            questionEn = "What number does 'Пять' represent?",
            options = listOf("तीन (3)", "चार (4)", "पाँच (5)", "दश (10)"),
            correctIndex = 2,
            explanationNp = "«Пять» (Pyat') भनेको संख्या ५ (पाँच) हो।",
            explanationEn = "'Пять' (Pyat') means the number 5 (Five).",
            audioSnippet = "Пять"
        ),
        QuizQuestion(
            id = "q5",
            questionRu = "Что означает «Спасибо»?",
            questionNp = "«Спасибо» (Spasibo) को सही अर्थ छान्नुहोस्:",
            questionEn = "Choose the correct meaning of 'Спасибо' (Spasibo):",
            options = listOf("माफ गर्नुहोस् (Sorry)", "कृपया (Please)", "धन्यवाद (Thank you)", "स्वागत छ (Welcome)"),
            correctIndex = 2,
            explanationNp = "«Спасибо» (Spasibo) को अर्थ 'धन्यवाद' हो।",
            explanationEn = "'Спасибо' (Spasibo) means 'Thank you'.",
            audioSnippet = "Спасибо"
        ),
        QuizQuestion(
            id = "q6",
            questionRu = "Какая русская еда похожа на непальские Момо?",
            questionNp = "नेपाली मःम (Momo) सँग धेरै मिल्दोजुल्दो रुसी परिकार कुन हो?",
            questionEn = "Which Russian dish is very similar to Nepali Momo dumplings?",
            options = listOf("Борщ (Borscht)", "Пельмени (Pelmeni)", "Блины (Blini)", "Каша (Kasha)"),
            correctIndex = 1,
            explanationNp = "«Пельмени» (Pelmeni) किमा भरिएको रुसी डम्पलिङ हो, जुन नेपाली मःम जस्तै हुन्छ!",
            explanationEn = "'Пельмени' (Pelmeni) are traditional minced meat dumplings just like momos!",
            audioSnippet = "Пельмени"
        ),
        QuizQuestion(
            id = "q7",
            questionRu = "Какая буква означает звук «Ж» (झ/zh)?",
            questionNp = "नेपाली 'झ' (zh) जस्तै घर्षण ध्वनिको लागि कुन सिरिलिक अक्षर प्रयोग हुन्छ?",
            questionEn = "Which letter represents the 'zh' (as in pleasure) sound?",
            options = listOf("Ж", "Ш", "Щ", "Ч"),
            correctIndex = 0,
            explanationNp = "अक्षर 'Ж' (Zheh) ले 'झ' वा 'zh' को आवाज दिन्छ (जस्तै 'Женщина' - महिला)।",
            explanationEn = "Letter 'Ж' (Zheh) makes the sound 'zh' (like 's' in measure).",
            audioSnippet = "Ж"
        ),
        QuizQuestion(
            id = "q8",
            questionRu = "Что означает фраза «Я тебя люблю»?",
            questionNp = "«Я тебя люблю» को अर्थ के हो?",
            questionEn = "What does 'Я тебя люблю' mean?",
            options = listOf("म तिमीलाई माया गर्छु (I love you)", "मेरो नाम इभान हो", "म घर जाँदैछु", "तिमीलाई भेटेर खुसी लाग्यो"),
            correctIndex = 0,
            explanationNp = "«Я тебя люблю» (Ya tebya lyublyu) को अर्थ 'म तिमीलाई माया गर्छु' (I love you) हो।",
            explanationEn = "'Я тебя люблю' (Ya tebya lyublyu) means 'I love you'.",
            audioSnippet = "Я тебя люблю"
        )
    )

    val matchPairs = listOf(
        MatchPair("m1", "Дом", "Dom", "घर", "House"),
        MatchPair("m2", "Вода", "Voda", "पानी", "Water"),
        MatchPair("m3", "Книга", "Kniga", "किताब", "Book"),
        MatchPair("m4", "Друг", "Drug", "साथी", "Friend"),
        MatchPair("m5", "Мама", "Mama", "आमा", "Mother"),
        MatchPair("m6", "Город", "Gorod", "सहर", "City"),
        MatchPair("m7", "Хлеб", "Khleb", "रोटी", "Bread"),
        MatchPair("m8", "Непал", "Nepal", "नेपाल", "Nepal")
    )
}
