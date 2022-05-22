package com.minrd.gajang.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.minrd.gajang.R
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.NearbyStoreDetailItemViewBinding
import com.minrd.gajang.view.fragment.NearbyStoreFragmentDirections

class NearByDetailAdapter(var dataList: MutableList<ResponseNecessariesData> = ArrayList()): RecyclerView.Adapter<NearByDetailAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: NearbyStoreDetailItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(myData: ResponseNecessariesData){
            binding.nearByDetailItemData = myData
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=
            NearbyStoreDetailItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int =dataList.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
        Log.d("연결 잘되냐", dataList[position].M_NAME.toString());
    }

}