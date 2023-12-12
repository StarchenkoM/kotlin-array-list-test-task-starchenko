package mate.academy

//import jdk.internal.util.ArraysSupport;
import java.util.Arrays
import java.util.NoSuchElementException


class ArrayList<T> : List<T> {



    private val defCapacity = 10
    private val empty_arrayData = arrayOfNulls<Any>(0)


    private var array: Array<T?> = arrayOfNulls<Any>(defCapacity) as Array<T?>
    private var size = 0
    private var cursor = 0


    private fun errorMsg(index: Int): String {
        return "Index: $index, Size: $size"
    }


    private fun grow(): Array<T?> {
        val oldCapacity = array.size
        val multiplicator = if (oldCapacity == size) 1.5 else 1.0
        val newCapacity = (oldCapacity * multiplicator + 1).toInt()
        array = if (oldCapacity > 0 || array !== empty_arrayData) {
            return Arrays.copyOf(array, newCapacity)
        } else {
            return arrayOfNulls<Any>(defCapacity) as Array<T?>
        }
        return array
    }

    companion object {
        fun listToArray(list: List<*>): Array<Any?>? {
            if (!list.isEmpty()) {
                return Array(list.size()) { index -> list[index] }
            }
            return null
        }
    }

    override fun add(value: T?) {
        val index = cursor
        this.add(value, index)
        cursor = index + 1
    }


    override fun add(value: T?, index: Int) {
        if (index > size || index < 0) {
            throw ArrayListIndexOutOfBoundsException(errorMsg(index))
        } else {
            val s = size;
            if (s == array.size) {
                array = grow()
            }
            System.arraycopy(array, index, array, index + 1, size - index)
            array[index] = value
            size = s + 1
        }
    }


    override fun addAll(list: List<T>) {
        if (!list.isEmpty()) {
                val tempArray = listToArray(list) as Array<T?>
            val newCapacity = size + tempArray.size
            array = Arrays.copyOf(array, newCapacity)
            System.arraycopy(tempArray, 0, array, size, tempArray.size)
            size = newCapacity
        }
    }

    override fun get(index: Int): T {
        if (index >= size || index < 0) {
            throw ArrayListIndexOutOfBoundsException(errorMsg(index))
        } else {
            return array[index] as T
        }
    }

    override fun set(value: T, index: Int) {
        if (index >= size || index < 0) {
            throw ArrayListIndexOutOfBoundsException(errorMsg(index))
        } else {
            array[index] = value
        }
    }

    override fun remove(index: Int): T {
        if (index >= size || index < 0) {
            throw ArrayListIndexOutOfBoundsException(errorMsg(index))
        } else {
            val newSize = size - 1
            val oldValue = get(index)
            if (newSize > index) {
                System.arraycopy(array, index + 1, array, index, newSize - index)
            }
            size = newSize
            array[newSize] = null
            return oldValue
        }
    }

    override fun remove(element: T): T {
        var index = 0
        if (element == null) {
            while (index < size) {
                if (array[index] == null) {
                    for (i in index until size - 1) {
                        array[i] = array[i + 1]
                    }
                    array[size - 1] = null
                    size--
                    return element
                }
                index++
            }
        } else {
            while (index < size) {
                if (element.equals(array[index])) {
                    for (i in index until size - 1) {
                        array[i] = array[i + 1]
                    }
                    array[size - 1] = null
                    size--
                    return element
                }
                index++
            }
        }
        throw NoSuchElementException("Element $element not found in the list")
    }

    override fun size(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        var empty = true;
        for (element in array) {
            if (element != null) {
                empty = false
                break;
            }
        }
        return empty
    }

}