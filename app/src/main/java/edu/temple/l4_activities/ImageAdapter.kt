package edu.temple.l4_activities

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val _images: ArrayList<ImageObject>, private val listener: OnItemClickListener): RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    private val imageObject = _images

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val textView: TextView = itemView.findViewById(R.id.textView2)
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)


        init{
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            textView.setTextColor(Color.BLACK)
            textView.setTextSize(20f)

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) { // forwards click events to main
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder { // only creates a new view holder when there are no existing view holder
        var newView = LayoutInflater.from(parent.context).inflate(R.layout.temporary, parent,false)
        // ensure the inflate is of the right xml files
        return ViewHolder(newView)

    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) { // where you reuse the viewholders, or update an item with new data
        // this method can be called multiple times
        // make sure to name the holder's type the same as this class's file name = ImageAdapter
        var currentImages = imageObject[position]
        holder.imageView.setImageResource(currentImages.resourceId)
        holder.textView.text = currentImages.description


    }

    override fun getItemCount() = imageObject.size

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}