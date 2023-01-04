package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class FinanceAppColors(
    val primaryBackground: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val hintTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color,
    val thirdTextColor: Color,
    val tagColor: Color,
    val tagTextColor: Color
)

val palette = FinanceAppColors(
    primaryBackground = Color(0xff276c35),
    primaryAction = Color(0xffa6d15d),
    primaryTextColor = Color(0xff20271f),
    hintTextColor = Color(0xFF696C75),
    highlightTextColor = Color(0xFFF4D144),
    secondaryTextColor = Color(0xff20271f),
    thirdTextColor = Color(0xFFEEF2FB),
    tagColor = Color(0x1844A9F4),
    tagTextColor = Color(0xFF44A9F4)
)

val LocalColorProvider = staticCompositionLocalOf<FinanceAppColors> { error("No default implementation") }