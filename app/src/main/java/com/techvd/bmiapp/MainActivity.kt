package com.techvd.bmiapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.techvd.bmiapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener{
            calculate()
        }
    }

    private fun calculate(){

        if (binding.weight.text.isNotEmpty() && binding.height.text.isNotEmpty()) {
            val num = binding.weight.text.toString().toFloat()
            val num1 = binding.height.text.toString().toFloat()
            val result1 = num / (num1 * num1)
            binding.result.text = result1.toString()
            binding.image1.setImageResource(picture(result1))
        }
        else{
            Toast.makeText(this, "enter the needed field", Toast.LENGTH_SHORT).show()
        }
    }

    private fun picture(result1: Float): Int {
        var img : Int = R.drawable.ic_obesity
        if(result1 in 0.0..18.5) {
            img = R.drawable.ic_underweight
        }else if (result1 in 18.5..24.9) {
            img = R.drawable.ic_healthy
        }
        else if (result1 in 24.9..30.0){
            img= R.drawable.ic_overweight
        }
        return img
    }


}