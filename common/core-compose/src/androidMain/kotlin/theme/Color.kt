package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class FinanceAppColors(
    val primaryBackground: Color,
    val primaryBackgroundBorder: Color,
    val secondaryColor: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val hintTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color,
    val thirdTextColor: Color,
    val tagColor: Color,
    val tagTextColor: Color,
    val defaultBackground: Color,
    val defaultBackgroundBorder: Color,
    val fabButtonColor:Color
)

val palette = FinanceAppColors(
    primaryBackground = Color(0xff276c35),
    primaryBackgroundBorder = Color(0xff357242),
    secondaryColor = Color(0xffa5d15b),
    primaryAction = Color(0xffa6d15d),
    primaryTextColor = Color(0xffffffff),
    hintTextColor = Color(0xFF696C75),
    highlightTextColor = Color(0xFFF4D144),
    secondaryTextColor = Color(0xff20271f),
    thirdTextColor = Color(0xff737d40),
    tagColor = Color(0x1844A9F4),
    tagTextColor = Color(0xFF44A9F4),
    defaultBackground = Color(0xffffffff),
    defaultBackgroundBorder = Color(0xffe3e3e3),
    fabButtonColor = Color(0xff0d2b10),
)

val LocalColorProvider = staticCompositionLocalOf<FinanceAppColors> { error("No default implementation") }