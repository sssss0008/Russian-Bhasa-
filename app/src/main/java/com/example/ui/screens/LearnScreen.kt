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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.data.AlphabetData
import com.example.data.DialoguesData
import com.example.data.GrammarData
import com.example.data.VocabularyData
import com.example.model.AlphabetLetter
import com.example.model.AppLanguageMode
import com.example.model.Dialogue
import com.example.model.GrammarTopic
import com.example.model.LetterType
import com.example.model.VocabularyItem
import com.example.ui.components.AlphabetDetailDialog
import com.example.ui.components.WordCard
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianRed

@Composable
fun LearnScreen(
    initialSubTab: Int,
    languageMode: AppLanguageMode,
    bookmarkedIds: Set<String>,
    onSpeak: (String) -> Unit,
    onBookmarkToggle: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedSubTab by remember { mutableIntStateOf(initialSubTab) }
    var selectedLetterForDialog by remember { mutableStateOf<AlphabetLetter?>(null) }

    val subTabs = listOf(
        "अक्षरमाला (Alphabet)",
        "शब्दावली (Vocabulary)",
        "व्याकरण (Grammar)",
        "कुराकानी (Dialogues)"
    )

    LaunchedEffect(initialSubTab) {
        selectedSubTab = initialSubTab
    }

    Column(modifier = modifier.fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = selectedSubTab,
            edgePadding = 16.dp,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth().testTag("learn_sub_tabs")
        ) {
            subTabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedSubTab == index,
                    onClick = { selectedSubTab = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedSubTab == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        when (selectedSubTab) {
            0 -> AlphabetSubTab(
                onLetterClick = { selectedLetterForDialog = it }
            )
            1 -> VocabularySubTab(
                languageMode = languageMode,
                bookmarkedIds = bookmarkedIds,
                onSpeak = onSpeak,
                onBookmarkToggle = onBookmarkToggle
            )
            2 -> GrammarSubTab(
                onSpeak = onSpeak
            )
            3 -> DialoguesSubTab(
                onSpeak = onSpeak
            )
        }
    }

    selectedLetterForDialog?.let { letter ->
        AlphabetDetailDialog(
            letter = letter,
            onDismiss = { selectedLetterForDialog = null },
            onSpeak = onSpeak
        )
    }
}

@Composable
private fun AlphabetSubTab(
    onLetterClick: (AlphabetLetter) -> Unit
) {
    var letterFilter by remember { mutableStateOf<LetterType?>(null) }

    val filteredLetters = remember(letterFilter) {
        if (letterFilter == null) AlphabetData.letters
        else AlphabetData.letters.filter { it.type == letterFilter }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Filter row
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                FilterChip(
                    selected = letterFilter == null,
                    onClick = { letterFilter = null },
                    label = { Text("सबै (All 33)") }
                )
            }
            item {
                FilterChip(
                    selected = letterFilter == LetterType.VOWEL,
                    onClick = { letterFilter = LetterType.VOWEL },
                    label = { Text("स्वर वर्ण (Vowels - 10)") }
                )
            }
            item {
                FilterChip(
                    selected = letterFilter == LetterType.CONSONANT,
                    onClick = { letterFilter = LetterType.CONSONANT },
                    label = { Text("व्यञ्जन वर्ण (Consonants - 21)") }
                )
            }
            item {
                FilterChip(
                    selected = letterFilter == LetterType.SIGN,
                    onClick = { letterFilter = LetterType.SIGN },
                    label = { Text("चिह्न (Signs - 2)") }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 20.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredLetters) { letter ->
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surface,
                    shadowElevation = 2.dp,
                    modifier = Modifier
                        .clickable { onLetterClick(letter) }
                        .height(100.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = letter.letter,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = letter.lowerCase,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = letter.nepaliPhonetic,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = RussianRed
                        )
                        Text(
                            text = letter.englishPhonetic,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun VocabularySubTab(
    languageMode: AppLanguageMode,
    bookmarkedIds: Set<String>,
    onSpeak: (String) -> Unit,
    onBookmarkToggle: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryId by remember { mutableStateOf<String?>(null) }

    val filteredWords = remember(searchQuery, selectedCategoryId) {
        VocabularyData.words.filter { word ->
            val matchesCategory = selectedCategoryId == null || word.categoryId == selectedCategoryId
            val matchesQuery = searchQuery.isBlank() ||
                word.russian.contains(searchQuery, ignoreCase = true) ||
                word.nepali.contains(searchQuery, ignoreCase = true) ||
                word.english.contains(searchQuery, ignoreCase = true) ||
                word.transliteration.contains(searchQuery, ignoreCase = true)
            matchesCategory && matchesQuery
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("शब्द खोज्नुहोस् (Search word in Russian, Nepali, Eng)...") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .testTag("vocab_search_field")
        )

        // Category Pills
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            item {
                FilterChip(
                    selected = selectedCategoryId == null,
                    onClick = { selectedCategoryId = null },
                    label = { Text("सबै (${VocabularyData.words.size})") }
                )
            }
            items(VocabularyData.categories) { category ->
                FilterChip(
                    selected = selectedCategoryId == category.id,
                    onClick = { selectedCategoryId = category.id },
                    label = { Text(category.titleNp) }
                )
            }
        }

        // Word list
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            if (filteredWords.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "कुनै शब्द फेला परेन। (No words found)",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                        )
                    }
                }
            } else {
                items(filteredWords, key = { it.id }) { word ->
                    WordCard(
                        word = word,
                        isBookmarked = bookmarkedIds.contains(word.id),
                        languageMode = languageMode,
                        onSpeakClick = onSpeak,
                        onBookmarkToggle = onBookmarkToggle
                    )
                }
            }
        }
    }
}

