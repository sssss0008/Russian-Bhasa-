package com.example.data

import com.example.model.AlphabetLetter
import com.example.model.LetterType

object AlphabetData {
    val letters = listOf(
        AlphabetLetter(
            letter = "А", lowerCase = "а", nameRussian = "а",
            englishPhonetic = "ah", nepaliPhonetic = "आ",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको 'आ' जस्तै उच्चारण हुन्छ (जस्तै 'आमा')",
            englishSoundTip = "Like 'a' in 'father'",
            sampleWordRu = "Автобус", sampleWordEn = "Bus",
            sampleWordNp = "बस (Bus)", sampleWordTranslit = "Avtobus / आभ्तोबुस"
        ),
        AlphabetLetter(
            letter = "Б", lowerCase = "б", nameRussian = "бэ",
            englishPhonetic = "beh", nepaliPhonetic = "ब",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'ब' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'b' in 'bad'",
            sampleWordRu = "Брат", sampleWordEn = "Brother",
            sampleWordNp = "दाजु/भाइ (Brother)", sampleWordTranslit = "Brat / ब्रात"
        ),
        AlphabetLetter(
            letter = "В", lowerCase = "в", nameRussian = "вэ",
            englishPhonetic = "veh", nepaliPhonetic = "भ / व",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'व' वा अंग्रेजीको 'v' जस्तै दाँत ओठमा छोएर उच्चारण हुन्छ",
            englishSoundTip = "Like 'v' in 'voice'",
            sampleWordRu = "Вода", sampleWordEn = "Water",
            sampleWordNp = "पानी (Water)", sampleWordTranslit = "Voda / वदा"
        ),
        AlphabetLetter(
            letter = "Г", lowerCase = "г", nameRussian = "гэ",
            englishPhonetic = "geh", nepaliPhonetic = "ग",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'ग' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'g' in 'go'",
            sampleWordRu = "Город", sampleWordEn = "City",
            sampleWordNp = "सहर (City)", sampleWordTranslit = "Gorod / गोरद"
        ),
        AlphabetLetter(
            letter = "Д", lowerCase = "д", nameRussian = "дэ",
            englishPhonetic = "deh", nepaliPhonetic = "द",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको दन्त्य 'द' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'd' in 'door'",
            sampleWordRu = "Дом", sampleWordEn = "House / Home",
            sampleWordNp = "घर (House)", sampleWordTranslit = "Dom / दोम"
        ),
        AlphabetLetter(
            letter = "Е", lowerCase = "е", nameRussian = "йэ",
            englishPhonetic = "yeh", nepaliPhonetic = "ये",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको 'ये' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'ye' in 'yes'",
            sampleWordRu = "Еда", sampleWordEn = "Food",
            sampleWordNp = "खाना (Food)", sampleWordTranslit = "Yeda / येदा"
        ),
        AlphabetLetter(
            letter = "Ё", lowerCase = "ё", nameRussian = "йо",
            englishPhonetic = "yoh", nepaliPhonetic = "यो",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको 'यो' जस्तै उच्चारण हुन्छ, सधैं जोड दिएर बोलिन्छ",
            englishSoundTip = "Like 'yo' in 'yonder'",
            sampleWordRu = "Ёлка", sampleWordEn = "Fir tree / Christmas tree",
            sampleWordNp = "सल्लोको रुख (Pine/Fir)", sampleWordTranslit = "Yolka / योल्का"
        ),
        AlphabetLetter(
            letter = "Ж", lowerCase = "ж", nameRussian = "жэ",
            englishPhonetic = "zheh", nepaliPhonetic = "झ (zh)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'झ' वा 'zh' जस्तै मन्द घर्षणसहित उच्चारण हुन्छ",
            englishSoundTip = "Like 's' in 'measure' or 'pleasure'",
            sampleWordRu = "Женщина", sampleWordEn = "Woman",
            sampleWordNp = "महिला (Woman)", sampleWordTranslit = "Zhenshchina / झेनश्चिना"
        ),
        AlphabetLetter(
            letter = "З", lowerCase = "з", nameRussian = "зэ",
            englishPhonetic = "zeh", nepaliPhonetic = "ज/ज़ (z)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "अंग्रेजी 'z' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'z' in 'zebra'",
            sampleWordRu = "Здравствуйте", sampleWordEn = "Hello (Formal)",
            sampleWordNp = "नमस्ते (Hello)", sampleWordTranslit = "Zdrastvuyte / ज्‍द्रास्त-वुइते"
        ),
        AlphabetLetter(
            letter = "И", lowerCase = "и", nameRussian = "и",
            englishPhonetic = "ee", nepaliPhonetic = "इ / ई",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको दीर्घ 'ई' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'ee' in 'meet'",
            sampleWordRu = "Имя", sampleWordEn = "Name",
            sampleWordNp = "नाम (Name)", sampleWordTranslit = "Imya / इम्या"
        ),
        AlphabetLetter(
            letter = "Й", lowerCase = "й", nameRussian = "и краткое",
            englishPhonetic = "y (short)", nepaliPhonetic = "य् (छोटो)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको छोटो 'य्' जस्तै (जस्तै 'चाय')",
            englishSoundTip = "Like 'y' in 'boy' or 'coy'",
            sampleWordRu = "Чай", sampleWordEn = "Tea",
            sampleWordNp = "चिया (Tea)", sampleWordTranslit = "Chay / चाय"
        ),
        AlphabetLetter(
            letter = "К", lowerCase = "к", nameRussian = "ка",
            englishPhonetic = "kah", nepaliPhonetic = "क",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'क' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'k' in 'kite'",
            sampleWordRu = "Книга", sampleWordEn = "Book",
            sampleWordNp = "किताब (Book)", sampleWordTranslit = "Kniga / क्सिनिगा"
        ),
        AlphabetLetter(
            letter = "Л", lowerCase = "л", nameRussian = "эль",
            englishPhonetic = "el", nepaliPhonetic = "ल",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'ल' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'l' in 'lamp'",
            sampleWordRu = "Любовь", sampleWordEn = "Love",
            sampleWordNp = "माया / प्रेम (Love)", sampleWordTranslit = "Lyubov / ल्युबोभ"
        ),
        AlphabetLetter(
            letter = "М", lowerCase = "м", nameRussian = "эм",
            englishPhonetic = "em", nepaliPhonetic = "म",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'म' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'm' in 'mother'",
            sampleWordRu = "Мама", sampleWordEn = "Mom / Mother",
            sampleWordNp = "आमा (Mother)", sampleWordTranslit = "Mama / मामा"
        ),
        AlphabetLetter(
            letter = "Н", lowerCase = "н", nameRussian = "эн",
            englishPhonetic = "en", nepaliPhonetic = "न",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'न' जस्तै उच्चारण हुन्छ (अंग्रेजीको H जस्तो देखिन्छ)",
            englishSoundTip = "Like 'n' in 'no'",
            sampleWordRu = "Нет", sampleWordEn = "No",
            sampleWordNp = "होइन / अहँ (No)", sampleWordTranslit = "Net / न्येत"
        ),
        AlphabetLetter(
            letter = "О", lowerCase = "о", nameRussian = "о",
            englishPhonetic = "oh", nepaliPhonetic = "ओ / अ",
            type = LetterType.VOWEL,
            nepaliSoundTip = "जोड हुँदा 'ओ', जोड नहुँदा 'अ' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'o' in 'more' when stressed, 'a' in 'about' unstressed",
            sampleWordRu = "Окно", sampleWordEn = "Window",
            sampleWordNp = "झ्याल (Window)", sampleWordTranslit = "Okno / अक्नो"
        ),
        AlphabetLetter(
            letter = "П", lowerCase = "п", nameRussian = "пэ",
            englishPhonetic = "peh", nepaliPhonetic = "प",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'प' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'p' in 'pen'",
            sampleWordRu = "Привет", sampleWordEn = "Hi / Hello",
            sampleWordNp = "हेल्लो / नमस्ते (Hi)", sampleWordTranslit = "Privet / प्रिवेत"
        ),
        AlphabetLetter(
            letter = "Р", lowerCase = "р", nameRussian = "эр",
            englishPhonetic = "er (rolled)", nepaliPhonetic = "र (कम्पित)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको जिब्रो थर्काएर बोल्ने 'र' (अंग्रेजीको P जस्तो देखिन्छ)",
            englishSoundTip = "Rolled 'r' like in Spanish or Scottish",
            sampleWordRu = "Россия", sampleWordEn = "Russia",
            sampleWordNp = "रुस (Russia)", sampleWordTranslit = "Rossiya / रसिया"
        ),
        AlphabetLetter(
            letter = "С", lowerCase = "с", nameRussian = "эс",
            englishPhonetic = "es", nepaliPhonetic = "स",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'स' जस्तै उच्चारण हुन्छ (अंग्रेजी C जस्तो देखिन्छ)",
            englishSoundTip = "Like 's' in 'sun'",
            sampleWordRu = "Спасибо", sampleWordEn = "Thank you",
            sampleWordNp = "धन्यवाद (Thank you)", sampleWordTranslit = "Spasibo / स्पासिबा"
        ),
        AlphabetLetter(
            letter = "Т", lowerCase = "т", nameRussian = "тэ",
            englishPhonetic = "teh", nepaliPhonetic = "त",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको दन्त्य 'त' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 't' in 'table'",
            sampleWordRu = "Ты", sampleWordEn = "You (informal)",
            sampleWordNp = "तँ / तिमी (You)", sampleWordTranslit = "Ty / ति"
        ),
        AlphabetLetter(
            letter = "У", lowerCase = "у", nameRussian = "у",
            englishPhonetic = "oo", nepaliPhonetic = "उ / ऊ",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको 'ऊ' जस्तै उच्चारण हुन्छ (अंग्रेजी Y जस्तो देखिन्छ)",
            englishSoundTip = "Like 'oo' in 'boot'",
            sampleWordRu = "Утро", sampleWordEn = "Morning",
            sampleWordNp = "बिहानी (Morning)", sampleWordTranslit = "Utro / उत्रो"
        ),
        AlphabetLetter(
            letter = "Ф", lowerCase = "ф", nameRussian = "эф",
            englishPhonetic = "ef", nepaliPhonetic = "फ (f)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "अंग्रेजीको 'f' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'f' in 'fast'",
            sampleWordRu = "Фото", sampleWordEn = "Photo",
            sampleWordNp = "तस्विर (Photo)", sampleWordTranslit = "Foto / फतो"
        ),
        AlphabetLetter(
            letter = "Х", lowerCase = "х", nameRussian = "ха",
            englishPhonetic = "khah", nepaliPhonetic = "ख / ह",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको कण्ठ्य 'ख' वा घाँटीबाट आउने आवाज",
            englishSoundTip = "Like 'ch' in Scottish 'loch'",
            sampleWordRu = "Хорошо", sampleWordEn = "Good / Well / OK",
            sampleWordNp = "राम्रो / ठिक छ (Good/Fine)", sampleWordTranslit = "Khorosho / खारसो"
        ),
        AlphabetLetter(
            letter = "Ц", lowerCase = "ц", nameRussian = "цэ",
            englishPhonetic = "tseh", nepaliPhonetic = "त्स",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "'त्' र 'स' मिलेर बनेको संयुक्त ध्वनि",
            englishSoundTip = "Like 'ts' in 'cats'",
            sampleWordRu = "Центр", sampleWordEn = "Center",
            sampleWordNp = "केन्द्र (Center)", sampleWordTranslit = "Tsentr / त्सेन्त्र"
        ),
        AlphabetLetter(
            letter = "Ч", lowerCase = "ч", nameRussian = "чэ",
            englishPhonetic = "cheh", nepaliPhonetic = "च",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "नेपालीको 'च' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'ch' in 'chair'",
            sampleWordRu = "Час", sampleWordEn = "Hour",
            sampleWordNp = "घण्टा (Hour)", sampleWordTranslit = "Chas / चास"
        ),
        AlphabetLetter(
            letter = "Ш", lowerCase = "ш", nameRussian = "ша",
            englishPhonetic = "shah", nepaliPhonetic = "ष / श (मोटो)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "जिब्रो पछाडि तानेर कडा 'श' उच्चारण गरिन्छ",
            englishSoundTip = "Hard 'sh' like in 'shut'",
            sampleWordRu = "Школа", sampleWordEn = "School",
            sampleWordNp = "विद्यालय (School)", sampleWordTranslit = "Shkola / श्कोला"
        ),
        AlphabetLetter(
            letter = "Щ", lowerCase = "щ", nameRussian = "ща",
            englishPhonetic = "shch", nepaliPhonetic = "श्च / श (नरम)",
            type = LetterType.CONSONANT,
            nepaliSoundTip = "जिब्रो अगाडि राखेर नरम 'श्च' उच्चारण गरिन्छ",
            englishSoundTip = "Soft 'shch' like in 'fresh cheese'",
            sampleWordRu = "Борщ", sampleWordEn = "Borscht (Beetroot Soup)",
            sampleWordNp = "रुसी चुकन्दर सुप (Borscht)", sampleWordTranslit = "Borshch / बोर्शच"
        ),
        AlphabetLetter(
            letter = "Ъ", lowerCase = "ъ", nameRussian = "твёрдый знак",
            englishPhonetic = "Hard sign", nepaliPhonetic = "कडा चिह्न (Hard sign)",
            type = LetterType.SIGN,
            nepaliSoundTip = "यसको आफ्नै ध्वनि हुँदैन, अघिल्लो व्यञ्जनलाई कडा बनाउँछ",
            englishSoundTip = "Silent modifier that prevents softening of preceding consonant",
            sampleWordRu = "Объект", sampleWordEn = "Object",
            sampleWordNp = "वस्तु / परियोजना (Object)", sampleWordTranslit = "Obyekt / अब्येक्त"
        ),
        AlphabetLetter(
            letter = "Ы", lowerCase = "ы", nameRussian = "ы",
            englishPhonetic = "ih / guttural y", nepaliPhonetic = "इ (गहिरो)",
            type = LetterType.VOWEL,
            nepaliSoundTip = "घाँटीको भित्री भागबाट निकालिने गहिरो 'इ'",
            englishSoundTip = "Deep vowel, like 'i' in 'roses' or gut punch sound",
            sampleWordRu = "Мы", sampleWordEn = "We",
            sampleWordNp = "हामी (We)", sampleWordTranslit = "My / मि"
        ),
        AlphabetLetter(
            letter = "Ь", lowerCase = "ь", nameRussian = "мягкий знак",
            englishPhonetic = "Soft sign", nepaliPhonetic = "नरम चिह्न (Soft sign)",
            type = LetterType.SIGN,
            nepaliSoundTip = "यसको आफ्नै आवाज हुँदैन, अघिल्लो व्यञ्जनलाई नरम बनाउँछ",
            englishSoundTip = "Silent modifier that palatalizes / softens the preceding letter",
            sampleWordRu = "Мать", sampleWordEn = "Mother",
            sampleWordNp = "आमा (Mother)", sampleWordTranslit = "Mat' / मात्य"
        ),
        AlphabetLetter(
            letter = "Э", lowerCase = "э", nameRussian = "э оборотное",
            englishPhonetic = "eh", nepaliPhonetic = "ए",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको सिधा 'ए' जस्तै उच्चारण हुन्छ (ये होइन)",
            englishSoundTip = "Like 'e' in 'met' or 'egg'",
            sampleWordRu = "Это", sampleWordEn = "This / It is",
            sampleWordNp = "यो हो (This is)", sampleWordTranslit = "Eto / एतो"
        ),
        AlphabetLetter(
            letter = "Ю", lowerCase = "ю", nameRussian = "йу",
            englishPhonetic = "yoo", nepaliPhonetic = "यु",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको 'यु' जस्तै उच्चारण हुन्छ",
            englishSoundTip = "Like 'u' in 'universe' or 'youth'",
            sampleWordRu = "Юг", sampleWordEn = "South",
            sampleWordNp = "दक्षिण (South)", sampleWordTranslit = "Yug / युग्"
        ),
        AlphabetLetter(
            letter = "Я", lowerCase = "я", nameRussian = "йа",
            englishPhonetic = "yah", nepaliPhonetic = "या / म (I)",
            type = LetterType.VOWEL,
            nepaliSoundTip = "नेपालीको 'या' जस्तै उच्चारण हुन्छ; यसको अर्थ 'म' (I) पनि हुन्छ!",
            englishSoundTip = "Like 'ya' in 'yard'; also means 'I' (first person pronoun)",
            sampleWordRu = "Яблоко", sampleWordEn = "Apple",
            sampleWordNp = "स्याउ (Apple)", sampleWordTranslit = "Yabloko / याब्लोको"
        )
    )
}
