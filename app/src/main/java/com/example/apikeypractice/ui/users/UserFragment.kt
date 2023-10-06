package com.example.apikeypractice.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apikeypractice.R
import com.example.apikeypractice.data.model.users.UserModel
import com.example.apikeypractice.databinding.FragmentUserBinding
import com.example.apikeypractice.util.ResponseHandling
import com.example.apikeypractice.util.ResponseHandling.Failure
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList


@AndroidEntryPoint
class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = FragmentUserBinding.inflate(inflater, container, false)
        val root: View = binding.root

        userViewModel.personDetails.observe(viewLifecycleOwner) {
            it?.let {
                // showData()

                when (it) {
                    is ResponseHandling.Success<*> -> {
                        // Set up the RecyclerView with a LinearLayoutManager and the PeopleAdapter.
                        binding.recyclerViewUser.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = UserAdapter(it.result as ArrayList<UserModel>){
                                findNavController().navigate(
                                    R.id.action_navigation_user_to_navigation_profile,
                                    bundleOf(
                                        "profileName" to it.login,
                                        "profileImage" to it.avatarUrl,
                                        "userLink" to it.htmlUrl

                                    )
                                )
                            }

                        }
                    }

                    is Failure -> {
                        Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()

                    }

                    else -> {
                        // Loading
                    Toast.makeText(context, "Loading. . .", Toast.LENGTH_SHORT).show()

                    }
            }
        }}
        binding.recyclerViewUser.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = UserAdapter(arrayListOf()){
                findNavController().navigate(
                    R.id.action_navigation_user_to_navigation_profile,
                    bundleOf()
                )
            }
        }
        userViewModel.getUserDetails()
        return root
    }

    private fun showData(userDetails: ArrayList<UserModel>) {
        adapter.updateUserList(userDetails)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}