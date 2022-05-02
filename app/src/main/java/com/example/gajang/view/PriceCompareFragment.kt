package com.example.gajang.view

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.databinding.FragmentPriceCompareBinding

class PriceCompareFragment : BaseFragment<FragmentPriceCompareBinding>(R.layout.fragment_price_compare) {

    val priceCompareDatas = mutableListOf<PriceCompareData>()

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

        with(priceCompareDatas){
            add(PriceCompareData("1000원", "롯데마트", "국내산", "송파구"))
            add(PriceCompareData("2000원", "기가마트", "해외산", "동작구"))
            add(PriceCompareData("3000원", "런천미트", "아세트산", "아이구"))
            add(PriceCompareData("4000원", "천리마마트", "백두산", "오졌구"))
            add(PriceCompareData("5000원", "신세계", "아크샨", "화나구"))
            add(PriceCompareData("6000원", "롯데킹", "탑리산", "어이없구"))
            add(PriceCompareData("7000원", "꾸륵꾸륵", "염산", "변화구"))
            add(PriceCompareData("1000원", "하이마트", "드립ㅋㅋ", "어쩌라구"))
            add(PriceCompareData("19000원", "이마트", "산산산", "쌌구"))


        }

        val adapter1 = PriceCompareAdapter()
        adapter1.datalist = priceCompareDatas
        binding.priceCompareRcv.adapter = adapter1
    }
}