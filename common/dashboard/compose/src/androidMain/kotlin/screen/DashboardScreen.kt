package screen

import CategoriesComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodkin.financeapp_kmm.dashboard.compose.R
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.Theme

@Composable
fun DashboardScreen() {

    val rootController = LocalRootController.current

    Box() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                TopComponent()
            }
            item {
                MiddleComponent()
            }
            item {
                BottomComponent()
            }
            item {
                CategoriesComponent()
            }
        }
        Button(
            modifier = Modifier
                .padding(16.dp)
                .size(64.dp)
                .align(Alignment.BottomEnd),
            onClick = { rootController.findRootController().push(NavigationTree.Transaction.TransactionFlow.name) },
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.fabButtonColor,
            contentColor = Theme.colors.defaultBackground)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }
}

@Composable
fun TopComponent() {
    Box(
        modifier = Modifier
            .background(Theme.colors.primaryBackground)
            .padding(bottom = 70.dp)
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = { /*TODO*/ }) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Create Game"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 130.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Expenses on",
                color = Theme.colors.primaryTextColor,
                fontSize = 34.sp,
            )
            Text(
                modifier = Modifier
                    .padding(start = 32.dp)
                    .background(
                        color = Theme.colors.primaryBackgroundBorder,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(12.dp),
                text = "Feb 19'",
                color = Theme.colors.primaryTextColor,
                fontSize = 30.sp,
            )
        }
    }
}

@Composable
fun MiddleComponent() {
    Box(
        modifier = Modifier
            .offset(y = (-35).dp)
            .clip(shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(Theme.colors.secondaryColor)
            .fillMaxWidth()
            .height(230.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.avocado),
                contentDescription = "Avocado"
            )
            Column() {
                Text(text = "$12 325", color = Theme.colors.primaryTextColor, fontSize = 25.sp)
                Text(
                    text = "/ 16 490",
                    color = Theme.colors.thirdTextColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Icon(
                modifier = Modifier,
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "more"
            )

        }
    }
}

@Composable
fun BottomComponent() {
    Box(
        modifier = Modifier
            .offset(y = (-70).dp)
            .clip(shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(Theme.colors.defaultBackground)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .background(
                        color = Theme.colors.defaultBackgroundBorder,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "arrow"
                )
                Text(text = "Expenses")
            }
            Row(
                modifier = Modifier
                    .padding(start = 32.dp)
                    .background(
                        color = Theme.colors.defaultBackgroundBorder,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "arrow"
                )
                Text(text = "Incomes")
            }
        }
    }
}

