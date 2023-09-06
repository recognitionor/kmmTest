package com.jhlee.kmmtest.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.jhlee.kmmtest.ui.theme.BackgroundDark
import com.jhlee.kmmtest.ui.theme.BackgroundLight
import com.jhlee.kmmtest.ui.theme.ErrorContainerDark
import com.jhlee.kmmtest.ui.theme.ErrorContainerLight
import com.jhlee.kmmtest.ui.theme.ErrorDark
import com.jhlee.kmmtest.ui.theme.ErrorLight
import com.jhlee.kmmtest.ui.theme.GreenContainerDark
import com.jhlee.kmmtest.ui.theme.GreenContainerLight
import com.jhlee.kmmtest.ui.theme.GreenPrimaryDark
import com.jhlee.kmmtest.ui.theme.GreenPrimaryLight
import com.jhlee.kmmtest.ui.theme.GreenSecondaryContainerDark
import com.jhlee.kmmtest.ui.theme.GreenSecondaryContainerLight
import com.jhlee.kmmtest.ui.theme.GreenSecondaryDark
import com.jhlee.kmmtest.ui.theme.GreenSecondaryLight
import com.jhlee.kmmtest.ui.theme.GreenTertiaryContainerDark
import com.jhlee.kmmtest.ui.theme.GreenTertiaryContainerLight
import com.jhlee.kmmtest.ui.theme.GreenTertiaryDark
import com.jhlee.kmmtest.ui.theme.GreenTertiaryLight
import com.jhlee.kmmtest.ui.theme.OnBackgroundDark
import com.jhlee.kmmtest.ui.theme.OnBackgroundLight
import com.jhlee.kmmtest.ui.theme.OnErrorContainerDark
import com.jhlee.kmmtest.ui.theme.OnErrorContainerLight
import com.jhlee.kmmtest.ui.theme.OnErrorDark
import com.jhlee.kmmtest.ui.theme.OnErrorLight
import com.jhlee.kmmtest.ui.theme.OnGreenContainerDark
import com.jhlee.kmmtest.ui.theme.OnGreenContainerLight
import com.jhlee.kmmtest.ui.theme.OnGreenDark
import com.jhlee.kmmtest.ui.theme.OnGreenLight
import com.jhlee.kmmtest.ui.theme.OnGreenSecondaryContainerDark
import com.jhlee.kmmtest.ui.theme.OnGreenSecondaryContainerLight
import com.jhlee.kmmtest.ui.theme.OnGreenSecondaryDark
import com.jhlee.kmmtest.ui.theme.OnGreenSecondaryLight
import com.jhlee.kmmtest.ui.theme.OnGreenTertiaryContainerDark
import com.jhlee.kmmtest.ui.theme.OnGreenTertiaryContainerLight
import com.jhlee.kmmtest.ui.theme.OnGreenTertiaryDark
import com.jhlee.kmmtest.ui.theme.OnGreenTertiaryLight
import com.jhlee.kmmtest.ui.theme.OnSurfaceDark
import com.jhlee.kmmtest.ui.theme.OnSurfaceLight
import com.jhlee.kmmtest.ui.theme.OnSurfaceVariantDark
import com.jhlee.kmmtest.ui.theme.OnSurfaceVariantLight
import com.jhlee.kmmtest.ui.theme.OutlineDark
import com.jhlee.kmmtest.ui.theme.OutlineLight
import com.jhlee.kmmtest.ui.theme.SurfaceDark
import com.jhlee.kmmtest.ui.theme.SurfaceLight
import com.jhlee.kmmtest.ui.theme.SurfaceVariantDark
import com.jhlee.kmmtest.ui.theme.SurfaceVariantLight

val DarkColorScheme = darkColorScheme(
    primary = GreenPrimaryDark,
    secondary = GreenSecondaryDark,
    tertiary = GreenTertiaryDark,
    onPrimary = OnGreenDark,
    primaryContainer = GreenContainerDark,
    onPrimaryContainer = OnGreenContainerDark,
    onSecondary = OnGreenSecondaryDark,
    secondaryContainer = GreenSecondaryContainerDark,
    onSecondaryContainer = OnGreenSecondaryContainerDark,
    onTertiary = OnGreenTertiaryDark,
    onTertiaryContainer = OnGreenTertiaryContainerDark,
    tertiaryContainer = GreenTertiaryContainerDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
    outline = OutlineDark,
)

val LightColorScheme = lightColorScheme(
    primary = GreenPrimaryLight,
    secondary = GreenSecondaryLight,
    tertiary = GreenTertiaryLight,
    onPrimary = OnGreenLight,
    primaryContainer = GreenContainerLight,
    onPrimaryContainer = OnGreenContainerLight,
    onSecondary = OnGreenSecondaryLight,
    secondaryContainer = GreenSecondaryContainerLight,
    onSecondaryContainer = OnGreenSecondaryContainerLight,
    onTertiary = OnGreenTertiaryLight,
    onTertiaryContainer = OnGreenTertiaryContainerLight,
    tertiaryContainer = GreenTertiaryContainerLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
    outline = OutlineLight,
)