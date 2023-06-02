package com.dleite.carrefourdev.common.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import java.io.FileNotFoundException
import java.net.URL

abstract class BaseUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Throws(FileNotFoundException::class)
    fun readFile(path: String): String {
        val content: URL? = ClassLoader.getSystemResource(path)
        return content?.readText() ?: throw FileNotFoundException("File path: $path was not found")
    }
}