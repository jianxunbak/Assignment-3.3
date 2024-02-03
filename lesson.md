## Part 1 - Arrays

### Arrays

The array is a data structure that allows you to store a sequence of values, all of the same type.

Arrays can store any of the 8 primitive types (`int`, `char`, etc.) as well as object references (`String`, `SomeCustomClass` etc.)

Create `LearnArrays.java` and code along.

#### Declaring an Array

```java
// Declare an array of integers
int[] ageList;

// Declare an array of Strings
String[] namesList;

// Alternate syntax - less common
String namesList[];
```

#### Instantiating an Array

One way to instantiate a new array is to use the `new` keyword. The number in the brackets is the size of the array.

```java
// Instantiate an array of 5 integers
int[] scoresList = new int[5];
Integer[] scoresList2 = new Integer[5];

// Instantiate an array of 10 Strings
String[] studentsList = new String[10];
```

#### Initializing an Array

If we already know the values for our array, we can initialize it.

```java
String[] favMovies = new String[] {"Avengers","Infinity War", "Iron Man"};
```

The elements are separated by commas and enclosed in curly braces `{}`. Because the size of the array is determined by the number of elements, we do not need to specify the size in the brackets.

We can further simplify this by omitting the `new String[]` part if it is in a declaration statement.

```java
String[] favMovies = {"Avengers","Infinity War", "Iron Man"};
```

Note that this only works in a declaration statement.

If we need to assign values to an array that has already been declared, we must use `new String[]`.

```java
String[] favMovies;

favMovies = {"Avengers","Infinity War", "Iron Man"}; // ❌ ERROR

favMovies = new String[] {"Avengers","Infinity War", "Iron Man"}; // ✅ OK
```

#### Accessing Elements

We can access elements in an array using the index. The index starts at 0 and ends at the size of the array minus 1.

```java
System.out.println(favMovies[0]); // Avengers
System.out.println(favMovies[1]); // Infinity War
System.out.println(favMovies[2]); // Iron Man
```

#### Changing Elements

We can change the value of an element in an array by assigning a new value to it.

```java
favMovies[0] = "Endgame";
System.out.println(favMovies[0]); // Endgame
```

#### Array Length

We can get the length of an array using the `length` property.

```java
System.out.println(favMovies.length); // 3
```

Note that an array's length is fixed. We cannot change it once it has been instantiated.

```java
favMovies.length = 5; // ❌ ERROR
favMovie[3] = "Captain America"; // ❌ ERROR
```

We cannot change the type of an array once it has been instantiated. All elements also have to be of the same type.

```java
favMovies = new int[5]; // ❌ ERROR
favMovies[0] = 1; // ❌ ERROR
```

Let us try to print out an array.

```java
System.out.println(favMovies); // [Ljava.lang.String;@39a054a5
System.out.println(scoresList); // [I@6d06d69c
```

#### `java.util.Arrays`

Java's array type is very basic and does not provide useful methods. As you saw, what we can do is just to check the property length.

We were not able to print the array directly using `System.out.println(favMovies)`. Instead the output was something like `[I@6d06d69c`. This is actually the class name and hashcode of the array object.

Java provides a utility class called `java.util.Arrays` that contains useful methods for working with arrays.

We can import this class at the top of the file or use VSCode to import it.

```java
import java.util.Arrays;
```

We can then print the array using `Arrays.toString()`.

```java
System.out.println(Arrays.toString(scoresList)); // [0, 0, 0, 0, 0]

System.out.println(Arrays.toString(scoresList2)); // [null, null, null, null, null]
```

🤔 Why are the initial element values different for array of integers i.e. `0` and `null`?

<details>
<summary>💡 Answer</summary>
This is because Java initializes the array with default values. For primitive types, the default value is `0`. For object references, the default value is `null`.
</details>

#### More utils - `sort`, `fill`, `copyOf`

We can sort an array using `Arrays.sort()`.

