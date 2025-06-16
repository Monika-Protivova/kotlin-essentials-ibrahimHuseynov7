package com.motycka.edu.lesson04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.doubles.shouldBeWithinPercentageOf
import io.kotest.matchers.shouldBe

class TemperatureConverterTest : StringSpec({

    // Existing tests for toFahrenheit method
    "convert Celsius to Fahrenheit where celsius is 0" {
        // given
        val celsius = 0.0
        
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        
        // then
        fahrenheit shouldBe 32.0
    }

    "convert Celsius to Fahrenheit where celsius is 100" {
        // given
        val celsius = 100.0
        
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        
        // then
        fahrenheit shouldBe 212.0
    }

    "convert Celsius to Fahrenheit where celsius is 37" {
        // given
        val celsius = 37.0
        
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        
        // then
        fahrenheit shouldBe 98.6
    }

    // New tests for toCelsius method
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

    "convert Fahrenheit to Celsius where fahrenheit is 98.6" {
        // given
        val fahrenheit = 98.6
        
        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        celsius shouldBeWithinPercentageOf(37.0, 0.01)
    }

    "convert negative Fahrenheit to Celsius where fahrenheit is -40" {
        // given
        val fahrenheit = -40.0
        
        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        celsius shouldBe -40.0
    }

    "convert negative Fahrenheit to Celsius where fahrenheit is -4" {
        // given
        val fahrenheit = -4.0
        
        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        celsius shouldBe -20.0
    }

    // Bonus challenge tests - Edge cases
    "convert very large Fahrenheit value to Celsius" {
        // given
        val fahrenheit = 1000.0
        
        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        celsius shouldBeWithinPercentageOf(537.78, 0.01)
    }

    "convert very small Fahrenheit value to Celsius" {
        // given
        val fahrenheit = -459.67 // absolute zero in Fahrenheit
        
        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        celsius shouldBeWithinPercentageOf(-273.15, 0.01)
    }

    "test round-trip conversion from Celsius to Fahrenheit and back" {
        // given
        val originalCelsius = 25.0
        
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(originalCelsius)
        val backToCelsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        backToCelsius shouldBeExactly originalCelsius
    }

    "test round-trip conversion from Fahrenheit to Celsius and back" {
        // given
        val originalFahrenheit = 77.0
        
        // when
        val celsius = TemperatureConverter.toCelsius(originalFahrenheit)
        val backToFahrenheit = TemperatureConverter.toFahrenheit(celsius)
        
        // then
        backToFahrenheit shouldBeWithinPercentageOf(originalFahrenheit, 0.001)
    }

    "convert room temperature Fahrenheit to Celsius" {
        // given
        val fahrenheit = 68.0 // typical room temperature in Fahrenheit
        
        // when
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        
        // then
        celsius shouldBe 20.0
    }

    "convert freezing point of water from Celsius to Fahrenheit" {
        // given
        val freezingCelsius = 0.0
        
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(freezingCelsius)
        
        // then
        fahrenheit shouldBe 32.0
    }

    "convert freezing point of water from Fahrenheit to Celsius" {
        // given
        val freezingFahrenheit = 32.0
        
        // when
        val celsius = TemperatureConverter.toCelsius(freezingFahrenheit)
        
        // then
        celsius shouldBe 0.0
    }

    "convert boiling point of water from Celsius to Fahrenheit" {
        // given
        val boilingCelsius = 100.0
        
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(boilingCelsius)
        
        // then
        fahrenheit shouldBe 212.0
    }

    "convert boiling point of water from Fahrenheit to Celsius" {
        // given
        val boilingFahrenheit = 212.0
        
        // when
        val celsius = TemperatureConverter.toCelsius(boilingFahrenheit)
        
        // then
        celsius shouldBe 100.0
    }
})
