package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.app.Application
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import www.rozkey59.tokyo.groupiesampletwodimensions.flux.store.Store
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse
import javax.inject.Inject


class MainStore @Inject constructor(
    application: Application,
    private val dispatcher: MainDispatcher
): Store(application) {

    fun observe(): Observable<IchibaListResponse> {
        return dispatcher.refresh
            .map {
                if (it is MainAction.Refresh) {
                    it.data
                } else {
                    IchibaListResponse(Items = mutableListOf())
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}
