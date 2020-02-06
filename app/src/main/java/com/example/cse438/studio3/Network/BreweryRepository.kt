package com.example.cse438.studio3.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.studio3.data.Brewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class BreweryRepository {

    val service = ApiClient.makeRetrofitService()

    fun searchByCity(resBody: MutableLiveData<List<Brewery>>, city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getBreweryByCity(city)

            withContext(Dispatchers.Main) {
                try {
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch(e: HttpException) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun searchWithQuery(resBody: MutableLiveData<List<Brewery>>, query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.searchBreweries(query)

            withContext(Dispatchers.Main) {
                try {
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch(e: HttpException) {
                    e.printStackTrace()
                }
            }
        }
    }
}