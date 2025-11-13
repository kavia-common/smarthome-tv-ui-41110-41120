@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package org.example.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * PUBLIC_INTERFACE
 * CctvScreen
 * Shows a placeholder "video" box with simple playback and volume controls.
 */
@Composable
fun CctvScreen(
    cameraId: String?,
    onBack: () -> Unit
) {
    var playing by remember { mutableStateOf(true) }
    var muted by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("CCTV ${cameraId ?: ""}") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                MaterialTheme.colorScheme.surface,
                                MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                Color.Black
                            )
                        )
                    )
                    .aspectRatio(16f / 9f)
                    .fillMaxSize(fraction = 0.9f),
                contentAlignment = Alignment.Center
            ) {
                Text("Live Feed Placeholder", color = MaterialTheme.colorScheme.onSurface)
            }

            androidx.compose.foundation.layout.Row(
                modifier = Modifier.padding(top = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { playing = !playing }) {
                    Icon(
                        imageVector = if (playing) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (playing) "Pause" else "Play"
                    )
                }
                IconButton(onClick = { muted = !muted }) {
                    Icon(
                        imageVector = if (muted) Icons.Default.VolumeOff else Icons.Default.VolumeUp,
                        contentDescription = if (muted) "Unmute" else "Mute"
                    )
                }
                OutlinedButton(onClick = { /* simulate fullscreen */ }) {
                    Icon(imageVector = Icons.Default.Fullscreen, contentDescription = "Fullscreen")
                    Text(" Fullscreen")
                }
            }
        }
    }
}
