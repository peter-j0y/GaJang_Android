package com.example.gajang.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gajang.data.model.ResponseNecessariesData
import com.example.gajang.data.remote.ServiceCreator
import com.example.gajang.repository.GajangRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private var gajangRepository : GajangRepository = GajangRepository()

    // 선택한 거주지를 저장하는 변수
    private val _currentLivingArea = MutableLiveData<String>("하남")
    val livingArea: LiveData<String> = _currentLivingArea

    // 현재 선택한 생필품을 저장하는 변수
    private val _currentSelectedNecessary = MutableLiveData<String>()
    val selectedNecessary: LiveData<String> = _currentSelectedNecessary

    // 서울시 공공데이터로부터 받은 데이터를 저장하는 변수
    private var _currentRemoteData = MutableLiveData<ArrayList<ResponseNecessariesData.Row>>()
    val currentRemoteData : MutableLiveData<ArrayList<ResponseNecessariesData.Row>> = _currentRemoteData

    fun updateCurrentRemoteData(){
        gajangRepository.updateRemoteData()
        _currentRemoteData.value = gajangRepository.getRemoteLiveData().value
    }
}