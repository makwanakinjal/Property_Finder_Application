package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener
{

    val titles: MutableList<String> = mutableListOf()
    val descriptions : MutableList<String> = mutableListOf()
    val beds = intArrayOf(2,3,1)
    val baths = intArrayOf(1,2,1)
    val years = intArrayOf(2010,2018,2020)


    val prop_1_images = arrayListOf<Int>()
    val prop_2_images = arrayListOf<Int>()
    val prop_3_images = arrayListOf<Int>()

    val allImagesArr : MutableList<ArrayList<Int>> = mutableListOf()

        fun populatedData (){

            descriptions.add("When homeowner Radeesh Shetty approached Kavya Sheth of Studio Ruh, he had a one-line brief for his abode’s design — to make it like a home in Sri Lanka. Being personally inspired by Sri Lankan architecture- Shetty who is the founder and director of Beruru.")
            descriptions.add("This stunning two-story home is on a large lot in a hot neighborhood. From the open-concept kitchen and living space to the large shaded backyard, there is plenty of room for the whole family to enjoy. Recent updates include new carpeting upstairs and stainless appliances. ")
            descriptions.add("“Remodeled to perfection! This beautiful home is located close to shopping and dining. Here are just a few of its wonderful features: cozy fireplace, new kitchen cabinets, stainless steel sink, modern quartz counter tops, wood flooring, remodeled bathrooms, freshly painted, central a/c.")

        titles.add("\$825,000")
            titles.add("\$409,000")
            titles.add("\$845,000")

        prop_1_images.add(R.drawable.img2_1)
            prop_1_images.add(R.drawable.img2_2)
            prop_1_images.add(R.drawable.img2_3)
            prop_1_images.add(R.drawable.img2_4)
            allImagesArr.add(prop_1_images)

            prop_2_images.add(R.drawable.img3_1)
            prop_2_images.add(R.drawable.img3_2)
            prop_2_images.add(R.drawable.img3_3)
            prop_2_images.add(R.drawable.img3_4)
           allImagesArr .add(prop_2_images)

            prop_3_images.add(R.drawable.img4_1)
            prop_3_images.add(R.drawable.img4_2)
            prop_3_images.add(R.drawable.img4_3)
            allImagesArr.add(prop_3_images)

        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        populatedData()

        val card_1_titleTextview = findViewById<TextView>(R.id.card_1_titleTextview)
        val card_2_titleTextview = findViewById<TextView>(R.id.card_2_titleTextview)
        val card_3_titleTextview = findViewById<TextView>(R.id.card_3_titleTextview)

        card_1_titleTextview.text = titles[0]
        card_2_titleTextview.text = titles[1]
        card_3_titleTextview.text = titles[2]

        val card_1 = findViewById<LinearLayout>(R.id.card_1)
        val card_2 = findViewById<LinearLayout>(R.id.card_2)
        val card_3 = findViewById<LinearLayout>(R.id.card_3)


        card_1.setOnClickListener(this)
        card_2.setOnClickListener(this)
        card_3.setOnClickListener(this)
    }
        override fun onClick(view: View?)
        {
        val intent = Intent(this,
        DetailActivity::class.java)


            var index = 0
            when (view!!.id){
                R.id.card_1 -> index = 0
                    R.id.card_2 ->index = 1
                R.id.card_3 -> index = 2
            }


            val extras = Bundle()

            extras.putInt("bedskey", beds[index])
            extras.putInt("bathskey", baths[index])
            extras.putInt("yearskey", years[index])
            extras.putString("titleskey", titles[index])
            extras.putString("descriptionskey", descriptions[index])


            extras.putIntegerArrayList("imageskey" , allImagesArr[index])
            intent.putExtras(extras)
            startActivity(intent)
        }

}