import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import components.SegmentText
import components.SegmentedControl
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.Theme
import transaction.TransactionViewModel
import transaction.models.TransactionAction
import transaction.models.TransactionEvent
import transaction.models.TransactionViewState

@Composable
fun TransactionScreen() {
    val rootController = LocalRootController.current
    ViewModel(factory = { TransactionViewModel() }) { viewModel ->

        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        TransactionView(state.value){
            viewModel.obtainEvent(it)
        }

        when(action.value){
            TransactionAction.OpenDashboardScreen -> {
                rootController.popBackStack()
            }
            null -> {}
        }
    }
}

@Composable
fun TransactionView(state:TransactionViewState,eventHandler: (TransactionEvent) -> Unit) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(modifier = Modifier.padding(8.dp),
                    onClick = { eventHandler.invoke(TransactionEvent.CloseClick) }) {
                    Image(
                        imageVector = Icons.Default.Close,
                        contentDescription = Icons.Default.Close.name
                    )
                }
                IconButton(modifier = Modifier.padding(8.dp),
                    onClick = { eventHandler.invoke(TransactionEvent.DoneClick) }) {
                    Image(
                        imageVector = Icons.Default.Done,
                        contentDescription = Icons.Default.Done.name
                    )
                }
            }
        }

        item {
            val twoSegments = remember { listOf("Expenses", "Incomes") }
            var selectedTwoSegment by remember { mutableStateOf(twoSegments.first()) }
            SegmentedControl(
                modifier = Modifier.padding(horizontal = 64.dp),
                segments = twoSegments,
                selectedSegment = selectedTwoSegment,
                onSegmentSelected = { selectedTwoSegment = it }
            ) {
                SegmentText(it)
            }
        }

        item {
            val message = remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier.padding(32.dp),
                value = message.value,
                onValueChange = { message.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Theme.colors.secondaryColor,
                    unfocusedBorderColor = Theme.colors.primaryBackground
                )
            )
        }

        item {
            CategoryList(modifier = Modifier.padding(16.dp))
        }

    }
}