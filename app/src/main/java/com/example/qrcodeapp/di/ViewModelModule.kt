package com.example.qrcodeapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.qrcodeapp.ui.counter.CounterViewModel
import com.example.qrcodeapp.ui.base.ViewModelFactory
import com.example.qrcodeapp.ui.joke.JokeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(JokeViewModel::class)
    abstract fun bindJokeViewModel(counterViewModel: JokeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CounterViewModel::class)
    abstract fun bindCounterViewModel(counterViewModel: CounterViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}