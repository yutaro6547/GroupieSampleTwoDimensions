package www.rozkey59.tokyo.groupiesampletwodimensions.di.component

import dagger.Subcomponent
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.MainModule
import www.rozkey59.tokyo.groupiesampletwodimensions.main.MainActivity
import javax.inject.Singleton

@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}
