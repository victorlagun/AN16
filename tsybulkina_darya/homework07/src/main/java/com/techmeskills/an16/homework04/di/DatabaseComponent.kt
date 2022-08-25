package com.techmeskills.an16.homework04.di

import androidx.lifecycle.ViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataBaseModule::class])
@Singleton
interface DatabaseComponent {
fun inject(viewModel: ViewModel){

}
}