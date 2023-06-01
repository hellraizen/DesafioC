package com.dleite.carrefourdev.src.presentation.view.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dleite.carrefourdev.databinding.ListItemBinding
import com.dleite.carrefourdev.src.presentation.model.UserListViewData

class UserAdapter(
    private val userList: List<UserListViewData>,
    private val onItemClickListener: (user: UserListViewData) -> Unit
) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        if (user.imgUrl.isNotEmpty()) {
            holder.binding.apply {
                Glide.with(picture).load(user.imgUrl).into(picture)
                name.text = user.name
                this.root.setOnClickListener { onItemClickListener.invoke(user) }
            }
        }
    }

    override fun getItemCount(): Int = userList.size
}