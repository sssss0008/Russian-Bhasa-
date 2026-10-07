package com.example.data

import com.example.model.Dialogue
import com.example.model.DialogueLine

object DialoguesData {
    val dialogues = listOf(
        Dialogue(
            id = "d_meeting",
            titleRu = "Знакомство: Непал и Россия",
            titleNp = "परिचय: नेपाली र रुसी मित्रको भेट",
            titleEn = "Meeting: A Nepali & Russian Friend",
            situationNp = "मस्को विश्वविद्यालयमा नेपाली विद्यार्थी र रुसी साथीबीच पहिलो भेट।",
            situationEn = "First meeting between a Nepali student and a Russian local in Moscow.",
            lines = listOf(
                DialogueLine(
                    speaker = "इभान (Ivan)",
                    russian = "Привет! Меня зовут Иван. А тебя?",
                    transliteration = "Privet! Menya zovut Ivan. A tebya?",
                    nepali = "हेल्लो! मेरो नाम इभान हो। अनि तिम्रो?",
                    english = "Hi! My name is Ivan. And yours?"
                ),
                DialogueLine(
                    speaker = "आविष्कार (Awiskar)",
                    russian = "Привет, Иван! Меня зовут Авишкар. Я из Непала.",
                    transliteration = "Privet, Ivan! Menya zovut Avishkar. Ya iz Nepala.",
                    nepali = "नमस्ते इभान! मेरो नाम आविष्कार हो। म नेपालबाट आएको हुँ।",
                    english = "Hi, Ivan! My name is Awiskar. I am from Nepal."
                ),
                DialogueLine(
                    speaker = "इभान (Ivan)",
                    russian = "Очень приятно! Непал — удивительная страна с Гималаями!",
                    transliteration = "Ochen' priyatno! Nepal — udivitel'naya strana s Gimalayami!",
                    nepali = "भेटेर धेरै खुसी लाग्यो! नेपाल हिमालले भरिएको अचम्मको सुन्दर देश हो!",
                    english = "Pleased to meet you! Nepal is an amazing country with the Himalayas!"
                ),
                DialogueLine(
                    speaker = "आविष्कार (Awiskar)",
                    russian = "Спасибо! А мне очень нравится Москва и русский язык.",
                    transliteration = "Spasibo! A mne ochen' nravitsya Moskva i russkiy yazyk.",
                    nepali = "धन्यवाद! अनि मलाई मस्को सहर र रुसी भाषा धेरै मन पर्छ।",
                    english = "Thank you! And I really like Moscow and the Russian language."
                )
            )
        ),
        DialogueLine(
            speaker = "",
            russian = "",
            transliteration = "",
            nepali = "",
            english = ""
        ).let {
            Dialogue(
                id = "d_cafe",
                titleRu = "В русском кафе",
                titleNp = "रुसी क्याफेमा चिया र पेल्मेनी अर्डर",
                titleEn = "In a Russian Traditional Cafe",
                situationNp = "क्याफेमा वेटरसँग चिया र खाना मगाउँदा।",
                situationEn = "Ordering hot tea and dumplings from a cafe waiter.",
                lines = listOf(
                    DialogueLine(
                        speaker = "वेटर (Waiter)",
                        russian = "Добрый день! Что будете заказывать?",
                        transliteration = "Dobryy den'! Chto budete zakazyvat'?",
                        nepali = "शुभ दिन! तपाईं के अर्डर गर्नुहुन्छ?",
                        english = "Good day! What would you like to order?"
                    ),
                    DialogueLine(
                        speaker = "ग्राहक (Guest)",
                        russian = "Здравствуйте! Пожалуйста, один чёрный чай с лимоном и пельмени.",
                        transliteration = "Zdravstvuyte! Pozhaluysta, odin chornyy chay s limonom i pel'meni.",
                        nepali = "नमस्कार! कृपया, एक कप कागती हालेको कालो चिया र एक प्लेट पेल्मेनी दिनुहोस्।",
                        english = "Hello! Please, one black tea with lemon and pelmeni."
                    ),
                    DialogueLine(
                        speaker = "वेटर (Waiter)",
                        russian = "Отличный выбор! Пельмени со сметаной?",
                        transliteration = "Otlichnyy vybor! Pel'meni so smetanoy?",
                        nepali = "उत्कृष्ट रोजाइ! पेल्मेनीमा अमिलो क्रिम (स्मेताना) राख्ने?",
                        english = "Great choice! Pelmeni with sour cream (smetana)?"
                    ),
                    DialogueLine(
                        speaker = "ग्राहक (Guest)",
                        russian = "Да, конечно. Большое спасибо!",
                        transliteration = "Da, konechno. Bol'shoye spasibo!",
                        nepali = "हजुर, अवश्य। धेरै धेरै धन्यवाद!",
                        english = "Yes, of course. Thank you very much!"
                    )
                )
            )
        },
        Dialogue(
            id = "d_metro",
            titleRu = "Как пройти на Красную площадь?",
            titleNp = "रेड स्क्वायर र मेट्रोको बाटो सोध्ने",
            titleEn = "Finding Directions to Red Square",
            situationNp = "मस्कोको सडकमा बाटो सोध्दा।",
            situationEn = "Asking a passerby for directions to the Red Square.",
            lines = listOf(
                DialogueLine(
                    speaker = "पर्यटक (Tourist)",
                    russian = "Извините, пожалуйста! Где находится станция метро?",
                    transliteration = "Izvinite, pozhaluysta! Gde nakhoditsya stantsiya metro?",
                    nepali = "माफ गर्नुहोस्, कृपया! मेट्रो स्टेसन कहाँ पर्छ?",
                    english = "Excuse me, please! Where is the metro station located?"
                ),
                DialogueLine(
                    speaker = "स्थानीय (Local)",
                    russian = "Идите прямо двести метров, потом поверните направо.",
                    transliteration = "Idite pryamo dvesti metrov, potom povernite napravo.",
                    nepali = "सिधै २०० मिटर जानुहोस्, त्यसपछि दायाँ मोडिनुहोस्।",
                    english = "Go straight 200 meters, then turn right."
                ),
                DialogueLine(
                    speaker = "पर्यटक (Tourist)",
                    russian = "А оттуда можно дойти до Красной площади?",
                    transliteration = "A ottuda mozhno doyti do Krasnoy ploshchadi?",
                    nepali = "अनि त्यहाँबाट रेड स्क्वायर पुग्न सकिन्छ?",
                    english = "And from there can I walk to the Red Square?"
                ),
                DialogueLine(
                    speaker = "स्थानीय (Local)",
                    russian = "Да, это совсем рядом! Приятной прогулки!",
                    transliteration = "Da, eto sovsem ryadom! Priyatnoy progulki!",
                    nepali = "हजुर, त्यो एकदमै नजिकै छ! घुमघाम रमाइलो होस्!",
                    english = "Yes, it is very close! Have a nice walk!"
                )
            )
        )
    )
}
