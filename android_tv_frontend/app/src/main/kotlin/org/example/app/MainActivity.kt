package org.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.example.app.model.DummyData
import org.example.app.model.SmartDevice
import org.example.app.theme.SmartHomeTheme
import org.example.app.ui.CctvScreen
import org.example.app.ui.DeviceDetailScreen
import org.example.app.ui.HomeScreen

/**
 * PUBLIC_INTERFACE
 * MainActivity
 * This is the entry point activity for the SmartHome TV app. It sets up the Jetpack Compose content
 * and configures navigation across app screens for Android TV.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartHomeTheme {
                Surface {
                    SmartHomeApp()
                }
            }
        }
    }
}

/**
 * PUBLIC_INTERFACE
 * SmartHomeApp
 * Root composable for the app that hosts the NavController and NavHost with routes:
 * - home
 * - device/{deviceId}
 * - cctv/{cameraId?}
 */
@Composable
fun SmartHomeApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(
                devices = DummyData.devices,
                onOpenDevice = { device ->
                    navController.navigate("device/${device.id}")
                },
                onOpenCctv = { cameraId ->
                    navController.navigate("cctv/${cameraId}")
                }
            )
        }

        composable(
            route = "device/{deviceId}",
            arguments = listOf(navArgument("deviceId") { type = NavType.StringType })
        ) { backStackEntry ->
            val deviceId = backStackEntry.arguments?.getString("deviceId").orEmpty()
            val device: SmartDevice? = DummyData.devices.find { it.id == deviceId }
            DeviceDetailScreen(
                device = device,
                onBack = { navController.popBackStack() },
                onOpenCctv = { cameraId -> navController.navigate("cctv/$cameraId") }
            )
        }

        composable(
            route = "cctv/{cameraId}",
            arguments = listOf(navArgument("cameraId") { type = NavType.StringType; nullable = true })
        ) { backStackEntry ->
            val cameraId = backStackEntry.arguments?.getString("cameraId")
            CctvScreen(
                cameraId = cameraId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
