package models

data class Category(
    val id: Long,
    val name: String,
    val icon: Int,
    val spendMoney: Int?
)
