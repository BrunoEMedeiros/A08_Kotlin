package com.example.a07ex04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import androidx.core.widget.NestedScrollView
import android.content.Context
import android.widget.Toast

// A classe MainActivity representa a tela principal da aplicação
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Chama a função 'exibirToast' para exibir um Toast de mensagem padrão
        exibirToast(this, "Acabaram as ideias, foi mal")
    }
}

// Esta função é responsável por exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    // Cria um Toast com a mensagem fornecida e o exibe por um curto período
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}
