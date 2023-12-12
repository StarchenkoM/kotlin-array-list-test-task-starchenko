package mate.academy

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ArrayListTest {
    private val elementsCount = 1000

    @Test
    fun addElementToArrayList() {
        val arrayList = ArrayList<String>()
        arrayList.add("Test")
        arrayList.add(null)
        arrayList.add("for")
        arrayList.add("Mate")
        assertEquals(4, arrayList.size(), "Test failed! Size of array should be 4 but it is ${arrayList.size()}")
        assertEquals("Test", arrayList.get(0), "Test failed! Element is not added correctly")
        assertNull(arrayList.get(1), "Test failed! Element is not added correctly")
        assertEquals("for", arrayList.get(2), "Test failed! Element is not added correctly")
        assertEquals("Mate", arrayList.get(3), "Test failed! Element is not added correctly")
    }

    @Test
    fun addElementToArrayListByIndex() {
        val arrayList = ArrayList<String>()
        arrayList.add("Test")
        arrayList.add("for")
        arrayList.add("Mate")
        assertEquals(3, arrayList.size(), "Test failed! Size of array should be 3 but it is ${arrayList.size()}")
        arrayList.add("Academy", 1)
        assertEquals("Test", arrayList.get(0))
        assertEquals("Academy", arrayList.get(1), "Test failed! Can't correctly add element by index 1")
        assertEquals("for", arrayList.get(2))
        assertEquals("Mate", arrayList.get(3))
        arrayList.add(null, 0)
        assertEquals(5, arrayList.size(), "Test failed! Size of array should be 5 but it is ${arrayList.size()}")
        assertNull(arrayList.get(0))
        arrayList.add("value", 5)
        assertEquals("value", arrayList.get(5), "Test failed! Can't correctly add element by index 5")
        assertEquals(6, arrayList.size(), "Test failed! Size of array should be 6 but it is ${arrayList.size()}")
    }

    @Test
    fun addListToArrayList() {
        val arrayList = ArrayList<String>()
        arrayList.add("Test")
        arrayList.add("for")
        arrayList.add("Mate")
        assertEquals(3, arrayList.size())
        val newArrayList = ArrayList<String>()
        newArrayList.add("Academy")
        newArrayList.add("Kiev")
        arrayList.addAll(newArrayList)
        assertEquals(5, arrayList.size(), "Test failed! Size of array should be 5 but it is ${arrayList.size()}")
        assertEquals("Academy", arrayList.get(3))
        assertEquals("Kiev", arrayList.get(4))
    }

    @Test
    fun addElementInTheNonExistentPosition() {
        val arrayList = ArrayList<String>()
        arrayList.add("First")
        arrayList.add("Second")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.add("Second", 5)
        }
        assertEquals("Index: 5, Size: 2", exception.message)
    }

    @Test
    fun addElementInTheNegativePosition() {
        val arrayList = ArrayList<String>()
        arrayList.add("String")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.add("Java", -6)
        }
        assertEquals("Index: -6, Size: 1", exception.message)
    }

    @Test
    fun checkingResize() {
        val arrayList = ArrayList<String>()
        for (i in 0 until elementsCount) {
            arrayList.add("First + $i")
        }
        for (i in 0 until elementsCount) {
            assertEquals("First + $i", arrayList.get(i), "Test failed! Array can't resize correctly")
        }
    }

    @Test
    fun checkingResizeInAddByIndex() {
        val arrayList = ArrayList<String>()
        for (i in 0 until elementsCount) {
            arrayList.add("First + $i", 0)
            assertEquals(i + 1, arrayList.size(), "Test failed! Size of array should be ${i + 1} but it is ${arrayList.size()}")
        }
        for (i in 0 until elementsCount) {
            assertEquals("First + ${elementsCount - i - 1}", arrayList.get(i), "Test failed! Array can't resize correctly")
        }
    }

    @Test
    fun removeElementFromArrayListByIndex() {
        val arrayList = ArrayList<String>()
        arrayList.add("String")
        arrayList.add(null)
        arrayList.add("Java")
        arrayList.add("Private")
        assertEquals(4, arrayList.size())
        var actualResult = arrayList.remove(2)
        assertEquals("Java", actualResult, "Test failed! Returned value should be $actualResult")
        assertEquals(3, arrayList.size(), "Test failed! Size of array after removed element should be 3 but it is ${arrayList.size()}")
        assertEquals("Private", arrayList.get(2), "Test failed! Can't remove element by index")
        actualResult = arrayList.remove(0)
        assertEquals("String", actualResult, "Test failed! Returned value should be $actualResult")
        assertEquals(2, arrayList.size())
        assertNull(arrayList.get(0), "Test failed! Can't remove element by index")
        actualResult = arrayList.remove(1)
        assertEquals("Private", actualResult, "Test failed! Returned value should be null")
        assertEquals(1, arrayList.size())
        assertNull(arrayList.get(0), "Test failed! Can't remove element by index")
    }

    @Test
    fun removeElementFromFullArrayListByIndex() {
        val arrayList = ArrayList<Int>()
        for (i in 0..9) {
            arrayList.add(i)
        }
        assertEquals(10, arrayList.size())
        val actualResult = arrayList.remove(index = 9)
        assertEquals(9, actualResult, "Test failed! Returned value should be $actualResult")
        assertEquals(9, arrayList.size(), "Test failed! Size of array after removing element should be 9, but it is ${arrayList.size()}")
    }

    @Test
    fun removeElementFromArrayListByNonExistentIndex() {
        val arrayList = ArrayList<String>()
        arrayList.add("String")
        arrayList.add("Java")
        arrayList.add("Private")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.remove(3)
        }
        assertNotNull(exception.message)
    }

    @Test
    fun removeElementFromArrayListByNegativeIndex() {
        val arrayList = ArrayList<String>()
        arrayList.add("String")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.remove(-5)
        }
        assertNotNull(exception.message)
    }

    @Test
    fun removeElementFromArrayListByValue() {
        val arrayList = ArrayList<String?>()
        arrayList.add("String")
        arrayList.add("Another string")
        arrayList.add(null)
        arrayList.add("Java")
        arrayList.add("Private")
        arrayList.add(null)
        assertEquals(6, arrayList.size())
        var actualResult = arrayList.remove("Java")
        assertEquals("Java", actualResult, "Test failed! Returned value should be \"$actualResult\"")
        assertEquals(5, arrayList.size(), "Test failed! Size of array after removing element should be 5, but it is ${arrayList.size()}")
        assertEquals("Private", arrayList.get(3), "Test failed! Remove was incorrect")
        actualResult = arrayList.remove("String")
        assertEquals("String", actualResult, "Test failed! Returned value should be \"$actualResult\"")
        assertEquals(4, arrayList.size(), "Test failed! Size of array after removing element should be 4, but it is ${arrayList.size()}")
        assertEquals("Private", arrayList.get(2), "Test failed! Remove was incorrect")
        actualResult = arrayList.remove(null)
        assertNull(actualResult, "Test failed! Returned value should be null")
        assertEquals(3, arrayList.size(), "Test failed! Size of array after removing element should be 3, but it is ${arrayList.size()}")
    }

    @Test
    fun removeElementFromArrayListByNonExistentValue() {
        val arrayList = ArrayList<String>()
        arrayList.add("String")
        arrayList.add("Java")
        arrayList.add("Private")

        // Expect the NoSuchElementException to be thrown
        val exception = assertThrows<NoSuchElementException> {
            arrayList.remove("Public")
        }

        // Optionally, you can also check the message of the exception if needed
        assertNotNull(exception)
    }

    @Test
    fun removeObjectValueByValue() {
        val firstCat = Cat("Fantic", "grey")
        val secondCat = Cat("Barsik", "black")
        val thirdCat = Cat("Tom", "white")
        val fourthCat = Cat("Barsik", "black")
        val cats = ArrayList<Cat>()
        cats.add(firstCat)
        cats.add(secondCat)
        cats.add(thirdCat)
        assertEquals(3, cats.size(), "Test failed! Size of array should be 3 but it is ${cats.size()}")
        val actualResult = cats.remove(fourthCat)
        assertEquals(fourthCat, actualResult, "Test failed! Returned value should be $actualResult")
        assertEquals(2, cats.size(), "Test failed! Size of array should be 2 but it is ${cats.size()}")
    }

    @Test
    fun setValueInIndex() {
        val arrayList = ArrayList<String?>()
        arrayList.add("5")
        arrayList.add("115")
        assertEquals("115", arrayList.get(1))
        arrayList.set("511", 1)
        assertEquals(2, arrayList.size(), "Test failed! Size of array should be 2 but it is ${arrayList.size()}")
        assertEquals("511", arrayList.get(1), "Test failed! Can't set value by special position")
        arrayList.set(null, 0)
        assertEquals(2, arrayList.size(), "Test failed! Size of array should be 2 but it is ${arrayList.size()}")
        assertNull(arrayList.get(0), "Test failed! Can't set value by special position")
    }

    @Test
    fun setValueInTheNonExistentPosition() {
        val arrayList = ArrayList<String>()
        arrayList.add("First")
        arrayList.add("Second")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.set("Third", 2)
        }
        assertNotNull(exception.message)
    }

    @Test
    fun setValueInTheNegativePosition() {
        val arrayList = ArrayList<String>()
        arrayList.add("First")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.set("Third", -2)
        }
        assertNotNull(exception.message)
    }

    @Test
    fun getElementByIndex() {
        val arrayList = ArrayList<String?>()
        arrayList.add("First")
        arrayList.add("Second")
        arrayList.add("Third")
        arrayList.add(null)
        var actualResult = arrayList.get(2)
        assertEquals("Third", actualResult)
        actualResult = arrayList.get(3)
        assertNull(actualResult)
    }

    @Test
    fun getElementByNonExistedIndex() {
        val arrayList = ArrayList<String>()
        arrayList.add("First")
        arrayList.add("Second")
        arrayList.add("Third")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.get(3)
        }
        assertNotNull(exception.message)
    }

    @Test
    fun getElementByNegativeIndex() {
        val arrayList = ArrayList<String>()
        arrayList.add("First")

        val exception = assertThrows<ArrayListIndexOutOfBoundsException> {
            arrayList.get(-2)
        }
        assertNotNull(exception.message)
    }

    @Test
    fun checkIsNotEmpty() {
        val arrayList = ArrayList<String>()
        arrayList.add("First")
        arrayList.add("Second")
        arrayList.add("Third")
        assertFalse(arrayList.isEmpty(), "Test failed! ArrayList shouldn't be empty")
    }

    @Test
    fun checkIsEmpty() {
        val arrayList = ArrayList<String>()
        assertTrue(arrayList.isEmpty(), "Test failed! ArrayList should be empty")
        arrayList.add("First")
        arrayList.remove(0)
        assertTrue(arrayList.isEmpty(), "Test failed! ArrayList should be empty")
    }
}
