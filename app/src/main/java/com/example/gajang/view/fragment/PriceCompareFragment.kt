package com.example.gajang.view.fragment

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.data.model.ResponseNecessariesData
import com.example.gajang.data.remote.ServiceCreator
import com.example.gajang.databinding.FragmentPriceCompareBinding
import com.example.gajang.repository.GajangRepository
import com.example.gajang.view.adapter.PriceCompareAdapter
import com.example.gajang.view.PriceCompareData
import com.example.gajang.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PriceCompareFragment : BaseFragment<FragmentPriceCompareBinding>(R.layout.fragment_price_compare) {

    private lateinit var viewModel : MainViewModel
    private val priceCompareAdapter = PriceCompareAdapter()
    val priceCompareDatas = mutableListOf<PriceCompareData>()

    override fun FragmentPriceCompareBinding.onCreateView(){
        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        viewModel.updateCurrentRemoteData()

        binding.priceCompareRcv.adapter = priceCompareAdapter

        Log.d(TAG, "데이터 확인 ${viewModel.currentRemoteData.value}")
        if(viewModel.currentRemoteData.value!=null) {
            priceCompareAdapter.dataList = viewModel.currentRemoteData.value!!
            Log.d(TAG, "onViewCreated: 잘들어갔나 ${priceCompareAdapter.dataList}")
        }
        Log.d(TAG, "onViewCreated: ${viewModel.currentRemoteData.value}")
        priceCompareAdapter.notifyDataSetChanged()
    }

    override fun FragmentPriceCompareBinding.onViewCreated(){


        var itemData = resources.getStringArray(R.array.item_array)
        var itemImage = resources.getStringArray(R.array.item_image)
        var adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, itemData)





        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        priceCompareMarketSpinner.adapter = adapter

        priceCompareMarketSpinner.setSelection(1)
        priceCompareMarketSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                priceCompareItemName.text = priceCompareMarketSpinner.selectedItem.toString()
                var whatItem = priceCompareMarketSpinner.selectedItem.toString()
                if(whatItem == "고등어"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.fish)
                }
                else if(whatItem == "오징어"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.squid)
                }
                else if(whatItem == "명태"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.pollock)
                }
                else if(whatItem == "조기"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.jogi)
                }
                else if(whatItem == "달걀"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.eggs)
                }
                else if(whatItem == "닭고기"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.chicken)
                }
                else if(whatItem == "돼지고기"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.pig)
                }
                else if(whatItem == "쇠고기"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.cow)
                }
                else if(whatItem == "애호박"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.greenpumkin)
                }
                else if(whatItem == "오이"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.cucumber)
                }
                else if(whatItem == "상추"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.lettuce)
                }
                else if(whatItem == "양파"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.onion)
                }
                else if(whatItem == "무"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.radish)
                }
                else if(whatItem == "배추"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.cabbage)
                }
                else if(whatItem == "배"){
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.pear)
                }
                else{
                    priceCompareMarketImage.setImageResource(com.example.gajang.R.drawable.apple)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

//        with(priceCompareDatas){
//            add(PriceCompareData("1000원", "롯데마트", "국내산", "송파구"))
//            add(PriceCompareData("2000원", "기가마트", "해외산", "동작구"))
//            add(PriceCompareData("3000원", "런천미트", "아세트산", "아이구"))
//            add(PriceCompareData("4000원", "천리마마트", "백두산", "오졌구"))
//            add(PriceCompareData("5000원", "신세계", "아크샨", "화나구"))
//            add(PriceCompareData("6000원", "롯데킹", "탑리산", "어이없구"))
//            add(PriceCompareData("7000원", "꾸륵꾸륵", "염산", "변화구"))
//            add(PriceCompareData("1000원", "하이마트", "드립ㅋㅋ", "어쩌라구"))
//            add(PriceCompareData("19000원", "이마트", "산산산", "쌌구"))
//
//
//        }
    }
}