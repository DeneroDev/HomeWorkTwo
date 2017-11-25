package com.example.denero.dz2

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtTextUser:EditText
    lateinit var btnTakePhoto:Button
    private val CAMERA_RESULT = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtTextUser = findViewById(R.id.edt_name)
        btnTakePhoto = findViewById(R.id.btn_photo)

        btnTakePhoto.setOnClickListener(View.OnClickListener {
            if(edtTextUser.text!=null && edtTextUser.text.toString()!=""){
                var cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent,CAMERA_RESULT)
            }
            else
                Toast.makeText(applicationContext,R.string.eror_input_name,Toast.LENGTH_LONG).show()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CAMERA_RESULT && data?.getExtras()?.get("data")!=null){
            val intent = Intent(applicationContext,ResultActivity::class.java)
            val bitmap = data.getExtras().get("data") as Bitmap
            intent.putExtra("photo",bitmap)
            intent.putExtra("name",edtTextUser.text.toString())
            startActivity(intent)
        }

    }
}
