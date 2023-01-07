package navigation

import TransactionScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.transactionFlow() {
    flow(name = NavigationTree.Transaction.TransactionFlow.name) {
        screen(name = NavigationTree.Transaction.Transaction.name) {
            TransactionScreen()
        }
    }
}