package com.poli.prevendasomie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class CoroutineTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    protected val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
}