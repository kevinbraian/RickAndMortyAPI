package com.example.rickandmortyapi.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapi.databinding.ItemCharBinding
import com.example.rickandmortyapi.entities.SingleCharacter

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemCharBinding.bind(view)
    fun bind(character: SingleCharacter){
        binding.image.load(character.image)
        binding.textViewName.text = character.name
        binding.textViewSpecies.text = character.species
        binding.textViewStatus.text = character.status
        binding.textViewKnownLocation.text = character.location.name
        binding.textViewKnownOrigin.text = character.origin.name
    }
}