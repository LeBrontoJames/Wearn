package com.reift.wearn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.reift.wearn.adapter.WearnAdapter
import com.reift.wearn.data.Dummy
import com.reift.wearn.data.Watch
import com.reift.wearn.databinding.FragmentWatchBinding

class WatchFragment : Fragment() {

    private lateinit var binding: FragmentWatchBinding

    private lateinit var watch: Watch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchBinding.inflate(layoutInflater)

        watch = arguments?.getParcelable(WearnAdapter.BUNDLE_WATCH) ?: Dummy.listWearn[0] as Watch

        setUpWatch()

        return binding.root
    }

    private fun setUpWatch() {
        binding.apply {
            tvCaption.text = watch.title
            tvCreator.text = watch.creator

            lifecycle.addObserver(ytPlayer)

            val listener = object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(watch.url, 0f)
                }
            }

            val option = IFramePlayerOptions.Builder()
                .controls(0)
                .ccLoadPolicy(3)
                .ivLoadPolicy(1)
                .build()

            ytPlayer.enableAutomaticInitialization = false
            ytPlayer.initialize(listener, option)

        }
    }

}