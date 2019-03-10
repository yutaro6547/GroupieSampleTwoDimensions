package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.repository.IchibaRepository
import javax.inject.Inject


class MainViewModelFactory @Inject constructor(
    private val application: Application,
    private val dispatcher: MainDispatcher,
    private val repository: IchibaRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainStore(
            application = application,
            dispatcher = dispatcher,
            repository = repository
        ) as T
    }
}
