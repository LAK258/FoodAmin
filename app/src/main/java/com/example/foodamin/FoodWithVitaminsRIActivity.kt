package com.example.foodamin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.foodamin.databinding.ActivityFoodWithVitaminsActvityBinding
import com.example.foodamin.databinding.ActivityFoodWithVitaminsRiactivityBinding

class FoodWithVitaminsRIActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodWithVitaminsRiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodWithVitaminsRiactivityBinding.inflate(layoutInflater)
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
        binding.vitaminNameRi.text = vitaminProduct[0].Vitamin

    //bellPepper
        val bellPepper = foodDB.foodDao().usabilityTestQuery("Pepper, sweet, red, raw")

        val firstFoodName = "Red Pepper"
        binding.firstFoodNameRi.text = firstFoodName

        val firstFoodText = "${(100/(bellPepper[0].ResVal!!/ vitaminProduct[0].RI!!*100)*100).toInt()}g"
        binding.firstFoodTextRi.text = firstFoodText

    //mashedPotatoes
        val mashedPotatoes = foodDB.foodDao().usabilityTestQuery("Potatoes, mashed, instant powder with dry milk")

        val secondFoodName = "Mashed Potatoes"
        binding.secondFoodNameRi.text = secondFoodName
        val secondFoodText = "${(100/(mashedPotatoes[0].ResVal!!/ vitaminProduct[0].RI!!*100)*100).toInt()}g"
        binding.secondFoodTextRi.text = secondFoodText

    //popcorn
        val popcorn = foodDB.foodDao().usabilityTestQuery("Pop corn, oil and salt added")

        val thirdFoodName = "popcorn, microwave"
        binding.thirdFoodNameRi.text = thirdFoodName

        val thirdFoodText = "${(100/(popcorn[0].ResVal!!/ vitaminProduct[0].RI!!*100)*100).toInt()}g"
        binding.thirdFoodTextRi.text = thirdFoodText

    //coriander
        val coriander = foodDB.foodDao().usabilityTestQuery("Coriander, leaf, raw")

        binding.fourthFoodNameRi.text = coriander[0].FoodName

        val fourthFoodText = "${(100/(coriander[0].ResVal!!/ vitaminProduct[0].RI!!*100)*100).toInt()}g"
        binding.fourthFoodTextRi.text = fourthFoodText

    // button interactions

        binding.toggleRiRi.setOnClickListener {
            val foodsWithVitamins = Intent(this, FoodWithVitaminsActvity::class.java).apply {
                putExtra("vitaminID",vitaminID)
            }
            startActivity(foodsWithVitamins)
        }

        binding.scanBtnRi.setOnClickListener {
            val scanActivity = Intent(this, BarcodeScanningActivity::class.java).apply {
                putExtra("vitaminID",vitaminID)
            }
            startActivity(scanActivity)
        }
    }
}