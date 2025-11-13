package org.example.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.example.app.model.SmartDevice

/**
 * PUBLIC_INTERFACE
 * DeviceDetailScreen
 * Large, TV-friendly controls to simulate device actions with a prominent toggle.
 */
@Composable
fun DeviceDetailScreen(
    device: SmartDevice?,
    onBack: () -> Unit,
    onOpenCctv: (String) -> Unit
) {
    val d = device
    if (d == null) {
        onBack()
        return
    }
    var isOn by remember { mutableStateOf(d.isOn) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            org.example.app.ui.components.AppBar(
                title = d.name,
                onBack = onBack
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = d.room, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if (isOn) "On" else "Off",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(Modifier.height(0.dp))
                Switch(
                    checked = isOn,
                    onCheckedChange = { isOn = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
                    )
                )
            }

            Spacer(Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { isOn = !isOn }) {
                    Text(if (isOn) "Turn Off" else "Turn On")
                }
                OutlinedButton(onClick = { /* simulate schedule */ }) {
                    Text("Schedule")
                }
                FilledTonalButton(
                    onClick = { d.cameraId?.let { onOpenCctv(it) } },
                    enabled = d.cameraId != null
                ) {
                    Icon(imageVector = Icons.Default.Videocam, contentDescription = "Open CCTV")
                    Text(" CCTV", modifier = Modifier)
                }
            }
        }
    }
}
