package anuvix.garetonolev.hubapp.di

import androidx.room.Room
import anuvix.garetonolev.hubapp.data.database.AXOVPAppDatabase
import anuvix.garetonolev.hubapp.data.repository.HighScoreRepository
import anuvix.garetonolev.hubapp.data.model.Difficulty
import anuvix.garetonolev.hubapp.ui.viewmodel.GameViewModel
import anuvix.garetonolev.hubapp.ui.viewmodel.HighScoreViewModel
import anuvix.garetonolev.hubapp.ui.viewmodel.MenuViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private const val DB_NAME = "axovp_db"

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = AXOVPAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<AXOVPAppDatabase>().highScoreDao() }

    single {
        HighScoreRepository(
            highScoreDao = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }
}

val viewModule = module {
    viewModel { (difficulty: Difficulty) ->
        GameViewModel(difficulty = difficulty, highScoreRepository = get())
    }

    viewModel { HighScoreViewModel(highScoreRepository = get()) }

    viewModel { MenuViewModel(highScoreRepository = get()) }
}

val appModules: List<Module> = listOf(dispatcherModule, dataModule, viewModule)
