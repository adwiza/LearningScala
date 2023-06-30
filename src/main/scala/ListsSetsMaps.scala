package org.learn.scala

import java.util
import scala.jdk.CollectionConverters._

object ListsSetsMaps {
  def main(args: Array[String]): Unit = {

    val numbers = List(32, 95, 24, 21, 17)
    val colors = List("red", "green", "blue")

    println(s"I have ${numbers.size} numbers: ${numbers}")
    println(s"I have ${colors.size} colors: ${colors}")

    println(colors.head)
    println(colors.tail)
    println(colors(1))
    println(colors(2))


    var total = 0;
    for (i <- numbers) {
      println("Сейчас i =" + " " + i); total += i
    }
    println("Сумма всех i =" + " " + total)

    //    for (c <- colors) { println(c) }

    colors.foreach((c: String) => println(c))

    val sizes = colors.map((c: String) => c.size)
    println(sizes)

    val tot = numbers.reduce((a: Int, b: Int) => {
      println(a, b); a + b
    })
    println(tot)

    val unique = Set(10, 20, 30, 20, 20, 10)
    println(unique)

    val sum = unique.reduce((a: Int, b: Int) => a + b)
    println(sum)

    val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00,
      "blue" -> 0xFF)

    val redRGB = colorMap("red")
    println(redRGB)

    val cyanRGB = colorMap("green") | colorMap("blue")
    println(cyanRGB)

    val hasWhite = colorMap.contains("white")
    println(hasWhite)

    for (pairs <- colorMap) {
      println(pairs)
    }

    val oddsAndEvents = List(List(1, 3, 5), List(2, 4, 6))
    println(oddsAndEvents.flatten)

    val keyValues = List(('A', 65), ('B', 66), ('C', 67))
    println(keyValues)

    val primes = List(2, 3, 4, 5, 7, 11, 13)

    //    val first = primes(0)
    val first = primes.head
    val four = primes(3)
    val remaining = primes.tail
    println(first, four)
    println(remaining)

    var i = primes

    while (!i.isEmpty) {
      print(i.head + ", "); i = i.tail
    }
    print("\n")

    def visit(i: List[Int]) {
      if (i.size > 0) {
        print(i.head + ", ");
        visit(i.tail)
      }
    }

    println("visit output:")
    visit(primes)

    while (i != Nil) {
      print(i.head + ", "); i = i.tail
    }
    print("\n")

    val l: List[Int] = List()
    println(l == Nil)

    val m: List[String] = List("a")
    println(m.head)
    println(m.tail == Nil)

    val numbers2 = 1 :: 2 :: 3 :: Nil
    println(numbers2)

    val first2 = Nil.::(1)
    println(first2, first2.tail == Nil)

    val second = 2 :: first2
    println(second.tail == first2)

    val third = first2 ::: second
    println(third)
    println("*" * 50)
    println(List(1, 2) ++ Set(3, 4, 5))
    println(List(1, 2) == List(1, 2))
    println(List(3, 5, 4, 3, 4).distinct)
    println(List('a', 'b', 'c', 'd').drop(2))
    println(List(23, 8, 14, 21).filter(_ > 18))
    println(List(List(1, 2), List(3, 4, 5)).flatten)
    println(List(1, 2, 3, 4, 5).filter(_ < 3))
    println(List(2, 3, 5, 7).slice(1, 3))
    println(List("apple", "one", "four").sortBy(_.length))
    println(List("apple", "carrot", "banana").sorted)
    println(List(2, 3, 5, 7, 11, 13).take(3))
    println(List(1, 2).zip(List("a", "b")))
    println("*" * 50)

    val f = List(23, 8, 14, 21) filter (_ > 18)
    val p = List(1, 2, 3, 4, 5) partition (_ < 3)
    val s = List("apple", "to") sortBy (_.length)
    println(f)
    println(p)
    println(s)

    // List appending operations
    val appended = List(1, 2, 3, 4) :+ 5
    val suffix = appended takeRight (3)
    val middle = suffix dropRight 2
    println(appended)
    println(suffix)
    println(middle)

    //    Mapping Lists

    println(List(0, 1, 0) collect {
      case 1 => "OK"
      case 0 => "Error"
    })

