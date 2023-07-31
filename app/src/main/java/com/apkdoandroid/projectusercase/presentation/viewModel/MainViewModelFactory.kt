package com.apkdoandroid.projectusercase.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apkdoandroid.projectusercase.domain.usecase.PostagemUseCase

class MainViewModelFactory(private val  postagemUseCase: PostagemUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(postagemUseCase) as T
        }else{
            throw IllegalArgumentException("ViewModel não foi configurado corretamente")
        }
    }
}