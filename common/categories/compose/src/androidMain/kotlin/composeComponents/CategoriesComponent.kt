import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import di.Inject
import theme.Theme

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

@Composable
fun CategoryList(modifier: Modifier = Modifier) {
    val categories = Inject.instance<CategoriesRepo>().getCategoriesList()
    var visible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Theme.colors.secondaryColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .clickable { visible = !visible },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = "Category")
                Text(text = "Category doesn't Choose")
            }
            Image(
                modifier = Modifier.padding(8.dp),
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = Icons.Default.KeyboardArrowDown.name
            )
        }
        AnimatedVisibility(visible = visible) {
            Column {
                categories.forEach { categoryItem ->
                    Row(modifier = Modifier.fillMaxWidth().clickable { Toast.makeText(context,categoryItem.toString(),LENGTH_SHORT).show() },
                        verticalAlignment = CenterVertically) {
                        Image(
                            modifier = Modifier.size(60.dp),
                            painter = painterResource(id = categoryItem.icon),
                            contentDescription = categoryItem.name
                        )
                        Text(text = categoryItem.name)
                    }
                }
            }
        }
    }
}