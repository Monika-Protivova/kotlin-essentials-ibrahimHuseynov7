# Conditionals in Kotlin

Kotlin provides several ways to express conditional logic in your code, including `if-else` expressions and `when` expressions.

## If-Else Expressions

In Kotlin, `if-else` is an expression, which means it returns a value. This allows you to use it for assignments.

```kotlin
val discount = if (items.size >= 3) {
    prices.min()
} else {
    0.0
}
```

## When Expressions

The `when` expression is Kotlin's version of a switch statement, but much more powerful. It can be used with or without an argument.

```kotlin
val price = when (coffeeType) {
    "Espresso" -> 2.5
    "Cappuccino" -> 3.0
    "Latte" -> 3.5
    else -> error("$coffeeType is not on the menu!")
}
```

## Exercise
**Use the `../src/com/motycka/edu/lesson02/Conditionals.kt` file to complete the following exercise:**

1. Define constants for the prices of different coffee types:
   - `ESPRESSO_PRICE`: 2.5
   - `DOUBLE_ESPRESSO_PRICE`: 3.0
   - `CAPPUCCINO_PRICE`: 3.0
   - `LATTE_PRICE`: 3.5
   - `AMERICANO_PRICE`: 2.0
   - `FLAT_WHITE_PRICE`: 3.2

2. Create a `main` function that:
   - Creates a map of coffee orders, where the key is the order ID and the value is a list of coffee items
   - Iterates through each order
   - For each order:
     - Prints the order ID and items
     - Uses a `when` expression to determine the price of each coffee item
     - Uses an `if-else` expression to apply a discount (the price of the cheapest coffee) if the order contains 4 or more items
     - Calculates and prints the total price for the order

Example output:
```
Processing Order ID: 1
Items: [Espresso, Cappuccino, Latte, Americano]
You ordered 3 or more coffees, you get 1 for free!
Total price for Order ID 1: 9.0

Processing Order ID: 2
Items: [Espresso, Double Espresso, Flat White]
You ordered 3 or more coffees, you get 1 for free!
Total price for Order ID 2: 6.2
```

Note: This exercise uses the coffee type constants defined in the Collections exercise. Make sure you have completed that exercise first.
