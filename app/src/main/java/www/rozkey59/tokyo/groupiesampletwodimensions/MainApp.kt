package www.rozkey59.tokyo.groupiesampletwodimensions

import android.app.Application
import www.rozkey59.tokyo.groupiesampletwodimensions.di.component.AppComponent
import www.rozkey59.tokyo.groupiesampletwodimensions.di.component.DaggerAppComponent
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.AppModule


class MainApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }
}
