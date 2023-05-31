package org.learn.scala

import scala.util.control.Breaks.break

object Expressions {

  def main (args: Array[String]): Unit = {

    val x = 5 * 20; val amo = x + 10
    println(amo)

    val amount = {
      val y = 5 * 20;
      y + 10
    }
      println(amount)

    println { val a = 1; { val b = a * 2; {val c = b + 4; c}}}

    if (47 % 3 > 0) println("Not a multiple of 3")

    val result = if ( false ) "what does this return?"

    val z = 10; val f = 20

    val max = if ( z > f ) z else f
    println(max)

    val s = 10; val t = 20

    val maxx = s > t match {
      case true => s
      case false => t
    }
    println(maxx)

    val status = 500
    val message = status match {
      case 200 =>
        "OK"
      case 400 => {
        println("ERROR = we called the service incorrectly")
        "error"
      }
      case 500 => {
        println("ERROR - the service encountered an error")
        "error"
      }
    }
    println(status, message)

    val day = "MON"

    val kind = day match {
      case "MON" | "TUE" | "WED" | "THU" | "FRI" =>
        "weekday"
      case "SAT" | "SUN" =>
        "weekend"
    }
    println(kind)

    val messageNew = "OK"

    val state = messageNew match {
      case "OK" => 200
      case other => {
        println(s"Couldn't parse $other")
        -1
      }
    }
    println(state)

    val mess = "Unauthorized"

    val statuss = mess match {
      case "OK" => 200
      case _ => {
        println(s"Couldn't parse $mess")
        -1
      }
    }
    println(statuss)

    val response: String = null

    response match {
      case s if s != null => println(s"Received '$s'")
      case s => println("Error! Received a null response")
    }
    println(response)

    val n: Int = 12180

    val yy: Any = n

    yy match {
      case n: String => s"'n'"
      case n: Double => f"$n%.2f"
      case n: Float => f"$n%.2f"
      case n: Int => s"${n}i"
    }
    println(yy)

    for (xx <- 1 to 7) {
      println((s"Day $xx:"))
    }

    //for (xx <- 1 to 7) yield { println((s"Day $xx:")) }

    val threes = for (i <- 1 to 20 if i % 3 == 0) yield i
    println(threes)

    val quote = "Faith,Hope,,Charity"

    for {
      t <- quote.split(",")
      if t != null
      if t.size > 0
    }
      { println(t) }

    for { xxx <- 1 to 2
          yyy <- 1 to 3 }
    { print(s"($xxx, $yyy) ") }
    print("\n")

    val powerOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow
    println(powerOf2)

    var xxxx = 10; while (xxxx > 0) xxxx -= 1
    println(xxxx)

    var m = 10
    do {
      println(s"Here I am, m = $m")
      m -= 1
    } while (m > 0)
  }

}
