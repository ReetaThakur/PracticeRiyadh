package com.example.practiceriyadh.zoneScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.practiceriyadh.R

class ImageActivity : AppCompatActivity() {

    lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        image=findViewById(R.id.showImage)
        var url=intent.getStringExtra("imageUrl")
        Glide.with(image).load(url).into(image)
    }
}