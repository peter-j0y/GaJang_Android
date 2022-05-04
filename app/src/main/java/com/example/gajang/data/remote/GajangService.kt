package com.example.gajang.data.remote

import com.example.gajang.data.model.ResponseNecessariesData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GajangService {
    @GET("/6948546b4e746d64393379756a7850/json/ListNecessariesPricesService/{start_idx}/{end_idx}")
    fun getData(
        @Path("start_idx") start_idx : Int,
        @Path("end_idx") end_idx : Int
    ): Call<ResponseNecessariesData>
}