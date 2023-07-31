package com.apkdoandroid.projectusercase.data.repository

import com.apkdoandroid.projectusercase.domain.model.Postagem

interface IPostagemRepository {
    suspend fun recuperarPostagens() : List<Postagem>
}