package com.example.practiceriyadh.blurImage

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.practiceriyadh.R
import jp.wasabeef.glide.transformations.BlurTransformation

class BlurImageAdapter(var list:ArrayList<String>):RecyclerView.Adapter<BlurImageAdapter.BlurImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlurImageViewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.image_blur_layout,parent,false)
        return BlurImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlurImageViewHolder, position: Int) {
       var image=list[position]
        holder.setImage(image)
    }

    override fun getItemCount(): Int {
        return list.size
    }



    class BlurImageViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var imageView: ImageView = itemView.findViewById(R.id.image_view)
           fun setImage(image: String) {
//               Glide.with(imageView).load(image)
//                   .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 2)))
//                   .into(imageView)


           }
    }
}