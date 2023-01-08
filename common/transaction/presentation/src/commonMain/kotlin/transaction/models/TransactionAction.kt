package transaction.models

sealed class TransactionAction {
    object OpenDashboardScreen : TransactionAction()
}