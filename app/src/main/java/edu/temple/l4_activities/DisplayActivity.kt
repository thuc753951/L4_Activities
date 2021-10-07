package edu.temple.l4_activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        Log.d("Second activity state", "onCreate() fired")
        val intent = intent
        val extras = intent.extras
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)
        val imageName : String
        if(extras != null){
            imageName = extras.getString("String").toString()
        }else{
            imageName = ""
        }

        imageView.setImageResource(getId(this, imageName))
        textView.text = imageName

    }
    fun getId(context: Context, imageName: String): Int { //returns the object similar to R.drawable.imageName given a string input of the image
        return context.resources.getIdentifier("drawable/$imageName", null, context.packageName)
    }
}