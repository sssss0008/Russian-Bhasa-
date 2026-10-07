package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material3.Divider
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguageMode
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianGold
import com.example.ui.theme.RussianRed

@Composable
fun AppDrawerContent(
    currentLanguageMode: AppLanguageMode,
    onLanguageModeChange: (AppLanguageMode) -> Unit,
    speechRate: Float,
    onSpeechRateChange: (Float) -> Unit,
    onNavigateToBookmarks: () -> Unit,
    onNavigateToAbout: () -> Unit,
    onCloseDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Surface(
        modifier = modifier
            .fillMaxHeight()
            .width(320.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            // Header with Russian & Nepali greeting theme
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(RussianBlue, Color(0xFF1E293B))
                        )
                    )
                    .padding(24.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = RussianRed,
                            modifier = Modifier.size(48.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "Я",
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Russian Bhasa",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "रुसी भाषा सिकाई",
                                color = Color(0xFF93C5FD),
                                fontSize = 13.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "Учи русский язык • Learn Russian",
                        color = Color(0xFFE2E8F0),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Language Mode Section
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = "Language",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "सिकाई माध्यम (Language Mode)",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    FilterChip(
                        selected = currentLanguageMode == AppLanguageMode.TRILINGUAL,
                        onClick = { onLanguageModeChange(AppLanguageMode.TRILINGUAL) },
                        label = { Text("नेपाली + English + Русский (सबै)") },
                        modifier = Modifier.fillMaxWidth().testTag("lang_trilingual_chip")
                    )
                    FilterChip(
                        selected = currentLanguageMode == AppLanguageMode.NEPALI_FOCUSED,
                        onClick = { onLanguageModeChange(AppLanguageMode.NEPALI_FOCUSED) },
                        label = { Text("नेपाली + Русский (नेपाली माध्यम)") },
                        modifier = Modifier.fillMaxWidth().testTag("lang_nepali_chip")
                    )
                    FilterChip(
                        selected = currentLanguageMode == AppLanguageMode.ENGLISH_FOCUSED,
                        onClick = { onLanguageModeChange(AppLanguageMode.ENGLISH_FOCUSED) },
                        label = { Text("English + Русский (English Mode)") },
                        modifier = Modifier.fillMaxWidth().testTag("lang_english_chip")
                    )
                }
            }

            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

            // Speech Rate Control
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Speed,
                        contentDescription = "Audio Speed",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "उच्चारण गति (Audio Speed): ${(speechRate * 10).toInt() / 10f}x",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Slider(
                    value = speechRate,
                    onValueChange = onSpeechRateChange,
                    valueRange = 0.6f..1.3f,
                    steps = 6,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("0.6x (सुस्त)", style = MaterialTheme.typography.bodySmall)
                    Text("1.0x (सामान्य)", style = MaterialTheme.typography.bodySmall)
                    Text("1.3x (छिटो)", style = MaterialTheme.typography.bodySmall)
                }
            }

            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

            // Quick App Navigation items
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                DrawerItem(
                    icon = Icons.Default.Bookmark,
                    title = "बुकमार्क शब्दहरू (Saved Words)",
                    subtitle = "तपाईंले सुरक्षित गर्नुभएका शब्दहरू",
                    onClick = {
                        onCloseDrawer()
                        onNavigateToBookmarks()
                    }
                )
                DrawerItem(
                    icon = Icons.Default.Info,
                    title = "एपको बारेमा (About the App)",
                    subtitle = "सुविधाहरू र विकासकर्ता विवरण",
                    onClick = {
                        onCloseDrawer()
                        onNavigateToAbout()
                    }
                )
            }

            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

            // Developer & Feedback Section (Explicitly requested)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "प्रतिक्रिया र सम्पर्क (Feedback & Contact)",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "एप सम्बन्धी कुनै सल्लाह, सुझाव वा जिज्ञासा भएमा सोझै सम्पर्क गर्नुहोस्:",
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Developer card
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Author",
                                tint = RussianBlue,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Awiskar Acharya (आविष्कार आचार्य)",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Email Button
                        ContactRow(
                            icon = Icons.Default.Email,
                            label = "Email",
                            value = "awiskaracharya@gmail.com",
                            onClick = {
                                openEmail(context, "awiskaracharya@gmail.com")
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // WhatsApp Button
                        ContactRow(
                            icon = Icons.Outlined.Chat,
                            label = "WhatsApp",
                            value = "+977 9827106244",
                            onClick = {
                                openWhatsApp(context, "+9779827106244")
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // LinkedIn Button
                        ContactRow(
                            icon = Icons.Outlined.Public,
                            label = "LinkedIn",
                            value = "linkedin.com/in/awiskaracharya",
                            onClick = {
                                openUrl(context, "https://www.linkedin.com/in/awiskaracharya/")
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun DrawerItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
    }
}

@Composable
private fun ContactRow(
    icon: ImageVector,
    label: String,
    value: String,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = RussianRed,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

private fun openEmail(context: Context, email: String) {
    try {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, "Feedback for Russian Bhasa Learning App")
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Email: $email", Toast.LENGTH_LONG).show()
    }
}

private fun openWhatsApp(context: Context, phone: String) {
    try {
        val cleanPhone = phone.replace("+", "").replace(" ", "")
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$cleanPhone&text=Hello%20Awiskar,%20I%20am%20using%20the%20Russian%20Bhasa%20App!")
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "WhatsApp: $phone", Toast.LENGTH_LONG).show()
    }
}

private fun openUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, url, Toast.LENGTH_LONG).show()
    }
}
