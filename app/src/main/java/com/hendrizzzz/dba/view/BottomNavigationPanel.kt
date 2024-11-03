package com.hendrizzzz.dba.view

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hendrizzzz.dba.R // Adjust the import based on your package structure

@Composable
fun BottomNavigationPanel(
    selectedButton: String,
    onButtonClick: (String) -> Unit
) {
    // Create a bottom navigation panel
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(0.dp),
        horizontalArrangement = Arrangement.SpaceEvenly // Ensures spacing is even
    ) {
        // Define button labels and icons
        val buttons = listOf(
            ButtonData("Games", R.drawable.games),
            ButtonData("Teams", R.drawable.teams),
            ButtonData("Home", R.drawable.home),
            ButtonData("Players", R.drawable.players),
            ButtonData("Discover", R.drawable.discover)
        )

        // Create buttons dynamically
        buttons.forEach { button ->
            ButtonWithRipple(
                onClick = { onButtonClick(button.label) },
                iconRes = button.iconRes,
                label = button.label,
                modifier = Modifier.weight(1f), // Use weight for equal distribution
                iconColor = if (selectedButton == button.label) Color.Red else Color.White // Change color based on selection
            )
        }
    }
}

// Data class to hold button information
data class ButtonData(val label: String, val iconRes: Int)

@Composable
fun ButtonWithRipple(
    onClick: () -> Unit,
    iconRes: Int,
    label: String,
    iconColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    // Create an interaction source for the ripple effect
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp), clip = true)
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = LocalIndication.current // Use the default indication
            )
            .padding(top = 5.dp, bottom = 0.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = iconColor
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = iconColor,
            modifier = Modifier.padding(0.dp)
        )
    }
}
