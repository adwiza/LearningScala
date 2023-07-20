package org.learn.scala

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.{DateTimeFormatter, FormatStyle}
import java.util.Date
import scala.Console.println
import scala.annotation.tailrec
import scala.math.Ordered.orderingToOrdered
import scala.math.{exp, pow}
import scala.math.Ordering.Implicits.{infixOrderingOps, seqOrdering}

object Exercises {

  def main (args: Array[String]): Unit = {
    val inputValue = 2.7255
    println("You owe $%.2f".format(inputValue))

    def ToF(x: Double): Int = {
      val result = (x * 9 / 5) + 32
      result.toInt
    }

    println("Result: " + ToF(21.0))

    val flag: Boolean = false
    val result: Boolean = (flag == false)
    println(result)

    val num = 128

    val cha = num.toChar
    println(cha.getClass)
    val str = cha.toString
    println(str.getClass)
    val dbl = cha.toDouble
    println(dbl.getClass)
    val int = dbl.toInt
    println(int.getClass)

    val sentence = "Frank,123 Main,925-555-1943,95122"

    val pattern = raw"""(\d+)-(\d+)-(\d+)""".r
    val all = pattern.findAllIn(sentence).toList.head
    val one, two, three = all.split("-")
    val digOne = one.apply(0).toInt
    val digTwo = two.apply(1).toInt
    val digThree = three.apply(2).toInt

    println(all)
    println(digOne, digOne.getClass)
    println(digTwo, digTwo.getClass)
    println(digThree, digThree.getClass)
    println("****" * 50)

    val x = List.range(1, 101)
    val z = x.grouped(5).toList
    for { xxx <- z.take(x.size) }
      { println(xxx.mkString(", ")) }

    println("****" * 50)
    val xx = (1 to 100)
    for { yyy <- xx.take(x.size)} if (yyy % 15 == 0)
      println("typesafe ", yyy)
    else if (yyy % 3 == 0)
      println("type ", yyy)
    else if (yyy % 5 == 0)
      println("safe ", yyy)

println("***" * 30)

    /*
    This function calculates the area of the circle
    by the radius
     */
    def circleArea(r: String) = { if (r.isEmpty) null else 3.14 * (r.toDouble * r.toDouble) }
    println("Area of a circle is: " + circleArea("6"))

    def factorial(n: Int): Unit = {
      if (n == 5)
        n
      else if (n <= 50) factorial(n - 5)
      else factorial(n)
      println(n)
    }

    factorial(50)

    def convertCurrentTime(date: Long): String = {
      val dataString = new Date(date)
      new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(dataString)
    }

    println(convertCurrentTime(System.currentTimeMillis()))

    def XinY(x: Double, y: Double): Unit = {
      val result = pow(x, y)
      println(result.toString)
    }

    XinY(2, 4)

    def coordCalc(x1:Double, y1:Double, x2:Double, y2:Double) = {
      val result = (x1-x2, y1-y2)
      result
    }
    println(coordCalc(1.2, 4.4, 3.6, 7.8))

    def IntConverter(tup: Any) = {
      tup match {
        case (a: String, b: Any) => println(a.toInt, b)
        case (a: Int, b: Any) => println(a, b)
      }
    }

    def SixValuesTuple(a:Any, b: Any, c: Any) = {
      val tup = (a, b, c, a.toString, b.toString, c.toString)
      tup

    }
    println(SixValuesTuple(true, 22.25, "yes"))

// Exercises 81
    def lit(a: Int, b: Int) = {
      scala.math.max(a, b)
    }
    println(lit(30, 49))

    def llit(a: Int, c: Int) = {
      scala.math.max(a, c)
    }
    println(llit(lit(30, 49), 50))

    def smallInt(): Int = {
      val a = util.Random.nextInt()
      val b = util.Random.nextInt()
      println(f"a = ${a} b = ${b}")
      scala.math.min(a, b)
    }
    println("Smallest ", smallInt())

    def fnc(x: Int) = {
      def insidefnc(z:Int) =
        x * z
      insidefnc(5)
    }
    println(fnc(5))

    def fzero[A](x: A)(f: A => Double): A = { f(x); x }

    println(fzero(1.45)(exp))

    def p(x: Int): Boolean = {
      if (x >= 100) true
      else false
    }

    def f(x: Int) = x * x

    def conditional(x: Int) = {
      if (p(x)) f(x)
      else x
    }
    println(conditional(557))

    println("*" * 50)
// 1.
    def isOdd(number: Int) = number % 2 == 0

    val odds = Seq.range(0, 20).filter(isOdd)
    println("Filter odds")
    println(odds)

    val twentyNumbers = List.range(0, 20)
    val odds2 = twentyNumbers.filter(_ % 2 == 0)
    println("Filter odds2")
    println(odds2)
// 2. Factors function
    def factor(x: Int): List[Int] = {
      @tailrec
      def foo(x: Int, a: Int = 2, list: List[Int] = Nil): List[Int] = a*a > x match {
        case false if x % a == 0 => foo(x / a, a    , a :: list)
        case false               => foo(x    , a + 1, list)
        case true                => x :: list
      }
      foo(x)
    }
    println("Factor is " + factor(15))
    val newList = List(9, 11, 13, 15)
    println {
      newList.flatMap(factor)
    }
// 3.
    def first[A](items: List[A], count: Int): List[A] = {
      items.slice(0, count)
    }
    println(first(List('a','t','o'), 2))
// 4.
    val myList = List("abc", "abcd", "abcdf")
    println(myList.maxBy(_.length))

// 5.
    def reverseList[A](list: List[A]): List[A] = {
      @tailrec
      def rlRec[A](result: List[A], list: List[A]): List[A] = {
        list match {
          case Nil => result
          case (x :: xs) => {
            rlRec(x :: result, xs)
          }
        }
      }

      rlRec(Nil, list)
    }
    println(reverseList(myList))

//  7.
    val url = "https://api.coindesk.com/v1/bpi/currentprice.json"
    val l: List[String] = io.Source.fromURL(url).getLines.toList

    println(l.head)

    println("&" * 50)

// 1.

    def fibTR(num: Int): BigInt = {
      @tailrec
      def fibFcn(n: Int, acc1: BigInt, acc2: BigInt): BigInt = n match {
        case 0 => acc1
        case 1 => acc2
        case _ => fibFcn(n - 1, acc2, acc1 + acc2)
      }

      fibFcn(num, 0, 1)
    }
    println(fibTR(20))
  }
}
