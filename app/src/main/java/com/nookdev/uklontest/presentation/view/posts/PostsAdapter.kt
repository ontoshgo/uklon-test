package com.nookdev.uklontest.presentation.view.posts

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nookdev.uklontest.R
import com.nookdev.uklontest.domain.model.Post
import com.nookdev.uklontest.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_post.*
import javax.inject.Inject

class PostsAdapter @Inject constructor() : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private val data: MutableList<Post> = mutableListOf()
    private var onItemSelectedListener: (Post) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(inflate(parent, R.layout.list_item_post))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindModel(data[position])
    }

    fun setOnItemSelectedListener(callback: (Post) -> Unit) {
        onItemSelectedListener = callback
    }

    fun setData(newData: List<Post>) {
        val diffCallback = object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data[oldItemPosition].id == newData[newItemPosition].id
            }

            override fun getOldListSize(): Int {
                return data.size
            }

            override fun getNewListSize(): Int {
                return newData.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data[oldItemPosition] == newData[newItemPosition]
            }
        }
        DiffUtil.calculateDiff(diffCallback, true).dispatchUpdatesTo(this)
        data.apply {
            clear()
            addAll(newData)
        }
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        init {
            cvPostRoot.setOnClickListener {
                onItemSelectedListener(data[adapterPosition])
            }
        }

        fun bindModel(model: Post) {
            tvPostItemText.text = model.title
        }
    }
}