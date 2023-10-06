package com.example.apikeypractice.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apikeypractice.R
import com.example.apikeypractice.data.model.searchusers.ItemModel
import com.example.apikeypractice.data.model.users.UserModel
import com.example.apikeypractice.databinding.UserItemBinding

class UserAdapter(
    private val userData: ArrayList<UserModel>,
    private val function: (item: UserModel) -> Unit,
) :
    RecyclerView.Adapter<UserAdapter.AdapterViewHolder>() {

    // Load the avatar image using Glide and set it to the ImageView.

    class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = UserItemBinding.bind(view)

        fun setUpUI(userData: UserModel, position: Int) {

            // Set up the UI for a specific item using the provided peopleData and position.
            // Set the name to the corresponding TextView.
            binding.firstName.text = userData.login


            // Set the job title and email to the corresponding TextView.
            binding.email.text = userData.reposUrl

            val avatarUrl = userData.avatarUrl

            Glide.with(itemView.context)
                .load(avatarUrl)
                .placeholder(R.drawable.ic_dashboard_black_24dp)
                .into(binding.personImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        )


    override fun getItemCount() = userData.size


    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val currentUser = userData[position]

        holder.setUpUI(currentUser, position)

        holder.itemView.setOnClickListener {
            function.invoke(currentUser)
        }

    }

    fun updateUserList(peopleDetails: java.util.ArrayList<UserModel>) {
        peopleDetails.addAll(peopleDetails)
        notifyDataSetChanged()
    }


}








