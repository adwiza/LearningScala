package org.learn.scala

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")


    def ToF(x: Float): Float = {
      (x * 9 / 5) + 32
    }

    println(ToF(21))

    val a: String = "Some string value"
    println(a)


  }
}