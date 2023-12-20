package com.example.a07ex09

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import android.content.Context
import android.widget.Toast

// A classe MainActivity representa a tela principal da aplicação
class MainActivity : AppCompatActivity() {

    // Declarando as variáveis lateinit para armazenar o botão e a imagem
    lateinit var btnCapturar: Button
    lateinit var imgFoto: ImageView

    // Objeto de registro do evento de tirar foto
    val register = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { image: Bitmap? ->  // 'image' pode ser nulo, por isso 'Bitmap?' é usado.
        image?.let { bitmap ->
            // Define o Bitmap capturado no ImageView
            imgFoto.setImageBitmap(bitmap)

            // Cria um objeto InputImage a partir do Bitmap
            val inputImage = InputImage.fromBitmap(bitmap, 0)

            // Processa o código de barras na imagem usando a API de leitura de código de barras
            val result = BarcodeScanning.getClient().process(inputImage)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        // Obtém o tipo de valor do código de barras
                        val valueType = barcode.valueType
                        when (valueType) {
                            Barcode.TYPE_URL -> {
                                barcode.url?.let { url ->
                                    // Se o valor do código de barras for uma URL, exibe no TextView
                                    findViewById<TextView>(R.id.txtResultado).text = url.url
                                } ?: run {
                                    // Trate o caso onde url é nulo.
                                    findViewById<TextView>(R.id.txtResultado).text =
                                        "URL não encontrado no QR Code."
                                }
                            }
                            // Adicione mais casos aqui para outros tipos de dados de código de barras.
                        }
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("=====", e.printStackTrace().toString())
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa as variáveis com os elementos do layout
        btnCapturar = findViewById(R.id.btnCapturar)
        imgFoto = findViewById(R.id.imgFoto)
    }

    // Evento associado ao clique do botão de captura de foto
    fun capturarFoto(view: View) {
        // Chama a função 'exibirToast' para exibir um Toast
        exibirToast(this, "Foto tirada")
        // Dispara o evento registrado para captura de imagem
        register.launch(null)
    }
}

// Função para exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}
