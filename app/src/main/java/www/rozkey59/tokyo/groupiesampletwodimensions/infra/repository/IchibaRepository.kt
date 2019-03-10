package www.rozkey59.tokyo.groupiesampletwodimensions.infra.repository

import io.reactivex.Observable
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.api.RakutenClient
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaResponse
import javax.inject.Inject


class IchibaRepository @Inject constructor(
    private val rakutenClient: RakutenClient
) {

    fun getRakutenIchibaItemsByKeyword(applicationId: String, keyword: String): Observable<IchibaListResponse> {
        return rakutenClient.getIchibaItem(applicationId = applicationId, keyword = keyword)
    }
}
