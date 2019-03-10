package www.rozkey59.tokyo.groupiesampletwodimensions.main

import www.rozkey59.tokyo.groupiesampletwodimensions.flux.action.Action


sealed class MainAction: Action {
    object Reflesh: MainAction()
}
