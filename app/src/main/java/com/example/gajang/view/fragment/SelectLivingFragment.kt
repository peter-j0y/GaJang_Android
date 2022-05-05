package com.example.gajang.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gajang.databinding.FragmentSelectLivingBinding

class SelectLivingFragment : Fragment(){
    private var binding : FragmentSelectLivingBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectLivingBinding.inflate(inflater, container, false)
        return binding?.root
    }
}