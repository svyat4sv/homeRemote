package com.example.homeremote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homeremote.databinding.CustomLayoutBinding

class MoviesAdapter: PagingDataAdapter<Movie, MoviesAdapter.MoviesViewholder>(MyUtil()) {

    class MoviesViewholder(private val binding: CustomLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            item.let{
                binding.ogTitle.text = it.ogTitle
                binding.posterPath.text = it.posterPath
                binding.overview.text = it.overview
                binding.title.text = it.title
            }
        }
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewholder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewholder {
        val binding =
            CustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewholder(binding)
    }

    class MyUtil : DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
