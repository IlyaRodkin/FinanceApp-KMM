package screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import theme.Theme

@Composable
fun DashboardScreen() {
    Box(modifier = Modifier
        .background(Theme.colors.primaryBackground)
        .fillMaxSize()) {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = { /*TODO*/ }) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Create Game"
            )
        }
    }
}
