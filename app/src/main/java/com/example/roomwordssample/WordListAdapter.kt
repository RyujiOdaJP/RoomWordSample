package com.example.roomwordssample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(
    private val context: Context,
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context),
    private val words: List<Word?>
) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        WordViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false))

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val currentWord = words[position]
        holder.wordItemView.text = currentWord?.getWord() ?: "no word"
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }
}