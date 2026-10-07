package com.example.ui.screens

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.ui.theme.RussianBlue
import com.example.ui.theme.RussianGold
import com.example.ui.theme.RussianRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("एपको बारेमा (About the App)", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick, modifier = Modifier.testTag("about_back_btn")) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            // App Banner Header
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(RussianBlue, Color(0xFF1E40AF), RussianRed)
                            )
                        )
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Surface(
                            shape = CircleShape,
                            color = RussianRed,
                            modifier = Modifier.size(72.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "Я",
                                    fontSize = 36.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Russian Bhasa",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "रुसी भाषा सिकाई • नेपाली र अंग्रेजी माध्यम",
                            fontSize = 13.sp,
                            color = Color(0xFFE2E8F0),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0x33FFFFFF),
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text(
                                text = "Version 1.0 • Offline Ready",
                                color = Color.White,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // App Mission & Overview
            Text(
                text = "एपको उद्देश्य र दृष्टिकोण (Vision):",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Russian Bhasa नेपाली, अंग्रेजी र रुसी भाषीहरूलाई जोड्ने आधुनिक र पूर्ण भाषा सिकाई मञ्च हो। रुसमा उच्च शिक्षा, चिकित्सा, इन्जिनियरिङ, कूटनीति वा पर्यटनका लागि जाने नेपाली विद्यार्थी तथा विश्वभरका शिक्षार्थीहरूलाई सहज, रमाइलो र वैज्ञानिक ढंगले रुसी भाषा सिकाउन यो एप तयार पारिएको हो।",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 22.sp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Features Breakdown
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "✨ मुख्य सुविधाहरू (Core Features):",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FeatureCheckItem("३३ वटै सिरिलिक अक्षरहरू (अडियो, नेपाली र अंग्रेजी उच्चारण विधि सहित)")
                    FeatureCheckItem("१०+ महत्वपूर्ण विषयहरूमा १००+ भन्दा बढी आवश्यक रुसी शब्दावली")
                    FeatureCheckItem("रुसी ६ कारकहरू, लिङ्ग, र क्रियापदको रूप नेपालीमा सरल व्याख्या")
                    FeatureCheckItem("दैनिक व्यावहारिक कुराकानी (विमानस्थल, क्याफे, सडक, मित्रता)")
                    FeatureCheckItem("अन्तरक्रियात्मक क्विज, फ्ल्यासकार्ड, र जोडा मिलाउने खेल")
                    FeatureCheckItem("रुसी परम्परा, मत्र्योस्का, समोभार, साहित्य, र नेपाल-रुस सम्बन्धका सचित्र लेखहरू")
                    FeatureCheckItem("एन्ड्रोइड नेटिभ Text-to-Speech द्वारा शुद्ध रुसी उच्चारण र गति नियन्त्रण")
                    FeatureCheckItem("शब्दहरू बुकमार्क गर्ने र सुरक्षित राख्ने सुविधा")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Developer & Feedback Section (Explicitly requested by user)
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = RussianBlue,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "विकासकर्ता र सम्पर्क (Developer & Feedback)",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "Awiskar Acharya (आविष्कार आचार्य)",
                                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "तपाईंको प्रतिक्रिया, सुझाव वा प्रश्नहरू हाम्रा लागि अमूल्य छन्। कृपया तलका माध्यमबाट सोझै सम्पर्क गर्नुहोस्:",
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Email Action Button
                    ContactActionButton(
                        icon = Icons.Default.Email,
                        title = "Email (इमेल पठाउनुहोस्)",
                        value = "awiskaracharya@gmail.com",
                        badgeColor = RussianRed,
                        onClick = {
                            openEmail(context, "awiskaracharya@gmail.com")
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // WhatsApp Action Button
                    ContactActionButton(
                        icon = Icons.Outlined.Chat,
                        title = "WhatsApp (ह्वाट्सएप च्याट)",
                        value = "+977 9827106244",
                        badgeColor = Color(0xFF25D366),
                        onClick = {
                            openWhatsApp(context, "+9779827106244")
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // LinkedIn Action Button
                    ContactActionButton(
                        icon = Icons.Outlined.Public,
                        title = "LinkedIn (लिंक्डइन प्रोफाइल)",
                        value = "https://www.linkedin.com/in/awiskaracharya/",
                        badgeColor = Color(0xFF0077B5),
                        onClick = {
                            openUrl(context, "https://www.linkedin.com/in/awiskaracharya/")
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Footer note
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Made with ",
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Love",
                    tint = RussianRed,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = " for Language Lovers in Nepal & Worldwide",
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun FeatureCheckItem(text: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = RussianBlue,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface)
        )
    }
}

@Composable
private fun ContactActionButton(
    icon: ImageVector,
    title: String,
    value: String,
    badgeColor: Color,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = badgeColor.copy(alpha = 0.15f),
                modifier = Modifier.size(38.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = badgeColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary)
                )
            }
            Text(
                text = "खोल्नुहोस् >",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
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
