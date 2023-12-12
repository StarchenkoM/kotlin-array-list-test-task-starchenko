package mate.academy

interface List<T> {
    fun add(value: T?)

    fun add(value: T?, index: Int)

    fun addAll(list: List<T>)

    operator fun get(index: Int): T

    fun set(value: T, index: Int)

    fun remove(index: Int): T

    fun remove(element: T): T

    fun size(): Int

    fun isEmpty(): Boolean
}
