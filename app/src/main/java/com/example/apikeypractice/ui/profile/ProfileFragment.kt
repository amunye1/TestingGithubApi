package com.example.apikeypractice.ui.profile

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.apikeypractice.R
import com.example.apikeypractice.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)



        val image = arguments?.getString("profileImage")
        val name = arguments?.getString("profileName")
        val hmtlLink = arguments?.getString("userLink")
        //val followingURL = arguments?.getString("profileFollowing")





        Glide.with(this)
            .load(image)
            .placeholder(R.drawable.ic_dashboard_black_24dp)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageView)

        binding.apply {
            binding.profileNm.text = name.toString().uppercase()
            binding.emailAddLink.text = hmtlLink
            binding.emailAddLink.setOnClickListener {
                startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(hmtlLink))
                )
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }

