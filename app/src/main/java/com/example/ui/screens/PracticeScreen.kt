package com.example.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PracticeData
import com.example.data.VocabularyData
import com.example.model.AppLanguageMode
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianGold
import com.example.ui.theme.RussianRed
import com.example.ui.theme.SuccessGreen

@Composable
fun PracticeScreen(
    languageMode: AppLanguageMode,
    onSpeak: (String) -> Unit,
    onQuizFinished: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedMode by remember { mutableIntStateOf(0) }
    val modes = listOf("क्विज (Quiz)", "फ्ल्यासकार्ड (Flashcards)", "जोडा मिलाउने (Match)")

    Column(modifier = modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedMode,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth().testTag("practice_tabs")
        ) {
            modes.forEachIndexed { index, title ->
                Tab(
                    selected = selectedMode == index,
                    onClick = { selectedMode = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedMode == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        when (selectedMode) {
            0 -> QuizModeView(
                onSpeak = onSpeak,
                onQuizFinished = onQuizFinished
            )
            1 -> FlashcardsModeView(
                onSpeak = onSpeak
            )
            2 -> MatchPairsModeView(
                onSpeak = onSpeak
            )
        }
    }
}

@Composable
private fun QuizModeView(
    onSpeak: (String) -> Unit,
    onQuizFinished: (Int) -> Unit
) {
    val questions = PracticeData.quizQuestions
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableIntStateOf(0) }
    var isQuizCompleted by remember { mutableStateOf(false) }

    val currentQ = questions.getOrNull(currentIndex)
    val scrollState = rememberScrollState()

    if (isQuizCompleted || currentQ == null) {
        // Results summary
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = CircleShape,
                color = RussianGold.copy(alpha = 0.2f),
                modifier = Modifier.size(100.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = "Trophy",
                        tint = RussianGold,
                        modifier = Modifier.size(54.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "अभ्यास पूरा भयो! (Well Done!)",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "तपाईंको कुल प्राप्ताङ्क: $score / ${questions.size}",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = RussianBlue,
                    fontWeight = FontWeight.Bold
                )
            )

            val percentage = (score * 100) / questions.size
            Text(
                text = if (percentage >= 80) "अद्भूत! तपाईंको रुसी भाषा ज्ञान निकै राम्रो छ! (Отлично!)"
                else "राम्रो प्रयास! अझै अभ्यास गरेर उत्कृष्टता हासिल गर्नुहोस्। (Хорошо!)",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    currentIndex = 0
                    selectedOptionIndex = null
                    score = 0
                    isQuizCompleted = false
                },
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = RussianBlue),
                modifier = Modifier.fillMaxWidth().testTag("restart_quiz_btn")
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("फेरि अभ्यास गर्नुहोस् (Play Again)", fontWeight = FontWeight.Bold)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            // Progress row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "प्रश्न ${currentIndex + 1} / ${questions.size}",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = "अंक: $score",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = RussianRed
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Question Card
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = currentQ.questionRu,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        if (currentQ.audioSnippet.isNotEmpty()) {
                            IconButton(
                                onClick = { onSpeak(currentQ.audioSnippet) },
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = "Speak",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "नेपाली: ${currentQ.questionNp}",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Text(
                        text = "English: ${currentQ.questionEn}",
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Options
            currentQ.options.forEachIndexed { optIndex, optionText ->
                val isSelected = selectedOptionIndex == optIndex
                val isCorrect = optIndex == currentQ.correctIndex
                val optionBg = when {
                    selectedOptionIndex == null -> MaterialTheme.colorScheme.surface
                    isCorrect -> Color(0xFFDCFCE7) // Light green
                    isSelected -> Color(0xFFFEE2E2) // Light red
                    else -> MaterialTheme.colorScheme.surface
                }
                val borderStroke = when {
                    selectedOptionIndex == null -> Color.Transparent
                    isCorrect -> SuccessGreen
                    isSelected -> RussianRed
                    else -> Color.Transparent
                }

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = optionBg,
                    shadowElevation = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable(enabled = selectedOptionIndex == null) {
                            selectedOptionIndex = optIndex
                            if (isCorrect) {
                                score += 1
                            }
                        }
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = when {
                                selectedOptionIndex != null && isCorrect -> SuccessGreen
                                selectedOptionIndex != null && isSelected -> RussianRed
                                else -> MaterialTheme.colorScheme.primaryContainer
                            },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = ('A'.code + optIndex).toChar().toString(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = if (selectedOptionIndex != null && (isCorrect || isSelected)) Color.White
                                    else MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = optionText,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = if (isSelected || (selectedOptionIndex != null && isCorrect)) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    }
                }
            }

            // Explanation & Next Button
            if (selectedOptionIndex != null) {
                Spacer(modifier = Modifier.height(14.dp))

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = if (selectedOptionIndex == currentQ.correctIndex) Color(0xFFDCFCE7) else Color(0xFFFEF3C7),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = if (selectedOptionIndex == currentQ.correctIndex) "✓ सही उत्तर! (Correct!)" else "✗ उत्तर स्पष्टीकरण (Explanation):",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = if (selectedOptionIndex == currentQ.correctIndex) SuccessGreen else Color(0xFF92400E)
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentQ.explanationNp,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = currentQ.explanationEn,
                            style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFF4B5563)),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (currentIndex + 1 < questions.size) {
                            currentIndex += 1
                            selectedOptionIndex = null
                        } else {
                            isQuizCompleted = true
                            onQuizFinished(score)
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = RussianBlue),
                    modifier = Modifier.fillMaxWidth().testTag("next_question_btn")
                ) {
                    Text(
                        text = if (currentIndex + 1 < questions.size) "अर्को प्रश्न (Next Question) >" else "नतिजा हेर्नुहोस् (See Results)",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun FlashcardsModeView(
    onSpeak: (String) -> Unit
) {
    val words = VocabularyData.words
    var cardIndex by remember { mutableIntStateOf(0) }
    var isFlipped by remember { mutableStateOf(false) }

    val currentWord = words[cardIndex]

    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 400),
        label = "card_flip"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Progress
        Text(
            text = "फ्ल्यासकार्ड: ${cardIndex + 1} / ${words.size}",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Flippable Card
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
                .clickable { isFlipped = !isFlipped }
                .testTag("flashcard_item")
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                if (rotation <= 90f) {
                    // Front Side: Russian Word
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                text = "रूसी भाषा (Russian)",
                                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = currentWord.russian,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            ),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "${currentWord.transliteration} (${currentWord.nepaliPhonetics})",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        IconButton(
                            onClick = { onSpeak(currentWord.russian) },
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VolumeUp,
                                contentDescription = "Speak",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "💡 अर्थ हेर्न कार्डमा थिच्नुहोस् (Tap to flip)",
                            style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFF94A3B8))
                        )
                    }
                } else {
                    // Back Side: Nepali and English Meanings
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.graphicsLayer { rotationY = 180f }
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = RussianRed.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "नेपाली & English अर्थ",
                                style = MaterialTheme.typography.labelSmall.copy(color = RussianRed, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = currentWord.nepali,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = RussianRed
                            ),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = currentWord.english,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            textAlign = TextAlign.Center
                        )

                        if (currentWord.exampleRussian.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "«${currentWord.exampleRussian}»",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight.Medium,
                                    color = MaterialTheme.colorScheme.primary
                                ),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = {
                    if (cardIndex > 0) {
                        cardIndex -= 1
                        isFlipped = false
                    }
                },
                enabled = cardIndex > 0,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("< अघिल्लो (Prev)")
            }

            Button(
                onClick = {
                    if (cardIndex + 1 < words.size) {
                        cardIndex += 1
                        isFlipped = false
                    } else {
                        cardIndex = 0
                        isFlipped = false
                    }
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = RussianBlue)
            ) {
                Text(if (cardIndex + 1 < words.size) "पछिल्लो (Next) >" else "सुरुबाट (Restart)")
            }
        }
    }
}

