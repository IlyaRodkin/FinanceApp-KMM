import models.Category

class CategoriesRepoImpl : CategoriesRepo {
    override fun getCategoriesList(): List<Category> = Category.mockAndroidCategory()
}