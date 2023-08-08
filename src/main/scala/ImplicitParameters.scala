package org.learn.scala

object ImplicitParameters {
  def main(args: Array[String]) = {

    object Doubly {
      def print(num: Double)(implicit fmt: String) = {
        println(fmt format num)
      }
    }
   Doubly.print(3.742)("%.1f")

    case class USD(amount: Double) {
      implicit val printFmt = "%.2f"
      def print = Doubly.print(amount)
    }
    new USD(81.924).print

    object IntUtils {
      implicit class Fishies(val x: Int) {
        def fishes = "Fish" * x
      }
    }
    import IntUtils._
    println(3.fishes)

    implicit class ArrowAssoc[A](x: A) {
      def ->[B](y: B): (A, B) = Tuple2(x, y)
    }



  }
}
