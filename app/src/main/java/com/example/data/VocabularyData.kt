package com.example.data

import com.example.model.VocabularyCategory
import com.example.model.VocabularyItem

object VocabularyData {
    val categories = listOf(
        VocabularyCategory(
            id = "greetings",
            titleRu = "Приветствия",
            titleNp = "अभिवादन र शिष्टाचार",
            titleEn = "Greetings & Politeness",
            iconName = "WAVING_HAND",
            itemCount = 12
        ),
        VocabularyCategory(
            id = "numbers",
            titleRu = "Числа и счёт",
            titleNp = "संख्याहरू र गणना",
            titleEn = "Numbers & Counting",
            iconName = "NUMBERS",
            itemCount = 14
        ),
        VocabularyCategory(
            id = "essential",
            titleRu = "Важные фразы",
            titleNp = "दैनिक आवश्यक वाक्यहरू",
            titleEn = "Essential Daily Phrases",
            iconName = "CHAT",
            itemCount = 12
        ),
        VocabularyCategory(
            id = "food",
            titleRu = "Еда и напитки",
            titleNp = "खाना र पेय पदार्थ",
            titleEn = "Food, Tea & Dining",
            iconName = "RESTAURANT",
            itemCount = 14
        ),
        VocabularyCategory(
            id = "travel",
            titleRu = "Путешествия и транспорт",
            titleNp = "यात्रा र यातायात",
            titleEn = "Travel & Transport",
            iconName = "FLIGHT",
            itemCount = 12
        ),
        VocabularyCategory(
            id = "family",
            titleRu = "Семья и люди",
            titleNp = "परिवार र मानिसहरू",
            titleEn = "Family & People",
            iconName = "PEOPLE",
            itemCount = 12
        ),
        VocabularyCategory(
            id = "time",
            titleRu = "Время и погода",
            titleNp = "समय, दिन र मौसम",
            titleEn = "Time & Weather",
            iconName = "SCHEDULE",
            itemCount = 12
        ),
        VocabularyCategory(
            id = "emergency",
            titleRu = "Помощь и безопасность",
            titleNp = "मद्दत र आपतकालीन",
            titleEn = "Emergency & Help",
            iconName = "LOCAL_HOSPITAL",
            itemCount = 10
        ),
        VocabularyCategory(
            id = "shopping",
            titleRu = "Покупки и деньги",
            titleNp = "किनमेल र पैसा",
            titleEn = "Shopping & Money",
            iconName = "SHOPPING_BAG",
            itemCount = 10
        ),
        VocabularyCategory(
            id = "nepal_russia",
            titleRu = "Непал и Россия",
            titleNp = "नेपाल र रुस सम्बन्ध",
            titleEn = "Nepal & Russia Ties",
            iconName = "PUBLIC",
            itemCount = 8
        )
    )

