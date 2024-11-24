package com.example.articlesearchpt3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.articlesearchpt3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar as the ActionBar
        setSupportActionBar(binding.toolbar)

        // Set up BottomNavigationView item selection listener
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_books -> loadFragment(BestSellersFragment(), "BooksFragment")
                R.id.nav_articles -> loadFragment(ArticlesFragment(), "ArticlesFragment")
                else -> false
            }
        }

        // Load default fragment if no saved instance state
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.nav_books
        }
    }

    private fun loadFragment(fragment: Fragment, tag: String): Boolean {
        val currentFragment = supportFragmentManager.findFragmentByTag(tag)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    android.R.anim.fade_in, // Enter animation
                    android.R.anim.fade_out // Exit animation
                )
                .replace(R.id.fragment_container, fragment, tag)
                .commit()
        }
        return true
    }
}