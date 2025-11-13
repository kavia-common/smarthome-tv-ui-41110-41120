package org.example.app.model

/**
 * PUBLIC_INTERFACE
 * SmartDevice
 * Represents a smart home device for display purposes only (dummy data).
 */
data class SmartDevice(
    val id: String,
    val name: String,
    val type: DeviceType,
    val isOn: Boolean,
    val room: String,
    val cameraId: String? = null
)

/**
 * PUBLIC_INTERFACE
 * DeviceType
 * Enumerates types of smart devices.
 */
enum class DeviceType {
    Light, Thermostat, Camera, Plug, Sensor
}

/**
 * PUBLIC_INTERFACE
 * DummyData
 * Singleton providing placeholder devices and camera IDs for UI previews/demo.
 */
object DummyData {
    val devices: List<SmartDevice> = listOf(
        SmartDevice("dev-1", "Living Lamp", DeviceType.Light, true, "Living Room"),
        SmartDevice("dev-2", "Hall Thermostat", DeviceType.Thermostat, false, "Hallway"),
        SmartDevice("dev-3", "Front Door Cam", DeviceType.Camera, true, "Entrance", cameraId = "cam-1"),
        SmartDevice("dev-4", "Coffee Plug", DeviceType.Plug, false, "Kitchen"),
        SmartDevice("dev-5", "Garden Cam", DeviceType.Camera, true, "Garden", cameraId = "cam-2"),
        SmartDevice("dev-6", "Bedroom Lamp", DeviceType.Light, true, "Bedroom"),
        SmartDevice("dev-7", "Air Sensor", DeviceType.Sensor, true, "Kitchen"),
        SmartDevice("dev-8", "Heater Plug", DeviceType.Plug, false, "Kids Room"),
        SmartDevice("dev-9", "Garage Cam", DeviceType.Camera, true, "Garage", cameraId = "cam-3"),
        SmartDevice("dev-10", "Desk Lamp", DeviceType.Light, false, "Office")
    )
}
