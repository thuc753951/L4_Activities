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


        imageArray.add(ImageObject("druid",R.drawable.druid))
        imageArray.add(ImageObject("monk",R.drawable.monk))
        imageArray.add(ImageObject("ranger", R.drawable.ranger))
        imageArray.add(ImageObject("rogue", R.drawable.rogue))
        imageArray.add(ImageObject("warlock", R.drawable.warlock))
        imageArray.add(ImageObject("wizard", R.drawable.wizard))
        imageArray.add(ImageObject("cleric", R.drawable.cleric))
        imageArray.add(ImageObject("barbarian", R.drawable.barbarian))
        imageArray.add(ImageObject("bard", R.drawable.bard))
        imageArray.add(ImageObject("fighter", R.drawable.fighter))
        imageArray.add(ImageObject("paladin", R.drawable.paladin))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapting
        recyclerView.layoutManager = GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        //val secondActivityIntent = Intent(this, DisplayActivity::class.java)

        //launch




    }

    override fun onItemClick(position: Int) { // send to activity 2
        val secondActivityIntent = Intent(this@SelectionActivity, DisplayActivity::class.java)
        secondActivityIntent.putExtra("String", imageArray[position].description)
        startActivity(secondActivityIntent)
        //val imageView = findViewById<ImageView>(R.id.imageView)
        //val textView = findViewById<TextView>(R.id.textView)
        //textView.setTextSize(20f)
        //imageView.setImageResource(imageArray[position].resourceId)
        //textView.text = imageArray[position].description
        //adapting.notifyItemChanged(position)
    }
}