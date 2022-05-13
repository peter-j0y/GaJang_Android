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

//                binding.priceCompareItemName.text = binding.priceCompareMarketSpinner.selectedItem.toString()
                binding.priceCompareItemName.text = binding.priceCompareMarketSpinner.selectedItem.toString()
                var whatItem = binding.priceCompareMarketSpinner.selectedItem.toString()
                val itemName: String = when(whatItem){
                    "고등어" -> "fish_icon"
                    "오징어" -> "squid"
                    "명태" -> "pollock"
                    "조기" -> "jogi"
                    "달걀" -> "eggs"
                    "닭고기" -> "chicken"
                    "돼지고기" -> "pig"
                    "쇠고기" -> "cow"
                    "애호박" -> "greenpumkin"
                    "오이" -> "cucumber"
                    "상추" -> "lettuce"
                    "양파" -> "onion"
                    "무" -> "radish"
                    "배추" -> "cabbage"
                    "배" -> "pear"
                    else -> "apple" //사과에 대응함
                }
                val imageResourceId: Int = resources.getIdentifier(itemName, "drawable",requireContext().packageName)
                priceCompareMarketImage.setImageResource(imageResourceId)

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}