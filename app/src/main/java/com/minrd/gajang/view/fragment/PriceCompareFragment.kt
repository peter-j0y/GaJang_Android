package com.minrd.gajang.view.fragment

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.minrd.gajang.R
import com.minrd.gajang.base.BaseFragment
import com.minrd.gajang.databinding.FragmentPriceCompareBinding
import com.minrd.gajang.view.adapter.PriceCompareAdapter
import com.minrd.gajang.viewmodel.MainViewModel

class PriceCompareFragment : BaseFragment<FragmentPriceCompareBinding>(R.layout.fragment_price_compare) {

    private lateinit var viewModel : MainViewModel

    override fun FragmentPriceCompareBinding.onCreateView(){
        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        viewModel.updateRemoteData()

        viewModel.currentRemoteData.observe(viewLifecycleOwner) {
            val priceCompareAdapter = PriceCompareAdapter(it)
            binding.priceCompareRcv.adapter = priceCompareAdapter
        }
    }

    override fun FragmentPriceCompareBinding.onViewCreated(){


        var itemData = resources.getStringArray(R.array.item_array)
        var adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, itemData)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        priceCompareMarketSpinner.adapter = adapter

        priceCompareMarketSpinner.setSelection(1)
        priceCompareMarketSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                priceCompareItemName.text = priceCompareMarketSpinner.selectedItem.toString()
                var whatItem = priceCompareMarketSpinner.selectedItem.toString()
                if(whatItem == "고등어"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.fish)
                }
                else if(whatItem == "오징어"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.squid)
                }
                else if(whatItem == "명태"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.pollock)
                }
                else if(whatItem == "조기"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.jogi)
                }
                else if(whatItem == "달걀"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.eggs)
                }
                else if(whatItem == "닭고기"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.chicken)
                }
                else if(whatItem == "돼지고기"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.pig)
                }
                else if(whatItem == "쇠고기"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.cow)
                }
                else if(whatItem == "애호박"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.greenpumkin)
                }
                else if(whatItem == "오이"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.cucumber)
                }
                else if(whatItem == "상추"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.lettuce)
                }
                else if(whatItem == "양파"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.onion)
                }
                else if(whatItem == "무"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.radish)
                }
                else if(whatItem == "배추"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.cabbage)
                }
                else if(whatItem == "배"){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.pear)
                }
                else{
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.apple)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}