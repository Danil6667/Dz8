package com.danil.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danil.myapplication.databinding.ItemNameBinding

class RecyclerAdapter(onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(), View.OnClickListener {

    private var list: MutableList<RecyclerModel>? = null
    private val onItemClickListener: OnItemClickListener

    fun setData(listCharacters: MutableList<RecyclerModel>?) {
        this.list = listCharacters
        notifyDataSetChanged()
    }

    fun setData2(model: RecyclerModel) {
        list?.add(model)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(list!![position])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun onClick(view: View) {
        onItemClickListener.onClick(view.tag as RecyclerModel)
    }

    class ViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {



        fun onBind(characters: RecyclerModel) {

                Glide.with(binding.ivImage.context).load(characters.imageUrl).into(binding.ivImage)
            binding.tvName.text = characters.name
            binding.tvAge.text = characters.age.toString()
            binding.tvFamily.text = characters.family
            itemView.tag = characters
        }
    }
}