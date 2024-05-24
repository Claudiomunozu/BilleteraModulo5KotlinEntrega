package com.example.billeteramodulo4.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billeteramodulo4.databinding.ItemContactsBinding
import com.example.billeteramodulo4.model.Contactos

class ContactsAdapter(private val contactsList: List<Contactos>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {

        val binding =
            ItemContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contactositem: Contactos = contactsList[position]
        holder.bind(contactositem)
    }

    override fun getItemCount(): Int = contactsList.size


    inner class ContactsViewHolder(private val binding: ItemContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contactos: Contactos) {

            binding.ivfotoContacts.setImageResource(contactos.photo)
            binding.tvnombreContacts.text = contactos.name
            binding.tvdateTransaction.text = contactos.date
            binding.tvvalueTransaction.text = contactos.import
        }
    }
}
