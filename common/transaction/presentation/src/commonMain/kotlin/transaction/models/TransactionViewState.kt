package transaction.models

import models.Category
import models.MainCategoryEnum

data class TransactionViewState(
    var mainCategory: MainCategoryEnum,
    val totalCost: Double,
    val category: Category
)