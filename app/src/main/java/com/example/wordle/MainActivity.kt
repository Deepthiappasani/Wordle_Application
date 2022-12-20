package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.wordle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        keepPassingFocus()

        binding.edt15.addTextChangedListener {
            validateRow(
                binding.edt11,
                binding.edt12,
                binding.edt13,
                binding.edt14,
                binding.edt15
            )
        }
        binding.edt25.addTextChangedListener {
            validateRow(
                binding.edt21,
                binding.edt22,
                binding.edt23,
                binding.edt24,
                binding.edt25
            )
        }
        binding.edt35.addTextChangedListener {
            validateRow(
                binding.edt31,
                binding.edt32,
                binding.edt33,
                binding.edt34,
                binding.edt35
            )
        }
        binding.edt45.addTextChangedListener {
            validateRow(
                binding.edt41,
                binding.edt42,
                binding.edt43,
                binding.edt44,
                binding.edt45
            )
        }
        binding.edt55.addTextChangedListener {
            validateRow(
                binding.edt51,
                binding.edt52,
                binding.edt53,
                binding.edt54,
                binding.edt55
            )
        }
        binding.edt65.addTextChangedListener {
            validateRow(
                binding.edt61,
                binding.edt62,
                binding.edt63,
                binding.edt64,
                binding.edt65
            )
        }



    }

    private fun validateRow(
        edt1: EditText,
        edt2: EditText,
        edt3: EditText,
        edt4: EditText,
        edt5: EditText
    ){
        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()
        val edt5Text = edt5.text.toString()

        val word1 = Word[0].toString()
        val word2 = Word[1].toString()
        val word3 = Word[2].toString()
        val word4 = Word[3].toString()
        val word5 = Word[4].toString()
        /**
         * Red: ff3333
         * yellow: ffff00
         * green: 33cc33
         **/
        if(edt1Text == word2 || edt1Text == word3 || edt1Text == word4 || edt1Text == word5) {
            //color is yellow


            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt2Text == word1 || edt2Text == word3 || edt2Text == word4 || edt2Text == word5){
            //color is yellow

            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt3Text == word1 || edt3Text == word2 || edt3Text == word4 || edt3Text == word5) {
            //color is yellow

            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt4Text == word1 || edt4Text == word3 || edt4Text == word2 || edt4Text == word5) {
            //color is yellow

            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt5Text == word1 || edt5Text == word3 || edt5Text == word4 || edt5Text == word2) {
            //color is yellow

            edt5.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt1Text == word1){
            edt1.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt2Text == word2){
            edt2.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt3Text == word3){
            edt3.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt4Text == word4){
            edt4.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt5Text == word5){
            edt5.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt1Text != word1 && edt1Text != word2 && edt1Text != word3 && edt1Text != word4 && edt1Text != word5){
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt2Text != word1 && edt2Text != word2 && edt2Text != word3 && edt2Text != word4 && edt2Text != word5){
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt3Text != word1 && edt3Text != word2 && edt3Text != word3 && edt3Text != word4 && edt3Text != word5){
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt4Text != word1 && edt4Text != word2 && edt4Text != word3 && edt4Text != word4 && edt4Text != word5){
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt5Text != word1 && edt5Text != word2 && edt5Text != word3 && edt5Text != word4 && edt5Text != word5){
            edt5.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if(edt1Text == word1 && edt2Text == word2 && edt3Text == word3 && edt4Text == word4 && edt5Text == word5){
            Toast.makeText(this,"Congrats, You Guessed The Word Right!!!",Toast.LENGTH_SHORT).show()
            binding.txtWinnerLosser.visibility = View.VISIBLE
            binding.txtWinnerLosser.text = "Congrats, You Guessed The Word Right!!!"
            //make game inactive
            makeGameInactive()
            return
        }
        if(edt5.id == R.id.edt_65) {
            Toast.makeText(this, "Sorry, You Couldn't guess the word :((", Toast.LENGTH_SHORT)
                .show()
            binding.txtWinnerLosser.visibility = View.VISIBLE
            binding.txtWinnerLosser.text = "Sorry, You Couldn't guess the word :(("
            //make game inactive
            makeGameInactive()
            return
        }

    }
        private fun makeGameInactive() {
            binding.edt11.isEnabled = false
            binding.edt12.isEnabled = false
            binding.edt13.isEnabled = false
            binding.edt14.isEnabled = false
            binding.edt15.isEnabled = false
            binding.edt21.isEnabled = false
            binding.edt22.isEnabled = false
            binding.edt23.isEnabled = false
            binding.edt24.isEnabled = false
            binding.edt25.isEnabled = false
            binding.edt31.isEnabled = false
            binding.edt32.isEnabled = false
            binding.edt33.isEnabled = false
            binding.edt34.isEnabled = false
            binding.edt35.isEnabled = false
            binding.edt41.isEnabled = false
            binding.edt42.isEnabled = false
            binding.edt43.isEnabled = false
            binding.edt44.isEnabled = false
            binding.edt45.isEnabled = false
            binding.edt51.isEnabled = false
            binding.edt52.isEnabled = false
            binding.edt53.isEnabled = false
            binding.edt54.isEnabled = false
            binding.edt55.isEnabled = false
            binding.edt61.isEnabled = false
            binding.edt62.isEnabled = false
            binding.edt63.isEnabled = false
            binding.edt64.isEnabled = false
            binding.edt65.isEnabled = false
            //binding.edt11.isEnabled = false

        }


        private  fun keepPassingFocus(){
            passFocusToNextEdittext(binding.edt11,binding.edt12)
            passFocusToNextEdittext(binding.edt12,binding.edt13)
            passFocusToNextEdittext(binding.edt13,binding.edt14)
            passFocusToNextEdittext(binding.edt14,binding.edt15)

            passFocusToNextEdittext(binding.edt21,binding.edt22)
            passFocusToNextEdittext(binding.edt22,binding.edt23)
            passFocusToNextEdittext(binding.edt23,binding.edt24)
            passFocusToNextEdittext(binding.edt24,binding.edt25)

            passFocusToNextEdittext(binding.edt31,binding.edt32)
            passFocusToNextEdittext(binding.edt32,binding.edt33)
            passFocusToNextEdittext(binding.edt33,binding.edt34)
            passFocusToNextEdittext(binding.edt34,binding.edt35)

            passFocusToNextEdittext(binding.edt41,binding.edt42)
            passFocusToNextEdittext(binding.edt42,binding.edt43)
            passFocusToNextEdittext(binding.edt43,binding.edt44)
            passFocusToNextEdittext(binding.edt44,binding.edt45)

            passFocusToNextEdittext(binding.edt51,binding.edt52)
            passFocusToNextEdittext(binding.edt52,binding.edt53)
            passFocusToNextEdittext(binding.edt53,binding.edt54)
            passFocusToNextEdittext(binding.edt54,binding.edt55)

            passFocusToNextEdittext(binding.edt61,binding.edt62)
            passFocusToNextEdittext(binding.edt62,binding.edt63)
            passFocusToNextEdittext(binding.edt63,binding.edt64)
            passFocusToNextEdittext(binding.edt64,binding.edt65)
        }
        private fun passFocusToNextEdittext(
            edt1: EditText,
            edt2: EditText
        )
        {
            edt1.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}


                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(edt: Editable?) {
                    if(edt?.length == 1){
                        edt2.requestFocus()
                    }
                }

            })
        }

    companion object {
        private val Word = "abhay"
    }
}
