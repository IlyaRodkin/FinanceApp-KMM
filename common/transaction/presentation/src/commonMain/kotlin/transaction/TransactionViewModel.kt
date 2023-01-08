package transaction

import CategoriesRepo
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import models.Category
import models.MainCategoryEnum
import transaction.models.TransactionAction
import transaction.models.TransactionEvent
import transaction.models.TransactionViewState

class TransactionViewModel(private val categoriesRepo: CategoriesRepo = Inject.instance()) :
    BaseSharedViewModel<TransactionViewState, TransactionAction, TransactionEvent>(
        initialState = TransactionViewState(
            mainCategory = MainCategoryEnum.Expenses,
            totalCost = 0.0,
            category = categoriesRepo.getCategoriesList().first()
        )
    ) {
    override fun obtainEvent(viewEvent: TransactionEvent) {
        when (viewEvent) {
            is TransactionEvent.ChangeCategory -> changeCategory(viewEvent.category)
            is TransactionEvent.ChangeMainCategoryClick -> changeMainCategory()
            TransactionEvent.CloseClick -> closeClick()
            TransactionEvent.DoneClick -> doneClick()
            is TransactionEvent.TotalCostChange -> totalCostChange(viewEvent.cost)
        }
    }

    private fun changeCategory(value: Category) {
        viewState = viewState.copy(category = value)
    }

    private fun changeMainCategory() {
        viewState =
            if (viewState.mainCategory == MainCategoryEnum.Expenses)
                viewState.copy(mainCategory = MainCategoryEnum.Incomes)
            else viewState.copy(mainCategory = MainCategoryEnum.Expenses)
    }

    private fun closeClick() {
        viewAction = TransactionAction.OpenDashboardScreen
    }

    private fun doneClick() {
        viewAction = TransactionAction.OpenDashboardScreen
    }

    private fun totalCostChange(value: Double) {
        viewState = viewState.copy(totalCost = value)
    }
}