package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.TagName
import com.example.newsjournal.domain.repository.TagRepository

class GetTagNameUseCase(private val tagRepository: TagRepository) {
    fun getTagName(): TagName {
        return tagRepository.getTag()
    }
}