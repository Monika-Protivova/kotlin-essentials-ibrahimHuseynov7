package com.motycka.edu.lesson02

object CoffeeShop {

    val coffeeOrders = mutableMapOf<Int, List<String>>()

    // Prices for coffee types (make sure these match your test expectations)
    const val ESPRESSO = "Espresso"
    const val DOUBLE_ESPRESSO = "Double Espresso"
    const val CAPPUCCINO = "Cappuccino"
    const val LATTE = "Latte"
    const val AMERICANO = "Americano"
    const val FLAT_WHITE = "Flat White"

    const val ESPRESSO_PRICE = 2.5
    const val DOUBLE_ESPRESSO_PRICE = 3.5
    const val CAPPUCCINO_PRICE = 3.0
    const val LATTE_PRICE = 3.0
    const val AMERICANO_PRICE = 2.0
    const val FLAT_WHITE_PRICE = 3.0

    @JvmStatic
    fun placeOrder(items: List<String>): Int {
        val newId = (coffeeOrders.keys.maxOrNull() ?: 0) + 1
        coffeeOrders[newId] = items
        return newId
    }

    @JvmStatic
    fun payOrder(orderId: Int): Double {
        val items = coffeeOrders[orderId] ?: throw IllegalStateException("Order ID $orderId not found.")
        val prices = items.map { getPrice(it) }

        return if (prices.size >= 3) {
            prices.sum() - (prices.minOrNull() ?: 0.0)
        } else {
            prices.sum()
        }
    }

    @JvmStatic
    fun completeOrder(orderId: Int) {
        if (!coffeeOrders.containsKey(orderId)) {
            throw IllegalStateException("Order ID $orderId not found.")
        }
        coffeeOrders.remove(orderId)
    }

    @JvmStatic
    fun processOrder(items: List<String>, payment: Double): Double {
        val orderId = placeOrder(items)
        val totalToPay = payOrder(orderId)

        if (payment < totalToPay) {
            throw IllegalStateException("Insufficient payment. Total to pay is $totalToPay, but received $payment.")
        }

        val change = payment - totalToPay
        println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: $change")

        completeOrder(orderId)
        return change
    }

    @JvmStatic
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
}
