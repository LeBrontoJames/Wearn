package com.reift.wearn.adapter

import android.net.IpSecManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.reift.wearn.LearnFragment
import com.reift.wearn.WatchFragment
import com.reift.wearn.data.Dummy
import com.reift.wearn.data.Learn
import com.reift.wearn.data.Watch

class WearnAdapter(
    fa: FragmentActivity
): FragmentStateAdapter(fa) {
    override fun getItemCount() = Dummy.listWearn.size

    override fun createFragment(position: Int): Fragment {
        return when(Dummy.listWearn[position]) {
            is Watch -> {
                val watchFragment = WatchFragment()
                val watchBundle = Bundle()
                watchBundle.putParcelable(BUNDLE_WATCH, Dummy.listWearn[position])
                watchFragment.arguments = watchBundle
                return watchFragment
            }
            else -> {
                val learnFragment = LearnFragment()
                val learnBundle = Bundle()
                learnBundle.putParcelable(BUNDLE_LEARN, Dummy.listWearn[position])
                learnFragment.arguments = learnBundle
                return learnFragment
            }
        }
    }

    companion object {
        const val BUNDLE_LEARN = "bundle_learn"
        const val BUNDLE_WATCH = "bundle_watch"
    }

}