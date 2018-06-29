package tests

import api.j.JavaInterface
import api.k.JavaDelegate
import api.k.KotlinDelegate
import api.k.KotlinInterface

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test

class CanGetParameterNames {

    @Test
    fun `from java interface`() {
        assertParameterNamesOf(JavaInterface::class.java)
    }

    @Test
    fun `from kotlin interface`() {
        assertParameterNamesOf(KotlinInterface::class.java)
    }

    @Test
    fun `from kotlin delegate`() {
        assertParameterNamesOf(KotlinDelegate::class.java)
    }

    @Test
    fun `from java delegate`() {
        assertParameterNamesOf(JavaDelegate::class.java)
    }

    private
    fun assertParameterNamesOf(javaClass: Class<*>) {

        val pluginMethod =
            javaClass.getDeclaredMethod("plugin", String::class.java)

        assertThat(
            pluginMethod.parameters.map { it.name },
            equalTo(listOf("id"))
        )
    }
}