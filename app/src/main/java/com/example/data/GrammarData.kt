package com.example.data

import com.example.model.GrammarExample
import com.example.model.GrammarTopic

object GrammarData {
    val topics = listOf(
        GrammarTopic(
            id = "g_gender",
            titleRu = "Род имён существительных",
            titleNp = "रुसी संज्ञाको लिङ्ग (३ प्रकार)",
            titleEn = "Gender of Nouns (3 Types)",
            level = "आधारभूत (Beginner)",
            overviewNp = "रुसी भाषामा हरेक संज्ञा (Noun) तीनमध्ये कुनै एक लिङ्गमा पर्छ: पुलिङ्ग (Masculine), स्त्रीलिङ्ग (Feminine), वा नपुंसकलिङ्ग (Neuter)। शब्दको अन्तिम अक्षर हेरेर लिङ्ग सजिलै चिन्न सकिन्छ!",
            overviewEn = "In Russian, all nouns belong to one of 3 genders: Masculine, Feminine, or Neuter. You can easily determine the gender by looking at the last letter of the word!",
            keyPointsNp = listOf(
                "पुलिङ्ग (Masculine): व्यञ्जन वर्ण (Consonant) वा 'й' मा टुङ्गिन्छ (जस्तै: Дом - घर, Брат - भाइ)।",
                "स्त्रीलिङ्ग (Feminine): 'а' वा 'я' मा टुङ्गिन्छ (जस्तै: Мама - आमा, Книга - किताब)।",
                "नपुंसकलिङ्ग (Neuter): 'о' वा 'е' मा टुङ्गिन्छ (जस्तै: Окно - झ्याल, Море - समुद्र)।",
                "नरम चिह्न 'ь' मा टुङ्गिने शब्द पुलिङ्ग वा स्त्रीलिङ्ग दुवै हुन सक्छन् (जस्तै: День - दिन = पुलिङ्ग, Ночь - रात = स्त्रीलिङ्ग)।"
            ),
            keyPointsEn = listOf(
                "Masculine nouns end in a consonant or 'й' (e.g. Дом - House, Чай - Tea).",
                "Feminine nouns end in 'а' or 'я' (e.g. Мама - Mom, Россия - Russia).",
                "Neuter nouns end in 'о' or 'е' (e.g. Окно - Window, Кафе - Cafe).",
                "Soft sign 'ь' endings can be masculine or feminine (e.g. День - Day is masc, Ночь - Night is fem)."
            ),
            examples = listOf(
                GrammarExample("Он мой брат", "उहाँ मेरो दाजु हुनुहुन्छ (पुलिङ्ग)", "He is my brother (Masc)"),
                GrammarExample("Она моя мама", "उहाँ मेरी आमा हुनुहुन्छ (स्त्रीलिङ्ग)", "She is my mother (Fem)"),
                GrammarExample("Это моё окно", "यो मेरो झ्याल हो (नपुंसकलिङ्ग)", "This is my window (Neuter)")
            )
        ),
        GrammarTopic(
            id = "g_cases",
            titleRu = "Падежи в русском языке",
            titleNp = "रुसी ६ कारकहरू (The 6 Cases)",
            titleEn = "The 6 Russian Cases (Overview)",
            level = "महत्वपूर्ण (Core Grammar)",
            overviewNp = "रुसी व्याकरणको मुटु भनेकै ६ वटा कारक (Падежи) हुन्। नेपालीमा 'ले, लाई, बाट, को, मा' जस्ता विभक्तिहरू प्रयोग भएजस्तै रुसी भाषामा शब्दको अन्त्य (Suffix) परिवर्तन हुन्छ।",
            overviewEn = "Cases indicate the role of a noun in a sentence. While English uses prepositions and word order, Russian alters word endings according to 6 cases.",
            keyPointsNp = listOf(
                "१. प्रथमा (Именительный): कर्ता कारक (Who/What? - Кто? Что?) -> Иван читает (इभान पढ्छ)।",
                "२. द्वितीया (Винительный): कर्म कारक (Whom/What? - Кого? Что?) -> Я вижу Ивана (मैले इभानलाई देख्छु)।",
                "३. षष्ठी (Родительный): सम्बन्ध कारक (Of/From? - Кого? Чего?) -> Книга Ивана (इभानको किताब)।",
                "४. सम्प्रदान (Дательный): कसलाई दिने? (To whom? - Кому? Чему?) -> Я звоню Ивану (म इभानलाई फोन गर्छु)।",
                "५. तृतीया (Творительный): साधन/सँग (With whom/By what? - Кем? Чем?) -> С Иваном (इभानसँग)।",
                "६. अधिकरण (Предложный): स्थान/बारे (About whom/Where? - О ком? О чём?) -> О Иване (इभानको बारेमा)।"
            ),
            keyPointsEn = listOf(
                "1. Nominative (Именительный): Subject of sentence (Who/What?).",
                "2. Accusative (Винительный): Direct object (Whom/What?).",
                "3. Genitive (Родительный): Possession and absence (Whose/Of what?).",
                "4. Dative (Дательный): Indirect object / Giving (To whom/what?).",
                "5. Instrumental (Творительный): Means and accompaniment (With whom/what?).",
                "6. Prepositional (Предложный): Location or topic (About whom/In where?)."
            ),
            examples = listOf(
                GrammarExample("Я живу в Непале", "म नेपालमा बस्छु (अधिकरण कारक)", "I live in Nepal (Prepositional)"),
                GrammarExample("У меня есть книга", "मसँग किताब छ (षष्ठी कारक निर्माण)", "I have a book (Genitive construction)"),
                GrammarExample("Я пью чай с сахаром", "म चिनीसँग चिया पिउँछु (तृतीया कारक)", "I drink tea with sugar (Instrumental)")
            )
        ),
        GrammarTopic(
            id = "g_verbs",
            titleRu = "Спряжение глаголов",
            titleNp = "क्रियापदको रूप (Conjugation)",
            titleEn = "Present Tense Verb Conjugation",
            level = "व्यावहारिक (Elementary)",
            overviewNp = "रुसी भाषामा क्रियापदहरू मुख्यतया दुई समूहमा बाँडिन्छन्: पहिलो समूह (First Conjugation) र दोस्रो समूह (Second Conjugation)। कर्ता अनुसार क्रियापदको अन्त्य बदलिन्छ।",
            overviewEn = "Russian verbs conjugate according to person (I, you, he/she, we, you all, they). In the present tense, there are two main conjugation classes (-ать verbs and -ить verbs).",
            keyPointsNp = listOf(
                "म (Я): अन्त्यमा -ю वा -у थपिन्छ (Я читаю - म पढ्छु)।",
                "तँ/तिमी (Ты): अन्त्यमा -ешь थपिन्छ (Ты читаешь - तिमी पढ्छौ)।",
                "उनी/उहाँ (Он/Она): अन्त्यमा -ет थपिन्छ (Он читает - उहाँ पढ्नुहुन्छ)।",
                "हामी (Мы): अन्त्यमा -ем थपिन्छ (Мы читаем - हामी पढ्छौँ)।",
                "तपाईंहरू (Вы): अन्त्यमा -ете थपिन्छ (Вы читаете - तपाईंहरू पढ्नुहुन्छ)।",
                "उनीहरू (Они): अन्त्यमा -ют वा -ут थपिन्छ (Они читают - उनीहरू पढ्छन्)।"
            ),
            keyPointsEn = listOf(
                "I (Я): ends in -ю or -у (Я знаю - I know).",
                "You (Ты informal): ends in -ешь or -ишь (Ты знаешь - You know).",
                "He/She (Он/Она): ends in -ет or -ит (Он знает - He knows).",
                "We (Мы): ends in -ем or -им (Мы знаем - We know).",
                "You (Вы formal/plural): ends in -ете or -ите (Вы знаете - You know).",
                "They (Они): ends in -ют, -ут, -ят (Они знают - They know)."
            ),
            examples = listOf(
                GrammarExample("Я говорю по-русски", "म रुसी बोल्छु", "I speak Russian"),
                GrammarExample("Ты понимаешь меня?", "तिमीले मलाई बुझ्छौ?", "Do you understand me?"),
                GrammarExample("Мы любим путешествовать", "हामी यात्रा गर्न मन पराउँछौँ", "We love traveling")
            )
        ),
        GrammarTopic(
            id = "g_politeness",
            titleRu = "Ты и Вы (Вежливость)",
            titleNp = "तिमी (Ты) र तपाईं (Вы) को प्रयोग",
            titleEn = "Informal 'Ты' vs Polite 'Вы'",
            level = "शिष्टाचार (Crucial Culture)",
            overviewNp = "नेपाली संस्कार जस्तै रुसमा पनि अपरिचित व्यक्ति, ठूलाबडा, शिक्षक, डाक्टर र व्यावसायिक व्यक्तिलाई सधैं 'Вы' (तपाईं/हजुर) भनिन्छ। साथीभाइ र सानालाई 'Ты' (तँ/तिमी) भनिन्छ।",
            overviewEn = "Similar to Nepali culture, Russian strictly differentiates between informal 'Ты' (close friends, children) and respectful 'Вы' (strangers, elders, teachers, professionals).",
            keyPointsNp = listOf(
                "नचिनेको वा १८ वर्षभन्दा माथिका जो कोहीलाई पहिलो पटक भेट्दा सधैं 'Вы' प्रयोग गर्नुहोस्।",
                "'Вы' सँग क्रियापदको बहुवचन रूप लाग्छ (जस्तै: Вы говорите - तपाईं बोल्नुहुन्छ)।",
                "आपसी सहमतिमा साथी बन्दा 'Давай на ты' (आऊ अब तिमी भनौँ) भनिन्छ।"
            ),
            keyPointsEn = listOf(
                "Always use 'Вы' with strangers, service workers, and people older than you.",
                "'Вы' takes the plural verb conjugation (e.g. Здравствуйте - polite greeting).",
                "Friends transition to 'ты' by saying 'Давай на ты' (Let's switch to informal 'you')."
            ),
            examples = listOf(
                GrammarExample("Как вас зовут? (Вы)", "तपाईंको नाम के हो? (आदरार्थी)", "What is your name? (Polite)"),
                GrammarExample("Как тебя зовут? (Ты)", "तिम्रो नाम के हो? (अनौपचारिक)", "What is your name? (Casual)")
            )
        )
    )
}
