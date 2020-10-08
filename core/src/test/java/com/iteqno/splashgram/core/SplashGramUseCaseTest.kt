package com.iteqno.splashgram.core

import com.iteqno.splashgram.core.domain.repository.ISplashGramRepository
import com.iteqno.splashgram.core.domain.usecase.SplashGramInteractor
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SplashGramUseCaseTest {

    private lateinit var useCase: SplashGramUseCase

    @Mock private lateinit var repository: ISplashGramRepository

    @Before
    fun setUp(){
        useCase = SplashGramInteractor(repository)
        `when`(repository.getLovedPhotos()).thenReturn(flow {})
    }

    @Test
    fun `should get data from repository`() {
        useCase.getLovedPhotos()

        verify(repository).getLovedPhotos()
        verifyNoMoreInteractions(repository)
    }
}