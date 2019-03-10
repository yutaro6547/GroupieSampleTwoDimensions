package www.rozkey59.tokyo.groupiesampletwodimensions.di.component

import dagger.Component
import www.rozkey59.tokyo.groupiesampletwodimensions.MainApp
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.AppModule
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.MainModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: MainApp)

    fun plus(module: MainModule) : MainComponent
}
