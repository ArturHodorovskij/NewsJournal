package com.example.newsjournal.presentation.design

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

private const val INFINITE_ANIMATION_LABEL = "SHIMMER_INFINITE_ANIMATION_LABEL"
private const val ANIMATION_LABEL = "SHIMMER_ANIMATION_LABEL"
private const val ANIMATION_DURATION_MS = 1300
private const val ANIMATION_DELAY_MS = 700
private const val SHADOW_BRUSH_WIDTH_DP = 180
private const val NO_OFFSET = 0f


@Composable
fun Modifier.shimmer(): Modifier {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenWidth = remember {
        with(density) {
            configuration.screenWidthDp.dp.toPx()
        }
    }
    val shadowBrushWidthPx = remember {
        with(density) { SHADOW_BRUSH_WIDTH_DP.dp.toPx() }
    }
    var offsetX by remember { mutableFloatStateOf(0f) }
    val transitionAnimation by rememberInfiniteTransition(label = INFINITE_ANIMATION_LABEL).animateFloat(
        initialValue = -offsetX,
        targetValue = screenWidth - offsetX + shadowBrushWidthPx,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = ANIMATION_DURATION_MS,
                delayMillis = ANIMATION_DELAY_MS,
                easing = LinearEasing
            )
        ),
        label = ANIMATION_LABEL
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f)
        ),
        start = Offset(x = transitionAnimation - shadowBrushWidthPx, y = NO_OFFSET),
        end = Offset(x = transitionAnimation, y = NO_OFFSET)
    )

    return background(brush).onGloballyPositioned { offsetX = it.positionInWindow().x }
}