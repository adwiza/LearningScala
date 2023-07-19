package org.learn.scala

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.{Duration, SECONDS}

object FutureCollections {
  def main(args: Array[String]): Unit = {

    val f = concurrent.Future { println("hi") }
    println(f)

    val ff = concurrent.Future { Thread.sleep(5000); println("hi") }
    println("waiting")

    def nextFtr(i: Int = 0) = Future {
      def rand(x: Int) = util.Random.nextInt(x)

      Thread.sleep(rand(5000))
      if (rand(3) > 0) (i + 1) else throw new Exception

    }
    nextFtr(2)

    def cityTemp(name: String): Double = {
      val url = "http://api.openweathermap.org/data/2.5/weather"
      val cityUrl = s"$url?q=$name"
      val json = io.Source.fromURL(cityUrl).mkString.trim
      val pattern = """.*"temp":([\d.]).*""".r
      val pattern(temp) = json
      temp.toDouble
    }
    val cityTemps = Future sequence Seq(
      Future(cityTemp("Fresno")), Future(cityTemp(("Tempe")))
    )
//    cityTemps onComplete  {
//
//      case Seq(xx, y) if xx > y => println(s"Fresno is warmer: $xx K")
//      case Seq(xx, y) if y > xx => println(s"Tempe is warmer: $y K")
//
//    }

    val maxTime = Duration(10, SECONDS)
    val amount = concurrent.Await.result(nextFtr(5), maxTime)
    println(amount)





  }
}
