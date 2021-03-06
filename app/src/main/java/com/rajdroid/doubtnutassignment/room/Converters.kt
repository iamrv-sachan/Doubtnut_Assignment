package com.rajdroid.doubtnutassignment.room

import androidx.room.TypeConverter
import com.rajdroid.doubtnutassignment.entites.Source

class Converters {


    @TypeConverter
    fun fromSource(source: Source):String{

        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}