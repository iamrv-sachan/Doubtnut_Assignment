package com.rajdroid.doubtnutassignment.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rajdroid.doubtnutassignment.R
import com.rajdroid.doubtnutassignment.Utils
import com.rajdroid.doubtnutassignment.databinding.FragmentDescriptionBinding
import com.rajdroid.doubtnutassignment.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("lkl", Utils.gestDesc!!.title!!)

        if (Utils.gestDesc!!.urlToImage!=null){
            context?.let {
                Glide.with(it).load(Utils.gestDesc!!.urlToImage)
                    .into(binding.img)
            }
        }

        binding.t.text=Utils.gestDesc!!.title
        binding.d.text=Utils.gestDesc!!.description
    }

}