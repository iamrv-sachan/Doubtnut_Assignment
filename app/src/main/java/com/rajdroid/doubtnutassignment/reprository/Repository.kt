package com.rajdroid.doubtnutassignment.reprository

import com.rajdroid.doubtnutassignment.performGetOperation
import com.rajdroid.doubtnutassignment.retrofit.NewsRetro
import com.rajdroid.doubtnutassignment.room.NewsDao
import javax.inject.Inject

class Repository  @Inject constructor( val newsRetro: NewsRetro, val newsDao: NewsDao){

    fun getNews() = performGetOperation(
        databaseQuery = { newsDao.getAllArticles() },
        networkCall = { newsRetro.getAllNews() },
        saveCallResult = { newsDao.insertAll(it.articles) }
    )

}