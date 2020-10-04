package com.iteqno.splashgram.core.domain.usecase

import com.iteqno.splashgram.core.domain.model.Photo
import com.iteqno.splashgram.core.domain.repository.ISplashGramRepository

class SplashGramInteractor(private val splashGramRepository: ISplashGramRepository) : SplashGramUseCase {
    override fun getAllPhoto() = splashGramRepository.getAllPhoto()

    override fun getLovedPhotos() = splashGramRepository.getLovedPhotos()

    override fun setLovedPhoto(photo: Photo, state: Boolean) = splashGramRepository.setLovedPhoto(photo, state)

}