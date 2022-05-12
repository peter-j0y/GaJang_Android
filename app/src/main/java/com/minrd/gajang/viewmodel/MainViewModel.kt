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

    // 선택한 거주지 문자열 저장하는 변수
    private val _currentLivingAreaString = MutableLiveData<String>()
    val livingAreaString: LiveData<String> = _currentLivingAreaString

    // 거주지 문자열을 업데이트하는 함수
    fun updateLivingAreaString(input : String){
        _currentLivingAreaString.value = input
    }

    // 현재 선택한 생필품 인덱스를 저장하는 변수
    private val _currentSelectedNecessary = MutableLiveData<Int>(0)
    val selectedNecessary: LiveData<Int> = _currentSelectedNecessary

    // 선택한 생필품 인덱스를 업데이트하는 함수
    fun updateNecessary(input : Int){
        _currentSelectedNecessary.value = input
    }

    // 자세히 보고 있는 마트에 관련된 데이터
    private val _currentSelectedMarket = MutableLiveData<String>()
    val selectedMarket: LiveData<String> = _currentSelectedMarket

    // 선택한 마트의 이름을 업데이트하는 함수
    fun updateSelectedMarket(input : String){
        _currentSelectedMarket.value = input
    }

    // 서울시 공공데이터로부터 받은 데이터를 저장하는 변수
    private var _currentNecessariesData = MutableLiveData<ArrayList<ResponseNecessariesData>>()
    val currentNecessariesData : LiveData<ArrayList<ResponseNecessariesData>> = _currentNecessariesData

    fun updateNecessariesData(input : ArrayList<ResponseNecessariesData>){
        _currentNecessariesData.value = input
    }
}