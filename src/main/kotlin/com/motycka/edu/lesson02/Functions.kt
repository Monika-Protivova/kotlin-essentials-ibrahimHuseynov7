package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()

fun main() {
    // You can write code here to try the functions
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    // processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // will fail due to insufficient payment
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    if (payment < totalToPay) {
        throw IllegalArgumentException("Payment of $payment is not enough. Total to pay is $totalToPay")
    }

    println("Payment successful. You paid $$payment for order #$orderId")

    val change = payment - totalToPay

    completeOrder(orderId)

    return change
}

fun placerOrder(items: List<String>): Int {
    val newOrderId = if (coffeeOrders.isEmpty()) 1 else coffeeOrders.keys.maxOrNull()!! + 1
    coffeeOrders[newOrderId] = items
    return newOrderId
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: throw IllegalArgumentException("Order ID $orderId does not exist.")

    val prices = items.map { getPrice(it) }

    val total = if (prices.size >= 3) {
        prices.sum() - prices.minOrNull()!!
    } else {
        prices.sum()
    }

    return total
}

fun completeOrder(orderId: Int) {
    if (!coffeeOrders.containsKey(orderId)) {
        throw IllegalArgumentException("Order ID $orderId does not exist.")
    }
    coffeeOrders.remove(orderId)
}

fun getPrice(item: String): Double {
    return when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        else -> throw IllegalArgumentException("$item is not on the menu!")
    }
}
