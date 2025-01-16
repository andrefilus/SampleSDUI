package br.com.brq.samplesdui

import android.app.Application
import br.com.brq.samplesdui.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CustomApplication)
            modules(AppModule.instance)
        }
    }
}