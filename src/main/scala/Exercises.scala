package org.learn.scala

import scala.Console.println
import scala.annotation.tailrec
import scala.math.Ordered.orderingToOrdered
import scala.math.pow
import scala.math.Ordering.Implicits.{infixOrderingOps, seqOrdering}

object Exercises {

  def main (args: Array[String]): Unit = {
    val inputValue = 2.7255
    println("You owe $%.2f".format(inputValue))

    def ToF(x: Double): Int = {
      val result = (x * 9 / 5) + 32
      result.toInt
    }

    println("Result: " + ToF(21.0))

    val flag: Boolean = false
    val result: Boolean = (flag == false)
    println(result)

    val num = 128

    val cha = num.toChar
    println(cha.getClass)
    val str = cha.toString
    println(str.getClass)
    val dbl = cha.toDouble
    println(dbl.getClass)
    val int = dbl.toInt
    println(int.getClass)

    val sentence = "Frank,123 Main,925-555-1943,95122"

    val pattern = raw"""(\d+)-(\d+)-(\d+)""".r
    val all = pattern.findAllIn(sentence).toList.head
    val one, two, three = all.split("-")
    val digOne = one.apply(0).toInt
    val digTwo = two.apply(1).toInt
    val digThree = three.apply(2).toInt

    println(all)
    println(digOne, digOne.getClass)
    println(digTwo, digTwo.getClass)
    println(digThree, digThree.getClass)
    println("****" * 50)

    val x = List.range(1, 101)
    val z = x.grouped(5).toList
    for { xxx <- z.take(x.size) }
      { println(xxx.mkString(", ")) }

    println("****" * 50)
    val xx = (1 to 100)
    for { yyy <- xx.take(x.size)} if (yyy % 15 == 0)
      println("typesafe ", yyy)
    else if (yyy % 3 == 0)
      println("type ", yyy)
    else if (yyy % 5 == 0)
      println("safe ", yyy)

println("***" * 30)

    /*
    This function calculates the area of the circle
    by the radius
     */
    def circleArea(r: String) = { if (r.isEmpty) null else 3.14 * (r.toDouble * r.toDouble) }
    println("Area of a circle is: " + circleArea("6"))

    def factorial(n: Int): Unit = {
      if (n == 5)
        n
      else if (n <= 50) factorial(n - 5)
      else factorial(n)
      println(n)
    }

    factorial(50)

    def convertMs(time: Long) = {

    }

  }
}
