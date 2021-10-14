package edu.temple.l4_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity(), ImageAdapter.OnItemClickListener {

    var imageArray = ArrayList<ImageObject>()
    val adapting = ImageAdapter(imageArray, this)

    val secondActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        //Log.d("Returned data", it.data?.getStringExtra("resultValue").toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myArray =resources.getStringArray(R.array.name_array) // cant place string resource collection before oncreate, since it will be null

        imageArray.add(ImageObject(myArray[0],R.drawable.druid))
        imageArray.add(ImageObject(myArray[1],R.drawable.monk))
        imageArray.add(ImageObject(myArray[2], R.drawable.ranger))
        imageArray.add(ImageObject(myArray[3], R.drawable.rogue))
        imageArray.add(ImageObject(myArray[4], R.drawable.warlock))
        imageArray.add(ImageObject(myArray[5], R.drawable.wizard))
        imageArray.add(ImageObject(myArray[6], R.drawable.cleric))
        imageArray.add(ImageObject(myArray[7], R.drawable.barbarian))
        imageArray.add(ImageObject(myArray[8], R.drawable.bard))
        imageArray.add(ImageObject(myArray[9], R.drawable.fighter))
        imageArray.add(ImageObject(myArray[10], R.drawable.paladin))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapting
        recyclerView.layoutManager = GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        //val secondActivityIntent = Intent(this, DisplayActivity::class.java)

        //launch




    }

    override fun onItemClick(position: Int) { // send to activity 2
        val secondActivityIntent = Intent(this@SelectionActivity, DisplayActivity::class.java)
        val myBundle = Bundle()
        myBundle.putString(getString(R.string.String),imageArray[position].description)
        myBundle.putInt(getString(R.string.Int),imageArray[position].resourceId)
        secondActivityIntent.putExtra(getString(R.string.bundle), myBundle)
        startActivity(secondActivityIntent)
        //val imageView = findViewById<ImageView>(R.id.imageView)
        //val textView = findViewById<TextView>(R.id.textView)
        //textView.setTextSize(20f)
        //imageView.setImageResource(imageArray[position].resourceId)
        //textView.text = imageArray[position].description
        //adapting.notifyItemChanged(position)
    }
}