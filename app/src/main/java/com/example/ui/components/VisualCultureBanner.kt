package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun VisualCultureBanner(
    bannerType: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        when (bannerType) {
            "MATRYOSHKA" -> MatryoshkaBanner()
            "SAMOVAR" -> SamovarBanner()
            "KREMLIN" -> KremlinBanner()
            "LITERATURE" -> LiteratureBanner()
            "WINTER" -> WinterBanner()
            "NEPAL_RUSSIA" -> NepalRussiaBanner()
            else -> DefaultRussianBanner()
        }
    }
}

@Composable
fun MatryoshkaBanner() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Background Warm Amber to Deep Russian Crimson Gradient
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFF991B1B), Color(0xFFC2410C), Color(0xFFD97706)),
                start = Offset(0f, 0f),
                end = Offset(w, h)
            )
        )

        // Folk floral circles background
        for (i in 0..6) {
            drawCircle(
                color = Color(0x22FFFFFF),
                radius = 30f + (i * 12f),
                center = Offset(w * 0.15f * i, h * 0.85f)
            )
        }

        // Draw Stylized Matryoshka Doll in center right
        val dollCenterX = w * 0.72f
        val dollBaseY = h * 0.88f

        // Doll bottom body
        drawOval(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFFDC2626), Color(0xFF7F1D1D))
            ),
            topLeft = Offset(dollCenterX - 65f, dollBaseY - 110f),
            size = Size(130f, 110f)
        )

        // Doll head / upper body
        drawCircle(
            color = Color(0xFFDC2626),
            radius = 45f,
            center = Offset(dollCenterX, dollBaseY - 95f)
        )

        // Doll face circle (Cream)
        drawCircle(
            color = Color(0xFFFEF3C7),
            radius = 28f,
            center = Offset(dollCenterX, dollBaseY - 95f)
        )

        // Scarf knot & details
        drawCircle(
            color = Color(0xFFFBBF24),
            radius = 7f,
            center = Offset(dollCenterX, dollBaseY - 65f)
        )

        // Rosy cheeks
        drawCircle(color = Color(0x66F87171), radius = 5f, center = Offset(dollCenterX - 12f, dollBaseY - 92f))
        drawCircle(color = Color(0x66F87171), radius = 5f, center = Offset(dollCenterX + 12f, dollBaseY - 92f))

        // Eyes and smile
        drawCircle(color = Color(0xFF1E293B), radius = 2.5f, center = Offset(dollCenterX - 9f, dollBaseY - 98f))
        drawCircle(color = Color(0xFF1E293B), radius = 2.5f, center = Offset(dollCenterX + 9f, dollBaseY - 98f))

        // Golden floral belly ornament
        drawCircle(
            color = Color(0xFFFDE68A),
            radius = 18f,
            center = Offset(dollCenterX, dollBaseY - 45f)
        )
        drawCircle(
            color = Color(0xFFB45309),
            radius = 9f,
            center = Offset(dollCenterX, dollBaseY - 45f)
        )

        // Smaller sister doll next to it
        val smallX = w * 0.45f
        drawOval(
            color = Color(0xFFD97706),
            topLeft = Offset(smallX - 40f, dollBaseY - 80f),
            size = Size(80f, 80f)
        )
        drawCircle(
            color = Color(0xFFFEF3C7),
            radius = 20f,
            center = Offset(smallX, dollBaseY - 68f)
        )
    }
}

