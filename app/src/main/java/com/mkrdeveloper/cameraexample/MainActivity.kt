package com.mkrdeveloper.cameraexample

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var btn : Button
    lateinit var img : ImageView

    val resutContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->


        if (result.resultCode == Activity.RESULT_OK){
            val bitmap = result.data?.extras?.get("data") as Bitmap

            img.setImageBitmap(bitmap)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)
        img = findViewById(R.id.imageView)

        btn.setOnClickListener {
           val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            resutContract.launch(intent)
        }

    }
}