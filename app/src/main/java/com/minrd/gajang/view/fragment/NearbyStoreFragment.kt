package com.minrd.gajang.view.fragment

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.minrd.gajang.R
import com.minrd.gajang.base.BaseFragment
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.FragmentNearbyStoreBinding
import com.minrd.gajang.util.GajangApplication
import com.minrd.gajang.view.adapter.NearByAdapter
import com.minrd.gajang.view.adapter.PriceCompareAdapter
import com.minrd.gajang.viewmodel.MainViewModel

class NearbyStoreFragment : BaseFragment<FragmentNearbyStoreBinding>(R.layout.fragment_nearby_store) {

    private lateinit var viewModel : MainViewModel

    override fun FragmentNearbyStoreBinding.onCreateView() {
        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        setRecyclerViewAdapter()
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
                val sub : ArrayList<ResponseNecessariesData> = viewModel.currentNecessariesData.value!!
                val dataList: MutableList<ResponseNecessariesData> = ArrayList()
                val check : MutableList<String> = ArrayList()

                sub.forEach{
                    val name = it.M_GU_NAME
                    if (name != null) {
                        if(name.contains(nearbyChoiceItemSpinner.selectedItem.toString())){
                            var checking = 0
                            if (it.M_NAME in check){
                                checking = 1
                            }
                            if(checking == 0) {
                                check.add(it.M_NAME!!)
                                dataList.add(it)
                            }
                        }
                    }

                }
                val nearByAdapter = NearByAdapter(dataList)
                binding.nearbyChoiceRcv.adapter = nearByAdapter
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun setRecyclerViewAdapter(){
        val nearByAdapter = NearByAdapter(viewModel.currentNecessariesData.value!!)
        binding.nearbyChoiceRcv.adapter = nearByAdapter
    }
}




