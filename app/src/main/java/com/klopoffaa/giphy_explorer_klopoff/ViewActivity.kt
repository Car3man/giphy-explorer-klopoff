package com.klopoffaa.giphy_explorer_klopoff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.core.models.enums.RenditionType
import com.klopoffaa.giphy_explorer_klopoff.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gif = intent.getParcelableExtra<Media>("EXTRA_GIF")
        binding.gphMediaView.setMedia(gif, RenditionType.original)
    }
}