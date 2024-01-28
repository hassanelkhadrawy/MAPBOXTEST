import android.content.Context
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.offline.OfflineManager
import com.mapbox.mapboxsdk.offline.OfflineRegion
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition

class OfflineMapDownloader(private val context: Context) {

    private val offlineManager: OfflineManager by lazy {
        OfflineManager.getInstance(context)
    }

    private val offlineMapCallback = object : OfflineManager.CreateOfflineRegionCallback {
        override fun onCreate(offlineRegion: OfflineRegion) {
            // Implement download completion or progress updates here
            offlineRegion.setDownloadState(OfflineRegion.STATE_ACTIVE)
        }

        override fun onError(error: String) {
            // Handle errors during offline region creation
        }
    }

    fun downloadMap(region: LatLngBounds, styleUrl: String, minZoom: Double, maxZoom: Double) {
        val definition = OfflineTilePyramidRegionDefinition(
            styleUrl,
            region,
            minZoom,
            maxZoom,
            context.resources.displayMetrics.density
        )

        val metadata = "{\"key\":\"value\"}".toByteArray() // You can customize metadata as needed

//        val offlineRegionDefinition = OfflineRegionDefinition(
//            definition,
//            metadata
//        )
//
//        offlineManager.createOfflineRegion(
//            offlineRegionDefinition,
//            offlineMapCallback
//        )
    }

    // Additional methods for pausing, resuming, deleting offline regions, etc.
}