@Composable
private fun MatchPairsModeView(
    onSpeak: (String) -> Unit
) {
    val pairs = remember { PracticeData.matchPairs.shuffled().take(5) }
    val russianOptions = remember { pairs.map { it.russian }.shuffled() }
    val meaningOptions = remember { pairs.map { "${it.meaningNp} (${it.meaningEn})" }.shuffled() }

    var selectedRussian by remember { mutableStateOf<String?>(null) }
    var selectedMeaning by remember { mutableStateOf<String?>(null) }
    val matchedPairs = remember { mutableStateListOf<String>() }

    fun checkMatch(ru: String, meaning: String) {
        val match = pairs.find { it.russian == ru && "${it.meaningNp} (${it.meaningEn})" == meaning }
        if (match != null) {
            matchedPairs.add(ru)
            onSpeak(ru)
        }
        selectedRussian = null
        selectedMeaning = null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "रुसी शब्द र नेपाली अर्थको जोडा मिलाउनुहोस्",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
        Text(
            text = "मिलेका जोडा: ${matchedPairs.size} / ${pairs.size}",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier.padding(top = 2.dp, bottom = 14.dp)
        )

        if (matchedPairs.size == pairs.size) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFFDCFCE7),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = SuccessGreen,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "बधाई छ! सबै जोडा मिल्यो! (Поздравляем!)",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = SuccessGreen),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = { matchedPairs.clear() },
                        colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)
                    ) {
                        Text("फेरि खेल्नुहोस्")
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Left Column: Russian Words
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    russianOptions.forEach { ru ->
                        val isMatched = matchedPairs.contains(ru)
                        val isSelected = selectedRussian == ru

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = when {
                                isMatched -> Color(0xFFDCFCE7)
                                isSelected -> MaterialTheme.colorScheme.primaryContainer
                                else -> MaterialTheme.colorScheme.surface
                            },
                            shadowElevation = 2.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clickable(enabled = !isMatched) {
                                    selectedRussian = ru
                                    selectedMeaning?.let { m -> checkMatch(ru, m) }
                                }
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = ru,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp,
                                    color = if (isMatched) SuccessGreen else MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }

                // Right Column: Meanings
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    meaningOptions.forEach { meaning ->
                        val correspondingRu = pairs.find { "${it.meaningNp} (${it.meaningEn})" == meaning }?.russian
                        val isMatched = correspondingRu != null && matchedPairs.contains(correspondingRu)
                        val isSelected = selectedMeaning == meaning

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = when {
                                isMatched -> Color(0xFFDCFCE7)
                                isSelected -> RussianRed.copy(alpha = 0.2f)
                                else -> MaterialTheme.colorScheme.surface
                            },
                            shadowElevation = 2.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clickable(enabled = !isMatched) {
                                    selectedMeaning = meaning
                                    selectedRussian?.let { ru -> checkMatch(ru, meaning) }
                                }
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(horizontal = 6.dp)
                            ) {
                                Text(
                                    text = meaning,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = if (isMatched) SuccessGreen else MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