```java
scoresList = new int[] { 7, 3, 8, 4, 5 };

System.out.println("Before sort : " + Arrays.toString(scoresList));
Arrays.sort(scoresList);
System.out.println("After sort : " + Arrays.toString(scoresList));
```

We can fill an array with a value using `Arrays.fill()`.

```java
Arrays.fill(scoresList, 100);
System.out.println("After fill : " + Arrays.toString(scoresList)); // [100, 100, 100, 100, 100]
```

As you might have observed, these methods mutate the array. This means that the original array is changed, which might not be what we want.

We can create a copy of an array using `Arrays.copyOf()`.

This method takes in the array to copy and the length of the new array.

```java
String[] heroes = { "Ironman", "Captain America", "Hawkeye", "Hulk", "Black Widow", "Thor" };
System.out.println(Arrays.toString(heroes));

// Full Copy
String[] heroesCopy = Arrays.copyOf(heroes, heroes.length);
System.out.println("heroesCopy = " + Arrays.toString(heroesCopy));

// Partial Copy
String[] heroesPartialCopy = Arrays.copyOf(heroes, 3);
System.out.println("heroesPartialCopy = " + Arrays.toString(heroesPartialCopy));

// Copy and extend the array
String[] heroesExtendedCopy = Arrays.copyOf(heroes, heroes.length + 3);
System.out.println("heroesExtendedCopy = " + Arrays.toString(heroesExtendedCopy));
```

#### Binary Search

We can search for an element in an array using `Arrays.binarySearch()`. This method returns the index of the element if it is found, or a negative number if it is not found. Note that the array **must be sorted** before we can use this method.

```java
// Sort
Arrays.sort(heroes);
System.out.println("Sorted " + Arrays.toString(heroes));

// Search
System.out.println("Search for Hulk " + Arrays.binarySearch(heroes, "Hulk"));
System.out.println("Search for Ironman " + Arrays.binarySearch(heroes, "Ironman"));
```

#### Comparing Arrays

We can compare two arrays using `Arrays.equals()`. This method returns `true` if the arrays are equal, or `false` if they are not.

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};

