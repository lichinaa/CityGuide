package com.example.turist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // Initialize map fragment
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add markers for each location
        addMarker("Skopje Square", 41.99643840387665, 21.43226920675442)
        addMarker("Old Bazar", 42.001848931690965, 21.438603996961117)
        addMarker("Canyon Matka", 41.95830882840553, 21.297571053790456)
        addMarker("Vodno", 41.96580647332994, 21.39781604905857)

        // Move camera to a position that includes all markers
        val boundsBuilder = LatLngBounds.builder()
        boundsBuilder.include(LatLng(41.99643840387665, 21.43226920675442)) // Skopje Square
        boundsBuilder.include(LatLng(42.001848931690965, 21.438603996961117)) // Old Bazar
        boundsBuilder.include(LatLng(41.95830882840553, 21.297571053790456)) // Canyon Matka
        boundsBuilder.include(LatLng(41.96580647332994, 21.39781604905857)) // Vodno

        val bounds = boundsBuilder.build()
        val padding = 100 // in pixels
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.animateCamera(cameraUpdate)
    }

    private fun addMarker(name: String, latitude: Double, longitude: Double) {
        val marker = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(marker).title(name))
    }
}