package com.example.gajang.view.fragment

import android.content.Intent
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.gajang.R
import com.example.gajang.base.BaseFragment
import com.example.gajang.databinding.FragmentLoginBinding
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
        private lateinit var client: GoogleSignInClient
        private lateinit var auth: FirebaseAuth
        private var callbackManager: CallbackManager? = null

        override fun FragmentLoginBinding.onCreateView(){
                callbackManager = CallbackManager.Factory.create()
        }

        override fun FragmentLoginBinding.onViewCreated(){
                setGoogleLogin()
                // 페이스북 로그인 버튼 누르면 페이스북 로그인 실행
                binding.facebookLoginButton.setOnClickListener{
                        facebookLogin()
                }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                callbackManager?.onActivityResult(requestCode, resultCode, data)
                // onActivityResult가 Deprecated되어서 다른 방법을 찾아야 함
                super.onActivityResult(requestCode, resultCode, data)
                if (requestCode == 1) {
                        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                        var account: GoogleSignInAccount? = null
                        try {
                                account = task.getResult(ApiException::class.java)
                                firebaseAuthWithGoogle(account!!.idToken)
                        } catch (e: ApiException) {
                                Toast.makeText(requireActivity(), "Failed Google Login", Toast.LENGTH_SHORT).show()
                        }
                }
        }

        fun setGoogleLogin(){
                // 요청 정보 옵션
                val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.web_client_id))
                        .requestEmail().build()
                client = GoogleSignIn.getClient(requireActivity(), options)

                binding.googleLoginButton.setOnClickListener {
                        // 로그인 요청
                        startActivityForResult(client.signInIntent, 1)
                }
        }

        private fun firebaseAuthWithGoogle(idToken: String?) {
                auth = Firebase.auth
                val credential = GoogleAuthProvider.getCredential(idToken, null)
                auth.signInWithCredential(credential)
                        .addOnCompleteListener(requireActivity()
                        ) { task ->
                                if (task.isSuccessful) {
                                        // 인증에 성공하면 홈화면으로 이동
                                        findNavController().navigate(R.id.action_loginFragment_to_priceCompareFragment)
                                }
                        }
        }

        private fun facebookLogin() {
                LoginManager.getInstance()
                        .logInWithReadPermissions(this, listOf("email", "public_profile"))

                LoginManager.getInstance()
                        .registerCallback(callbackManager, object:FacebookCallback<LoginResult>{
                                override fun onSuccess(result: LoginResult) {
                                        // facebook 계정 정보를 firebase 서버에게 전달(로그인)
                                        val accessToken = result.accessToken
                                        firebaseAuthWithFacebook(result.accessToken)
                                }

                                override fun onCancel() {
                                        //취소가 된 경우 할일
                                }

                                override fun onError(error: FacebookException) {
                                        //에러가 난 경우 할일
                                }
                        })
        }

        private fun firebaseAuthWithFacebook(accessToken: AccessToken?) {
                auth = Firebase.auth
                // AccessToken 으로 Facebook 인증
                val credential = FacebookAuthProvider.getCredential(accessToken?.token!!)

                // 성공 시 Firebase 에 유저 정보 보내기 (로그인)
                auth.signInWithCredential(credential)
                    .addOnCompleteListener{ task ->
                            if(task.isSuccessful){ // 정상적으로 email, password 가 전달된 경우
                                    // 로그인 처리
                                    findNavController().navigate(R.id.action_loginFragment_to_priceCompareFragment)
                            } else {
                                    // 예외 발생 시 메시지 출력
                                    Toast.makeText(requireContext(), task.exception?.message, Toast.LENGTH_LONG).show()
                            }
                    }
        }
}