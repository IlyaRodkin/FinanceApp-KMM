import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import di.Inject
import models.Category

@Composable
fun CategoriesComponent() {
    val categories: CategoriesRepo = Inject.instance()

    Row() {
        /*Icon(
            bitmap = BitmapFactory.decodeFile(categories.first().icon).asImageBitmap(),
            contentDescription = ""
        )*/
        Text(text = categories.getCategoriesList().first().name)
    }
}