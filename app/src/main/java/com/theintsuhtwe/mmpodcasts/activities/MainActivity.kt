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
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
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
                        callFragment(HomeFragment.newInstance("a", "b"))
                        return true
                    }
                    R.id.nav_search -> {
                        callFragment(SearchFragment.newInstance("a", "b"))
                        return true
                    }
                    R.id.nav_download -> {
                        callFragment(DownloadFragment.newInstance("a", "b"))
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
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}