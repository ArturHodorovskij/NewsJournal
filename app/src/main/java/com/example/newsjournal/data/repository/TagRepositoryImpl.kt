package com.example.newsjournal.data.repository

import com.example.newsjournal.domain.models.TagName
import com.example.newsjournal.domain.repository.TagRepository


class TagRepositoryImpl: TagRepository {

     private var tagList = arrayListOf<TagName>()

    override fun saveTag(saveTag: TagName) {
        tagList.add(saveTag)
    }

    override fun getTag():TagName{
        val tag = tagList[0].toString()
        return TagName(tag = tag)
    }
}