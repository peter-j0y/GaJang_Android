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
        var keyOfMarketName : String = "emart"
        if(args.marketName.contains("이마트")) {
            keyOfMarketName = "emart"
        }
        else if(args.marketName.contains("롯데마트")){
            keyOfMarketName = "lottemart"
        }
        else if(args.marketName.contains("홈플러스")){
            keyOfMarketName = "homeplus"
        }
        else if(args.marketName.contains("현대백화점")){
            keyOfMarketName = "hyundaidepartmentstore"
        }
        else if(args.marketName.contains("롯데백화점")){
            keyOfMarketName = "lottedepart"
        }
        else if(args.marketName.contains("신세계백화점")){
            keyOfMarketName = "sinsagae"
        }
        else if(args.marketName.contains("뉴코아")){
            keyOfMarketName = "newcore"
        }
        else if(args.marketName.contains("하나로")){
            keyOfMarketName = "hanaro"
        }
        else if(args.marketName.contains("NC")){
            keyOfMarketName = "ncdepart"
        }
        else if(args.marketName.contains("롯데슈퍼")){
            keyOfMarketName = "lottesuper"
        }
        else{
            keyOfMarketName = "market"
        }

        val imageResourceId: Int = resources.getIdentifier(keyOfMarketName, "drawable",requireContext().packageName)
        nearbyDetailShowImg.setImageResource(imageResourceId)
//        nearby_detail_show_img
    }

    override fun FragmentNearybyStoreDetailShowBinding.onViewCreated(){

    }
}
