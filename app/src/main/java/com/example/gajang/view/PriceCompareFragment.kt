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

                priceCompareItemName.text = priceCompareMarketSpinner.selectedItem.toString()
                var whatItem = priceCompareMarketSpinner.selectedItem.toString()
                if(whatItem == "고등어"){
                    priceCompareMarketImage.setImageResource(R.drawable.fish_icon)

                }
                else if(whatItem == "오징어"){
                    priceCompareMarketImage.setImageResource(R.drawable.squid)

                }
                else if(whatItem == "명태"){
                    priceCompareMarketImage.setImageResource(R.drawable.pollock)
                }
                else if(whatItem == "조기"){
                    priceCompareMarketImage.setImageResource(R.drawable.jogi)
                }
                else if(whatItem == "달걀"){
                    priceCompareMarketImage.setImageResource(R.drawable.eggs)
                }
                else if(whatItem == "닭고기"){
                    priceCompareMarketImage.setImageResource(R.drawable.chicken)
                }
                else if(whatItem == "돼지고기"){
                    priceCompareMarketImage.setImageResource(R.drawable.pig)
                }
                else if(whatItem == "쇠고기"){
                    priceCompareMarketImage.setImageResource(R.drawable.cow)
                }
                else if(whatItem == "애호박"){
                    priceCompareMarketImage.setImageResource(R.drawable.greenpumkin)
                }
                else if(whatItem == "오이"){
                    priceCompareMarketImage.setImageResource(R.drawable.cucumber)
                }
                else if(whatItem == "상추"){
                    priceCompareMarketImage.setImageResource(R.drawable.lettuce)
                }
                else if(whatItem == "양파"){
                    priceCompareMarketImage.setImageResource(R.drawable.onion)
                }
                else if(whatItem == "무"){
                    priceCompareMarketImage.setImageResource(R.drawable.radish)
                }
                else if(whatItem == "배추"){
                    priceCompareMarketImage.setImageResource(R.drawable.cabbage)
                }
                else if(whatItem == "배"){
                    priceCompareMarketImage.setImageResource(R.drawable.pear)
                }
                else{
                    priceCompareMarketImage.setImageResource(R.drawable.apple)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        with(priceCompareDatas){
            add(PriceCompareData("1000원", "롯데마트", "국내산", "송파구"))
            add(PriceCompareData("2000원", "시장", "해외산", "동작구"))
            add(PriceCompareData("3000원", "롯데백화점", "아세트산", "아이구"))
            add(PriceCompareData("4000원", "NC백화점", "백두산", "오졌구"))
            add(PriceCompareData("5000원", "롯데슈퍼", "아크샨", "화나구"))
            add(PriceCompareData("6000원", "신세계백화점", "탑리산", "어이없구"))
            add(PriceCompareData("7000원", "뉴코아아울렛", "염산", "변화구"))
            add(PriceCompareData("1000원", "하나로클럽", "드립ㅋㅋ", "어쩌라구"))
            add(PriceCompareData("19000원", "시장", "산산산", "쌌구"))
        }


        val adapter1 = PriceCompareAdapter()
        adapter1.datalist = priceCompareDatas
        binding.priceCompareRcv.adapter = adapter1
    }
}



//        val imageResourceId : Int = resources.getIdentifier("pig", "drawable", requireContext().packageName) //객체 ID얻는방법.
