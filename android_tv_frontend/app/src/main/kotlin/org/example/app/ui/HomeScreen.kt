package org.example.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.app.model.SmartDevice
import org.example.app.ui.components.DeviceCard

/**
 * PUBLIC_INTERFACE
 * HomeScreen
 * Displays a grid of smart devices with focusable cards for TV navigation.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    devices: List<SmartDevice>,
    onOpenDevice: (SmartDevice) -> Unit,
    onOpenCctv: (String) -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { Text("SmartHome TV") }
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(24.dp),
            columns = GridCells.Adaptive(minSize = 240.dp)
        ) {
            items(devices, key = { it.id }) { device ->
                DeviceCard(
                    device = device,
                    modifier = Modifier.padding(8.dp),
                    onClick = { d ->
                        if (d.cameraId != null) onOpenCctv(d.cameraId) else onOpenDevice(d)
                    }
                )
            }
        }
    }
}
