package com.example.rewiewoftheviewlayersection.viewStates

sealed class ViewStatePreviewListOfHabits {

    object Loading: ViewStatePreviewListOfHabits()

    data class LoadedSuccessfully(var allHabits: MutableList<ViewStateHabit>): ViewStatePreviewListOfHabits()

    object LoadedUnsuccessfully: ViewStatePreviewListOfHabits()

}

// "Loading", "LoadedSuccessfully" and "LoadedUnsuccessfully" inherit the sealed class
// in order to represent various states which the sealed class can have.