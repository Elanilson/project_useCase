package com.apkdoandroid.projectusercase.data.api

import com.apkdoandroid.projectusercase.data.model.PostagemResposta
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {
    @GET("posts")
    suspend fun recuperarPostagens() : Response<List<PostagemResposta>>
}