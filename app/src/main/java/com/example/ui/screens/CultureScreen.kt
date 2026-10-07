package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CultureData
import com.example.model.CultureArticle
import com.example.model.CultureCategory
import com.example.ui.components.VisualCultureBanner
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianGold
import com.example.ui.theme.RussianRed

@Composable
fun CultureScreen(
    onSpeak: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf<CultureCategory?>(null) }

    val filteredArticles = remember(selectedCategory) {
        if (selectedCategory == null) CultureData.articles
        else CultureData.articles.filter { it.category == selectedCategory }
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Category filters
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                FilterChip(
                    selected = selectedCategory == null,
                    onClick = { selectedCategory = null },
                    label = { Text("सबै (All)") }
                )
            }
            item {
                FilterChip(
                    selected = selectedCategory == CultureCategory.TRADITIONS,
                    onClick = { selectedCategory = CultureCategory.TRADITIONS },
                    label = { Text("परम्परा र लोककला (Traditions)") }
                )
            }
            item {
                FilterChip(
                    selected = selectedCategory == CultureCategory.LANDMARKS,
                    onClick = { selectedCategory = CultureCategory.LANDMARKS },
                    label = { Text("प्रसिद्ध स्थल (Landmarks)") }
                )
            }
            item {
                FilterChip(
                    selected = selectedCategory == CultureCategory.LITERATURE,
                    onClick = { selectedCategory = CultureCategory.LITERATURE },
                    label = { Text("साहित्य (Literature)") }
                )
            }
            item {
                FilterChip(
                    selected = selectedCategory == CultureCategory.FESTIVALS,
                    onClick = { selectedCategory = CultureCategory.FESTIVALS },
                    label = { Text("चाडपर्व र हिउँद (Festivals)") }
                )
            }
            item {
                FilterChip(
                    selected = selectedCategory == CultureCategory.NEPAL_RUSSIA,
                    onClick = { selectedCategory = CultureCategory.NEPAL_RUSSIA },
                    label = { Text("नेपाल-रुस सम्बन्ध (Nepal-Russia)") }
                )
            }
        }

        // Article List
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredArticles) { article ->
                CultureArticleCard(article = article, onSpeak = onSpeak)
            }
        }
    }
}

@Composable
private fun CultureArticleCard(
    article: CultureArticle,
    onSpeak: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("culture_card_${article.id}")
    ) {
        Column {
            // Visual Image Banner
            VisualCultureBanner(
                bannerType = article.bannerType,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                // Category Chip
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = when (article.category) {
                        CultureCategory.TRADITIONS -> RussianRed.copy(alpha = 0.12f)
                        CultureCategory.LANDMARKS -> RussianBlue.copy(alpha = 0.12f)
                        CultureCategory.LITERATURE -> Color(0xFF6366F1).copy(alpha = 0.12f)
                        CultureCategory.FESTIVALS -> Color(0xFF0EA5E9).copy(alpha = 0.12f)
                        CultureCategory.NEPAL_RUSSIA -> RussianGold.copy(alpha = 0.2f)
                    }
                ) {
                    Text(
                        text = when (article.category) {
                            CultureCategory.TRADITIONS -> "परम्परा र शिल्प (Traditions)"
                            CultureCategory.LANDMARKS -> "वास्तुकला र सम्पदा (Heritage)"
                            CultureCategory.LITERATURE -> "विश्व साहित्य (Literature)"
                            CultureCategory.FESTIVALS -> "हिउँद र चाडपर्व (Festivals)"
                            CultureCategory.NEPAL_RUSSIA -> "नेपाल-रुस सम्बन्ध (Diplomatic Ties)"
                        },
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = when (article.category) {
                                CultureCategory.TRADITIONS -> RussianRed
                                CultureCategory.LANDMARKS -> RussianBlue
                                CultureCategory.LITERATURE -> Color(0xFF4338CA)
                                CultureCategory.FESTIVALS -> Color(0xFF0284C7)
                                CultureCategory.NEPAL_RUSSIA -> Color(0xFFB45309)
                            }
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = article.titleNp,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = "${article.titleRu} • ${article.titleEn}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = article.summaryNp,
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )

                // Expandable detailed read
                AnimatedVisibility(visible = isExpanded) {
                    Column(modifier = Modifier.padding(top = 14.dp)) {
                        Text(
                            text = "📖 विस्तृत जानकारी (Detailed History):",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = article.contentNp,
                            style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 22.sp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "English Context:",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                        Text(
                            text = article.contentEn,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                lineHeight = 18.sp
                            ),
                            modifier = Modifier.padding(top = 2.dp)
                        )

                        // Fun Fact
                        if (article.funFactNp.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = Color(0xFFFEF3C7),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Lightbulb,
                                        contentDescription = "Fun fact",
                                        tint = Color(0xFFD97706),
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = "रोचक तथ्य (Интересный факт):",
                                            style = MaterialTheme.typography.labelSmall.copy(
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF92400E)
                                            )
                                        )
                                        Text(
                                            text = article.funFactNp,
                                            style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF78350F))
                                        )
                                    }
                                }
                            }
                        }

                        // Related Russian Vocabulary with audio
                        if (article.keyWords.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "संस्कृतिसँग सम्बन्धित रुसी शब्दहरू (Key Vocabulary):",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                article.keyWords.forEach { word ->
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(8.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = word.russian,
                                                    style = MaterialTheme.typography.bodyMedium.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        color = MaterialTheme.colorScheme.primary
                                                    )
                                                )
                                                Text(
                                                    text = "${word.transliteration} • ${word.nepali} (${word.english})",
                                                    style = MaterialTheme.typography.bodySmall
                                                )
                                            }

                                            IconButton(
                                                onClick = { onSpeak(word.russian) },
                                                modifier = Modifier.size(32.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.VolumeUp,
                                                    contentDescription = "Speak",
                                                    tint = MaterialTheme.colorScheme.primary,
                                                    modifier = Modifier.size(18.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Expand / Collapse action
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isExpanded = !isExpanded }
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isExpanded) "कम देखाउनुहोस् (Collapse)" else "पूरा पढ्नुहोस् (Read Full Article) >",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
