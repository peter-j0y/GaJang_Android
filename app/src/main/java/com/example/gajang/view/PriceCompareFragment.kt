package com.example.gajang.view

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.databinding.FragmentPriceCompareBinding

class PriceCompareFragment : BaseFragment<FragmentPriceCompareBinding>(R.layout.fragment_price_compare) {
    override fun FragmentPriceCompareBinding.onCreateView(){

    }

    override fun FragmentPriceCompareBinding.onViewCreated(){
        var itemData = resources.getStringArray(R.array.item_array)
        var itemImage = resources.getStringArray(R.array.item_image)
        var adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, itemData)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceCompareMarketSpinner.adapter = adapter

        priceCompareMarketSpinner.setSelection(1)

        priceCompareMarketSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}