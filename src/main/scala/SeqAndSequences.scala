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

  }
}
