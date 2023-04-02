package com.klopoffaa.giphy_explorer_klopoff

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.Giphy
import com.giphy.sdk.ui.views.GiphyDialogFragment
import com.klopoffaa.giphy_explorer_klopoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GiphyDialogFragment.GifSelectionListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Giphy.configure(this, "QN1DQwWloW9phrQiUeqadWTfBjDoYK2E")

        binding.btnExplore.setOnClickListener {
            GiphyDialogFragment.newInstance().show(supportFragmentManager, "giphy_dialog")
        }
    }

    override fun didSearchTerm(term: String) {

    }

    override fun onDismissed(selectedContentType: GPHContentType) {

    }

    override fun onGifSelected(
        media: Media,
        searchTerm: String?,
        selectedContentType: GPHContentType
    ) {
        Intent(this, ViewActivity::class.java).also {
            it.putExtra("EXTRA_GIF", media)
            this.startActivity(it)
        }
    }
}