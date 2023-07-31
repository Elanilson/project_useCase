package com.apkdoandroid.projectusercase.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.apkdoandroid.projectusercase.R
import com.apkdoandroid.projectusercase.data.api.RetrofitService
import com.apkdoandroid.projectusercase.data.repository.PostagemRepository
import com.apkdoandroid.projectusercase.databinding.ActivityMainBinding
import com.apkdoandroid.projectusercase.domain.usecase.PostagemUseCase
import com.apkdoandroid.projectusercase.presentation.viewModel.MainViewModel
import com.apkdoandroid.projectusercase.presentation.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        val jsonPlaceAPI = RetrofitService.recuperarJsonPlace()
        val postagemRepository = PostagemRepository(jsonPlaceAPI)
        val postagemUseCase = PostagemUseCase(postagemRepository)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(postagemUseCase)).get(MainViewModel::class.java)
        mainViewModel.listaPostagens.observe(this){ listaPostagens ->

            var listaResultado = ""
            listaPostagens.forEach { postagem ->
                listaResultado += "${postagem.codigo}) ${postagem.titulo} \n"
            }
            binding.textResultado.text = listaResultado

        }

    }

    override fun onStart() {
        super.onStart()
        mainViewModel.recuperarPostagens()
    }
}