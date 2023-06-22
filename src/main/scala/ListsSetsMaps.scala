package org.learn.scala

import scala.Console.println
import scala.{::, List}

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

    colors.foreach( (c: String) => println(c))

    val sizes = colors.map( (c: String) => c.size)
    println(sizes)

    val tot = numbers.reduce( (a: Int, b: Int) => { println(a, b); a + b } )
    println(tot)

    val unique = Set(10, 20, 30, 20, 20, 10)
    println(unique)

    val sum = unique.reduce( (a: Int, b: Int) =>  a + b )
    println(sum)

    val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00,
      "blue" -> 0xFF)

    val redRGB = colorMap("red")
    println(redRGB)

    val cyanRGB = colorMap("green") | colorMap("blue")
    println(cyanRGB)

    val hasWhite = colorMap.contains("white")
    println(hasWhite)

    for (pairs <- colorMap) { println(pairs) }

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

    while (! i.isEmpty) { print(i.head + ", "); i = i.tail }
    print("\n")

    def visit(i: List[Int]) { if (i.size > 0) { print(i.head + ", ");
      visit(i.tail) } }
    println("visit output:")
    visit(primes)

    while (i != Nil) { print(i.head + ", "); i = i.tail }
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

    println(List("milk,tea") flatMap(_.split(',')))
    println(List("milk","tea") map(_.toUpperCase))












  }
}
