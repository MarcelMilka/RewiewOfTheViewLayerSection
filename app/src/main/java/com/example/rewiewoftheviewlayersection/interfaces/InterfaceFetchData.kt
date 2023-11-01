package com.example.rewiewoftheviewlayersection.interfaces

import com.example.rewiewoftheviewlayersection.viewStates.ViewStateHabit

interface FetchData {

    suspend fun fetchHabits(): MutableList<ViewStateHabit>

}