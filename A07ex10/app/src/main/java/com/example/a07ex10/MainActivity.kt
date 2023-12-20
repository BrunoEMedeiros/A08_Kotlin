package com.example.a07ex10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import android.content.Context
import android.widget.Toast

//Obs, o mapa ficou bugando de uma hora pra outra, nao sei porque

// A classe MainActivity representa a tela principal da aplicação e implementa a interface OnMapReadyCallback
class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    // Variável lateinit para armazenar a referência ao mapa do Google
    private lateinit var mMap: GoogleMap

    // Método chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade com base em 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Obtém a referência ao SupportMapFragment do layout
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        // Notifica o SupportMapFragment que a atividade implementa OnMapReadyCallback e aguarda o mapa ficar pronto
        mapFragment.getMapAsync(this)
    }

    // Callback chamado quando o mapa está pronto para uso
    override fun onMapReady(googleMap: GoogleMap) {
        // Atribui a referência do mapa para a variável local
        mMap = googleMap

        // Chama a função 'exibirToast' para exibir um Toast indicando que o mapa foi aberto
        exibirToast(this, "teste mapa")//
        //exibirToast(this, "teste mapa")
    }
}

// Função para exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    // Cria um Toast com a mensagem fornecida e o exibe por um curto período
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}


