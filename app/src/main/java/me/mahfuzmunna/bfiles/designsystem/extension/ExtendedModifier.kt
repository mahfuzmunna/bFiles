package me.mahfuzmunna.bfiles.designsystem.extension

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.tan

fun Modifier.addGradientToBox(colorScheme: ColorScheme): Modifier {
    return drawWithCache {
        val offset = size.height * tan(
            Math.toRadians(11.11).toFloat()
        )
        val start = Offset(size.width / 2 + offset / 2, 0f)
        val end = Offset(size.width / 2 - offset / 2, size.height)

        val topGradient = Brush.linearGradient(
            0f to colorScheme.inverseOnSurface,
            0.725f to Color.Transparent,
            start = start,
            end = end,
        )
        val bottomGradient = Brush.linearGradient(
            0.225f to Color.Transparent,
            1f to colorScheme.primaryContainer,
            start = start,
            end = end
        )

        onDrawBehind {
            drawRect(topGradient)
            drawRect(bottomGradient)
        }
    }
}

fun Modifier.fillMaxAvailableHeight() {
    //calculate fraction available
    this.fillMaxHeight()
}