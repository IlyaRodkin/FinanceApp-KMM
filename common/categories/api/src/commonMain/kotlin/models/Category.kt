package models

data class Category(
    val id: Long,
    val name: String,
    val icon: String,
    val spendMoney: Int?
) {
    companion object {
        fun mockAndroidCategory(): List<Category> =
            listOf(
                Category(
                    1,
                    "Housing",
                    "/Users/ilarodkin/AndroidStudioProjects/FinanceAppKMM/common/categories/data/src/commonMain/resources/drawable/home_icon.png",
                    null
                )
            )
    }
}

