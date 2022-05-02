package com.example.gajang.view

import android.view.View
import android.widget.AdapterView
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.databinding.FragmentNearbyStoreBinding
import android.widget.ArrayAdapter as ArrayAdapter

class NearbyStoreFragment : BaseFragment<FragmentNearbyStoreBinding>(R.layout.fragment_nearby_store) {
    override fun FragmentNearbyStoreBinding.onCreateView() {

    }

    override fun FragmentNearbyStoreBinding.onViewCreated() {
        var marketData = resources.getStringArray(R.array.living_array)
        var marketImage = resources.getStringArray(R.array.item_image)
        var adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, marketData)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nearbyChoiceItemSpinner.adapter = adapter

        nearbyChoiceItemSpinner.setSelection(1)

        nearbyChoiceItemSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

}


