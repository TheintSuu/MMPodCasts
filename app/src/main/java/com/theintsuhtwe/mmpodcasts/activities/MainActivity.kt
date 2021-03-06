package com.theintsuhtwe.mmpodcasts.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.theintsuhtwe.mmpodcasts.R
import com.theintsuhtwe.mmpodcasts.fragments.DownloadFragment
import com.theintsuhtwe.mmpodcasts.fragments.HomeFragment
import com.theintsuhtwe.mmpodcasts.fragments.SearchFragment
import com.theintsuhtwe.mmpodcasts.utils.FRAGMENT_Home
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    val homeFragment = HomeFragment.newInstance("a", "b")
    val searchFragment = SearchFragment.newInstance("a", "b")
    val downloadFragment = DownloadFragment.newInstance("a", "b")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callFragment(HomeFragment.newInstance("a", "b"))
        setUpBottomNavigation()
    }


    fun setUpBottomNavigation(){
        BottomNav.setOnNavigationItemSelectedListener (object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_home -> {
                        callFragment(homeFragment)
                        return true
                    }
                    R.id.nav_search -> {
                        callFragment(searchFragment)
                        return true
                    }
                    R.id.nav_download -> {
                        callFragment(downloadFragment)
                        return true
                    }
                    R.id.nav_profile -> {
                        callFragment(HomeFragment.newInstance("a", "b"))
                        return true
                    }

                }
                return false

            }
        })
    }

    fun callFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction().
            replace(R.id.container, fragment)
            .addToBackStack(FRAGMENT_Home).commit()
    }

}