package api.k

import api.j.JavaInterface

interface KotlinInterface {
    fun plugin(id: String)
}

class KotlinDelegate(impl: KotlinInterface) : KotlinInterface by impl

class JavaDelegate(impl: JavaInterface) : JavaInterface by impl
