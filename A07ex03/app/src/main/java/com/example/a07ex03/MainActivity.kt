package com.example.a07ex03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Context
import android.widget.Toast

// A classe MainActivity representa a tela principal da aplicação
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Inicializa os botões flutuantes
        val browserButton = findViewById<FloatingActionButton>(R.id.browserButton)
        val callButton = findViewById<FloatingActionButton>(R.id.callButton)
        val smsButton = findViewById<FloatingActionButton>(R.id.smsButton)
        val emailButton = findViewById<FloatingActionButton>(R.id.emailButton)

        // Define as ações dos botões
        browserButton.setOnClickListener {
            // Chama a função 'exibirToast' para exibir um Toast personalizado
            exibirToast(this, "Acessar Google!")

            // Inicia uma atividade para abrir o navegador com a URL do Google
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))
        }

        callButton.setOnClickListener {
            // Chama a função 'exibirToast' para exibir um Toast personalizado
            exibirToast(this, "Fazer uma ligacao!")

            // Inicia uma atividade para discar o número de telefone
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789")))
        }

        smsButton.setOnClickListener {
            // Chama a função 'exibirToast' para exibir um Toast personalizado
            exibirToast(this, "Mandar um SMS!")

            // Inicia uma atividade para enviar SMS ao número especificado
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("sms:123456789")))
        }

        emailButton.setOnClickListener {
            // Chama a função 'exibirToast' para exibir um Toast personalizado
            exibirToast(this, "Enviar um e-mail!")

            // Inicia uma atividade para enviar e-mail ao endereço especificado
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:example@example.com")))
        }
    }
}

// Esta função é responsável por exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    // Cria um Toast com a mensagem fornecida e o exibe por um curto período
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}

