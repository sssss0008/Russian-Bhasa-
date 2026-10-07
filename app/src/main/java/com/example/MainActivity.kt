package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AlphabetLetter
import com.example.model.AppLanguageMode
import com.example.ui.components.AlphabetDetailDialog
import com.example.ui.components.AppDrawerContent
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.BookmarksScreen
import com.example.ui.screens.CultureScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearnScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.theme.RussianAppTheme
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianGold
import com.example.ui.theme.RussianRed
import com.example.util.PreferencesHelper
import com.example.util.TtsHelper
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var ttsHelper: TtsHelper
    private lateinit var prefsHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ttsHelper = TtsHelper(this)
        prefsHelper = PreferencesHelper(this)

        setContent {
            RussianAppTheme {
                MainAppContainer(
                    ttsHelper = ttsHelper,
                    prefsHelper = prefsHelper
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ttsHelper.shutdown()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppContainer(
    ttsHelper: TtsHelper,
    prefsHelper: PreferencesHelper
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    var currentTab by remember { mutableIntStateOf(0) }
    var learnSubTab by remember { mutableIntStateOf(0) }
    var cultureAboutSubTab by remember { mutableIntStateOf(0) } // 0 = Culture, 1 = About & Contact

    var showingBookmarks by remember { mutableStateOf(false) }
    var showingAboutDirectly by remember { mutableStateOf(false) }

    var selectedLetterForDialog by remember { mutableStateOf<AlphabetLetter?>(null) }

    var languageMode by remember { mutableStateOf(prefsHelper.getLanguageMode()) }
    var bookmarkedIds by remember { mutableStateOf(prefsHelper.getBookmarkedWordIds()) }
    var streakCount by remember { mutableIntStateOf(prefsHelper.getLearningStreak()) }
    var quizzesCompleted by remember { mutableIntStateOf(prefsHelper.getQuizzesCompleted()) }
    var quizPoints by remember { mutableIntStateOf(prefsHelper.getTotalQuizPoints()) }
    var speechRate by remember { mutableStateOf(ttsHelper.speechRate) }

    // System Back handling
    BackHandler(enabled = drawerState.isOpen || showingBookmarks || showingAboutDirectly || currentTab != 0) {
        when {
            drawerState.isOpen -> coroutineScope.launch { drawerState.close() }
            showingBookmarks -> showingBookmarks = false
            showingAboutDirectly -> showingAboutDirectly = false
            currentTab != 0 -> currentTab = 0
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                AppDrawerContent(
                    currentLanguageMode = languageMode,
                    onLanguageModeChange = { newMode ->
                        languageMode = newMode
                        prefsHelper.setLanguageMode(newMode)
                    },
                    speechRate = speechRate,
                    onSpeechRateChange = { newRate ->
                        speechRate = newRate
                        ttsHelper.updateSpeechRate(newRate)
                    },
                    onNavigateToBookmarks = {
                        showingBookmarks = true
                        showingAboutDirectly = false
                    },
                    onNavigateToAbout = {
                        showingAboutDirectly = true
                        showingBookmarks = false
                    },
                    onCloseDrawer = {
                        coroutineScope.launch { drawerState.close() }
                    }
                )
            }
        }
    ) {
        if (showingBookmarks) {
            BookmarksScreen(
                bookmarkedIds = bookmarkedIds,
                languageMode = languageMode,
                onSpeak = { ttsHelper.speakRussian(it) },
                onBookmarkToggle = { id ->
                    prefsHelper.toggleBookmark(id)
                    bookmarkedIds = prefsHelper.getBookmarkedWordIds()
                },
                onBackClick = { showingBookmarks = false }
            )
        } else if (showingAboutDirectly) {
            AboutScreen(
                onBackClick = { showingAboutDirectly = false }
            )
        } else {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = when (currentTab) {
                                    0 -> "Russian Bhasa (रुसी भाषा)"
                                    1 -> "सिक्नुहोस् (Learn)"
                                    2 -> "अभ्यास (Practice)"
                                    else -> if (cultureAboutSubTab == 0) "संस्कृति र इतिहास (Culture)" else "विवरण र सम्पर्क (About)"
                                },
                                fontWeight = FontWeight.Bold,
                                fontSize = 19.sp
                            )
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = { coroutineScope.launch { drawerState.open() } },
                                modifier = Modifier.testTag("app_drawer_open_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Open Drawer"
                                )
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = { showingBookmarks = true },
                                modifier = Modifier.testTag("top_bookmarks_btn")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bookmark,
                                    contentDescription = "Bookmarks",
                                    tint = if (bookmarkedIds.isNotEmpty()) RussianGold else MaterialTheme.colorScheme.onSurface
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                },
                bottomBar = {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 6.dp,
                        modifier = Modifier.testTag("main_bottom_nav")
                    ) {
                        NavigationBarItem(
                            selected = currentTab == 0,
                            onClick = { currentTab = 0 },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 0) Icons.Default.Home else Icons.Outlined.Home,
                                    contentDescription = "Home"
                                )
                            },
                            label = { Text("गृहपृष्ठ (Home)") },
                            modifier = Modifier.testTag("nav_item_home")
                        )
                        NavigationBarItem(
                            selected = currentTab == 1,
                            onClick = { currentTab = 1 },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 1) Icons.Default.School else Icons.Outlined.School,
                                    contentDescription = "Learn"
                                )
                            },
                            label = { Text("सिक्नुहोस् (Learn)") },
                            modifier = Modifier.testTag("nav_item_learn")
                        )
                        NavigationBarItem(
                            selected = currentTab == 2,
                            onClick = { currentTab = 2 },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 2) Icons.Default.FitnessCenter else Icons.Outlined.FitnessCenter,
                                    contentDescription = "Practice"
                                )
                            },
                            label = { Text("अभ्यास (Practice)") },
                            modifier = Modifier.testTag("nav_item_practice")
                        )
                        NavigationBarItem(
                            selected = currentTab == 3,
                            onClick = { currentTab = 3 },
                            icon = {
                                Icon(
                                    imageVector = if (currentTab == 3) Icons.Default.Info else Icons.Outlined.Info,
                                    contentDescription = "Culture & Details"
                                )
                            },
                            label = { Text("विवरण (About)") },
                            modifier = Modifier.testTag("nav_item_details")
                        )
                    }
                },
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    when (currentTab) {
                        0 -> HomeScreen(
                            languageMode = languageMode,
                            streakCount = streakCount,
                            quizzesCompleted = quizzesCompleted,
                            quizPoints = quizPoints,
                            onSpeak = { ttsHelper.speakRussian(it) },
                            onNavigateToLearnTab = { subIndex ->
                                learnSubTab = subIndex
                                currentTab = 1
                            },
                            onNavigateToPracticeTab = { currentTab = 2 },
                            onNavigateToCultureTab = {
                                cultureAboutSubTab = 0
                                currentTab = 3
                            },
                            onSelectLetter = { selectedLetterForDialog = it }
                        )
                        1 -> LearnScreen(
                            initialSubTab = learnSubTab,
                            languageMode = languageMode,
                            bookmarkedIds = bookmarkedIds,
                            onSpeak = { ttsHelper.speakRussian(it) },
                            onBookmarkToggle = { id ->
                                prefsHelper.toggleBookmark(id)
                                bookmarkedIds = prefsHelper.getBookmarkedWordIds()
                            }
                        )
                        2 -> PracticeScreen(
                            languageMode = languageMode,
                            onSpeak = { ttsHelper.speakRussian(it) },
                            onQuizFinished = { score ->
                                prefsHelper.recordQuizCompletion(score)
                                quizzesCompleted = prefsHelper.getQuizzesCompleted()
                                quizPoints = prefsHelper.getTotalQuizPoints()
                                prefsHelper.incrementStreak()
                                streakCount = prefsHelper.getLearningStreak()
                            }
                        )
                        3 -> {
                            // 4th Navigation Tab: Culture & About Details
                            androidx.compose.foundation.layout.Column(modifier = Modifier.fillMaxSize()) {
                                TabRow(
                                    selectedTabIndex = cultureAboutSubTab,
                                    containerColor = MaterialTheme.colorScheme.surface,
                                    contentColor = MaterialTheme.colorScheme.primary
                                ) {
                                    Tab(
                                        selected = cultureAboutSubTab == 0,
                                        onClick = { cultureAboutSubTab = 0 },
                                        text = { Text("संस्कृति र इतिहास (Culture)", fontWeight = FontWeight.Bold) },
                                        icon = { Icon(imageVector = Icons.Default.Public, contentDescription = null) }
                                    )
                                    Tab(
                                        selected = cultureAboutSubTab == 1,
                                        onClick = { cultureAboutSubTab = 1 },
                                        text = { Text("एप विवरण र सम्पर्क (About)", fontWeight = FontWeight.Bold) },
                                        icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) }
                                    )
                                }

                                if (cultureAboutSubTab == 0) {
                                    CultureScreen(
                                        onSpeak = { ttsHelper.speakRussian(it) }
                                    )
                                } else {
                                    AboutScreen(
                                        onBackClick = { currentTab = 0 }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    selectedLetterForDialog?.let { letter ->
        AlphabetDetailDialog(
            letter = letter,
            onDismiss = { selectedLetterForDialog = null },
            onSpeak = { ttsHelper.speakRussian(it) }
        )
    }
}
