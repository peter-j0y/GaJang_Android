package com.example.gajang.view

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gajang.R
import com.example.gajang.databinding.FragmentSplashBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashFragment : Fragment() {
    private var binding : FragmentSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // user는 현재 로그인되어있는 유저를 저장
        val user = Firebase.auth.currentUser
        // 로그인 되어있는 유저가 없다는 것은 로그인을 한 적이 없는 것이므로 로그인 창으로 이동
        if(user==null){
            // Splash화면 1초 보여주고 로그인 화면으로 이동
            Handler(Looper.myLooper()!!).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }, 1000L)
        }
        // 로그인 되어있는 유저의 정보가 있다면
        else{
            // 홈화면으로 1초 뒤에 이동
            Handler(Looper.myLooper()!!).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_priceCompareFragment)
            }, 1000L)
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}