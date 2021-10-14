package edu.temple.l4_activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        //Log.d("Second activity state", "onCreate() fired")
        val myArray = ArrayList<Int>()
        myArray.add(R.drawable.druid)
        myArray.add(R.drawable.monk)
        myArray.add(R.drawable.ranger)
        myArray.add(R.drawable.rogue)
        myArray.add(R.drawable.warlock)
        myArray.add(R.drawable.wizard)
        myArray.add(R.drawable.cleric)
        myArray.add(R.drawable.barbarian)
        myArray.add(R.drawable.bard)
        myArray.add(R.drawable.fighter)
        myArray.add(R.drawable.paladin)

        val intent = intent
        val extras = intent.extras
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)
        val imageName : String
        if(extras != null){
            imageName = extras.getString(getString(R.string.String)).toString()
        }else{
            imageName = ""
        }
        if((imageName == "druide") || (imageName == "druid")){
            imageView.setImageResource(myArray[0])
        }else if((imageName == "moine")||(imageName == "monk")){
            imageView.setImageResource(myArray[1])
        }else if(imageName == "ranger"){
            imageView.setImageResource(myArray[2])
        }else if((imageName == "voyou")||(imageName == "rogue")){
            imageView.setImageResource(myArray[3])
        }else if((imageName == "démoniste")||(imageName == "warlock")){
            imageView.setImageResource(myArray[4])
        }else if((imageName == "sorcier")||(imageName == "wizard")){
            imageView.setImageResource(myArray[5])
        }else if((imageName == "clerc")||(imageName == "cleric")){
            imageView.setImageResource(myArray[6])
        }else if((imageName == "barbare")||(imageName == "barbarian")){
            imageView.setImageResource(myArray[7])
        }else if((imageName == "barde")||(imageName == "bard")){
            imageView.setImageResource(myArray[8])
        }else if((imageName == "combattant")||(imageName == "fighter")){
            imageView.setImageResource(myArray[9])
        }else if((imageName == "paladin")||(imageName == "paladin")){
            imageView.setImageResource(myArray[10])
        }
        textView.textSize = 25f
        textView.setTextColor(Color.BLACK)
        textView.gravity = Gravity.CENTER_HORIZONTAL
        textView.text = imageName

    }
    private fun getId(context: Context, imageName: String): Int { //returns the object similar to R.drawable.imageName given a string input of the image
        return context.resources.getIdentifier(imageName,getString(R.string.drawable), context.packageName)
    }
}