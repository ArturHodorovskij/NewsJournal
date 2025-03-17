package com.example.newsjournal.domain.usecase

import com.example.newsjournal.domain.models.TagName
import com.example.newsjournal.domain.repository.TagRepository

class SaveTagNameUseCase(private val tagRepository: TagRepository) {
    fun saveTagName(nameTag: TagName){
        tagRepository.saveTag(saveTag = nameTag)
    }
}