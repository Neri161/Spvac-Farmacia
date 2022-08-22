package com.spvacfarmacia

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.spvacfarmacia.databinding.ActivitySucursalesBinding

class Sucursales : AppCompatActivity() {

    private lateinit var binding: ActivitySucursalesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySucursalesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}