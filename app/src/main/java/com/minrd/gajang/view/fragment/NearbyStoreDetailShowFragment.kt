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
    }

    override fun FragmentNearybyStoreDetailShowBinding.onViewCreated(){

    }

    private fun setMarketRecyclerView(){

    }
}