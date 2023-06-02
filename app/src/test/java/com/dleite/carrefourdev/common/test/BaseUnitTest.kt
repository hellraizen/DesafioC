package com.dleite.carrefourdev.common.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import java.io.FileNotFoundException
import java.net.URL

abstract class BaseUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


}