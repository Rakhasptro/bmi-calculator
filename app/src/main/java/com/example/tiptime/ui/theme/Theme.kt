/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tiptime.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = Color.White,
    primaryContainer = PrimaryBlueDark,
    onPrimaryContainer = Color.White,

    secondary = PrimaryBlueDark,
    onSecondary = Color.White,
    secondaryContainer = CardBackground,
    onSecondaryContainer = TextPrimary,

    tertiary = PrimaryBlue,
    onTertiary = Color.White,
    tertiaryContainer = CardBackground,
    onTertiaryContainer = TextPrimary,

    error = Color(0xFFB00020),
    errorContainer = Color(0xFFB00020),
    onError = Color.White,
    onErrorContainer = Color.White,

    background = BackgroundLight,
    onBackground = TextPrimary,
    surface = CardBackground,
    onSurface = TextPrimary,
    surfaceVariant = BackgroundLight,
    onSurfaceVariant = TextSecondary,
    outline = TextSecondary,
    inverseOnSurface = Color.White,
    inverseSurface = PrimaryBlueDark,
    inversePrimary = PrimaryBlueDark,
    surfaceTint = PrimaryBlue,
    outlineVariant = TextSecondary,
    scrim = Color.Black.copy(alpha = 0.5f),
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlueDark,
    onPrimary = Color.White,
    primaryContainer = PrimaryBlue,
    onPrimaryContainer = Color.White,

    secondary = PrimaryBlue,
    onSecondary = Color.White,
    secondaryContainer = CardBackground,
    onSecondaryContainer = TextPrimary,

    tertiary = PrimaryBlueDark,
    onTertiary = Color.White,
    tertiaryContainer = CardBackground,
    onTertiaryContainer = TextPrimary,

    error = Color(0xFFCF6679),
    errorContainer = Color(0xFFCF6679),
    onError = Color.Black,
    onErrorContainer = Color.Black,

    background = Color(0xFF0B1220),
    onBackground = Color.White,
    surface = Color(0xFF071022),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF172033),
    onSurfaceVariant = TextSecondary,
    outline = TextSecondary,
    inverseOnSurface = TextPrimary,
    inverseSurface = PrimaryBlue,
    inversePrimary = PrimaryBlue,
    surfaceTint = PrimaryBlueDark,
    outlineVariant = TextSecondary,
    scrim = Color.Black.copy(alpha = 0.7f),
)

@Composable
fun TipTimeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // Dynamic color in this app is turned off for learning purposes
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
