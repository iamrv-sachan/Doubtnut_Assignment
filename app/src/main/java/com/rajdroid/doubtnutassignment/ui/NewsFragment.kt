package com.rajdroid.doubtnutassignment.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajdroid.doubtnutassignment.R
import com.rajdroid.doubtnutassignment.Resource
import com.rajdroid.doubtnutassignment.Utils
import com.rajdroid.doubtnutassignment.databinding.FragmentNewsBinding
import com.rajdroid.doubtnutassignment.entites.Article
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Observer

@AndroidEntryPoint
class NewsFragment : Fragment(),NewsAdapter.onitemClick  {

    private lateinit var binding: FragmentNewsBinding
    private val viewmodel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsAdapter
    lateinit var list:ArrayList<Article>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = ArrayList()
        setupObservers()

    }

    private fun setupObservers() {
        Log.i("luck","dad")
        viewmodel.news.observe(viewLifecycleOwner, {
            Log.i("luck",it.status.toString())
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty())
                    {
                        list.addAll(ArrayList(it.data))
                        adapter = NewsAdapter(ArrayList(it.data),this@NewsFragment)
                        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                        binding.recycler.adapter = adapter
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

            }
        })
    }

    override fun onItemClicked(d: Int) {
        Log.i("luck",list.get(d).toString())
        Utils.gestDesc=list.get(d)
        view?.findNavController()?.navigate(R.id.action_newsFragment_to_descriptionFragment)
    }

}