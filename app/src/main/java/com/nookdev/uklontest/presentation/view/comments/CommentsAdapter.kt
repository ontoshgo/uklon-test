package com.nookdev.uklontest.presentation.view.comments

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nookdev.uklontest.R
import com.nookdev.uklontest.domain.model.Comment
import com.nookdev.uklontest.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_comment.*
import javax.inject.Inject

class CommentsAdapter @Inject constructor() : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {

    private val data: MutableList<Comment> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(inflate(parent, R.layout.list_item_comment))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bindModel(data[position])
    }

    fun setData(newData: List<Comment>) {
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

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindModel(model: Comment) {
            tvCommentItemName.text = model.name
            tvCommentItemBody.text = model.body
        }
    }
}