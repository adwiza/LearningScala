package org.learn.scala

object MonadicAndOption {
  def main (args: Array[String]): Unit = {

    var x: String = "Indeed"
    var a = Option(x)

    x = null
    var b = Option(x)
    println(b)
    println(s"a is defined? ${a.isDefined}")
    println(s"b is not defined? ${b.isEmpty}")

    def divide(amt: Double, divisor: Double): Option[Double] = {
      if (divisor == 0) None
      else Option(amt / divisor)
    }

    val legit = divide(5, 2)
    println(legit)
    val illegit = divide(3, 0)
    println(illegit)

    val odds = List(1, 3, 5)
    val firstOdd = odds.headOption
    val evens = odds filter (_ % 2 == 0)
    val firstEven = evens.headOption
    println(firstEven)

    val words = List("risible", "scavenger", "gist")
    val uppercase = words find (w => w == w.toUpperCase)
    val lowercase = words find (w => w == w.toLowerCase)
    println(uppercase)
    println(lowercase)

    val filtered = lowercase filter (_ endsWith "ible") map (_.toUpperCase)
    println(filtered)
    val exactSize = filtered filter (_.size > 15) map (_.size)
    println(exactSize)

    def nextOption = if (util.Random.nextInt > 0) Some(1) else None
    val aa = nextOption
    val bb = nextOption
    val z = nextOption match {
      case Some(a) => a
      case None => -1
    }
    println("z " + z)
    println(aa)
    println(bb)

  }
}
