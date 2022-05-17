package com.minrd.gajang.view.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.minrd.gajang.R
import com.minrd.gajang.base.BaseFragment
import com.minrd.gajang.databinding.FragmentNearybyStoreDetailShowBinding
import com.minrd.gajang.viewmodel.MainViewModel

class NearbyStoreDetailShowFragment : BaseFragment<FragmentNearybyStoreDetailShowBinding>(R.layout.fragment_nearyby_store_detail_show) {

    private lateinit var viewModel : MainViewModel

    override fun FragmentNearybyStoreDetailShowBinding.onCreateView(){
        val args: NearbyStoreDetailShowFragmentArgs by navArgs()

        activity?.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        viewModel.updateSelectedMarket(args.marketName)
        binding.nearbyDetailMarketNameTextView.text = args.marketName

        //디테일 뷰의 마트사진 변경
        var marketName = args.marketName
        var selectedMarketName = changeMartPhoto(marketName)
        val imageResourceId: Int = resources.getIdentifier(selectedMarketName, "drawable",requireContext().packageName)
        nearbyDetailShowImg.setImageResource(imageResourceId)
//        nearby_detail_show_img
    }

    override fun FragmentNearybyStoreDetailShowBinding.onViewCreated(){

    }

    private fun changeMartPhoto(marketName:String):String{
        var keyOfMarketName : String = "emart"
        if(marketName.contains("이마트")) {
            keyOfMarketName = "emart"
        }
        else if(marketName.contains("롯데마트")){
            keyOfMarketName = "lottemart"
        }
        else if(marketName.contains("홈플러스")){
            keyOfMarketName = "homeplus"
        }
        else if(marketName.contains("현대백화점")){
            keyOfMarketName = "hyundaidepartmentstore"
        }
        else if(marketName.contains("롯데백화점")){
            keyOfMarketName = "lottedepart"
        }
        else if(marketName.contains("신세계백화점")){
            keyOfMarketName = "sinsagae"
        }
        else if(marketName.contains("뉴코아")){
            keyOfMarketName = "newcore"
        }
        else if(marketName.contains("하나로")){
            keyOfMarketName = "hanaro"
        }
        else if(marketName.contains("NC")){
            keyOfMarketName = "ncdepart"
        }
        else if(marketName.contains("롯데슈퍼")){
            keyOfMarketName = "lottesuper"
        }
        else{
            keyOfMarketName = "market"
        }
        return keyOfMarketName
    }
}