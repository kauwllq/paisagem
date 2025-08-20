package com.kauany.paisagem
import retrofit2.http.GET

interface PaisagemApi {
    @GET("v2/random")
    suspend fun getRandomPaisagem(): PaisageResponse
}
