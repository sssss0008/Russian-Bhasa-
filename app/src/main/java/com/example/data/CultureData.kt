package com.example.data

import com.example.model.CultureArticle
import com.example.model.CultureCategory
import com.example.model.CultureWord

object CultureData {
    val articles = listOf(
        CultureArticle(
            id = "c_matryoshka",
            titleRu = "Матрёшка: символ русской души",
            titleNp = "मत्र्योस्का पुतली: रुसी पहिचान र परम्परा",
            titleEn = "Matryoshka: The Russian Nesting Doll",
            category = CultureCategory.TRADITIONS,
            bannerType = "MATRYOSHKA",
            summaryNp = "काठबाट कुँदिएको एउटाभित्र अर्को पुतली अटाउने 'मत्र्योस्का' रुसको विश्वप्रसिद्ध लोककला हो। यो मातृत्व, परिवार र निरन्तरताको प्रतीक मानिन्छ।",
            summaryEn = "The wooden nesting doll where one figure fits snugly inside another is the worldwide symbol of Russian folk craftsmanship and maternal warmth.",
            contentNp = """
मत्र्योस्का (Матрёшка) रुसी लोककलाको सबैभन्दा प्रिय र प्रख्यात प्रतीक हो। यसको जन्म सन् १८९० मा मस्को नजिकै भएको मानिन्छ। पहिलो मत्र्योस्कामा किसान महिलाको चित्र कोरिएको थियो जसको काखमा एउटा कालो कुखुरा थियो।

परम्परा र बनावट:
• काठ: यो पुतली बनाउन सामान्यतया लिन्डेन (Linden) वा सन्चो काठ प्रयोग गरिन्छ।
• रंगरोगन: परम्परागत खोखलोमा (Khokhloma) वा झास्तोभो शैलीका चहकिला रंगहरू, फूलबुट्टा र रुसी स्कार्फ (Платок) ले सजाइन्छ।
• दर्शन: बाहिरी पुतलीले आमालाई प्रतिनिधित्व गर्छ भने भित्रका साना पुतलीहरूले बालबच्चा र पुस्तौंपुस्ताको अटूट सम्बन्ध झल्काउँछन्। सबैभन्दा सानो भित्री पुतली एउटा काठको ठोस टुक्रा हुन्छ जसले मानव आत्माको शुद्धता जनाउँछ।
            """.trimIndent(),
            contentEn = """
The Matryoshka doll was crafted in the 1890s by craftsman Vasily Zvyozdochkin and designed by folk painter Sergey Malyutin. The name comes from 'Matryona', a popular Russian female name derived from the Latin root 'mater' (mother).

Symbolism:
• Maternal care and family continuity.
• Inside each larger doll is a slightly smaller one, representing generations.
• Hand-painted with Gouache and lacquer, depicting floral shawls (platok) and folk costumes (sarafan).
            """.trimIndent(),
            funFactNp = "रुसमा सबैभन्दा ठूलो मत्र्योस्का सेट ७२ वटा पुतली अटाउने सम्म बनाइएको रेकर्ड छ!",
            funFactEn = "The largest Matryoshka doll set in the world consists of 72 nested pieces!",
            keyWords = listOf(
                CultureWord("Матрёшка", "Matryóshka", "मत्र्योस्का पुतली", "Nesting doll"),
                CultureWord("Семья", "Sem'yá", "परिवार", "Family"),
                CultureWord("Дерево", "Dérevo", "काठ / रुख", "Wood / Tree"),
                CultureWord("Платок", "Platók", "रुसी महिलाको स्कार्फ", "Traditional headscarf")
            )
        ),
        CultureArticle(
            id = "c_samovar",
            titleRu = "Русский самовар и чаепитие",
            titleNp = "समोभार र रुसी चिया संस्कृति",
            titleEn = "The Russian Samovar & Tea Ritual",
            category = CultureCategory.TRADITIONS,
            bannerType = "SAMOVAR",
            summaryNp = "समोभार (Samovar) धातुबाट बनेको तातो पानी उमाल्ने रुसी भाँडो हो, जसको वरिपरि परिवार र पाहुना बसेर घण्टौँ चिया पिउँदै गफ गर्छन्।",
            summaryEn = "The samovar is the glowing heart of Russian hospitality, boiling water for deep tea gatherings with lemon, jam, and sweets.",
            contentNp = """
रुसमा चिया केवल एउटा पेय मात्र होइन, यो आत्मीयता र आतिथ्य सत्कारको जीवनशैली हो। 'Самовар' (Samovar) शब्द दुई शब्द 'Само' (आफैं) र 'Варить' (उमाल्नु) मिलेर बनेको हो।

समोभारको परम्परा:
• कोइला वा काठको धुवाँमा पानी उम्लिन्छ, र समोभारको टुप्पोमा सानो चियादानी (Заварник) राखिन्छ जसमा कडा कालो चिया (Заварка) बनाइन्छ।
• मानिसहरू कपमा अलिकति कडा चिया हालेर समोभारको टुटीबाट तातो पानी थप्छन्।
• रुसमा चियासँग कागती (Лимон), घरेलु जाम (Варенье), मह र सुक्खा रोटी (Баранки) खाने विशेष चलन छ।
            """.trimIndent(),
            contentEn = """
A samovar is a metal container traditionally heated by charcoal or kindling. Dating back to the 18th century city of Tula, it became the centerpiece of Russian living rooms.

Tea Ritual:
• Strong concentrated tea leaves (zavarka) brew in a small teapot perched atop the samovar.
• Guests pour strong tea into cups and dilute it with piping boiling water directly from the samovar spigot.
• Russian tea is almost always enjoyed with lemon slices, homemade berry jam (varenye), and baranki rings.
            """.trimIndent(),
            funFactNp = "रुसको तुला (Tula) सहरलाई समोभारको राजधानी मानिन्छ, जहाँका समोभारहरू राजा-महाराजाहरूलाई उपहार दिइन्थ्यो।",
            funFactEn = "The city of Tula is legendary for master samovar blacksmithing, where royal samovars were decorated with pure gold and silver.",
            keyWords = listOf(
                CultureWord("Самовар", "Samovár", "समोभार (पानी उमाल्ने भाँडो)", "Samovar"),
                CultureWord("Чай", "Chay", "चिया", "Tea"),
                CultureWord("Варенье", "Varén'ye", "घरेलु फलफूलको जाम", "Russian fruit preserves"),
                CultureWord("Гостеприимство", "Gostepriímstvo", "आतिथ्य सत्कार", "Hospitality")
            )
        ),
        CultureArticle(
            id = "c_kremlin",
            titleRu = "Красная площадь и Собор Василия Блаженного",
            titleNp = "रेड स्क्वायर र सेन्ट बेजिल्स क्याथेड्रल",
            titleEn = "Red Square & Saint Basil's Cathedral",
            category = CultureCategory.LANDMARKS,
            bannerType = "KREMLIN",
            summaryNp = "मस्कोको मुटुमा रहेको रंगीबिरंगी प्याज आकारको गुम्बज भएको सेन्ट बेजिल्स क्याथेड्रल र ऐतिहासिक रेड स्क्वायर वास्तुकलाको अनुपम नमुना हो।",
            summaryEn = "The multi-colored fairy-tale onion domes of Saint Basil's Cathedral rise above Moscow's Red Square as Russia's defining architectural marvel.",
            contentNp = """
रेड स्क्वायर (Красная площадь) रुसको राजधानी मस्कोको केन्द्र हो। रोचक कुरा के छ भने प्राचीन रुसी भाषामा 'Красная' शब्दको अर्थ 'सुन्दर' (Beautiful) पनि हुन्थ्यो।

सेन्ट बेजिल्स क्याथेड्रल (Собор Василия Блаженного):
• सन् १५५५ देखि १५६१ को बीचमा जार इभान द टेरिबल (Ivan the Terrible) को पालामा निर्माण गरिएको थियो।
• यसका ९ वटा रंगीबिरंगी गुम्बजहरू आगोको ज्वाला जस्तो आकाशतर्फ फर्केका छन्।
• यो संसारकै सबैभन्दा चिनिने वास्तुकलामध्ये एक हो र युनेस्को विश्व सम्पदा सूचीमा सूचीकृत छ।
            """.trimIndent(),
            contentEn = """
Saint Basil's Cathedral stands on the southern end of Red Square in Moscow. Commissioned by Tsar Ivan IV ('the Terrible') to commemorate the capture of Kazan in 1552, its architect Postnik Yakovlev created nine distinct chapels united under flame-like painted onion domes.

Red Square Highlights:
• The medieval red brick walls of Moscow Kremlin.
• Spasskaya Tower with its iconic chimes.
• The historic GUM department store illuminated by millions of lights.
            """.trimIndent(),
            funFactNp = "किंवदन्ती अनुसार सम्राट इभानले यति सुन्दर भवन फेरि कहिल्यै नबनोस् भनेर वास्तुकारको आँखा फोडिदिएका थिए भनिन्छ, यद्यपि यो ऐतिहासिक रूपमा प्रमाणित छैन।",
            funFactEn = "Urban legend claims Ivan blinded the architect so he could never build anything as magnificent, though archives prove he continued designing churches afterward!",
            keyWords = listOf(
                CultureWord("Красная площадь", "Krásnaya plóshchad'", "रेड स्क्वायर (रातो चोक)", "Red Square"),
                CultureWord("Собор", "Sabór", "क्याथेड्रल / महामन्दिर", "Cathedral"),
                CultureWord("Кремль", "Kreml'", "क्रेमलिन किल्ला", "Kremlin Fortress"),
                CultureWord("Москва", "Maskvá", "मस्को राजधानी", "Moscow")
            )
        ),
        CultureArticle(
            id = "c_literature",
            titleRu = "Золотой век русской литературы",
            titleNp = "पुष्किन, तोल्सतोय र रुसी साहित्यको स्वर्ण युग",
            titleEn = "Golden Age of Russian Literature",
            category = CultureCategory.LITERATURE,
            bannerType = "LITERATURE",
            summaryNp = "अलेक्जेन्डर पुष्किन, लियो तोल्सतोय र फ्योदोर दोस्तोएभ्स्कीले विश्व साहित्यलाई अमर कृतिहरू दिएका छन्, जसको प्रभाव नेपाली लेखकहरूमा पनि गहिरो छ।",
            summaryEn = "Pushkin, Tolstoy, Dostoevsky, and Chekhov shaped world literature with profound philosophical depth, realism, and moral exploration.",
            contentNp = """
रुसी साहित्य विश्व साहित्यको मुकुट मानिन्छ। यसले मानव जीवनको गहिरो दर्शन, प्रेम, पीडा र मुक्तिको खोजी गर्छ।

महान लेखकहरू:
• अलेक्जेन्डर पुष्किन (Александр Пушкин): आधुनिक रुसी भाषाका जनक। उनको कविता 'मलाई तिम्रो माया लाग्यो' (Я вас любил) विश्वप्रसिद्ध छ।
• लियो तोल्सतोय (Лев Толстой): 'युद्ध र शान्ति' (War and Peace) तथा 'अन्ना कारेनिना' (Anna Karenina) का अमर स्रष्टा। महात्मा गान्धीसमेत उनको अहिंसावादी विचारबाट प्रभावित थिए।
• फ्योदोर दोस्तोएभ्स्की (Фёдор Достоевский): मानव मनको भित्री मनोविज्ञान उतार्ने 'क्राइम एण्ड पनिसमेन्ट' (Crime and Punishment) का लेखक।
            """.trimIndent(),
            contentEn = """
Russian literature produced some of the deepest explorations of morality and psychological truth in human history.

Key Giants:
• Alexander Pushkin: The father of modern Russian poetic language.
• Leo Tolstoy: Epic master whose pacifist and moral writings profoundly influenced Mahatma Gandhi and global thinkers.
• Fyodor Dostoevsky: Unrivaled psychologist of the soul exploring existential redemption.
• Anton Chekhov: Revolutionary dramatist and master of the modern short story.
            """.trimIndent(),
            funFactNp = "काठमाडौंका धेरै नेपाली साहित्यकारहरूले तोल्सतोय र म्याक्सिम गोर्कीका कृतिहरू नेपालीमा अनुवाद गरेर पढेका छन्।",
            funFactEn = "Pushkin has monuments across five continents, and UNESCO celebrated the bicentenary of his birth worldwide.",
            keyWords = listOf(
                CultureWord("Книга", "Kníga", "किताब", "Book"),
                CultureWord("Писатель", "Pisátel'", "लेखक / साहित्यकार", "Writer"),
                CultureWord("Стихотворение", "Stikhatvaréniye", "कविता", "Poem"),
                CultureWord("Душа", "Dushá", "आत्मा / मन", "Soul")
            )
        ),
        CultureArticle(
            id = "c_winter",
            titleRu = "Русская зима и праздник Масленица",
            titleNp = "रुसी हिउँद, मास्लेनिता र नयाँ वर्ष",
            titleEn = "Russian Winter & Maslenitsa Festival",
            category = CultureCategory.FESTIVALS,
            bannerType = "WINTER",
            summaryNp = "रुसी हिउँद सेतो चाँदी जस्तै सुन्दर हुन्छ। वसन्तको स्वागत गर्न मनाइने 'मास्लेनिता' पर्वमा घामको प्रतीकका रूपमा मीठा प्यानकेक (ब्लिनी) खाइन्छ।",
            summaryEn = "Fairytale snowy landscapes, Troika horse sleds, New Year father Ded Moroz, and Maslenitsa sun pancake celebrations define Russian winter joy.",
            contentNp = """
रुसको जाडो याम प्रसिद्ध छ। चारैतिर हिउँको सेतो चादर, जमेका तालहरू, र क्रिसमस रुख (Ёлка) ले जाडोलाई जादुमय बनाउँछ।

मास्लेनिता (Масленица) पर्व:
• जाडो सकिएर वसन्तको आगमन हुने समयमा मनाइने एक हप्ते लोकपर्व।
• मानिसहरू गोलो, पहेँलो र तातो 'ब्लिनी' (रुसी प्यानकेक) पकाउँछन्, जसले चम्किलो सूर्यलाई प्रतिनिधित्व गर्छ।
• घोडाको बग्गी (Тройка) चढेर हिउँमा घुम्ने, खेलकुद गर्ने र परालको पुतली जलाएर जाडोलाई बिदाइ गरिन्छ।
            """.trimIndent(),
            contentEn = """
Russian winter is a celebrated cultural season rather than merely weather.

Highlights:
• Ded Moroz (Grandfather Frost) and his granddaughter Snegurochka (Snow Maiden) bringing gifts on New Year's Eve.
• Maslenitsa (Pancake Week): The ancient Slavic sun holiday waving goodbye to winter with butter, blini, and sleigh rides.
• Traditional Russian Banya: Birch leaf steaming saunas followed by snow dips for vibrant health.
            """.trimIndent(),
            funFactNp = "नयाँ वर्ष (Новый год) रुसमा सबैभन्दा ठूलो पारिवारिक चाड हो, जसमा राति १२ बजे क्रेमलिनको घडी बज्दा उपहार आदानप्रदान गरिन्छ।",
            funFactEn = "New Year's Eve is the most celebrated holiday in Russia, watched by millions as the Kremlin Spasskaya clock chimes at midnight.",
            keyWords = listOf(
                CultureWord("Зима", "Zimá", "हिउँद / जाडो याम", "Winter"),
                CultureWord("Снег", "Sneg", "हिउँ (Snow)", "Snow"),
                CultureWord("Блины", "Bliný", "प्यानकेक (सूर्यको प्रतीक)", "Pancakes"),
                CultureWord("Новый год", "Nóvyy god", "नयाँ वर्ष", "New Year")
            )
        ),
        CultureArticle(
            id = "c_nepal_russia",
            titleRu = "Дружба Непала и России: Борис Лисаневич и культура",
            titleNp = "नेपाल-रुस सम्बन्ध: बोरिस लिसानोभिच र मित्रता",
            titleEn = "Nepal & Russia Ties: Boris Lissanevitch & Friendship",
            category = CultureCategory.NEPAL_RUSSIA,
            bannerType = "NEPAL_RUSSIA",
            summaryNp = "नेपाल र रुसबीच सन् १९५६ मा दौत्य सम्बन्ध कायम भएको थियो। काठमाडौंमा रोयल होटल खोलेर नेपाललाई विश्व पर्यटनको नक्सामा पुर्‍याउने रुसी नागरिक बोरिस लिसानोभिचको योगदान अद्वितीय छ।",
            summaryEn = "Diplomatic ties established in 1956. Legendary Russian ballet dancer Boris Lissanevitch opened Nepal's iconic Royal Hotel, pioneering international tourism in Kathmandu.",
            contentNp = """
नेपाल र रुस भौगोलिक रूपमा टाढा भए पनि मित्रता र सांस्कृतिक आदानप्रदानमा निकै नजिक छन्।

ऐतिहासिक आयाम:
• बोरिस लिसानोभिच (Boris Lissanevitch): रुसी ब्याले नर्तक बोरिसले सन् १९५० को दशकमा काठमाडौंमा नेपालकै पहिलो आधुनिक 'रोयल होटल' स्थापना गरे। उनले तत्कालीन राजा महेन्द्रलाई मनाएर विदेशी पर्यटकका लागि नेपालको ढोका खोल्न लगाएका थिए!
• चिकित्सा र इन्जिनियरिङ शिक्षा: सोभियत संघ र रुसका प्रतिष्ठित विश्वविद्यालयहरूबाट हजारौँ नेपाली विद्यार्थीहरूले छात्रवृत्तिमा डाक्टरी, इन्जिनियरिङ र विज्ञान पढेर नेपाल फर्किएर देशको सेवा गरिरहेका छन्।
• हिमाल आरोहण: रुसी पर्वतारोहीहरूले सगरमाथा, अन्नपूर्ण, र मनास्लु जस्ता नेपाली हिमालहरूमा साहसिक कीर्तिमान राखेका छन्।
            """.trimIndent(),
            contentEn = """
Formal diplomatic relations between Nepal and the Soviet Union / Russian Federation were established on July 20, 1956.

Key Historical Highlights:
• Boris Lissanevitch: Legendary Russian explorer and performer who opened the legendary Royal Hotel in Kathmandu in the 1950s, personally persuading King Mahendra to grant tourist visas and introducing Nepal to the global jet-set!
• Education & Medicine: Thousands of Nepali students graduated as doctors, engineers, and scientists from top Russian universities in Moscow and Saint Petersburg.
• Mountain Mountaineering: Strong bond of adventure between Russian climbers and Nepali Sherpas conquering eight-thousander Himalayan summits.
            """.trimIndent(),
            funFactNp = "काठमाडौंको रुसी सांस्कृतिक केन्द्र (Russian Cultural Centre / Russian House) ले ६० वर्षभन्दा बढी समयदेखि नेपालीहरूलाई रुसी भाषा, नृत्य र संगीत सिकाउँदै आएको छ।",
            funFactEn = "The Russian House in Kamal Pokhari, Kathmandu has been teaching Russian language, chess, and classical ballet to Nepali students for over six decades!",
            keyWords = listOf(
                CultureWord("Дружба", "Drúzhba", "मित्रता / दोस्ती", "Friendship"),
                CultureWord("Непал", "Nepál", "नेपाल देश", "Nepal"),
                CultureWord("Гималаи", "Gimalái", "हिमालय पर्वतमाला", "Himalayas"),
                CultureWord("Культура", "Kul'túra", "संस्कृति", "Culture")
            )
        )
    )
}
