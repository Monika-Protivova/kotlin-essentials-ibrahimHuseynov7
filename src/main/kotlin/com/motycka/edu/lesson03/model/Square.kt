package com.motycka.edu.lesson03.model

class Square(val side: Double) : Rectangle(side, side) {

    fun to3D(): Shape3D = super.to3D(side)
}
