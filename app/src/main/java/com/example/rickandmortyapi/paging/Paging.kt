package com.example.rickandmortyapi.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapi.api.ApiService
import com.example.rickandmortyapi.entities.SingleCharacter
import java.lang.Exception

class Paging (private val retrofitService: ApiService) : PagingSource<Int, SingleCharacter>() {
    override fun getRefreshKey(state: PagingState<Int, SingleCharacter>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SingleCharacter> {
        return try {
            val nextPage : Int = params.key ?: FIRST_PAGE_INDEX
            val response = retrofitService.getCharacters(nextPage)
            val data = response?.apiCharacters
            val responseData = mutableListOf<SingleCharacter>()
            responseData.addAll(data)


            LoadResult.Page(data = responseData, if(nextPage == 1) null else -1, nextKey = nextPage.plus(1))

        }catch(e: Exception){
            LoadResult.Error(e)
        }
    }

    companion object{
        private const val FIRST_PAGE_INDEX = 1
    }
}