    val words = listOf(
        // Greetings
        VocabularyItem(
            id = "gr_1",
            russian = "Здравствуйте",
            transliteration = "Zdrávstvuyte",
            nepaliPhonetics = "ज्द्रास्त-वुइते",
            nepali = "नमस्ते / नमस्कार (औपचारिक)",
            english = "Hello / Greetings (Formal)",
            categoryId = "greetings",
            exampleRussian = "Здравствуйте, как поживаете?",
            exampleNepali = "नमस्कार, आरामै हुनुहुन्छ?",
            exampleEnglish = "Hello, how are you doing?"
        ),
        VocabularyItem(
            id = "gr_2",
            russian = "Привет",
            transliteration = "Privét",
            nepaliPhonetics = "प्रिवेत",
            nepali = "हेल्लो / नमस्ते (साथीभाइसँग)",
            english = "Hi / Hey (Informal)",
            categoryId = "greetings",
            exampleRussian = "Привет, мой друг!",
            exampleNepali = "हेल्लो, मेरो साथी!",
            exampleEnglish = "Hi, my friend!"
        ),
        VocabularyItem(
            id = "gr_3",
            russian = "Доброе утро",
            transliteration = "Dóbroye útro",
            nepaliPhonetics = "दोब्रोए उत्रो",
            nepali = "शुभ प्रभात / बिहानीको नमस्कार",
            english = "Good morning",
            categoryId = "greetings",
            exampleRussian = "Доброе утро, страна!",
            exampleNepali = "शुभ प्रभात, देशवासी!",
            exampleEnglish = "Good morning, country!"
        ),
        VocabularyItem(
            id = "gr_4",
            russian = "Добрый день",
            transliteration = "Dóbryy den'",
            nepaliPhonetics = "दोब्री देन",
            nepali = "शुभ दिन / दिउँसोको नमस्कार",
            english = "Good afternoon / Good day",
            categoryId = "greetings",
            exampleRussian = "Добрый день, господин!",
            exampleNepali = "शुभ दिन, महोदय!",
            exampleEnglish = "Good day, sir!"
        ),
        VocabularyItem(
            id = "gr_5",
            russian = "Добрый вечер",
            transliteration = "Dóbryy vécher",
            nepaliPhonetics = "दोब्री व्येचेर",
            nepali = "शुभ सन्ध्या",
            english = "Good evening",
            categoryId = "greetings",
            exampleRussian = "Добрый вечер всем!",
            exampleNepali = "सबैलाई शुभ सन्ध्या!",
            exampleEnglish = "Good evening to all!"
        ),
        VocabularyItem(
            id = "gr_6",
            russian = "Спокойной ночи",
            transliteration = "Spokóynoy nóchi",
            nepaliPhonetics = "स्पाकोइनोइ नोची",
            nepali = "शुभ रात्री (सुत्ने बेला)",
            english = "Good night",
            categoryId = "greetings",
            exampleRussian = "Спокойной ночи и приятных снов!",
            exampleNepali = "शुभ रात्री र मीठो सपना!",
            exampleEnglish = "Good night and sweet dreams!"
        ),
        VocabularyItem(
            id = "gr_7",
            russian = "До свидания",
            transliteration = "Do svidániya",
            nepaliPhonetics = "दा स्भिदानिया",
            nepali = "फेरि भेटौँला / बिदा (औपचारिक)",
            english = "Goodbye (Formal)",
            categoryId = "greetings",
            exampleRussian = "Спасибо за урок, до свидания!",
            exampleNepali = "पाठको लागि धन्यवाद, फेरि भेटौँला!",
            exampleEnglish = "Thank you for lesson, goodbye!"
        ),
        VocabularyItem(
            id = "gr_8",
            russian = "Пока",
            transliteration = "Paká",
            nepaliPhonetics = "पाका",
            nepali = "बाइ-बाइ (अनौपचारिक)",
            english = "Bye (Informal)",
            categoryId = "greetings",
            exampleRussian = "Пока, увидимся завтра!",
            exampleNepali = "बाइ-बाइ, भोलि भेटौँला!",
            exampleEnglish = "Bye, see you tomorrow!"
        ),
        VocabularyItem(
            id = "gr_9",
            russian = "Спасибо",
            transliteration = "Spasíba",
            nepaliPhonetics = "स्पासिबा",
            nepali = "धन्यवाद",
            english = "Thank you",
            categoryId = "greetings",
            exampleRussian = "Большое спасибо за помощь!",
            exampleNepali = "मद्दतको लागि धेरै धेरै धन्यवाद!",
            exampleEnglish = "Thank you very much for help!"
        ),
        VocabularyItem(
            id = "gr_10",
            russian = "Пожалуйста",
            transliteration = "Pazhálouysta",
            nepaliPhonetics = "पजालुइस्ता",
            nepali = "कृपया / स्वागत छ (You're welcome)",
            english = "Please / You are welcome",
            categoryId = "greetings",
            exampleRussian = "Пожалуйста, садитесь.",
            exampleNepali = "कृपया, बस्नुहोस्।",
            exampleEnglish = "Please, sit down."
        ),
        VocabularyItem(
            id = "gr_11",
            russian = "Извините",
            transliteration = "Izviníte",
            nepaliPhonetics = "इज्भिनिते",
            nepali = "माफ गर्नुहोस् (Excuse me/Sorry)",
            english = "Excuse me / I'm sorry",
            categoryId = "greetings",
            exampleRussian = "Извините, где метро?",
            exampleNepali = "माफ गर्नुहोस्, मेट्रो कहाँ छ?",
            exampleEnglish = "Excuse me, where is the metro?"
        ),
        VocabularyItem(
            id = "gr_12",
            russian = "Как дела?",
            transliteration = "Kak delá?",
            nepaliPhonetics = "काक दिला?",
            nepali = "के छ खबर? / कस्तो छ?",
            english = "How are you? / How's it going?",
            categoryId = "greetings",
            exampleRussian = "Привет! Как дела? — Всё отлично!",
            exampleNepali = "हेल्लो! के छ खबर? — सब ठिकठाक छ!",
            exampleEnglish = "Hi! How are you? — Everything is great!"
        ),

        // Numbers
        VocabularyItem(
            id = "num_0",
            russian = "Ноль",
            transliteration = "Nol'",
            nepaliPhonetics = "नोल",
            nepali = "शून्य (०)",
            english = "Zero (0)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_1",
            russian = "Один",
            transliteration = "Odín",
            nepaliPhonetics = "अदिन",
            nepali = "एक (१)",
            english = "One (1)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_2",
            russian = "Два",
            transliteration = "Dva",
            nepaliPhonetics = "द्भा",
            nepali = "दुई (२)",
            english = "Two (2)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_3",
            russian = "Три",
            transliteration = "Tri",
            nepaliPhonetics = "त्रि",
            nepali = "तीन (३)",
            english = "Three (3)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_4",
            russian = "Четыре",
            transliteration = "Chetýre",
            nepaliPhonetics = "चेतिरे",
            nepali = "चार (४)",
            english = "Four (4)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_5",
            russian = "Пять",
            transliteration = "Pyat'",
            nepaliPhonetics = "प्यात्य",
            nepali = "पाँच (५)",
            english = "Five (5)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_6",
            russian = "Шесть",
            transliteration = "Shest'",
            nepaliPhonetics = "शेस्त्य",
            nepali = "छ (६)",
            english = "Six (6)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_7",
            russian = "Семь",
            transliteration = "Sem'",
            nepaliPhonetics = "स्येम्य",
            nepali = "सात (७)",
            english = "Seven (7)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_8",
            russian = "Восемь",
            transliteration = "Vósem'",
            nepaliPhonetics = "भोसेम्य",
            nepali = "आठ (८)",
            english = "Eight (8)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_9",
            russian = "Девять",
            transliteration = "Dévyat'",
            nepaliPhonetics = "द्येभ्यात्य",
            nepali = "नौ (९)",
            english = "Nine (9)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_10",
            russian = "Десять",
            transliteration = "Désyat'",
            nepaliPhonetics = "द्येसियात्य",
            nepali = "दश (१०)",
            english = "Ten (10)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_20",
            russian = "Двадцать",
            transliteration = "Dvátsat'",
            nepaliPhonetics = "द्भातसात",
            nepali = "बीस (२०)",
            english = "Twenty (20)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_50",
            russian = "Пятьдесят",
            transliteration = "Pyat'desyát",
            nepaliPhonetics = "प्यात्दिस्यात",
            nepali = "पचास (५०)",
            english = "Fifty (50)",
            categoryId = "numbers"
        ),
        VocabularyItem(
            id = "num_100",
            russian = "Сто",
            transliteration = "Sto",
            nepaliPhonetics = "स्तो",
            nepali = "सय (१००)",
            english = "One Hundred (100)",
            categoryId = "numbers"
        ),

        // Essential phrases
        VocabularyItem(
            id = "ess_1",
            russian = "Да",
            transliteration = "Da",
            nepaliPhonetics = "दा",
            nepali = "हो / हजुर (Yes)",
            english = "Yes",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_2",
            russian = "Нет",
            transliteration = "Net",
            nepaliPhonetics = "न्येत",
            nepali = "होइन / अहँ (No)",
            english = "No",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_3",
            russian = "Меня зовут...",
            transliteration = "Menyá zavút...",
            nepaliPhonetics = "मिन्या जाभुत...",
            nepali = "मेरो नाम ... हो",
            english = "My name is...",
            categoryId = "essential",
            exampleRussian = "Меня зовут Авишкар.",
            exampleNepali = "मेरो नाम आविष्कार हो।",
            exampleEnglish = "My name is Awiskar."
        ),
        VocabularyItem(
            id = "ess_4",
            russian = "Как вас зовут?",
            transliteration = "Kak vas zavút?",
            nepaliPhonetics = "काक भास जाभुत?",
            nepali = "तपाईंको नाम के हो?",
            english = "What is your name? (Formal)",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_5",
            russian = "Очень приятно",
            transliteration = "Óchen' priyátno",
            nepaliPhonetics = "ओचेन प्रियात्नो",
            nepali = "भेटेर धेरै खुसी लाग्यो",
            english = "Nice to meet you",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_6",
            russian = "Я не понимаю",
            transliteration = "Ya ne panimáyu",
            nepaliPhonetics = "या ने पानिमायु",
            nepali = "मैले बुझिनँ",
            english = "I don't understand",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_7",
            russian = "Вы говорите по-английски?",
            transliteration = "Vy gavaríte pa-anglíyski?",
            nepaliPhonetics = "भी गभारिते पा-अङ्लिस्की?",
            nepali = "तपाईं अंग्रेजी बोल्नुहुन्छ?",
            english = "Do you speak English?",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_8",
            russian = "Я учу русский язык",
            transliteration = "Ya uchú rússkiy yazýk",
            nepaliPhonetics = "या उचु रुस्की याजिक",
            nepali = "म रुसी भाषा सिक्दैछु",
            english = "I am learning Russian language",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_9",
            russian = "Сколько это стоит?",
            transliteration = "Skól'ko éto stóit?",
            nepaliPhonetics = "स्कोल्को एतो स्तोइत?",
            nepali = "यसको कति पर्छ? / मूल्य कति हो?",
            english = "How much does this cost?",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_10",
            russian = "Где туалет?",
            transliteration = "Gde tualét?",
            nepaliPhonetics = "ग्दे तुअलेत?",
            nepali = "शौचालय कहाँ छ?",
            english = "Where is the toilet / restroom?",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_11",
            russian = "Хорошо",
            transliteration = "Kharashó",
            nepaliPhonetics = "खारसो",
            nepali = "राम्रो / ठिक छ / हुन्छ",
            english = "Good / Okay / Fine",
            categoryId = "essential"
        ),
        VocabularyItem(
            id = "ess_12",
            russian = "Плохо",
            transliteration = "Plókha",
            nepaliPhonetics = "प्लोखा",
            nepali = "नराम्रो / खराब",
            english = "Bad",
            categoryId = "essential"
        ),

        // Food & Dining
        VocabularyItem(
            id = "fd_1",
            russian = "Чай",
            transliteration = "Chay",
            nepaliPhonetics = "चाय",
            nepali = "चिया (रुसमा निकै लोकप्रिय)",
            english = "Tea",
            categoryId = "food",
            exampleRussian = "Чай с лимоном, пожалуйста.",
            exampleNepali = "कागती हालेको चिया दिनुहोस्, कृपया।",
            exampleEnglish = "Tea with lemon, please."
        ),
        VocabularyItem(
            id = "fd_2",
            russian = "Кофе",
            transliteration = "Kófe",
            nepaliPhonetics = "कोफे",
            nepali = "कफी",
            english = "Coffee",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_3",
            russian = "Вода",
            transliteration = "Vadá",
            nepaliPhonetics = "भदा",
            nepali = "पानी",
            english = "Water",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_4",
            russian = "Хлеб",
            transliteration = "Khleb",
            nepaliPhonetics = "ख्लेब",
            nepali = "रोटी / पाउरोटी (रुसी संस्कारमा पवित्र)",
            english = "Bread (Sacred in Russian culture)",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_5",
            russian = "Борщ",
            transliteration = "Borshch",
            nepaliPhonetics = "बोर्शच",
            nepali = "बोर्शच (चुकन्दर र मासु/तरकारीको प्रसिद्ध रुसी सुप)",
            english = "Borscht (Traditional beetroot soup)",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_6",
            russian = "Пельмени",
            transliteration = "Pel'méni",
            nepaliPhonetics = "पेलमेनी",
            nepali = "पेलमेनी (नेपाली मःम जस्तै डम्पलिङ)",
            english = "Pelmeni (Russian meat dumplings, similar to Nepali Momo!)",
            categoryId = "food",
            exampleRussian = "Пельмени очень похожи на непальские момо!",
            exampleNepali = "पेलमेनी नेपाली मःम जस्तै देखिन्छ!",
            exampleEnglish = "Pelmeni are very similar to Nepali momos!"
        ),
        VocabularyItem(
            id = "fd_7",
            russian = "Блины",
            transliteration = "Bliný",
            nepaliPhonetics = "ब्लिनी",
            nepali = "ब्लिनी (रुसी पातलो प्यानकेक)",
            english = "Blini (Russian traditional pancakes)",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_8",
            russian = "Рис",
            transliteration = "Ris",
            nepaliPhonetics = "रिस",
            nepali = "चामल / भात",
            english = "Rice",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_9",
            russian = "Мясо",
            transliteration = "Myása",
            nepaliPhonetics = "म्यासा",
            nepali = "मासु",
            english = "Meat",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_10",
            russian = "Сыр",
            transliteration = "Syr",
            nepaliPhonetics = "सिर",
            nepali = "चीज (Cheese)",
            english = "Cheese",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_11",
            russian = "Яблоко",
            transliteration = "Yáblaka",
            nepaliPhonetics = "याब्लाका",
            nepali = "स्याउ",
            english = "Apple",
            categoryId = "food"
        ),
        VocabularyItem(
            id = "fd_12",
            russian = "Приятного аппетита!",
            transliteration = "Priyátnogo appetíta!",
            nepaliPhonetics = "प्रियात्नाभा अपितिता",
            nepali = "खाना मीठो होस्! (Bon appétit)",
            english = "Enjoy your meal!",
            categoryId = "food"
        ),

        // Travel
        VocabularyItem(
            id = "tr_1",
            russian = "Аэропорт",
            transliteration = "Aeropórt",
            nepaliPhonetics = "एएरोपोर्त",
            nepali = "विमानस्थल / एयरपोर्ट",
            english = "Airport",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_2",
            russian = "Метро",
            transliteration = "Metró",
            nepaliPhonetics = "मित्रो",
            nepali = "मेट्रो रेल (मस्कोको मेट्रो दरबार जस्तै सुन्दर)",
            english = "Metro / Subway",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_3",
            russian = "Поезд",
            transliteration = "Póyezd",
            nepaliPhonetics = "पोयेज्द",
            nepali = "रेलगाडी (Train)",
            english = "Train",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_4",
            russian = "Автобус",
            transliteration = "Avtóbus",
            nepaliPhonetics = "आभ्तोबुस",
            nepali = "बस",
            english = "Bus",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_5",
            russian = "Гостиница / Отель",
            transliteration = "Gastínitsa / Otél'",
            nepaliPhonetics = "गास्तिनित्सा / अतेल",
            nepali = "होटल / बास बस्ने ठाउँ",
            english = "Hotel",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_6",
            russian = "Билет",
            transliteration = "Bilét",
            nepaliPhonetics = "बिलेत",
            nepali = "टिकट",
            english = "Ticket",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_7",
            russian = "Паспорт",
            transliteration = "Pásport",
            nepaliPhonetics = "पास्पोर्त",
            nepali = "राहदानी (Passport)",
            english = "Passport",
            categoryId = "travel"
        ),
        VocabularyItem(
            id = "tr_8",
            russian = "Улица",
            transliteration = "Úlitsa",
            nepaliPhonetics = "उलित्सा",
            nepali = "सडक / गल्ली",
            english = "Street",
            categoryId = "travel"
        ),

        // Family
        VocabularyItem(
            id = "fm_1",
            russian = "Семья",
            transliteration = "Sem'yá",
            nepaliPhonetics = "सिम्या",
            nepali = "परिवार",
            english = "Family",
            categoryId = "family"
        ),
        VocabularyItem(
            id = "fm_2",
            russian = "Мама / Мать",
            transliteration = "Máma / Mat'",
            nepaliPhonetics = "मामा / मात्य",
            nepali = "आमा",
            english = "Mother / Mom",
            categoryId = "family"
        ),
        VocabularyItem(
            id = "fm_3",
            russian = "Папа / Отец",
            transliteration = "Pápa / Otéts",
            nepaliPhonetics = "पापा / अतेत्स",
            nepali = "बुबा",
            english = "Father / Dad",
            categoryId = "family"
        ),
        VocabularyItem(
            id = "fm_4",
            russian = "Брат",
            transliteration = "Brat",
            nepaliPhonetics = "ब्रात",
            nepali = "दाजु / भाइ",
            english = "Brother",
            categoryId = "family"
        ),
        VocabularyItem(
            id = "fm_5",
            russian = "Сестра",
            transliteration = "Sestrá",
            nepaliPhonetics = "सिस्त्रा",
            nepali = "दिदी / बहिनी",
            english = "Sister",
            categoryId = "family"
        ),
        VocabularyItem(
            id = "fm_6",
            russian = "Друг",
            transliteration = "Drug",
            nepaliPhonetics = "द्रुग",
            nepali = "साथी (पुरुष साथी)",
            english = "Friend (Male)",
            categoryId = "family"
        ),
        VocabularyItem(
            id = "fm_7",
            russian = "Подруга",
            transliteration = "Padrúga",
            nepaliPhonetics = "पादुरुगा",
            nepali = "साथी (महिला साथी)",
            english = "Friend (Female)",
            categoryId = "family"
        ),

        // Nepal & Russia
        VocabularyItem(
            id = "nr_1",
            russian = "Непал",
            transliteration = "Nepál",
            nepaliPhonetics = "नेपाल",
            nepali = "नेपाल देश",
            english = "Nepal",
            categoryId = "nepal_russia"
        ),
        VocabularyItem(
            id = "nr_2",
            russian = "Россия",
            transliteration = "Rossíya",
            nepaliPhonetics = "रसिया",
            nepali = "रुस देश",
            english = "Russia",
            categoryId = "nepal_russia"
        ),
        VocabularyItem(
            id = "nr_3",
            russian = "Горы",
            transliteration = "Góry",
            nepaliPhonetics = "गोरी",
            nepali = "हिमाल / पहाडहरू",
            english = "Mountains / Himalayas",
            categoryId = "nepal_russia"
        ),
        VocabularyItem(
            id = "nr_4",
            russian = "Дружба",
            transliteration = "Drúzhba",
            nepaliPhonetics = "द्रुझबा",
            nepali = "मित्रता / दोस्ती",
            english = "Friendship",
            categoryId = "nepal_russia",
            exampleRussian = "Вечная дружба между Непалом и Россией!",
            exampleNepali = "नेपाल र रुसबीचको अमर मित्रता!",
            exampleEnglish = "Eternal friendship between Nepal and Russia!"
        ),
        VocabularyItem(
            id = "nr_5",
            russian = "Студент",
            transliteration = "Studént",
            nepaliPhonetics = "स्तुद्येन्त",
            nepali = "विद्यार्थी (रुसमा धेरै नेपाली डाक्टर/इन्जिनियर बन्न पुगेका छन्)",
            english = "Student",
            categoryId = "nepal_russia"
        )
    )
}
