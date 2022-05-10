package com.minrd.gajang.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minrd.gajang.databinding.FragmentPrivacyBinding

class PrivacyFragment : Fragment(){
    private var binding : FragmentPrivacyBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrivacyBinding.inflate(inflater, container, false)
        return binding?.root
    }
}