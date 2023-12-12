# Common mistakes

1. **Avoid beginning a class or method implementation with an empty line.**
    - Ensure to remove redundant empty lines for better readability.

2. **Use constants for magic numbers.**
    - Define constants for any hardcoded values to make your code more readable and maintainable.
    - Bad example:
      ```kotlin
      class Shelf {
          private var items = arrayOfNulls<Any>(6)
      }
      ```
    - Good example:
      ```kotlin
      class Shelf {
          companion object {
              private const val MAX_ITEMS_NUMBER = 6
          }
          private var items = arrayOfNulls<Any>(MAX_ITEMS_NUMBER)
      }
      ```

3. **Simplify if-else constructions.**
    - Write clear and concise logic without overcomplicating if-else statements.

4. **Avoid repeating code.**
    - Refactor any repeated logic into separate private methods. Adhere to the DRY (Don't Repeat Yourself) principle.
    - For example, common checks in `get()`, `set()`, and `remove()` methods should be abstracted into a separate method.

5. **Use descriptive names for variables and methods.**
    - Choose names that clearly reflect the purpose of the variable or what the method does.
    - Avoid vague or non-descriptive names.
      - **Bad Example:**
        ```kotlin
        private fun grow() {
            if (size == elementData.size) {
                // grow logic
            }
        }
        ```
        In this example, the `grow()` function suggests that it always increases the size of the array, but the conditional inside the function means this might not always happen.
      - **Good Example:**
        ```kotlin
        private fun grow() {
            // grow logic
        }
        ```
        This is a straightforward implementation where the grow logic is always executed.
      - **Another Good Example:**
        ```kotlin
        private fun growIfArrayFull() {
            if (size == elementData.size) {
                // grow logic
            }
        }
        ```
        Here, `growIfArrayFull()` clearly indicates that the array will only grow if a certain condition (array being full) is met. This name provides a more accurate description of the function's behavior.

6. **Avoid creating redundant variables.**
    - Redundant variables are confusing and make your code less clean and much more difficult to read. 

7. **Use Kotlin array copying functions.**
    - In Kotlin, use built-in functions like `copyInto()` for array copying tasks.

8. **Separate array resizing into its own method.**
    - Follow the Single Responsibility Principle by ensuring that each method or function does one thing only.

9. **Throw informative exceptions.**
   - Always include a clear and informative message when throwing exceptions to make it easier to understand the cause of an error.
