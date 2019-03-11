package berlin.code.smartme.smartme

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.IBinder
import android.support.v4.content.ContextCompat
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationService : Service() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            Log.d("MainActivity", "NOT GRANTED")
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                // Got last known location. In some rare situations this can be null.

                Log.d("LocationService", Build.VERSION.SDK_INT.toString())
                if (location == null){
                    Log.d("MainActivity", "NULL")
                }
                Log.d("LocationService", location?.toString())
            }
        Log.d("LocationService","Service started")
        return super.onStartCommand(intent, flags, startId)
    }
}
