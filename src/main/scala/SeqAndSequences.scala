package org.learn.scala

object SeqAndSequences {
  def main(args: Array[String]): Unit = {
    val inks = Seq('C', 'M', 'Y', 'K')
    println(inks)

    val hi = "Hello, " ++ "wordly" take 12 replaceAll("w", "W")
    println(hi)

    def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i+1))
    val s = inc(1)
    println(s)
    val l = s.take((5)).toList
    println(l)
    println(s)

    def inc2(head: Int): Stream[Int] = head #:: inc2(head+1)

    println(inc2(10).take(10).toList)

    def to(head: Char, end: Char): Stream[Char] = (head > end) match {
      case true => Stream.empty
      case false => head #:: to((head + 1).toChar, end)
      }

    val hexChars = to('A', 'F').take(20).toList
    println(hexChars)

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
    val firstOdd  = odds.headOption
    val evens = odds filter(_ % 2 == 0)
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









  }
}
