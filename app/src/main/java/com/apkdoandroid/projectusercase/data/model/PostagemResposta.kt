package com.apkdoandroid.projectusercase.data.model

import com.apkdoandroid.projectusercase.domain.model.Postagem

data class PostagemResposta(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
fun PostagemResposta.toPostagem() : Postagem{
    return Postagem(
        descricao = this.body,
        titulo = this.title,
        codigo = this.id,
        idUsuario = this.userId
    )
}