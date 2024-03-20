package com.example.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.demo.databinding.ItemUserBinding

class UserAdapter(
    //Unit is void
    // dummy function { _,_ -> }
    val fn: (ViewHolder, User) -> Unit = { _,_ -> }
) : ListAdapter<User,UserAdapter.ViewHolder>(Diff) {
//    static method - for comparing changes, if the list is changes
    companion object Diff :DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(a: User, b: User) = a.id == b.id
        override fun areContentsTheSame(a: User, b: User) = a == b
    }

    class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.imgPhoto.load(user.photo) //come from library coil
        holder.binding.txtName.text = user.name
        fn(holder,user)

    }
}