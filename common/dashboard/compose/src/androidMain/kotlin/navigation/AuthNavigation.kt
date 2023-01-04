package navigation

import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import screen.DashboardScreen

fun RootComposeBuilder.dashboardFlow() {
    flow(name = NavigationTree.Main.DashboardFlow.name) {
        screen(name = NavigationTree.Main.Dashboard.name) {
            DashboardScreen()
        }
    }
}