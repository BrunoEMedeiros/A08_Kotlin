package com.example.a07ex06

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.widget.Toast


//Obs - tentei fazer um alert ao clicar no recicler view
//esqueci de trocar o código de maquina e acabei perdendo// A classe MainActivity representa a tela principal da aplicação

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Chama a função 'exibirToast' para exibir um Toast informando que o Recycler está aberto
        //Colquei o toast apenas para ter alguma modificão pois perdi o codigo do alert nos itens do recicler view
        exibirToast(this, "Recycler aberto")

        // Cria um array de strings com 10 elementos
        //Meu android studio estava com um erro, apenas para testar coloquei
        // como 10 itens
        val strings = Array(10) { i -> "Item ${i + 1}" }

        // Configura um ArrayAdapter para exibir as strings em uma ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, strings)

        // Encontra a ListView no layout usando o ID 'listView'
        val listView = findViewById<ListView>(R.id.listView)

        // Conecta o adapter à ListView
        listView.adapter = adapter
    }
}

// Esta função é responsável por exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    // Cria um Toast com a mensagem fornecida e o exibe por um curto período
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}

