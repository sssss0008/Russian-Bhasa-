package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AlphabetData
import com.example.data.CultureData
import com.example.data.VocabularyData
import com.example.model.AlphabetLetter
import com.example.model.AppLanguageMode
import com.example.ui.components.VisualCultureBanner
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianGold
import com.example.ui.theme.RussianRed

@Composable
fun HomeScreen(
    languageMode: AppLanguageMode,
    streakCount: Int,
    quizzesCompleted: Int,
    quizPoints: Int,
    onSpeak: (String) -> Unit,
    onNavigateToLearnTab: (initialSubTab: Int) -> Unit,
    onNavigateToPracticeTab: () -> Unit,
    onNavigateToCultureTab: () -> Unit,
    onSelectLetter: (AlphabetLetter) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val dailyWord = VocabularyData.words.first() // Здравствуйте

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = 24.dp)
    ) {
        // Hero Header Card with Russian & Nepali greeting
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(
                    Brush.linearGradient(
                        colors = listOf(RussianBlue, Color(0xFF1E40AF), RussianRed)
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Добро пожаловать!",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "स्वागत छ! आज के नयाँ सिक्ने?",
                            color = Color(0xFFE2E8F0),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    // Streak Badge
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0x33FFFFFF)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalFireDepartment,
                                contentDescription = "Streak",
                                tint = RussianGold,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "$streakCount दिन",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Stats row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatPill(
                        icon = Icons.Default.School,
                        label = "३३ अक्षर",
                        sub = "वर्णमाला",
                        modifier = Modifier.weight(1f)
                    )
                    StatPill(
                        icon = Icons.Default.EmojiEvents,
                        label = "$quizzesCompleted अभ्यास",
                        sub = "अंक $quizPoints",
                        modifier = Modifier.weight(1f)
                    )
                    StatPill(
                        icon = Icons.Outlined.Translate,
                        label = "१००+ शब्द",
                        sub = "नेपाली अर्थ",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Daily Word of the Day (Слово дня)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Text(
                            text = "⭐ आजको रुसी शब्द (Слово дня)",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }

                    IconButton(
                        onClick = { onSpeak(dailyWord.russian) },
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                            .testTag("home_word_audio")
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Speak word",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = dailyWord.russian,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )

                Text(
                    text = "${dailyWord.transliteration}  •  (${dailyWord.nepaliPhonetics})",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(RussianRed)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "नेपाली: ${dailyWord.nepali}",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 4.dp)) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(RussianBlue)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "English: ${dailyWord.english}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                    )
                }

                if (dailyWord.exampleRussian.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "💬 उदाहरण: ${dailyWord.exampleRussian}",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                            Text(
                                text = "नेपाली: ${dailyWord.exampleNepali}",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Russian Cyrillic Alphabet Quick Strip
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "रुसी वर्णमाला (Русский алфавит)",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "३३ अक्षर र तिनको नेपाली उच्चारण",
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }
            Text(
                text = "सबै हेर्नुहोस् >",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .clickable { onNavigateToLearnTab(0) }
                    .padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(AlphabetData.letters.take(12)) { letter ->
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.surface,
                    shadowElevation = 2.dp,
                    modifier = Modifier
                        .clickable { onSelectLetter(letter) }
                        .size(width = 72.dp, height = 82.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = letter.letter,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = letter.nepaliPhonetic,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = RussianRed
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Quick Category Shortcuts
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "शब्दावली विषयहरू (Vocabulary Topics)",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "थप >",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .clickable { onNavigateToLearnTab(1) }
                    .padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            QuickTopicButton(
                title = "अभिवादन",
                subtitle = "Greetings",
                emoji = "👋",
                onClick = { onNavigateToLearnTab(1) },
                modifier = Modifier.weight(1f)
            )
            QuickTopicButton(
                title = "संख्याहरू",
                subtitle = "Numbers",
                emoji = "🔢",
                onClick = { onNavigateToLearnTab(1) },
                modifier = Modifier.weight(1f)
            )
            QuickTopicButton(
                title = "खाना र चिया",
                subtitle = "Food & Tea",
                emoji = "🍵",
                onClick = { onNavigateToLearnTab(1) },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Practice CTA Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "अभ्यास सुरु गर्नुहोस् (Start Practice)",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "क्विज, फ्ल्यासकार्ड र शब्द जोडा मिलाउने खेल",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                        )
                    )
                }

                Button(
                    onClick = onNavigateToPracticeTab,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RussianRed
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("सुरु", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Culture & History Highlight Card
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "रुसी संस्कृति र इतिहास (Culture)",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "परम्परा, मत्र्योस्का र नेपाल-रुस सम्बन्ध",
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }
            Text(
                text = "सबै हेर्नुहोस् >",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .clickable { onNavigateToCultureTab() }
                    .padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        val highlightArticle = CultureData.articles.first()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable { onNavigateToCultureTab() },
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column {
                VisualCultureBanner(
                    bannerType = highlightArticle.bannerType,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = highlightArticle.titleNp,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = highlightArticle.titleRu,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Text(
                        text = highlightArticle.summaryNp,
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                        maxLines = 2,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun StatPill(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    sub: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0x22FFFFFF),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = label, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text(text = sub, color = Color(0xFFCBD5E1), fontSize = 10.sp)
        }
    }
}

@Composable
private fun QuickTopicButton(
    title: String,
    subtitle: String,
    emoji: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = emoji, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
    }
}
