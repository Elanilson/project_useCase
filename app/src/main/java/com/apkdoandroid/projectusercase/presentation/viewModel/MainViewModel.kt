package com.apkdoandroid.projectusercase.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apkdoandroid.projectusercase.domain.model.Postagem
import com.apkdoandroid.projectusercase.domain.usecase.PostagemUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val postagemUseCase: PostagemUseCase) : ViewModel() {
    var listaPostagens = MutableLiveData<List<Postagem>>()

    fun recuperarPostagens(){
        viewModelScope.launch {
          //  val postagens = postagemUseCase.recuperarPostagens()
            val postagens = postagemUseCase()
            listaPostagens.value = postagens
        }
    }
}