@Composable
fun SamovarBanner() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Rich Warm Tea Amber gradient
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFF78350F), Color(0xFFB45309), Color(0xFFD97706)),
                start = Offset(0f, 0f),
                end = Offset(w, h)
            )
        )

        // Steam waves in sky
        val steamPath = Path().apply {
            moveTo(w * 0.7f, h * 0.4f)
            quadraticTo(w * 0.65f, h * 0.25f, w * 0.72f, h * 0.12f)
            quadraticTo(w * 0.76f, h * 0.05f, w * 0.71f, 0f)
        }
        drawPath(
            path = steamPath,
            color = Color(0x66FFFFFF),
            style = Stroke(width = 6f)
        )

        // Samovar silhouette (Brass / Gold)
        val sX = w * 0.72f
        val sY = h * 0.85f

        // Samovar base pedestal
        drawRect(
            color = Color(0xFFF59E0B),
            topLeft = Offset(sX - 45f, sY - 15f),
            size = Size(90f, 15f)
        )
        // Pedestal legs
        drawRect(color = Color(0xFFD97706), topLeft = Offset(sX - 40f, sY), size = Size(15f, 10f))
        drawRect(color = Color(0xFFD97706), topLeft = Offset(sX + 25f, sY), size = Size(15f, 10f))

        // Samovar body (grand brass urn)
        drawOval(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFFFDE68A), Color(0xFFF59E0B), Color(0xFFB45309))
            ),
            topLeft = Offset(sX - 55f, sY - 110f),
            size = Size(110f, 95f)
        )

        // Samovar neck and chimney
        drawRect(
            color = Color(0xFFF59E0B),
            topLeft = Offset(sX - 25f, sY - 135f),
            size = Size(50f, 25f)
        )

        // Teapot on top (crown)
        drawOval(
            color = Color(0xFFDC2626),
            topLeft = Offset(sX - 30f, sY - 165f),
            size = Size(60f, 32f)
        )
        drawCircle(
            color = Color(0xFFFDE68A),
            radius = 6f,
            center = Offset(sX, sY - 168f)
        )

        // Spigot and handle
        drawRect(
            color = Color(0xFF78350F),
            topLeft = Offset(sX - 65f, sY - 60f),
            size = Size(20f, 8f)
        )

        // Side handles
        drawArc(
            color = Color(0xFFB45309),
            startAngle = 120f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(sX + 45f, sY - 95f),
            size = Size(25f, 40f),
            style = Stroke(width = 6f)
        )
    }
}

@Composable
fun KremlinBanner() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Midnight Blue sky with starry ambiance
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF0F172A), Color(0xFF1E3A8A), Color(0xFF312E81))
            )
        )

        // Moon
        drawCircle(
            color = Color(0xFFFEF08A),
            radius = 22f,
            center = Offset(w * 0.2f, h * 0.25f)
        )

        // Distant Kremlin wall battlement silhouettes
        val wallY = h * 0.85f
        drawRect(
            color = Color(0xFF7F1D1D),
            topLeft = Offset(0f, wallY),
            size = Size(w, h - wallY)
        )

        // Saint Basil's Onion Domes in vibrant colors!
        val domes = listOf(
            Triple(w * 0.55f, wallY - 45f, Color(0xFF059669)), // Green
            Triple(w * 0.72f, wallY - 80f, Color(0xFFDC2626)), // Red & Gold center
            Triple(w * 0.88f, wallY - 40f, Color(0xFF2563EB))  // Blue
        )

        for ((dx, dy, domeColor) in domes) {
            // Tower base
            drawRect(
                color = Color(0xFF991B1B),
                topLeft = Offset(dx - 22f, dy),
                size = Size(44f, wallY - dy)
            )

            // Onion dome shape
            val domePath = Path().apply {
                moveTo(dx, dy - 45f) // Spire tip
                cubicTo(dx + 30f, dy - 25f, dx + 28f, dy, dx, dy + 5f)
                cubicTo(dx - 28f, dy, dx - 30f, dy - 25f, dx, dy - 45f)
                close()
            }
            drawPath(
                path = domePath,
                color = domeColor,
                style = Fill
            )

            // Golden Orthodox Cross on top
            drawLine(
                color = Color(0xFFFDE047),
                start = Offset(dx, dy - 45f),
                end = Offset(dx, dy - 60f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color(0xFFFDE047),
                start = Offset(dx - 6f, dy - 54f),
                end = Offset(dx + 6f, dy - 54f),
                strokeWidth = 3f
            )
        }
    }
}

