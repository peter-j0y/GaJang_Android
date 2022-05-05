package com.example.gajang.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gajang.databinding.NearbyItemViewBinding
import com.example.gajang.view.NearbyData

class NearbyAdapter: RecyclerView.Adapter<NearbyAdapter.MyViewHolder>() {

    var datalist = mutableListOf<NearbyData>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity등에서 datalist에 실제 데이터 추가

<<<<<<< HEAD:app/src/main/java/com/example/gajang/view/NearbyAdapter.kt
    inner class MyViewHolder(private val binding: NearbyItemviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(myData:NearbyData){
=======
    inner class MyViewHolder(private val binding: NearbyItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(myData: NearbyData){
>>>>>>> 20f2aff44f8580c6425ea3dd2a3a7f6e0ce5b8a7:app/src/main/java/com/example/gajang/view/adapter/NearbyAdapter.kt
            //binding.dogPhotoImg.=dogData.dog_img
            binding.nearbyItemName.text=myData.name
            binding.nearbyItemPrice.text = myData.price.toString()
            binding.nearbyItemOrigin.text = myData.origin
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
<<<<<<< HEAD:app/src/main/java/com/example/gajang/view/NearbyAdapter.kt
        val binding=NearbyItemviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

=======
        val binding=NearbyItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
>>>>>>> 20f2aff44f8580c6425ea3dd2a3a7f6e0ce5b8a7:app/src/main/java/com/example/gajang/view/adapter/NearbyAdapter.kt
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int =datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}