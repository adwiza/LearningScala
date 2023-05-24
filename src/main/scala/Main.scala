package org.learn.scala

import scala.annotation.unused

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")


    def ToF(x: Float): Float = {
      (x * 9 / 5) + 32
    }

    println(ToF(21))

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





  }
}