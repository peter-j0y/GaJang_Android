package com.minrd.gajang.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.minrd.gajang.R
import com.minrd.gajang.databinding.FragmentChangeLivingBinding
import com.minrd.gajang.util.GajangApplication
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
        binding?.changeLivingText?.text = getString(R.string.change_living_comment).format(GajangApplication.prefs.getString("LivingAreaString", "null"))
        binding?.changeLivingSpinner?.setSelection(GajangApplication.prefs.getString("LivingAreaIdx", "null").toInt())
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 거주지 선택 완료 버튼을 눌렀을 때 거주지가 저장되고 홈화면으로 이동
        binding?.changeLivingBtn?.setOnClickListener {
            selectLivingArea()
        }
    }

    private fun selectLivingArea(){
        val changeLivingAreaIdx = binding?.changeLivingSpinner?.selectedItemPosition
        val changeLivingAreaString = binding?.changeLivingSpinner?.selectedItem.toString()

        if (changeLivingAreaIdx != null) {
            viewModel.updateLivingArea(changeLivingAreaIdx)
            viewModel.updateLivingAreaString(changeLivingAreaString)
        }
        binding?.changeLivingText?.text = getString(R.string.change_living_comment).format(viewModel.livingAreaString.value)
        GajangApplication.prefs.setString("LivingAreaIdx", changeLivingAreaIdx.toString())
        GajangApplication.prefs.setString("LivingAreaString", changeLivingAreaString)
    }

}