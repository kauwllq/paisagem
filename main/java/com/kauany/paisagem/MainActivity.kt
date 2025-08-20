package com.kauany.paisagem

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.paia)
        button = findViewById(R.id.disparagementView)

        button.setOnClickListener {
            fetchRandomPaisagem()
        }
    }

    private fun fetchRandomPaisagem() {
        lifecycleScope.launch {
            try {
                val response = ApiClient.instance.getRandomPaisagem()
                Picasso.get()
                    .load(response.url)
                    .centerCrop()
                    .fit()
                    .into(imageView)

                Toast.makeText(this@MainActivity, response.massage, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
               Toast.makeText(this@MainActivity, "Erro: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
