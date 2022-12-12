package com.example.foodamin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.foodamin.databinding.ActivityComparisonBinding
import com.example.foodamin.databinding.ActivityFoodWithVitaminsActvityBinding

class FoodWithVitaminsActvity : AppCompatActivity() {

    lateinit var binding: ActivityFoodWithVitaminsActvityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodWithVitaminsActvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // databases are made in all classes only due to time restrictions

        val foodDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"foodFinalDB")
            .createFromAsset("databases/Food1.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val vitaminDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"VitaminFinalDB")
            .createFromAsset("databases/Vitamins.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val vitaminID = intent.getIntExtra("vitaminID", 0)  // finds the vitamin id
        val vitaminProduct = vitaminDB.VitaminsDao().findItemVitamin(vitaminID) // finds the specific vitamin bottle
        //val foodsWithVitamins = foodDB.foodDao().findItemVitamin(vitaminProduct[0].ParameterID) // finds all items containing the vitamin bottles' vitamin and sorts them in descending order in a list. this will not be used in the test version

        // layout

        //bellPepper
        val bellPepper = foodDB.foodDao().usabilityTestQuery("Pepper, sweet, red, raw")

        val firstFoodName = "Red Pepper"
        binding.firstFoodNameGrams.text = firstFoodName

        val firstFoodText = "${bellPepper[0].ResVal?.toInt()}g, ${(bellPepper[0].ResVal!!/ vitaminProduct[0].RI!!*100).toInt()}%RI pr. 100g"
        binding.firstFoodTextGrams.text = firstFoodText

        //mashedPotatoes
        val mashedPotatoes = foodDB.foodDao().usabilityTestQuery("Potatoes, mashed, instant powder with dry milk")

        val secondFoodName = "Mashed Potatoes"
        binding.secondFoodNameGrams.text = secondFoodName
        val secondFoodText = "${mashedPotatoes[0].ResVal?.toInt()}g, ${(mashedPotatoes[0].ResVal!!/ vitaminProduct[0].RI!!*100).toInt()}%RI pr. 100g"
        binding.secondFoodTextGrams.text = secondFoodText

        //popcorn
        val popcorn = foodDB.foodDao().usabilityTestQuery("Pop corn, oil and salt added")

        val thirdFoodName = "popcorn, microwave"
        binding.thirdFoodNameGrams.text = thirdFoodName

        val thirdFoodText = "${popcorn[0].ResVal?.toInt()}g, ${(popcorn[0].ResVal!!/ vitaminProduct[0].RI!!*100).toInt()}%RI pr. 100g"
        binding.thirdFoodTextGrams.text = thirdFoodText

        //coriander
        val coriander = foodDB.foodDao().usabilityTestQuery("Coriander, leaf, raw")

        binding.fourthFoodNameGrams.text = coriander[0].FoodName

        val fourthFoodText = "${coriander[0].ResVal?.toInt()}g, ${(coriander[0].ResVal!!/ vitaminProduct[0].RI!!*100).toInt()}%RI pr. 100g"
        binding.fourthFoodTextGrams.text = fourthFoodText

        // button interactions
        binding.scanBtnGrams.setOnClickListener {
            val scanActivity = Intent(this, BarcodeScanningActivity::class.java)
            startActivity(scanActivity)
        }

        binding.toggleBoxForRiInGrams.setOnClickListener {
            val foodsWithVitamins = Intent(this, FoodWithVitaminsRIActivity::class.java).apply {
                putExtra("vitaminID",vitaminID)
            }
            startActivity(foodsWithVitamins)
        }
    }
}