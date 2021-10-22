package com.example.rickandmortyapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.entities.SingleCharacter
import com.example.rickandmortyapi.view.ViewHolder

class ApiAdapter (private val characters: List<SingleCharacter>):PagingDataAdapter<SingleCharacter, ViewHolder>(
    diffCall
) {

    companion object{
        val diffCall = object:DiffUtil.ItemCallback<SingleCharacter>(){
            override fun areItemsTheSame(oldItem : SingleCharacter , newItem : SingleCharacter) : Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem : SingleCharacter, newItem : SingleCharacter) : Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_char, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = characters[position]
        return  holder.bind(cat)
    }

    override fun getItemCount(): Int = characters.size

}