package com.example.expensemanager.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensemanager.ui.navigation.AppNavigationDrawerScreen

@Composable
fun AppDrawerContent(
    destinations: List<AppNavigationDrawerScreen>,
    onNavigationSelected: (AppNavigationDrawerScreen) -> Unit,
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxHeight()
                .fillMaxWidth(0.8f)
        ) {
            destinations.forEach { destination ->
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id = destination.title)) },
                    icon = { Icon(imageVector = destination.icon, contentDescription = null) },
                    selected = false,
                    onClick = {
                        onNavigationSelected(destination)
                    },
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewAppDrawerContent() {
    AppDrawerContent(AppNavigationDrawerScreen.entries) {

    }
}
