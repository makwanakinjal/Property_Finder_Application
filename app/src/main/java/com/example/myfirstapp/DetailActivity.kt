package com.example.myfirstapp

import android.icu.text.AlphabeticIndex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        var backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        fetchData()
    }

    fun fetchData() {


        val intent = intent
        val extras = intent.extras

        val title = extras!!.getString("titleskey")
        val titleTextview = findViewById<TextView>(R.id.titleTextview)
        titleTextview.text = title

        val description = extras.getString("descriptionskey")
        val descriptionTextview = findViewById<TextView>(R.id.descriptionTextview)
        descriptionTextview.text = description

        val beds = extras.getInt("bedskey")
        val bedroomsTextview = findViewById<TextView>(R.id.bedroomsTextview)
        bedroomsTextview.text = beds.toString()

        val baths = extras.getInt("bathskey")
        val bathroomsTextview = findViewById<TextView>(R.id.bathroomTextview)
        bathroomsTextview.text = baths.toString()

        val years = extras.getInt("yearskey")
        val builtsTextview = findViewById<TextView>(R.id.builtTextview)
        builtsTextview.text = years.toString()

        val images = extras.getIntegerArrayList("imageskey")

        var index = 0

        val imageView = findViewById<ImageView>(R.id.imageView3)
        imageView.setImageResource(images!![index])

        imageView.setOnClickListener {
            index++
            if (index == images.size)
                index = 0
            imageView.setImageResource(images[index])
        }
    }


}