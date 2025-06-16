package com.motycka.edu.lesson04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class TemperatureConverterTest : StringSpec({

    "convert Fahrenheit to Celsius where fahrenheit is 32" {
        // given
        val fahrenheit = 32.0

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        celsius shouldBe 0.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is 212" {
        // given
        val fahrenheit = 212.0

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        celsius shouldBe 100.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is 98.6 (body temp)" {
        // given
        val fahrenheit = 98.6

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        // use a small tolerance due to floating point math
        celsius shouldBe (37.0 plusOrMinus 0.1)
    }

    "convert negative Fahrenheit to Celsius" {
        // given
        val fahrenheit = -40.0

        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        // then
        // -40 F = -40 C (the crossover point)
        celsius shouldBe -40.0
    }

    // Bonus tests

    "convert very large Fahrenheit to Celsius" {
        val fahrenheit = 1_000_000.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe ((fahrenheit - 32) * 5 / 9)
    }

    "convert very small Fahrenheit to Celsius" {
        val fahrenheit = -1_000_000.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe ((fahrenheit - 32) * 5 / 9)
    }

    "round-trip conversion: Celsius -> Fahrenheit -> Celsius returns original value" {
        val originalCelsius = 25.0
        val fahrenheit = TemperatureConverter.toFahrenheit(originalCelsius)
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe (originalCelsius plusOrMinus 0.0001)
    }

})
