package com.example.practiceriyadh.zoneScreen

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practiceriyadh.R

class ZoneImagesAdapter (var listOfUrl:MutableList<ImageClass>,var listner: ImageClickListner):
    RecyclerView.Adapter<ZoneImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.zone_images_video_layout, parent, false)
        return ImageViewHolder(view, listner)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = listOfUrl[position]
        holder.setImages(image)
    }

    override fun getItemCount(): Int {
        return listOfUrl.size
    }


    class ImageViewHolder(itemView: View, var listner: ImageClickListner) :
        RecyclerView.ViewHolder(itemView) {
        var image1: ImageView = itemView.findViewById(R.id.image1_row1)
        var image2: ImageView = itemView.findViewById(R.id.image2_row1)
        var image3: ImageView = itemView.findViewById(R.id.image3_row1)
        var image4: ImageView = itemView.findViewById(R.id.image1_row2)
        var image5: ImageView = itemView.findViewById(R.id.image2_row2)
        var image6: ImageView = itemView.findViewById(R.id.image3_row2)
        fun setImages(image:ImageClass) {
            Glide.with(image1).load(image.image1).into(image1)
            if (image.image2 == null) {
                image2.visibility = View.GONE
                image3.visibility = View.GONE
                image4.visibility = View.GONE
                image5.visibility = View.GONE
                image6.visibility = View.GONE

            } else if (image.image3 == null){
                Glide.with(image2).load(image.image2).into(image2)
                image3.visibility = View.GONE
                image4.visibility = View.GONE
                image5.visibility = View.GONE
                image6.visibility = View.GONE
            }else if (image.image4 == null){
                Glide.with(image2).load(image.image2).into(image2)
                Glide.with(image3).load(image.image3).into(image3)
                image4.visibility = View.GONE
                image5.visibility = View.GONE
                image6.visibility = View.GONE
            }else if (image.image5 == null){
                Glide.with(image2).load(image.image2).into(image2)
                Glide.with(image3).load(image.image3).into(image3)
                Glide.with(image4).load(image.image4).into(image4)
                image5.visibility = View.GONE
                image6.visibility = View.GONE
            }else if (image.image6 == null){
                Glide.with(image2).load(image.image2).into(image2)
                Glide.with(image3).load(image.image3).into(image3)
                Glide.with(image4).load(image.image4).into(image4)
                Glide.with(image5).load(image.image5).into(image5)
                image6.visibility = View.GONE
            }
                else {
                Glide.with(image2).load(image.image2).into(image2)
                Glide.with(image3).load(image.image3).into(image3)
                Glide.with(image4).load(image.image4).into(image4)
                Glide.with(image5).load(image.image5).into(image5)
                Glide.with(image6).load(image.image6).into(image6)

            }
        }

        }


}



