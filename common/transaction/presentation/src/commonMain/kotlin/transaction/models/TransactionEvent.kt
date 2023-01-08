package transaction.models

import models.Category
import models.MainCategoryEnum

sealed class TransactionEvent {
    data class ChangeMainCategoryClick(val category: MainCategoryEnum) : TransactionEvent()
    data class TotalCostChange(val cost: Double) : TransactionEvent()
    data class ChangeCategory(val category: Category) : TransactionEvent()
    object CloseClick : TransactionEvent()
    object DoneClick : TransactionEvent()
}