System.out.println("arr1 == arr2 " + (arr1 == arr2)); // false
System.out.println("Array.equals(arr1, arr2) " + Arrays.equals(arr1, arr2)); // true
```

Just like `String`, we should not use `==` to compare arrays. This will only compare the references, not the contents of the arrays.

```java
arr1 == arr2; // false
```

---

## Part 2 - ArrayLists

The problem with arrays is that they are of a fixed size. Once we have created an array, we cannot change its size. This is where `ArrayList` comes in.

The ArrayList is a flexible data structure that allows us to store a sequence of values, all of the same type. It is similar to an array, but it is dynamic in size.

Create `LearnArrayLists.java` and code along.

To use ArrayList, we need to import it at the top of the file.

```java
import java.util.ArrayList;
```

This can also be automatically imported by VSCode.

### Declaring and Instantiating an ArrayList

```java
// Declare an ArrayList of Strings
ArrayList<String> namesList = new ArrayList<String>();
```

The `<String>` part is called a **type parameter**. We specify a type parameter using angle brackets `<>`, sometimes informally called "the diamond".

This is used to specify the type of the elements in the `ArrayList`. We can only store elements of this type in the `ArrayList`.

It is actually not necessary to specify the type parameter on the right side of the assignment. This is because Java can infer the type from the left side.

```java
ArrayList<String> namesList = new ArrayList<>();
```

⚠️ The `ArrayList` can be declared without a type parameter. This is called a **raw type** and it is not recommended as it can lead to bugs.

For example, you could accidentally add an `Integer` to an `ArrayList` that should only contain `String` elements.

It also makes the code less maintainable because it is not clear what type of elements the `ArrayList` should contain.

Furthermore, the types are not checked at compile time. This means that you will only find out about the error at runtime i.e. when the program is running.

For example:

```java
ArrayList rawList = new ArrayList();
rawList.add("Hello");
Integer myInt = (Integer) rawList.get(0); // ClassCastException
```

If the type parameter had been specified, the compiler would have caught the error because we cannot cast a `String` to an `Integer`.

Note that `ArrayLists` can only store object references, not primitive types. This means that we cannot use `int`, `char`, etc. as the type parameter. Instead, we have to use the corresponding wrapper class `Integer`, `Character`, etc.

```java
ArrayList<int> numbers = new ArrayList<>(); // ❌ ERROR
ArrayList<Integer> numbers = new ArrayList<>(); // ✅ OK
```

### Adding Elements

We can add elements to an `ArrayList` using the `add()` method.

```java
namesList.add("Ironman");
namesList.add("Captain America");
namesList.add("Hawkeye");
namesList.add("Hulk");
```

### Accessing Elements

We can access elements in an `ArrayList` using the `get()` method.

```java
System.out.println(namesList[0]); // ❌ ERROR
System.out.println(namesList.get(0)); // Ironman
System.out.println(namesList.get(1)); // Captain America
System.out.println(namesList.get(2)); // Hawkeye
System.out.println(namesList.get(3)); // Hulk
```

### Updating Elements

We can update elements in an `ArrayList` using the `set()` method.

```java
namesList[0] = "test"; // ❌ ERROR
namesList.set(0, "Black Widow");
System.out.println(namesList.get(0)); // Black Widow
```

### Removing Elements

We can remove elements from an `ArrayList` using the `remove()` method.

```java
namesList.remove(0);
System.out.println(namesList);
```

When we remove an element, the indices of the elements after it are shifted down by one.

### ArrayList Length

We can get the length of an `ArrayList` using the `size()` method.

```java
System.out.println(namesList.size()); // 3
```

### Creating and Populating an ArrayList

We can create an `ArrayList` and populate it with elements using `Arrays.asList()`.

```java
ArrayList<String> heroes = new ArrayList<>(Arrays.asList("Ironman", "Captain America", "Hawkeye", "Hulk", "Black Widow", "Thor"));
```

### Add an ArrayList to another ArrayList with `addAll()`

We can add all the elements from one `ArrayList` to another using `addAll()`.

```java
ArrayList<String> heroes = new ArrayList<>(Arrays.asList("Ironman", "Captain America", "Hawkeye", "Hulk", "Black Widow", "Thor"));
ArrayList<String> moreHeroes = new ArrayList<>(Arrays.asList("Doctor Strange", "Spiderman", "Black Panther"));

heroes.addAll(moreHeroes);
System.out.println(heroes); // [Ironman, Captain America,  Hawkeye, Hulk, Black Widow, Thor, Doctor Strange, Spiderman, Black Panther]
```

### Search for an element with `contains()`

We can search for an element in an `ArrayList` using `contains()`. This method returns `true` if the element is found, or `false` if it is not.

```java
ArrayList<String> villainsList = new ArrayList<>(Arrays.asList("Thanos", "Ultron", "Loki"));
System.out.println("Is Thanos here? " + villainsList.contains("Thanos"));
System.out.println("Is Spiderman here? " + villainsList.contains("Spiderman"));
```

### Search for an element index with `indexOf()` or `lastIndexOf()`

We can search for the index of an element in an `ArrayList` using `indexOf()`. This method returns the index of the first occurrence of the element, or `-1` if it is not found.

```java
System.out.println("Index of Thanos: " + villainsList.indexOf("Thanos"));
System.out.println("Index of Ultron: " + villainsList.indexOf("Ultron"));
```

We can also search for the index of the last occurrence of an element using `lastIndexOf()`.

```java
System.out.println("Last index of Thanos: " + villainsList.lastIndexOf("Thanos"));
System.out.println("Last index of Ultron: " + villainsList.lastIndexOf("Ultron"));
```

### Remove a set of elements with `removeAll()`

We can remove a set of elements from an `ArrayList` using `removeAll()`. This method takes in another `ArrayList` and removes all the elements that are in it.

```java
ArrayList<String> moreVillains = new ArrayList<>(Arrays.asList("Ultron", "Loki"));

