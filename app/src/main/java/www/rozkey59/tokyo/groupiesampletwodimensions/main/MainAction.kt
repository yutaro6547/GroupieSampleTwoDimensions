package www.rozkey59.tokyo.groupiesampletwodimensions.main

import www.rozkey59.tokyo.groupiesampletwodimensions.flux.action.Action
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse


sealed class MainAction: Action {
    class Refresh(val data: IchibaListResponse): MainAction()
}
