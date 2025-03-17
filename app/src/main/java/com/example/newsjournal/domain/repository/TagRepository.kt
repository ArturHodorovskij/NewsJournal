package com.example.newsjournal.domain.repository

import com.example.newsjournal.domain.models.TagName

interface TagRepository {

    fun saveTag(saveTag: TagName)

    fun getTag(): TagName

}