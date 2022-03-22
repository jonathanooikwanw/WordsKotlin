/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.ActivityMainBinding

/**
 * Main Activity and entry point for the app. Displays a RecyclerView of letters.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = LetterAdapter()

        //binding
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//        recyclerView = binding.recyclerView
        // Sets the LinearLayoutManager of the recyclerview
//        chooseLayout()


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    private fun chooseLayout(){
//        if (isLinearLayoutManager){
//            recyclerView.layoutManager = LinearLayoutManager(this)
//        } else{
//            recyclerView.layoutManager = GridLayoutManager(this, 4)
//        }
//        recyclerView.adapter = LetterAdapter()
//    }
//
//    //this just updates the icon on what we press lmao
//    private fun setIcon(menuItem: MenuItem?){
//        if (menuItem == null)
//            return
//
//        // Set the drawable for the menu icon based on which LayoutManager is currently in use
//
//        // An if-clause can be used on the right side of an assignment if all paths return a value.
//        // The following code is equivalent to
//        // if (isLinearLayoutManager)
//        //     menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
//        // else menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
//        menuItem.icon =
//            if(isLinearLayoutManager)
//                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
//            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
//    }
//
//    //inflate menu options and perform more setupm i assume when we tap the button
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.layout_menu, menu)
//
//        val layoutButton = menu?.findItem(R.id.action_switch_layout)
//        setIcon(layoutButton)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//            R.id.action_switch_layout -> {
//                isLinearLayoutManager = !isLinearLayoutManager
//                chooseLayout()
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
