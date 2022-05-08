package com.example.gajang.view.fragment

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.ViewModelProvider
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.databinding.FragmentNearbyStoreBinding
import com.example.gajang.util.GajangApplication
import com.example.gajang.view.adapter.NearByAdapter
import com.example.gajang.viewmodel.MainViewModel
import android.widget.ArrayAdapter as ArrayAdapter

class NearbyStoreFragment : BaseFragment<FragmentNearbyStoreBinding>(R.layout.fragment_nearby_store) {

    private lateinit var viewModel : MainViewModel

    override fun FragmentNearbyStoreBinding.onCreateView() {
        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        viewModel.currentRemoteData.observe(viewLifecycleOwner){
            val nearByStoreAdapter = NearByAdapter(it)
            binding.nearbyChoiceRcv.adapter = nearByStoreAdapter
        }

    }

    override fun FragmentNearbyStoreBinding.onViewCreated() {
        var marketData = resources.getStringArray(R.array.living_array) //마켓들의 정보를 넣어놓기
        var marketImage = resources.getStringArray(R.array.item_image) //각 마켓들의 이미지 넣어놓기
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, marketData) //어뎁터와 연동
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //어뎁터 드롭다운
        nearbyChoiceItemSpinner.adapter = adapter //스피너와 연동

        nearbyChoiceItemSpinner.setSelection(GajangApplication.prefs.getString("LivingAreaIdx", "1").toInt()) //우선적으로 값 넣어놓기

        nearbyChoiceItemSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

}




