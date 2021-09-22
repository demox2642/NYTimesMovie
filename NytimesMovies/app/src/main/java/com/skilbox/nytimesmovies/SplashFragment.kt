package com.skilbox.nytimesmovies

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.fragment.findNavController
import com.skilbox.nytimesmovies.databinding.FragmentSplashBinding
import com.skilbox.nytimesmovies.plugins.ViewBindingFragment

class SplashFragment : ViewBindingFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Handler().postDelayed(
            Runnable {
                findNavController().navigate(R.id.action_splashFragment_to_movieListFragment)
            },
            3000
        )
    }
}
