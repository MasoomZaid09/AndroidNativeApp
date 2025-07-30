package com.example.nativeandroidapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nativeandroidapp.R
import com.example.nativeandroidapp.domain.model.Response

class PostsAdapter(private val posts: ArrayList<Response>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        holder.textTitle.text = post.title
        holder.textBody.text = post.body
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle: TextView = view.findViewById(R.id.textTitle)
        val textBody: TextView = view.findViewById(R.id.textBody)
    }
}
