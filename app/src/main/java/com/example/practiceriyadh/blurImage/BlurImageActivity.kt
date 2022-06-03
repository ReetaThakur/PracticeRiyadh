package com.example.practiceriyadh.blurImage

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.practiceriyadh.R
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_blur_image.*
import java.nio.file.Files.find

class BlurImageActivity : AppCompatActivity() {

    var imageVideoUrl = ArrayList<String>()
   
    val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    lateinit var blureAdapter: BlurImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blur_image)
        buildData()
        setRecyclerView()

        blurRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var firstPos = linearLayoutManager.findFirstVisibleItemPosition()
                var lastPos = linearLayoutManager.findLastVisibleItemPosition()
                val middle = Math.abs(lastPos - firstPos) / 2 + firstPos

                for (i in 0 until blureAdapter.itemCount) {
                    if (i == middle) {
                        linearLayoutManager.findViewByPosition(i)?.let {
                            Glide.with(it).load(imageVideoUrl[i]).into(it as ImageView)
                        }
                    } else {
                        linearLayoutManager.findViewByPosition(i)?.let {
                            Glide.with(it).load(imageVideoUrl[i])
                                .apply(RequestOptions.bitmapTransform(BlurTransformation(20, 2)))
                                .into(it as ImageView)
                        }
                    }

                    blureAdapter.notifyDataSetChanged()
                }
            }
        })

    }

    private fun setRecyclerView() {
        blureAdapter=BlurImageAdapter(imageVideoUrl)
        blurRecyclerView.apply {
            adapter=blureAdapter
            layoutManager=linearLayoutManager
        }
    }




    private fun buildData() {
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzx__blVU5FWJAUCU4d9-E095_n3Fgy1tuxA&usqp=CAU")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh90iDDn5BoUnZqANXUszd17_Q-RhfRo8V6Q&usqp=CAU")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzx__blVU5FWJAUCU4d9-E095_n3Fgy1tuxA&usqp=CAU")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh90iDDn5BoUnZqANXUszd17_Q-RhfRo8V6Q&usqp=CAU")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzx__blVU5FWJAUCU4d9-E095_n3Fgy1tuxA&usqp=CAU")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh90iDDn5BoUnZqANXUszd17_Q-RhfRo8V6Q&usqp=CAU")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzx__blVU5FWJAUCU4d9-E095_n3Fgy1tuxA&usqp=CAU")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh90iDDn5BoUnZqANXUszd17_Q-RhfRo8V6Q&usqp=CAU")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzx__blVU5FWJAUCU4d9-E095_n3Fgy1tuxA&usqp=CAU")
        imageVideoUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh90iDDn5BoUnZqANXUszd17_Q-RhfRo8V6Q&usqp=CAU")
        imageVideoUrl.add("https://cdn.videvo.net/videvo_files/video/free/2019-02/small_watermarked/181004_10_LABORATORIES-SCIENCE_22_preview.webm")


    }
    }