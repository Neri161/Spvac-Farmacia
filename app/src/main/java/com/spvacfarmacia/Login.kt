package com.spvacfarmacia

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.spvacfarmacia.Modelos.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val btnIniciaSesion: Button = findViewById(R.id.btn_login)

        btnIniciaSesion.setOnClickListener {

            val inCorreo: EditText = findViewById(R.id.correo_in);
            val inContrasenia: EditText = findViewById(R.id.contrasenia_in);

            if(inCorreo.text.isNotEmpty() && inContrasenia.text.isNotEmpty()){
                iniciarSesion(inCorreo.text.toString(), inContrasenia.text.toString())
            }else{
                if(inCorreo.text.isEmpty()) inCorreo.error = "Necesita colocar un correo"
                if(inContrasenia.text.isEmpty()) inContrasenia.error = "Necesita colocar una contraseña"
            }
        }
    }

    private fun iniciarSesion(correo : String, contrasenia : String) {
        RetrofitClient.instance.entrarLogin(correo, contrasenia)
            .enqueue(object: Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val res = response.body();
                    if(response.code() == 400){
                        Toast.makeText(applicationContext, res?.error.toString(), Toast.LENGTH_LONG).show();
                    }else if(response.code() == 500){
                        Toast.makeText(applicationContext, res?.error.toString(), Toast.LENGTH_LONG).show()
                    }else{
                        //Response 200
                        val res = response.body();
                        Toast.makeText(applicationContext, "Sesion iniciada", Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext, res?.token.toString(), Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()
                }
            })
    }

}