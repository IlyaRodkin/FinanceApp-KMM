import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import di.Inject

@Composable
fun CategoriesComponent() {
    val categories = Inject.instance<CategoriesRepo>().getCategoriesList()

    Column(
        modifier = Modifier
            .offset(y = (-80).dp)
    ) {
        categories.forEach { categoryItem ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = categoryItem.icon),
                    contentDescription = categoryItem.name
                )
                Text(modifier = Modifier.padding(end = 24.dp), text = categoryItem.name)
                Text(modifier = Modifier.padding(start = 24.dp), text = "\$Money")
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
            if (categoryItem != categories.last())
                Divider()
        }
    }
}