package com.example.countriesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countriesretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener{
            val countryName = binding.countryNameEt.text.toString()

            val countries = restCountriesService.getCountryByName(countryName)
            val country = countries[0]

            binding.countryName.text = country.name
            binding.capitalTv.text = country.capital
            binding.populationTv.text = country.population.toString()
            binding.area.text = country.area.toString()
            binding.languages.text = country.languages.toString()

        }
    }
}