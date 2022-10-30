package com.github.raininforest.bottom.navigation.extension

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.github.raininforest.bottom.navigation.extension.api.IconSource.Companion.resource
import com.github.raininforest.bottom.navigation.extension.api.IconSource.Companion.url
import com.github.raininforest.bottom.navigation.extension.api.setup
import com.github.raininforest.bottom.navigation.extension.databinding.ActivityMainBinding
import com.github.raininforest.bottom.navigation.extension.glide.loader.GlideMenuIconLoader
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        bottomNavigationView.setup {
            sections {
                section {
                    title("Dashboard")
                    iconSource(resource(R.drawable.ic_dashboard_black_24dp))
                    link("dashboard")
                }
                section {
                    title("Home")
                    iconSource(resource(R.drawable.ic_home_black_24dp))
                    link("home")
                }
                section {
                    title("Notifications")
                    iconSource(url("https://www.seekpng.com/png/full/138-1387657_app-icon-set-login-icon-comments-avatar-icon.png"))
                    link("notifications")
                }
            }
            tint(R.color.bottom_nav_tint)
            remoteLoader(GlideMenuIconLoader)
            onItemClicked { section ->
                navController.navigate(route = section.link)
                Log.d(TAG, "section clicked: $section")
            }
        }
    }

    companion object {
        private const val TAG = "BottomNavExtensionSampleApp"
    }
}