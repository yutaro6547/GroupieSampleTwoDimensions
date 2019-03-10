package www.rozkey59.tokyo.groupiesampletwodimensions.infra.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaResponse
import javax.inject.Inject


class RakutenClient @Inject constructor(private val service: RakutenService) {

    fun getIchibaItem(applicationId: String, keyword: String): Observable<IchibaListResponse> {
        return service.getItem(applicationId = applicationId, keyword = keyword, formatVersion = 2)
    }

    interface RakutenService {
        @GET("api/IchibaItem/Search/20170706?")
        fun getItem(
            @Query("applicationId") applicationId: String,
            @Query("keyword") keyword: String,
            @Query("formatVersion") formatVersion: Int
        ): Observable<IchibaListResponse>
    }
}
