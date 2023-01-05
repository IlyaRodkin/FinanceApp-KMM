import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val authModule = DI.Module("catgoriesModule") {
    bind<CategoriesRepo>() with singleton {
        CategoriesRepoImpl()
    }

    /*bind<SettingsAuthDataSource>() with provider {
        SettingsAuthDataSource(instance())
    }

    bind<KtorAuthRemoteDataSource>() with provider {
        KtorAuthRemoteDataSource(instance())
    }*/
}