package com.example.rewiewoftheviewlayersection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rewiewoftheviewlayersection.interfaces.FetchData
import com.example.rewiewoftheviewlayersection.repositories.RepositoryFetchingHabits
import com.example.rewiewoftheviewlayersection.viewStates.ViewStateHabit
import com.example.rewiewoftheviewlayersection.viewStates.ViewStatePreviewListOfHabits
import kotlinx.coroutines.launch


class ViewModelMainActivity(var fetchingData: FetchData = RepositoryFetchingHabits ): ViewModel() {

    var currentViewModelState = MutableLiveData<ViewStatePreviewListOfHabits>()
    var fetchedHabits = mutableListOf<ViewStateHabit>()

    fun LoadHabits() {

        viewModelScope.launch {

//        Sending info to the View that the data is being fetched
            currentViewModelState.postValue(ViewStatePreviewListOfHabits.Loading)

//        Fetching data
            fetchedHabits = fetchingData.fetchHabits()

//        Fetching data
            currentViewModelState.postValue(ViewStatePreviewListOfHabits.LoadedSuccessfully(fetchedHabits))

        }
    }
}