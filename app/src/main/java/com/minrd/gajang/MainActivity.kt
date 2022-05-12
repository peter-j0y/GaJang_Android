package com.minrd.gajang

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.minrd.gajang.data.model.ResponseNecessariesData
import com.minrd.gajang.databinding.ActivityMainBinding
import com.minrd.gajang.viewmodel.MainViewModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 네비게이션들을 담는 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment

        // 네비게이션 컨트롤러
        val navController = navHostFragment.navController

        // 바텀 네비게이션 뷰와 네비게이션을 묶어준다
        NavigationUI.setupWithNavController(binding.bottomNav, navController)

        // 바텀 네비게이션 뷰 출력하는 곳과 출력하지 않는 곳
        navController.addOnDestinationChangedListener{_, destination, _ ->
            if(destination.id == R.id.splashFragment || destination.id == R.id.loginFragment || destination.id == R.id.selectLivingFragment){
                binding.bottomNav.visibility = View.GONE
            }
            else{
                binding.bottomNav.visibility = View.VISIBLE
            }
        }

        this.run{
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(MainViewModel::class.java)
        }

        jsonParsing()
    }

    private fun jsonParsing(){
        val dataArray = mutableListOf<ResponseNecessariesData>()
        val jsonString = assets.open("necessaries_data.json").reader().readText()

        try{
            val data = JSONObject(jsonString)
            val jsonArray = data.optJSONArray("Data")
            var i = 0
            while(i < 1000){
                val jsonObject = jsonArray.getJSONObject(i)
                
                val m_gu_name = jsonObject.getString("m_gu_name")
                val m_type_code = jsonObject.getString("m_type_code")
                val a_name = jsonObject.getString("a_name")
                val a_price = jsonObject.getString("a_price")
                val p_seq = jsonObject.getString("p_seq")
                val m_type_name = jsonObject.getString("m_type_name")
                val a_unit = jsonObject.getString("a_unit")
                val m_gu_code = jsonObject.getString("m_gu_code")
                val add_col = jsonObject.getString("add_col")
                val m_name = jsonObject.getString("m_name")
                val p_date = jsonObject.getString("p_date")
                val p_year_month = jsonObject.getString("p_year_month")
                val a_seq = jsonObject.getString("a_seq")
                val m_seq = jsonObject.getString("m_seq")

                dataArray.add(ResponseNecessariesData(
                    add_col,
                    a_name,
                    a_price,
                    a_seq,
                    a_unit,
                    m_gu_code,
                    m_gu_name,
                    m_name,
                    m_seq,
                    m_type_code,
                    m_type_name,
                    p_date,
                    p_seq,
                    p_year_month
                ))
                //Log.d(TAG, "test: $dataArray $i")
                i++
            }
            Log.d(TAG, "result: $dataArray")
            viewModel.updateNecessariesData(dataArray as ArrayList<ResponseNecessariesData>)
            Log.d(TAG, "logging ${viewModel.currentNecessariesData.value}")
        }catch(e: JSONException){
            Log.d(TAG, "jsonParsing: $e")
            e.printStackTrace()
        }
    }
}