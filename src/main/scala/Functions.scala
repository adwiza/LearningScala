package org.learn.scala

import scala.annotation.tailrec

object Functions {

  def main(args: Array[String]): Unit = {

    def multiplier(x: Int, y: Int): Int = { x * y}

    println(multiplier(6, 7))

    def safeTrim(s: String): String = {
      if (s == null) return null
      s.trim()
    }

    println(safeTrim("     how are you dude                              "))

    def log(d: Double) = { println(f"Got value $d%.2f") }
    log(5.56565)

    def hi(): String = "hi"

    println(hi())
    println(hi)

    def formatEuro(amt: Double) = f"€$amt%.2f"

    println(formatEuro(2.3432432))
    println(formatEuro { val rate = 1.32; 0.235 + 0.7123 + rate * 5.32 })

    def power(x: Int, n: Int): Long = {
      if (n >= 1) x * power(x, n - 1)
      else 1
    }
    println(power(2, 8))
    println(power(2, 1))
    println(power(2, 0))

    @annotation.tailrec
    def powerTr(x: Int, n: Int, t: Int = 1): Int = {
      if (n < 1) t
      else powerTr(x, n - 1, x * t)
    }

    println("TAILREC", powerTr(2, 8))
    println(powerTr(2, 1))
    println(powerTr(2, 0))

//    Nested Functions
    def max(a: Int, b: Int, c: Int) = {
      def max(x: Int, y: Int) = if (x > y) x else y
      max(a, max(b, c))
    }
    println("Max function result: " + max(42, 181, 19))

    def greet(prefix: String, name: String) = s"$prefix $name"

    val greeting1 = greet("Ms", "Brown")
    val greeting2 = greet(name = "Brown", prefix = "Mr")

    println(greeting1)
    println(greeting2)

    def greet2(prefix: String = "", name: String) = s"$prefix $name"

    val greeting3 = greet2(prefix = "Mr", name = "Paul")

    println(greeting3)

    def greet3(name: String = "", prefix: String = "") = s"$prefix$name"

    val greeting4 = greet3("Ola")
    println(greeting4)

    def sum(items: Int*): Int = {
      var total = 0
      for (i <- items) total += i
      total
    }

    val summ = sum(10, 20, 30)
    println(summ)

    def maxx(x: Int)(y: Int) = if (x > y) x else y

    val larger = maxx(20)(39)
    println(larger)

    def identity[A](a: A): A = a

    val s: String = identity[String]("hello")
    val d: Double = identity[Double](2.717)

    println(s + " " + d)

    val fileName = "vacation.jpg"

    val isJPEG = fileName.endsWith(".jpg")
    println(isJPEG)

    println(d.round)
    println(d.floor)
    println(d.compare(18.0))
    println(d.+(2.721))

    println(fileName.substring(1, 5))






  }
}
