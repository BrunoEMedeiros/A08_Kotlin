package com.example.a07ex02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import android.content.Context
import android.widget.Toast

// A classe MainActivity representa a tela principal da aplicação
class MainActivity : AppCompatActivity() {

    // Este método é chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Encontra o elemento ConstraintLayout no layout usando o ID 'meuLayout'
        var meuLayout = findViewById<ConstraintLayout>(R.id.meuLayout)

        // Define um evento de clique para o layout (qualquer parte da tela)
        meuLayout.setOnClickListener { view ->
            // Encontra o elemento TextView no layout usando o ID 'textView'
            var rotulo = findViewById<TextView>(R.id.textView)

            // Mostra um Snackbar curto
            Snackbar.make(view, "Mensagem", Snackbar.LENGTH_SHORT).show()

            // Mostra um Snackbar longo
            Snackbar.make(view, "Mensagem", Snackbar.LENGTH_LONG).show()

            // Mostra um Snackbar com ação de fechar
            var s = Snackbar.make(view, rotulo.text, Snackbar.LENGTH_INDEFINITE)
            s.setAction("Fechar") { s.dismiss() }
            s.show()

            // Chama a função 'exibirToast' para exibir um Toast personalizado
            exibirToast(this, "Acertou miseravel")
        }
    }
}

// Esta função é responsável por exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    // Cria um Toast com a mensagem fornecida e o exibe por um curto período
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}