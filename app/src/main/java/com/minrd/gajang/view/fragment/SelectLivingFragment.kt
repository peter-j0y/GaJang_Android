package com.minrd.gajang.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.minrd.gajang.R
import com.minrd.gajang.databinding.FragmentSelectLivingBinding
import com.minrd.gajang.util.GajangApplication
import com.minrd.gajang.viewmodel.MainViewModel

class SelectLivingFragment : Fragment(){

    private var binding : FragmentSelectLivingBinding? = null
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectLivingBinding.inflate(inflater, container, false)

        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 거주지 선택 완료 버튼을 눌렀을 때 거주지가 저장되고 홈화면으로 이동
        binding?.spinnerSelectBtn?.setOnClickListener {
            selectLivingArea()
        }
    }

    private fun selectLivingArea(){
        val selectedLivingAreaIdx = binding?.spinnerLivingList?.selectedItemPosition
        val selectedLivingAreaString = binding?.spinnerLivingList?.selectedItem.toString()

        if (selectedLivingAreaIdx != null) {
            viewModel.updateLivingArea(selectedLivingAreaIdx)
            viewModel.updateLivingAreaString(selectedLivingAreaString)
        }
        GajangApplication.prefs.setString("LivingAreaIdx", selectedLivingAreaIdx.toString())
        GajangApplication.prefs.setString("LivingAreaString", selectedLivingAreaString)

        findNavController().navigate(R.id.action_selectLivingFragment_to_priceCompareFragment)
    }
}