villainsList.removeAll(moreVillains);
System.out.println(villainsList);
```

### Remove all elements with `clear()`

We can remove all the elements from an `ArrayList` using `clear()`.

```java
villainsList.clear();
System.out.println(villainsList);
```

### Check if an ArrayList is empty with `isEmpty()`

We can check if an `ArrayList` is empty using `isEmpty()`. This method returns `true` if the `ArrayList` is empty, or `false` if it is not.

```java
System.out.println("villainsList.isEmpty() " + villainsList.isEmpty());
```

### Specify elements not to be removed with `retainAll()`

We can specify elements not to be removed from an `ArrayList` using `retainAll()`. This method takes in another `ArrayList` and removes all the elements that are not in it.

```java
heroes.retainAll(Arrays.asList("Ironman", "Spiderman"));
System.out.println("heroes " + heroes);
```

---

## Part 3 - Loops and Accessing arrays

Create a `LearnLoops.java` file and code along.

To loop over an `Array` or `ArrayList`, we can use a `for` loop.

```java
int[] scoresList = { 74, 32, 82, 45, 56 };

// Looping over an Array
for (int i = 0; i < scoresList.length; i++) {
    System.out.println(scoresList[i]);
}

ArrayList<String> heroes = new ArrayList<>(
      Arrays.asList("Ironman", "Captain America", "Thor", "Hulk", "Black Widow", "Hawkeye"));


// Looping over an ArrayList
for (int i = 0; i < heroes.size(); i++) {
    System.out.println(heroes.get(i));
}
```

We can also use an enhanced for loop, which is also known as a **for-each** loop.

This is a special type of for loop that is used to iterate over a collection of elements.

The advantage of an enhanced for loop is that it is more concise and easier to read.

```java
// Looping over an Array
for (int score : scoresList) {
    System.out.println(score);
}

// Looping over an ArrayList
for (String hero : heroes) {
    System.out.println(hero);
}
```

Note that we cannot use an enhanced for loop to update elements.

```java
for (String hero : heroes) {
    hero = "Thanos"; // ❌ ERROR
}
```

### 👨‍💻 Activity

Create a new file called `ArrayActivity.java`.

Write a program to do the following:

- Allow a user to enter a list of suspect names
- Print out the list of suspect names
- Allow the user to enter the suspects with alibis
- Print out the updated list of suspects
- Find the suspect with the longest name
- Print out the suspect with the longest name

Hints:

- Use `ArrayLists` to store the suspect names and suspects with alibi names
- Use `while` loops to allow the user to enter the suspect names and suspects with alibi names
- Use `contains()` to check for repeats or an invalid suspect name
- Use `removeAll` to remove the suspects with alibis from the list of suspects
- Use a `for`/enhanced `for` loop to find the longest name (`String` length can be found using `.length()`)

---

## Part 4 - Lambda Expressions for ArrayLists (Optional)

Lambda expressions was introduced in Java 8. They are used to represent a block of code that can be passed around.

### Syntax

A lambda expression has the following syntax:

```java
// Single parameter
(parameter) -> expression

// No parameters
() -> expression

// Multiple parameters
(parameter1, parameter2) -> expression

// Multiple statements
(parameters) -> { statements }
```

Example with an `ArrayList`:

```java
ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

// Display all the numbers
numbers.forEach((number) -> System.out.println(number));

// Display all the even numbers
numbers.forEach((number) -> {
    if (number % 2 == 0) {
        System.out.println(number);
    }
});

// Remove all the odd numbers
numbers.removeIf((number) -> number % 2 != 0);
```
