package se.micanonym.viaplaysample.data.services

import retrofit2.http.GET
import retrofit2.http.Path
import se.micanonym.viaplaysample.data.ViaplayApi
import se.micanonym.viaplaysample.data.models.SectionDetail
import se.micanonym.viaplaysample.data.responses.RootResponse

interface ViaplayService {
    @GET(ViaplayApi.SECTIONS_BASE_URL)
    suspend fun getSections(): RootResponse

    @GET("${ViaplayApi.SECTIONS_BASE_URL}/{section}")
    suspend fun getSectionDetail(@Path("section") section: String): SectionDetail
}
