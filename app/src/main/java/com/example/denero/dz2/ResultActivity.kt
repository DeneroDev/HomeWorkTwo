package com.example.denero.dz2

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var imgViewPhoto:ImageView
    lateinit var tvUserText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_screen)
        imgViewPhoto = findViewById(R.id.img_view_photo)
        tvUserText = findViewById(R.id.tv_user)


        imgViewPhoto.setImageBitmap(intent.getParcelableExtra<Bitmap>("photo"))
        tvUserText.setText(intent.getStringExtra("name"))
    }
}
