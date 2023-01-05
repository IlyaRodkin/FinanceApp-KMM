import models.Category

interface CategoriesRepo {
    fun getCategoriesList(): List<Category>
}