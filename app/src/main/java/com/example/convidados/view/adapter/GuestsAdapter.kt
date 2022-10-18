package com.example.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel
import com.example.convidados.view.listener.OnGuestListener
import com.example.convidados.view.viewholder.GuestViewHolder

// VH = View Holder
class GuestsAdapter: RecyclerView.Adapter<GuestViewHolder>(){

    private var guestList: List<GuestModel> = listOf()
    private lateinit var listener: OnGuestListener
    // onCreate Cria os layouts
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): GuestViewHolder{
        // Aqui estamos inflando o Row Guest para que ele apareça na tela quando a onCreate do adapter for chamada

        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return GuestViewHolder(item,listener)

        //Responsavel por criar as linhas dentro da tabela
    }
    // Faz a cola das informações
    override fun  onBindViewHolder(holder: GuestViewHolder, position: Int){

         holder.bind(guestList[position])
    }
    // Define o tamanho da listagem
    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updatedGuests(list: List<GuestModel>){
        guestList = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener: OnGuestListener){
        listener = guestListener
    }

}