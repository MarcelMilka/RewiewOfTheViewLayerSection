package com.example.rewiewoftheviewlayersection.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import com.example.rewiewoftheviewlayersection.ViewModelMainActivity
import com.example.rewiewoftheviewlayersection.composableFunctions.Bar
import com.example.rewiewoftheviewlayersection.viewStates.ViewStatePreviewListOfHabits
import java.lang.reflect.Modifier

class ViewMainActivity : ComponentActivity() {

    val viewModel: ViewModelMainActivity by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.currentViewModelState.observe(this){ viewState ->

            setContent {

                Column(

                    modifier = androidx.compose.ui.Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    content = {

                        when (viewState) {

                            ViewStatePreviewListOfHabits.Loading -> {
                                Toast.makeText(this@ViewMainActivity, "loading", Toast.LENGTH_SHORT).show()
                            }

                            is ViewStatePreviewListOfHabits.LoadedSuccessfully -> {

                                LazyColumn(

                                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally,

                                    content = {

                                        items(viewState.allHabits){Habit ->

                                            Bar(Habit.name, Habit.levelOfImportance)

                                        }
                                    }

                                )
                            }


                            ViewStatePreviewListOfHabits.LoadedUnsuccessfully -> {
                                Toast.makeText(this@ViewMainActivity, "loaded unsuccessfully", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                )
            }
        }

        viewModel.LoadHabits()

    }
}
