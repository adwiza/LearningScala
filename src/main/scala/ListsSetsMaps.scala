package org.learn.scala

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








  }
}
