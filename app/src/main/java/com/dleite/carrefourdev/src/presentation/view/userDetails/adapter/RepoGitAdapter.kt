package com.dleite.carrefourdev.src.presentation.view.userDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dleite.carrefourdev.databinding.ListItemRepositoryBinding
import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData

class RepoGitAdapter(private val repoGitList: List<RepoGitListViewData>) :
    RecyclerView.Adapter<RepoGitAdapter.RepoGitViewHolder>() {
    class RepoGitViewHolder(val binding: ListItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoGitViewHolder {
        val binding = ListItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepoGitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoGitViewHolder, position: Int) {
        val repoGit = repoGitList[position]
        holder.binding.apply {
            name.text = repoGit.name
        }

    }

    override fun getItemCount(): Int = repoGitList.size
}