package org.retroachivements.api.test

import co.infinum.retromock.BodyFactory
import java.io.FileInputStream
import java.io.InputStream

internal class ResourceBodyFactory : BodyFactory {
    override fun create(input: String): InputStream {
        return FileInputStream(ResourceBodyFactory::class.java.classLoader.getResource("mock/$input").file)
    }
}
