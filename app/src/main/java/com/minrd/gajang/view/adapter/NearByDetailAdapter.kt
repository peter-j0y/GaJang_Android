package com.minrd.gajang.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.minrd.gajang.R
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.FragmentChangeLivingBinding
import com.minrd.gajang.databinding.FragmentSelectLivingBinding
import com.minrd.gajang.databinding.NearbyStoreDetailItemViewBinding
import com.minrd.gajang.view.fragment.NearbyStoreFragmentDirections

class NearByDetailAdapter(var dataList: MutableList<ResponseNecessariesData> = ArrayList()): RecyclerView.Adapter<NearByDetailAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: NearbyStoreDetailItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(myData: ResponseNecessariesData){
            binding.nearByDetailItemData = myData
            setOnItemImage(myData.A_NAME.toString())
        }

        private fun setOnItemImage(detailItemName:String){
            if(detailItemName.contains("고등어")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.fish_icon)
            }
            else if(detailItemName.contains("오징어")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.squid)
            }
            else if(detailItemName.contains("명태")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.pollock)
            }
            else if(detailItemName.contains("조기")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.jogi)
            }
            else if(detailItemName.contains("달걀")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.eggs)
            }
            else if(detailItemName.contains("닭")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.chicken)
            }
            else if(detailItemName.contains("돼지")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.pig)
            }
            else if(detailItemName.contains("쇠고기")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.cow)
            }
            else if(detailItemName.contains("호박")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.greenpumkin)
            }
            else if(detailItemName.contains("오이")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.cucumber)
            }
            else if(detailItemName.contains("상추")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.lettuce)
            }
            else if(detailItemName.contains("양파")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.onion)
            }
            else if(detailItemName.contains("무")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.radish)
            }
            else if(detailItemName.contains("배추")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.cabbage)
            }
            else if(detailItemName.contains("배")){
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.pear)
            }
            else{
                binding.nearbyStoreDetailImage.setImageResource(R.drawable.apple)
            }
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
        Log.d("연결 잘되냐", dataList[position].M_NAME.toString())
    }
}