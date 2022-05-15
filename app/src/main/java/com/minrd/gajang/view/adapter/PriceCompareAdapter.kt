package com.minrd.gajang.view.adapter

import android.content.ContentValues
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.minrd.gajang.R
import androidx.navigation.fragment.navArgs
import android.widget.ImageView
import androidx.databinding.adapters.ImageViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.FragmentNearybyStoreDetailShowBinding
import com.minrd.gajang.databinding.PriceCompareItemViewBinding


class PriceCompareAdapter(var dataList: ArrayList<ResponseNecessariesData>): RecyclerView.Adapter<PriceCompareAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: PriceCompareItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(myData: ResponseNecessariesData){
            binding.priceCompareItemData = myData
            if(myData.M_NAME!!.contains("롯데슈퍼")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.lottesuper)
            }
            else if(myData.M_NAME!!.contains("이마트")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.emart)
            }
            else if(myData.M_NAME!!.contains("홈플러스")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.homeplus)
            }
            else if(myData.M_NAME!!.contains("현대백화점")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.hyundaidepartmentstore)
            }
            else if(myData.M_NAME!!.contains("신세계백화점")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.sinsagae)
            }
            else if(myData.M_NAME!!.contains("롯데백화점")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.lottedepart)
            }
            else if(myData.M_NAME!!.contains("뉴코아")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.newcore)
            }
            else if(myData.M_NAME!!.contains("하나로")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.hanaro)
            }
            else if(myData.M_NAME!!.contains("NC")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.ncdepart)
            }
            else if(myData.M_NAME!!.contains("롯데마트")){
                binding.priceCompareItemViewImage.setImageResource(R.drawable.lottemart)
            }
            else{
                binding.priceCompareItemViewImage.setImageResource(R.drawable.market)
            }
        }
    }

    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding= PriceCompareItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size


    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])

    }


}