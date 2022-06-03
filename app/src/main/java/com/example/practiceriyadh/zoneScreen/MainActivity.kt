package com.example.practiceriyadh.zoneScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceriyadh.R
import com.example.practiceriyadh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ImageClickListner {

    private lateinit var zoneBinding: ActivityMainBinding
    var imageVideoUrl = mutableListOf<String>()
    var listOfUrl = mutableListOf<ImageClass>()
    lateinit var zoneAdapter:ZoneImagesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        zoneBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        buildData()
        setRecyclerView()
        zoneBinding.itemsCounting.text=imageVideoUrl.size.toString()
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


        var i = 0
        while (i < imageVideoUrl.size) {
            var count = imageVideoUrl.size - i
            if (count >= 6) {
                listOfUrl.add(
                    ImageClass(
                        imageVideoUrl[i], imageVideoUrl[++i], imageVideoUrl[++i],
                        imageVideoUrl[++i], imageVideoUrl[++i], imageVideoUrl[++i]
                    )
                )
            } else if (count == 5) {
                listOfUrl.add(
                    ImageClass(
                        imageVideoUrl[i], imageVideoUrl[++i], imageVideoUrl[++i],
                        imageVideoUrl[++i], imageVideoUrl[++i], null
                    )
                )
                break
            } else if (count == 4) {
                listOfUrl.add(
                    ImageClass(
                        imageVideoUrl[i], imageVideoUrl[++i], imageVideoUrl[++i],
                        imageVideoUrl[++i], null, null
                    )
                )
                break
            } else if (count == 3) {
                listOfUrl.add(
                    ImageClass(
                        imageVideoUrl[i], imageVideoUrl[++i], imageVideoUrl[++i],
                        null, null, null
                    )
                )
                break
            } else if (count == 2) {
                listOfUrl.add(
                    ImageClass(
                        imageVideoUrl[i], imageVideoUrl[++i], null,
                        null, null, null
                    )
                )
                break
            } else if (count == 1) {
                listOfUrl.add(
                    ImageClass(
                        imageVideoUrl[i], null, null,
                        null, null, null
                    )
                )
                break
            }
            ++i
        }

    }

    private fun setRecyclerView() {

        zoneAdapter = ZoneImagesAdapter(listOfUrl,this)
        val linearLayoutManager = LinearLayoutManager(this)


        zoneBinding.rvImages.apply {
            adapter=zoneAdapter
            layoutManager=linearLayoutManager
        }
    }

    override fun getUrl(url: String?) {
        if(url!!.contains(".mp4") || url!!.contains(".3gp") ||
            url!!.contains(".mkv") || url!!.contains(".webm")){
            val intent=Intent(this,VideoViewActivity::class.java)
            intent.putExtra("videoUrl",url)
            startActivity(intent)
        }else{
            val intent=Intent(this,ImageActivity::class.java)
            intent.putExtra("imageUrl",url)
            startActivity(intent)
        }
    }
}