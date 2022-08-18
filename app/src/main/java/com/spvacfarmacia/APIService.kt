package com.spvacfarmacia

import com.spvacfarmacia.Modelos.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {

    //Login
    @FormUrlEncoded
    @POST("api/login")
    fun entrarLogin(
        @Field("email") correo : String,
        @Field("password") contrasenia : String
    ) : Call<LoginResponse>


}