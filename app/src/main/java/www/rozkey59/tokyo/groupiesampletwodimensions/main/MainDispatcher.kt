package www.rozkey59.tokyo.groupiesampletwodimensions.main

import com.jakewharton.rxrelay2.PublishRelay
import www.rozkey59.tokyo.groupiesampletwodimensions.flux.action.Action
import www.rozkey59.tokyo.groupiesampletwodimensions.flux.dispatcher.Dispatcher


class MainDispatcher: Dispatcher() {

    private val relay = PublishRelay.create<Action>()

    fun dispatch(action: Action) {
        relay.accept(action)
    }
}
