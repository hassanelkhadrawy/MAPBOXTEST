package com.example.mapboxtest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mapboxtest.databinding.ActivityMainBinding
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.offline.OfflineManager


class MainActivity: AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
   lateinit var  offlineManager: OfflineManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.access_token2))
        binding = ActivityMainBinding.inflate(layoutInflater)

        // This goes before setContentView. You can also place it in your Application class
        offlineManager = OfflineManager.getInstance(this)

        // Initializing is asynchrounous- getMapAsync will return a map
        binding.mapview.getMapAsync { map ->
            // Set one of the many styles available
            map.setStyle(Style.MAPBOX_STREETS) { style ->
                // Style.MAPBOX_STREETS | Style.SATELLITE etc...
            }
        }
        binding.mapview.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    public override fun onStart() {
        super.onStart()
        binding. mapview.onStart()
    }

    public override fun onResume() {
        super.onResume()
        binding. mapview.onResume()
    }

    public override fun onPause() {
        super.onPause()
        binding.mapview.onPause()
    }

    public override fun onStop() {
        super.onStop()
        binding. mapview.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding. mapview.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding. mapview.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding. mapview.onSaveInstanceState(outState)
    }
}