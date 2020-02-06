package com.example.cse438.studio3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.studio3.Network.BreweryRepository
import com.example.cse438.studio3.data.Brewery


class BreweryViewModel(application: Application): AndroidViewModel(application) {

    public var breweryList: MutableLiveData<List<Brewery>> = MutableLiveData()
    public var breweryRepository = BreweryRepository()

    fun breweriesByCity(city: String) {
        breweryRepository.searchByCity(breweryList, city)
    }

    fun searchBreweries(query: String) {
        breweryRepository.searchWithQuery(breweryList, query)
    }

}