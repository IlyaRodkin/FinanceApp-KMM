import models.Category

class CategoriesRepoImpl : CategoriesRepo {
    override fun getCategoriesList(): List<Category> = mockAndroidCategory()
}