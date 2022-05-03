package com.example.gajang.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gajang.databinding.NearbyItemviewBinding
import com.example.gajang.databinding.PriceCompareItemviewBinding

class PriceCompareAdapter: RecyclerView.Adapter<PriceCompareAdapter.MyViewHolder>() {

    var datalist = mutableListOf<PriceCompareData>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity등에서 datalist에 실제 데이터 추가

    inner class MyViewHolder(private val binding: PriceCompareItemviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(myData:PriceCompareData){
            //binding.dogPhotoImg.=dogData.dog_img
            binding.priceCompareItemPrice.text=myData.price
            binding.priceCompareItemOrigin.text = myData.origin
            binding.priceCompareItemArea.text = myData.living
            binding.priceCompareItemMarket.text = myData.market
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding= PriceCompareItemviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int =datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }


}