package com.example.sp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.rilixtech.widget.countrycodepicker.CountryCodePicker


class MainActivity : AppCompatActivity() {

    lateinit var ccp: CountryCodePicker
    lateinit var edtPhoneNumber: AppCompatEditText
    //lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val rollButton: Button = findViewById(R.id.roll_button)

        val submitButton: Button = findViewById(R.id.phone_num_submit_button);

        ccp = findViewById(R.id.ccp);
        edtPhoneNumber = findViewById(R.id.phone_number_edt);
        ccp.registerPhoneNumberTextView(edtPhoneNumber);

        ccp.setDefaultCountryUsingPhoneCodeAndApply(966);
        ccp.setCountryPreference("SA,BH,KW,AE,QA");
        ccp.setOnCountryChangeListener {
                    selectedCountry -> Toast.makeText(
                this,
                "Changed to " + selectedCountry.name,
                Toast.LENGTH_SHORT
            ).show()
        }

        submitButton.setOnClickListener {
            if(!ccp.isValid()) {
                edtPhoneNumber.setText("");
                Toast.makeText(
                    this,
                    "Invalid number in " + ccp.selectedCountryName + "! Please re-enter it.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                Toast.makeText(
                    this,
                    "Correct! Full Number is : " + ccp.getFullNumberWithPlus(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        /* rollButton.text = "Let's Roll"
         diceImage = findViewById(R.id.dice_image)
         rollButton.setOnClickListener {
             rollDice()
             Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
         }*/


    }
    /*
    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)


    }*/

}
