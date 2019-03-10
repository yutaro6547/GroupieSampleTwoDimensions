package www.rozkey59.tokyo.groupiesampletwodimensions.main

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable
import www.rozkey59.tokyo.groupiesampletwodimensions.flux.dispatcher.Dispatcher


class MainDispatcher: Dispatcher() {

    private val relay = PublishRelay.create<MainAction>()
    val refresh: Observable<MainAction> = relay

    fun dispatch(action: MainAction.Refresh) {
        relay.accept(action)
    }
}
