package com.apkdoandroid.projectusercase.data.repository

import com.apkdoandroid.projectusercase.data.api.JsonPlaceAPI
import com.apkdoandroid.projectusercase.data.model.PostagemResposta
import com.apkdoandroid.projectusercase.data.model.toPostagem
import com.apkdoandroid.projectusercase.domain.model.Postagem
import retrofit2.Response

class PostagemRepository(private val jsonPlaceAPI: JsonPlaceAPI) : IPostagemRepository {

    override suspend fun recuperarPostagens(): List<Postagem> {
        try{
            val retorno = jsonPlaceAPI.recuperarPostagens()
            if(retorno.isSuccessful && retorno.body() != null){
                val listaPostagensResposta = retorno.body()
                val listaPostagens = listaPostagensResposta?.map { it.toPostagem() }
                if(listaPostagens != null){
                    return listaPostagens
                }

            }
        }catch (e : Exception){
            e.printStackTrace()
        }
            return  emptyList()
    }
}