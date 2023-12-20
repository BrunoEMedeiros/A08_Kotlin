package com.example.a07ex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.content.Context
import android.widget.Toast
import com.bumptech.glide.request.RequestOptions

// A classe MainActivity representa a tela principal da aplicação
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base no arquivo 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Encontra o elemento ImageView no layout usando o ID 'imgFoto'
        var imageView = findViewById<ImageView>(R.id.imgFoto)

        // Utiliza a biblioteca Glide para carregar e exibir uma imagem a partir de uma URL
        Glide.with(this)
            .load("https://www.melhoresdestinos.com.br/wp-content/uploads/2014/06/paris-franc%CC%A7a.jpg")
            // Carrega a imagem da URL especificada
            .apply(
                RequestOptions()
                    .override(400, 400) // Define a largura e altura desejadas da imagem
            )
            .into(imageView) // Exibe a imagem no ImageView

        // O tamanho definido por .override() pode não ser aplicado se o layout XML estiver ocupando a tela toda
    }
}