@Composable
private fun GrammarSubTab(
    onSpeak: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(GrammarData.topics) { topic ->
            GrammarTopicCard(topic = topic, onSpeak = onSpeak)
        }
    }
}

@Composable
private fun GrammarTopicCard(
    topic: GrammarTopic,
    onSpeak: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = topic.level,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = topic.titleNp,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = topic.titleRu,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = topic.overviewNp,
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )

            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    Text(
                        text = "📌 मुख्य नियमहरू (Key Rules):",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    topic.keyPointsNp.forEach { point ->
                        Row(modifier = Modifier.padding(vertical = 3.dp)) {
                            Text("• ", color = RussianBlue, fontWeight = FontWeight.Bold)
                            Text(text = point, style = MaterialTheme.typography.bodySmall)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "💬 उदाहरणहरू (Examples):",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    topic.examples.forEach { eg ->
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = eg.russian,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                    Text(
                                        text = eg.nepali,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = eg.english,
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    )
                                }
                                IconButton(
                                    onClick = { onSpeak(eg.russian) },
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
}

@Composable
private fun DialoguesSubTab(
    onSpeak: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(DialoguesData.dialogues) { dialogue ->
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = dialogue.titleNp,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = dialogue.titleRu,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Text(
                        text = "स्थिति: ${dialogue.situationNp}",
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                        modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
                    )

                    dialogue.lines.forEach { line ->
                        DialogueBubble(line = line, onSpeak = onSpeak)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogueBubble(
    line: com.example.model.DialogueLine,
    onSpeak: (String) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Surface(
                shape = CircleShape,
                color = RussianBlue,
                modifier = Modifier.size(32.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = line.speaker.firstOrNull()?.toString() ?: "👤",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = line.speaker,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = RussianBlue
                    )
                )
                Text(
                    text = line.russian,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                Text(
                    text = "${line.transliteration}  •  ${line.nepali}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
                Text(
                    text = "English: ${line.english}",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                    )
                )
            }

            IconButton(
                onClick = { onSpeak(line.russian) },
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
