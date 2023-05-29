package org.learn.scala

import scala.annotation.unused

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")


    def ToF(x: Double): Int = {
      val result = (x * 9 / 5) + 32
      result.toInt
    }

    println("Result", ToF(21.0))

    val a: String = "Some string value"
    println(a)

    val atSymbol: Char = '@'
    println(atSymbol)

    @unused
    val y = .15

    val yellowRgb = 0xffff00

    println(yellowRgb.getClass, yellowRgb)

    val signature = "With Regards, \nYour friend"
    print(signature)

    val greeting = "\nHello, " + "World"
    println(greeting)

    val matched = greeting == "\nHello, World"
    println(matched)

    val MultipleLinesGreeting =
      """She suggested reformatting the file
        | by replacing tabs (\t) with newlines (\n);
        | "Why do that?", he asked. """.stripMargin
    println(MultipleLinesGreeting)

    val approx = 355/113f
    println("Pi using 355/113, is about " + approx + ".")
    println(f"Pi using 355/113, is about $approx" + ".")

    val item = "apple"

    println(s"Ho do you like them ${item}s?")
    println(s"Fish n clips n vinegar, ${"pepper "*3}salt")

    println(f"I wrote a new $item%.3s today")
    println(f"Enjoying this $item ${355/113.0}%.2f times today")

    val input = "Enjoying this apple 3.14159 times today"

    val pattern = """.* apple ([\d.]+) times .*""".r

    val pattern(amountText) = input

    val amount = amountText.toDouble

    println(input)
    println(amount)

    val c = 'A'
    val i: Int = c
    val t: Char = 116
    println(c, i, t)

    val isTrue = !true

    val isFalse = !true

    val unequal = (5 != 6)
    val isLess = (5 < 6)
    val unequalAndLess = unequal & isLess
    val definitelyFalse = false && unequal

    println("***" * 30)
    println(isTrue)
    println(isFalse)
    println(unequal, isLess, unequalAndLess, definitelyFalse)

    val zero = 0

    val isValid = zero > 0

    println(isValid)

    val nada = ()

    println(nada.isInstanceOf[Long])
    println(nada.getClass)
    println(5.0.isInstanceOf[Float])
    println("A".hashCode)
    println(20.toByte, 47.toFloat)
    println((3.0 / 4.0).toString)


    // Tuples
    println("***" * 30)

    val info = (5, "Korben", true)
    println(info)

    val name = info._2
    println(name)

    val red = "red" -> "0xff0000"
    println(red)

    val reversed = red._2 -> red._1
    println(reversed)






  }
}