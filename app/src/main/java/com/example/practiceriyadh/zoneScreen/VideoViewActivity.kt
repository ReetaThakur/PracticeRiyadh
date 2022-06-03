package com.example.practiceriyadh.zoneScreen

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.practiceriyadh.R

class VideoViewActivity : AppCompatActivity() {
    lateinit var video:VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)
        video=findViewById(R.id.showVideo)
        var url=intent.getStringExtra("videoUrl")
        video.setVideoPath(url)
        video.setOnPreparedListener(OnPreparedListener { mp ->
            if (mp.isPlaying) {
                mp.pause()
            } else {
                mp.start()
            }
        })

        video.setOnCompletionListener(MediaPlayer.OnCompletionListener { mp ->
            if (mp.isPlaying) mp.pause()
            else  mp.start()
        })
    }
}