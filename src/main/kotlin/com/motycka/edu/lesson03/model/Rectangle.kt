package com.motycka.edu.lesson03.model

open class Rectangle(
    override val width: Double,
    override val length: Double
) : Shape2D, Quadrilateral {

    override fun area(): Double = width * length

    override fun perimeter(): Double = 2 * (width + length)

    override fun to3D(depth: Double): Shape3D = Cuboid(width, length, depth)
}
