package com.apkdoandroid.projectusercase.domain.usecase

import com.apkdoandroid.projectusercase.data.repository.IPostagemRepository
import com.apkdoandroid.projectusercase.domain.model.Postagem

class PostagemUseCase( private val repository :IPostagemRepository) {

  //  suspend fun recuperarPostagens() : List<Postagem>{
    suspend operator fun invoke() : List<Postagem>{

        try {
            return  repository.recuperarPostagens()
        }catch (e : Exception){
            e.printStackTrace()
            return emptyList()
        }

    }
}