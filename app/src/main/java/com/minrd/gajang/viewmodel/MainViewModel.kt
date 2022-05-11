package com.minrd.gajang.viewmodel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.data.remote.ServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    // 선택한 거주지 인덱스를 저장하는 변수
    private val _currentLivingArea = MutableLiveData<Int>()
    val livingArea: LiveData<Int> = _currentLivingArea

    // 거주지 인덱스를 업데이트하는 함수
    fun updateLivingArea(input : Int){
        _currentLivingArea.value = input
    }

    // 현재 선택한 생필품 인덱스를 저장하는 변수
    private val _currentSelectedNecessary = MutableLiveData<Int>()
    val selectedNecessary: LiveData<Int> = _currentSelectedNecessary

    // 선택한 생필품 인덱스를 업데이트하는 함수
    fun updateNecessary(input : Int){
        _currentSelectedNecessary.value = input
    }

    // 서울시 공공데이터로부터 받은 데이터를 저장하는 변수
    private var _currentRemoteData = MutableLiveData<ArrayList<ResponseNecessariesData.Row>>()
    val currentRemoteData : LiveData<ArrayList<ResponseNecessariesData.Row>> = _currentRemoteData

    fun updateRemoteData() {
        val call: Call<ResponseNecessariesData> = ServiceCreator.gajangService
            .getData(1, 12)

        call.enqueue(object : Callback<ResponseNecessariesData> {
            override fun onResponse(
                call: Call<ResponseNecessariesData>,
                response: Response<ResponseNecessariesData>
            ) {
                if (response.isSuccessful) {
                    _currentRemoteData.value = response.body()?.ListNecessariesPricesService?.row!!
                    Log.d(TAG, "onResponse: repository ${_currentRemoteData.value}")
                } else {
                    Log.d(ContentValues.TAG, "onResponse: 서버는 연결됐는데 데이터가 안옴")
                }
            }

            override fun onFailure(call: Call<ResponseNecessariesData>, t: Throwable) {
                Log.d(ContentValues.TAG, "onFailure: 서버 연결 실패")
            }
        })
    }
}