package com.example.gajang.repository

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gajang.data.model.ResponseNecessariesData
import com.example.gajang.data.remote.ServiceCreator
import com.example.gajang.viewmodel.MainViewModel
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GajangRepository {
    private var remoteLiveData: MutableLiveData<ArrayList<ResponseNecessariesData.Row>> = MutableLiveData()

    fun updateRemoteData(){
        val call: Call<ResponseNecessariesData> = ServiceCreator.gajangService
            .getData(1, 8)

        call.enqueue(object : Callback<ResponseNecessariesData> {
            override fun onResponse(
                call: Call<ResponseNecessariesData>,
                response: Response<ResponseNecessariesData>
            ) {
                if(response.isSuccessful){
                    remoteLiveData.value = response.body()?.ListNecessariesPricesService?.row
                    Log.d(TAG, "onResponse: repository ${remoteLiveData.value}")
                }

                else{
                    Log.d(ContentValues.TAG, "onResponse: 서버는 연결됐는데 데이터가 안옴")
                }
            }

            override fun onFailure(call: Call<ResponseNecessariesData>, t: Throwable) {
                Log.d(ContentValues.TAG, "onFailure: 서버 연결 실패")
            }

        })
    }

    fun getRemoteLiveData(): MutableLiveData<ArrayList<ResponseNecessariesData.Row>>{
        return this.remoteLiveData
    }
}