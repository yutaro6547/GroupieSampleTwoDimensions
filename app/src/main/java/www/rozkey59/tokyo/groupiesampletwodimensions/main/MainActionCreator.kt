package www.rozkey59.tokyo.groupiesampletwodimensions.main

import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import www.rozkey59.tokyo.groupiesampletwodimensions.Config
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.repository.IchibaRepository
import javax.inject.Inject


class MainActionCreator @Inject constructor(
    private val dispatcher: MainDispatcher,
    private val repository: IchibaRepository
) {

    fun fetchIchibaItemsByUsingKeyword(keyword: String): Disposable {
        return repository.getRakutenIchibaItemsByKeyword(Config.appId, keyword)
            .subscribeOn(Schedulers.io())
            .subscribe({
                dispatcher.dispatch(MainAction.Refresh(it))
            },{
                Timber.e(it)
            })
    }
}
