package navigation

import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import screen.DashboardScreen

fun RootComposeBuilder.dashboardFlow() {
    flow(name = NavigationTree.Dashboard.DashboardFlow.name) {
        screen(name = NavigationTree.Dashboard.Dashboard.name) {
            DashboardScreen()
        }
    }
}