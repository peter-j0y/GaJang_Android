package com.minrd.gajang.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.minrd.gajang.databinding.FragmentChangeLivingBinding
import com.minrd.gajang.databinding.FragmentSelectLivingBinding
import com.minrd.gajang.viewmodel.MainViewModel


class ChangeLivingFragment : Fragment(){
    private var binding : FragmentChangeLivingBinding? = null
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeLivingBinding.inflate(inflater, container, false)

        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        return binding?.root
    }
}