package com.example.rewiewoftheviewlayersection.repositories

import com.example.rewiewoftheviewlayersection.ViewModelMainActivity
import com.example.rewiewoftheviewlayersection.enumClasses.LevelsOfImportance
import com.example.rewiewoftheviewlayersection.interfaces.FetchData
import com.example.rewiewoftheviewlayersection.viewStates.ViewStateHabit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryFetchingHabits: FetchData {

    override suspend fun fetchHabits(): MutableList<ViewStateHabit> {

        var allHabits = mutableListOf<ViewStateHabit>()

        return withContext(Dispatchers.IO) {

            val habitMeditation = ViewStateHabit("Meditation", LevelsOfImportance.Green)
            val habitStudyingNorwegian = ViewStateHabit("Studying norwegian", LevelsOfImportance.Red)
            val habitReadingBooksInEnglish = ViewStateHabit("Reading books in english", LevelsOfImportance.Yellow)
            val habitStudyingAndroidDevelopment = ViewStateHabit("Studying android development", LevelsOfImportance.Red)
            val habitListeningToPodcastsInEnglish = ViewStateHabit("Listening to podcasts in norwegian", LevelsOfImportance.Yellow)

            allHabits.add(habitMeditation)
            allHabits.add(habitStudyingNorwegian)
            allHabits.add(habitReadingBooksInEnglish)
            allHabits.add(habitStudyingAndroidDevelopment)
            allHabits.add(habitListeningToPodcastsInEnglish)

            allHabits

        }

    }

}