@Composable
fun LiteratureBanner() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Deep scholarly parchment & navy
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFF1E293B), Color(0xFF334155), Color(0xFF475569))
            )
        )

        // Quill feather pen path
        val quillPath = Path().apply {
            moveTo(w * 0.8f, h * 0.15f)
            quadraticTo(w * 0.72f, h * 0.45f, w * 0.65f, h * 0.85f)
            quadraticTo(w * 0.75f, h * 0.55f, w * 0.8f, h * 0.15f)
            close()
        }
        drawPath(
            path = quillPath,
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFFF59E0B), Color(0xFFFEF3C7))
            )
        )

        // Open book silhouette
        val bX = w * 0.35f
        val bY = h * 0.65f
        drawRect(
            color = Color(0xFFF8FAFC),
            topLeft = Offset(bX - 70f, bY - 35f),
            size = Size(140f, 50f)
        )
        // Book spine
        drawLine(
            color = Color(0xFF94A3B8),
            start = Offset(bX, bY - 35f),
            end = Offset(bX, bY + 15f),
            strokeWidth = 3f
        )
    }
}

@Composable
fun WinterBanner() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Winter twilight gradient
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF1E3A8A), Color(0xFF60A5FA), Color(0xFFE2E8F0))
            )
        )

        // Snow hills
        val hillPath = Path().apply {
            moveTo(0f, h * 0.7f)
            quadraticTo(w * 0.35f, h * 0.55f, w * 0.7f, h * 0.75f)
            quadraticTo(w * 0.85f, h * 0.82f, w, h * 0.7f)
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(path = hillPath, color = Color.White)

        // Falling snowflakes
        val snowPositions = listOf(
            Offset(w * 0.1f, h * 0.2f), Offset(w * 0.25f, h * 0.4f),
            Offset(w * 0.4f, h * 0.15f), Offset(w * 0.65f, h * 0.3f),
            Offset(w * 0.8f, h * 0.18f), Offset(w * 0.9f, h * 0.45f)
        )
        for (pos in snowPositions) {
            drawCircle(color = Color.White, radius = 4f, center = pos)
        }

        // Fir / Pine trees (Ёлка)
        val treeX = w * 0.75f
        val treeBaseY = h * 0.72f
        val treePath = Path().apply {
            moveTo(treeX, treeBaseY - 60f)
            lineTo(treeX + 22f, treeBaseY - 35f)
            lineTo(treeX + 10f, treeBaseY - 35f)
            lineTo(treeX + 30f, treeBaseY)
            lineTo(treeX - 30f, treeBaseY)
            lineTo(treeX - 10f, treeBaseY - 35f)
            lineTo(treeX - 22f, treeBaseY - 35f)
            close()
        }
        drawPath(path = treePath, color = Color(0xFF047857))
    }
}

@Composable
fun NepalRussiaBanner() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Background sky blending Russian Blue and Himalayan Crimson
        drawRect(
            brush = Brush.horizontalGradient(
                colors = listOf(Color(0xFF1E3A8A), Color(0xFF4338CA), Color(0xFFDC2626))
            )
        )

        // Himalayan peaks silhouette on right
        val peakPath = Path().apply {
            moveTo(w * 0.4f, h)
            lineTo(w * 0.6f, h * 0.35f)
            lineTo(w * 0.75f, h * 0.6f)
            lineTo(w * 0.88f, h * 0.25f)
            lineTo(w, h * 0.5f)
            lineTo(w, h)
            close()
        }
        drawPath(path = peakPath, color = Color(0x55FFFFFF))

        // Russian Tricolor ribbon in a gentle wave
        val wavePath = Path().apply {
            moveTo(0f, h * 0.75f)
            quadraticTo(w * 0.5f, h * 0.65f, w, h * 0.85f)
        }
        drawLine(
            color = Color.White,
            start = Offset(0f, h * 0.75f),
            end = Offset(w, h * 0.75f),
            strokeWidth = 6f
        )
        drawLine(
            color = Color(0xFF2563EB),
            start = Offset(0f, h * 0.82f),
            end = Offset(w, h * 0.82f),
            strokeWidth = 6f
        )
        drawLine(
            color = Color(0xFFDC2626),
            start = Offset(0f, h * 0.89f),
            end = Offset(w, h * 0.89f),
            strokeWidth = 6f
        )
    }
}

@Composable
fun DefaultRussianBanner() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF1E3A8A), Color(0xFFDC2626))
                )
            )
    )
}
