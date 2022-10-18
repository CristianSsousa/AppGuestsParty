package com.example.convidados.view.viewholder

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel
import com.example.convidados.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding,private val listener: OnGuestListener) : RecyclerView.ViewHolder(bind.root) {


    // ligação do elemento de interface com as informações
    fun bind (guest: GuestModel){
        bind.textName.text =  guest.name



        bind.textName.setOnClickListener{
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener(View.OnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover? ")
                    // Tem tres tipo de buttons, positive, negative, neutral
                    // which seria qual botao foi clicado
                .setPositiveButton("SIM") { dialog, which -> listener.onDelete(guest.id) }
                .setNegativeButton("NÃO", null)
                .create()
                .show()

            true
        })
    }
}