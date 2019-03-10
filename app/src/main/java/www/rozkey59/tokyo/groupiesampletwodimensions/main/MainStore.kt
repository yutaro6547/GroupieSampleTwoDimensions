package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.app.Application
import io.reactivex.Observable
import www.rozkey59.tokyo.groupiesampletwodimensions.flux.store.Store
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.repository.IchibaRepository
import javax.inject.Inject


class MainStore @Inject constructor(
    application: Application,
    private val dispatcher: MainDispatcher,
    private val repository: IchibaRepository
): Store(application) {

    fun getIchibaItems(applicationId: String, keyword: String): Observable<IchibaListResponse> {
        return repository.getRakutenIchibaItemsByKeyword(applicationId, keyword)
    }
}
