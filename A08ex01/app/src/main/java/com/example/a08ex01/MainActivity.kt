package com.example.a08ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.a08ex01.api.Endpoint
import com.example.a08ex01.models.User
import com.example.a08ex01.util.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val meuBotao: Button = findViewById(R.id.btnFind)
        val textField: EditText = findViewById(R.id.editText)

        meuBotao.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                // Lógica a ser executada quando o botão for clicado
                getUsers(textField.text.toString())
            }
        })
    }


    //Fiz algumas modificacoes nos slides
    //A modificacao do projeto é, a pessoa escreve o nome de um usuario do github e clica no botao para pesquisar
   fun getUsers(usuario: String){

       //Separei em um package e uma classe pra poder melhorar a organizacao do codigo
       val retrofitClient = NetworkUtils
           .getRetrofitInstance("https://api.github.com/")

       //Pra poder lançar a requisição com o nome de usuario digitado pela pessoa, ultilizo o
       //@GET com parametro path, que pode ser visto na classe Endpoint
       val endpoint = retrofitClient.create(Endpoint::class.java)
       val users = endpoint.getUsers(usuario).enqueue(object : Callback<User>{
           override fun onFailure(call: Call<User>, t: Throwable) {
               Log.d("TAG_", "Houve um erro!")
               t.printStackTrace()
           }

           //Segui o mesmo esquema mostrado no slide, apenas mudando para mostrar as informações do usuario
           //ou "usuario nao econtrado"
           override fun onResponse(call: Call<User>, response: Response<User>) {
               val dados = response.body()
               if(dados?.name == null){
                   findViewById<TextView>(R.id.txt).text = "Usuario nao encontrado!"
               }else {
                   var usuario = "${response.body()?.name}, ${response.body()?.company}, ${response.body()?.location}"
                   findViewById<TextView>(R.id.txt).text = usuario
               }
           }
       })
   }
}