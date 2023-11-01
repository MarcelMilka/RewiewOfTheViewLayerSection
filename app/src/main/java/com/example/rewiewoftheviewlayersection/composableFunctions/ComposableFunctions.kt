package com.example.rewiewoftheviewlayersection.composableFunctions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rewiewoftheviewlayersection.enumClasses.LevelsOfImportance

@Composable
fun Bar(text: String, levelOfImportance: LevelsOfImportance) {

    val colourOfIcon = when(levelOfImportance){
        LevelsOfImportance.Red -> Color.Red
        LevelsOfImportance.Yellow -> Color.Yellow
        LevelsOfImportance.Green -> Color.Green
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(75.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        content = {

            Icon(

                imageVector = Icons.Rounded.Check,
                contentDescription = null,
                tint = colourOfIcon

            )

            Text(text)

        }
    )
}