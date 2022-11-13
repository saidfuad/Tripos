package com.example.tripso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }


    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

/**
 * loadFragment(HomeFragment())
bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
bottomNav.setOnNavigationItemReselectedListener {
when (it.itemId) {
R.id.home -> {
loadFragment(HomeFragment())
return@setOnNavigationItemReselectedListener
}
R.id.message -> {
loadFragment(ChatFragment())
return@setOnNavigationItemReselectedListener
}
R.id.settings -> {
loadFragment(SettingFragment())
return@setOnNavigationItemReselectedListener
}
}
}
 */