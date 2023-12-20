package com.example.a07ex01

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import android.content.Context
import android.widget.Toast


//Obs: ultilizamos o toast em quase tudo no projeto do thiago, e como estava fresco
//na cabeça, acabei adotando tambem

// A classe MainActivity representa a tela principal do app
class MainActivity : AppCompatActivity() {

    // Este método é chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Encontra o elemento TextView no layout usando o ID 'textView'
        val textView = findViewById<TextView>(R.id.textView)

        // Define um listener de clique para o TextView
        textView.setOnClickListener {
            // Cria um Snackbar que exibe o texto do TextView por um período longo
            val snackBar = Snackbar.make(it, textView.text, Snackbar.LENGTH_LONG)
            snackBar.show()

            // Chama a função 'exibirToast' para exibir um Toast personalizado
            exibirToast(this, "Clicou no botão")
        }
    }
}

// Esta função é responsável por exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}
