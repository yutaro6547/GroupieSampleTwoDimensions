package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import io.reactivex.Observable
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaResponse
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.repository.IchibaRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(
    application: Application,
    private val repository: IchibaRepository
): AndroidViewModel(application) {

    fun getIchibaItems(applicationId: String, keyword: String): Observable<IchibaListResponse> {
        return repository.getRakutenIchibaItemsByKeyword(applicationId, keyword)
    }
}