    println(List("milk,tea") flatMap (_.split(',')))
    println(List("milk", "tea") map (_.toUpperCase))

    //    Math reduction operations
    println(List(41, 59, 26).max)
    println(List(10.9, 32.5, 4.23, 5.67).min)
    println(List(5, 6, 7).product)
    println(List(34, 29, 18).contains(29))
    println(List(0, 4, 3).endsWith(List(4, 3)))
    println(List(24, 17, 32).exists(_ < 18))
    println(List(24, 17, 32).forall(_ < 18))
    println(List(0, 4, 3).startsWith(List(0)))

    println("*" * 50)
    val validations = List(true, true, false, true, true, true)
    val valid1 = !(validations contains false)
    println(valid1)
    val valid2 = validations forall (_ == true)
    println(valid2)
    val valid3 = validations.exists(_ == false) == false
    println(valid3)

    println("=" * 50)

    def contains(x: Int, l: List[Int]): Boolean = {
      var a: Boolean = false
      for (i <- l) {
        if (!a) a = (i == x)
      }
      a
    }

    val included = contains(19, List(46, 19, 92))
    println(included)

    def boolReduce(l: List[Int], start: Boolean)(f: (Boolean, Int) =>
      Boolean): Boolean = {
      var a = start
      for (i <- l) a = f(a, i)
      a
    }

    val included2 = boolReduce(List(46, 19, 92), false) { (a, i) =>
      if (a) a else i == 19
    }
    println(included2)

    def reduceOp[A, B](l: List[A], start: B)(f: (B, A) => B): B = {
      var a = start
      for (i <- l) a = f(a, i)
      a
    }

    val included3 = reduceOp(List(46, 19, 92), false) { (a, i) =>
      if (a) a else i == 19
    }
    println(included3)

    val answer = reduceOp(List(11.3, 23.5, 7.2), 0.0)(_ + _)
    println(answer)

    println("@" * 50)

    println(List(4, 5, 6).fold(0)(_ + _))
    println(List(4, 5, 6).foldLeft(0)(_ + _))
    println(List(4, 5, 6).foldRight(0)(_ + _))
    println(List(4, 5, 6).reduce(_ + _))
    println(List(4, 5, 6).reduceLeft(_ + _))
    println(List(4, 5, 6).reduceRight(_ + _))
    println(List(4, 5, 6).scan(0)(_ + _))
    println(List(4, 5, 6).scanLeft(0)(_ + _))
    println(List(4, 5, 6).scanRight(0)(_ + _))

    println("&" * 50)
    val included4 = List(46, 19, 92).foldLeft(false) { (a, i) =>
      if (a) a else (i == 19)
    }
    println(included4)

    val answer2 = List(11.3, 23.5, 7.2).reduceLeft(_ + _)
    println(answer2)

    println(List(24, 99, 104).mkString(", "))
    println(List('f', 't').toBuffer)
    println(Map("a" -> 1, "b" -> 2).toList)
    println(Set(1 -> true, 3 -> true).toMap)
    println(List(2, 5, 5, 3, 2).toSet)
    println(List(2, 5, 5, 3, 2).toString())

    println("#" * 50)

    println(List(12, 29).asJava)
    new util.ArrayList[5]().asScala
    val statuses = List(500, 404)
    val msg = statuses.head match {
      case x if x < 500 => "OK"
      case _ => "whoah, an error"
    }

    println(msg)
    val msg2 = statuses match {
      case x if x contains (500) => "has error"
      case _ => "okay"
    }
    println(msg2)

    val msg3 = statuses match {
      case List(404, 500) => "not found & error"
      case List(500, 404) => "error & not found"
      case List(200, 200) => "okay"
      case _ => "not sure what happened"
    }
    println(msg3)

    val msg4 = statuses match {
      case List(500, x) => s"Error followed by $x"
      case List(e, x) => s"$e followed by $x"
    }
    println(msg4)

    val head = List('r', 'g', 'b') match {
      case x :: xs => x
      case Nil => ' '
    }
    println(head)
    val code = ('h', 204, true) match {
      case (_, _, false) => 501
      case ('c', _, true) => 302
      case ('h', x, true) => x
      case (c, x, true) => {
        println(s"Did not expect code $c")
      }
    }
    println(code)
  }
}
