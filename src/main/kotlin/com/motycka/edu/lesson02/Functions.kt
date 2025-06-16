package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()

fun main() {
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    // processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // will fail
}

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    println("Processing payment for order #$orderId: total = $totalToPay, payment = $payment")

    if (payment < totalToPay) {
        throw IllegalArgumentException("Payment of $$payment is not enough, total is $$totalToPay")
    }

    val change = payment - totalToPay
    println("Payment successful. Change: $$change")

    completeOrder(orderId)
    return change
}

fun placerOrder(items: List<String>): Int {
    val newId = (coffeeOrders.keys.maxOrNull() ?: 0) + 1
    coffeeOrders[newId] = items
    return newId
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: throw IllegalArgumentException("Order #$orderId does not exist")
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
        throw IllegalArgumentException("Order #$orderId does not exist")
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
