package com.rajdroid.doubtnutassignment.ui

import androidx.lifecycle.ViewModel
import com.rajdroid.doubtnutassignment.reprository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val news = repository.getNews()
}