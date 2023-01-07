package navigation

object NavigationTree {

    enum class Splash {
        SplashScreen
    }

    enum class Auth {
        AuthFlow, Login, Register, Forgot
    }

    enum class Dashboard {
        Dashboard, DashboardFlow
    }

    enum class Transaction {
        Transaction, TransactionFlow
    }


}