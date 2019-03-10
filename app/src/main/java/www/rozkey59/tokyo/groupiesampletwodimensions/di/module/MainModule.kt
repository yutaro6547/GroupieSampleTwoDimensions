package www.rozkey59.tokyo.groupiesampletwodimensions.di.module

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.api.RakutenClient
import www.rozkey59.tokyo.groupiesampletwodimensions.main.MainStore
import www.rozkey59.tokyo.groupiesampletwodimensions.main.MainViewModelFactory

@Module
class MainModule(
    private val activity: FragmentActivity
) {

    @Provides
    fun provideRankutenService(
        retrofit: Retrofit
    ): RakutenClient.RakutenService {
        return retrofit.create(RakutenClient.RakutenService::class.java)
    }

    @Provides
    fun provideMainViewModel(factory: MainViewModelFactory): MainStore {
        return ViewModelProviders.of(activity, factory).get(MainStore::class.java)
    }
}
