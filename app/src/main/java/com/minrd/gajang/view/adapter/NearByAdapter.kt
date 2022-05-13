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
            if(myData.M_NAME!!.contains("롯데슈퍼")){
                binding.nearbyMarketImg.setImageResource(R.drawable.lottesuper)
            }
            else if(myData.M_NAME!!.contains("이마트")){
                binding.nearbyMarketImg.setImageResource(R.drawable.emart)
            }
            else if(myData.M_NAME!!.contains("홈플러스")){
                binding.nearbyMarketImg.setImageResource(R.drawable.homeplus)
            }
            else if(myData.M_NAME!!.contains("현대백화점")){
                binding.nearbyMarketImg.setImageResource(R.drawable.hyundaidepartmentstore)
            }
            else if(myData.M_NAME!!.contains("신세계백화점")){
                binding.nearbyMarketImg.setImageResource(R.drawable.sinsagae)
            }
            else if(myData.M_NAME!!.contains("롯데백화점")){
                binding.nearbyMarketImg.setImageResource(R.drawable.lottedepart)
            }
            else if(myData.M_NAME!!.contains("뉴코아")){
                binding.nearbyMarketImg.setImageResource(R.drawable.newcore)
            }
            else if(myData.M_NAME!!.contains("하나로")){
                binding.nearbyMarketImg.setImageResource(R.drawable.hanaro)
            }
            else if(myData.M_NAME!!.contains("NC")){
                binding.nearbyMarketImg.setImageResource(R.drawable.ncdepart)
            }
            else if(myData.M_NAME!!.contains("롯데마트")){
                binding.nearbyMarketImg.setImageResource(R.drawable.lottemart)
            }
            else{
                binding.nearbyMarketImg.setImageResource(R.drawable.market)
            }
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