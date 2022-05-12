package com.minrd.gajang.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.minrd.gajang.R
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.NearbyMarketItemViewBinding
import com.minrd.gajang.view.fragment.NearbyStoreFragmentDirections

class NearByAdapter(var dataList: ArrayList<ResponseNecessariesData>): RecyclerView.Adapter<NearByAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: NearbyMarketItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(myData: ResponseNecessariesData){
            binding.nearByItemData = myData
            binding.nearbyStoreItemView.setOnClickListener {
                // 마트 하나를 자세히 보려고 눌렀을 때 마트 이름을 자세히 보기 뷰로 전달하고 자세히 보기 뷰로 이동함
                val action = NearbyStoreFragmentDirections.actionNearbyStoreFragmentToNearbyStoreDetailShowFragment(myData.M_NAME!!)
                it.findNavController().navigate(action)
            }
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=NearbyMarketItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int =dataList.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}