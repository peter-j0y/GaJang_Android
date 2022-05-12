package com.minrd.gajang.view.fragment

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.minrd.gajang.R
import com.minrd.gajang.base.BaseFragment
import com.minrd.gajang.databinding.FragmentPriceCompareBinding
import com.minrd.gajang.view.adapter.NearByAdapter
import com.minrd.gajang.view.adapter.PriceCompareAdapter
import com.minrd.gajang.viewmodel.MainViewModel

class PriceCompareFragment : BaseFragment<FragmentPriceCompareBinding>(R.layout.fragment_price_compare) {

    private lateinit var viewModel : MainViewModel

    override fun FragmentPriceCompareBinding.onCreateView(){
        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }
        setRecyclerViewAdapter()
    }

    override fun FragmentPriceCompareBinding.onViewCreated() {
        setNecessarySpinner()
    }

    private fun setRecyclerViewAdapter(){
        val priceCompareAdapter = PriceCompareAdapter(viewModel.currentNecessariesData.value!!)
        binding.priceCompareRcv.adapter = priceCompareAdapter
    }

    private fun setNecessarySpinner(){
        val necessariesItemData = resources.getStringArray(R.array.item_array)
        val priceCompareAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, necessariesItemData)
        val priceCompareSpinner = binding.priceCompareMarketSpinner
        val priceCompareMarketImage = binding.priceCompareMarketImage

        priceCompareAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        priceCompareSpinner.adapter = priceCompareAdapter

        priceCompareSpinner.setSelection(viewModel.selectedNecessary.value!!)
        priceCompareSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                binding.priceCompareItemName.text = priceCompareSpinner.selectedItem.toString()
                var whatItem = priceCompareSpinner.selectedItem.toString()
                if(p2 == 0){
                    priceCompareMarketImage.setImageResource(com.minrd.gajang.R.drawable.fish)
                }
                else if(p2 == 1){
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