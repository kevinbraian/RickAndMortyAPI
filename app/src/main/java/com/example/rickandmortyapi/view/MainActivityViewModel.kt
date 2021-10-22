package com.example.rickandmortyapi.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyapi.api.ApiService
import com.example.rickandmortyapi.paging.Paging
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel()
class MainActivityViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    val listdata = Pager(PagingConfig(pageSize = 1)){
        Paging(apiService)
    }.flow.cachedIn(viewModelScope)
}