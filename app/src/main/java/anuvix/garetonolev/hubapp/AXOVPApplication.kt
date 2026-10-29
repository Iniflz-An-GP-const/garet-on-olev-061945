package anuvix.garetonolev.hubapp

import android.app.Application
import anuvix.garetonolev.hubapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class AXOVPApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AXOVPApplication)
            modules(appModules)
        }
    }
}