package com.example.gajang.view.fragment

import android.view.View
import android.widget.AdapterView
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.databinding.FragmentNearbyStoreBinding
import com.example.gajang.view.adapter.NearbyAdapter
import com.example.gajang.view.NearbyData
import android.widget.ArrayAdapter as ArrayAdapter

class NearbyStoreFragment : BaseFragment<FragmentNearbyStoreBinding>(R.layout.fragment_nearby_store) {

    val nearbyDatas = mutableListOf<NearbyData>()


    override fun FragmentNearbyStoreBinding.onCreateView() {

    }

    override fun FragmentNearbyStoreBinding.onViewCreated() {
        var marketData = resources.getStringArray(R.array.living_array) //마켓들의 정보를 넣어놓기
        var marketImage = resources.getStringArray(R.array.item_image) //각 마켓들의 이미지 넣어놓기
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, marketData) //어뎁터와 연동
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //어뎁터 드롭다운
        nearbyChoiceItemSpinner.adapter = adapter //스피너와 연동

        nearbyChoiceItemSpinner.setSelection(1) //우선적으로 값 넣어놓기

        nearbyChoiceItemSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        with(nearbyDatas){
            add(NearbyData("","고등어","국내산","1000원"))
            add(NearbyData("","고등어","국내산","2000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))
            add(NearbyData("","고등어","국내산","3000원"))

        }

        val adapter1 = NearbyAdapter()
        adapter1.datalist = nearbyDatas
        binding.nearbyChoiceRcv.adapter = adapter1



    }

}




