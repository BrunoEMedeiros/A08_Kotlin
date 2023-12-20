package com.example.a07ex07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.widget.Toast

// A classe MainActivity representa a tela principal da aplicação
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Encontra o RecyclerView no layout usando o ID 'rv'
        val recyclerView = findViewById<RecyclerView>(R.id.rv)

        // Configura o LinearLayoutManager para organizar os itens do RecyclerView em uma lista
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cria um ArrayList de produtos
        val productList = ArrayList<Produto>()

        // Adiciona dois primeiros produtos ao ArrayList
        productList.add(Produto(android.R.drawable.ic_menu_camera, "Máquina fotográfica", "R$ 100,00"))
        productList.add(Produto(android.R.drawable.ic_menu_call, "Telefone analógico", "R$ 12,00"))

        // Adiciona produtos fictícios ao ArrayList
        for (i in 3..99) {
            productList.add(Produto(android.R.drawable.ic_menu_edit, "Produto $i", "R$ $i,99"))
        }

        // Cria um adaptador personalizado (CustomAdapter) para o RecyclerView
        val adapter = CustomAdapter(productList)

        // Conecta o adaptador ao RecyclerView
        recyclerView.adapter = adapter

        // Chama a função 'exibirToast' para exibir um Toast de boas-vindas
        exibirToast(this, "Bem-vindo!")
    }
}

// Esta função é responsável por exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    // Cria um Toast com a mensagem fornecida e o exibe por um curto período
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}
