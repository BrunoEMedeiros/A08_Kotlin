package com.example.a07ex07

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// A classe CustomAdapter é responsável por adaptar os dados de Produto para uma exibição em um RecyclerView
class CustomAdapter(private val dataSet: ArrayList<Produto>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // A classe ViewHolder representa uma visualização individual dentro do RecyclerView
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Referências aos elementos dentro de cada item do RecyclerView
        val titulo = view.findViewById<TextView>(R.id.titulo)
        val valor = view.findViewById<TextView>(R.id.valor)
        val foto = view.findViewById<ImageView>(R.id.figura)
    }

    // Este método é chamado quando uma nova ViewHolder é criada
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Infla o layout 'text_row_item.xml' para criar uma nova ViewHolder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    // Este método é chamado para exibir dados na ViewHolder especificada
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Preenche os elementos da ViewHolder com os dados do produto na posição específica
        holder.titulo.text = dataSet[position].titulo
        holder.valor.text = dataSet[position].descricao
        holder.foto.setImageResource(dataSet[position].foto)
    }

    // Este método retorna o número total de itens no conjunto de dados
    override fun getItemCount(): Int {
        return dataSet.size
    }
}

