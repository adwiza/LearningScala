package org.learn.scala

object HOFs {

  def main(args: Array[String]): Unit = {

    def safeStringOp(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    def reverser(s: String) = s.reverse

    println(safeStringOp("Ready", reverser))

    val doubler = (x: Int) => x * 2

    val doubled = doubler(22)

    println(doubled)

    val greeter = (name: String) => s"Hello, $name"

    val hi = greeter("world")

    println(hi)

    def max(a: Int, b: Int) = if (a > b) a else b

    val maximize: (Int, Int) => Int = max
    println(maximize(84, 96))

    def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50
    val start = () => "=" * 50 + "\nStarting NOW\n" + "=" * 50

    println( start() )

    val doubler2: Int => Int = _ * 2

    def safeStringOp2(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    println(safeStringOp2(null, _.reverse))
    println(safeStringOp2("Ready", _.reverse))

    def combination(x: Int, y: Int, f: (Int, Int) => Int) = f(x, y)

    println(combination(23, 12, _ * _))

    def tripleOp(a: Int, b: Int, c: Int, f: (Int, Int, Int) => Int) = f(a, b, c)

    println(tripleOp(23, 92, 14, _ * _ + _))

    def tripleOp2[A, B](a: A, b: A, c: A, f: (A, A, A) => B) = f(a, b, c)

    println(tripleOp2[Int, Int](23, 92, 14, _ * _ + _))
    println(tripleOp2[Int, Double](23, 92, 14, 1.0 * _ / _ / _))
    println(tripleOp2[Int, Boolean](23, 92, 14, _ > _ + _))

    def factorOf(x: Int, y: Int) = y % x == 0

    val f = factorOf _
    val x = f(7, 20)
    println(x)

    val multiplyOf3 = factorOf(3, _: Int)
    val  y = multiplyOf3(78)
    println(y)

    def factorOf2(x: Int)(y: Int) = y % x == 0

    val isEven = factorOf2(2) _
    val z = isEven(32)
    println(z)

    def doubles(x: => Int) = {
      println("Now doubling " + x)
      x * 2
    }
    println(doubles(5))

    def ff(i: Int) = { println(s"Hello from f($i)"); i }
    println(doubles( ff(8) ))

    val statusHandler: Int => String = {
      case 200 => "Okay"
      case 400 => "You Error"
      case 500 => "Our error"
    }

    println(statusHandler(200))
    println(statusHandler(400))

    def safeStringOp3(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    def safeStringOp4(s: String)(f: String => String) = {
      if (s != null) f(s) else s
    }

    val uuid = java.util.UUID.randomUUID().toString
    val timedUUID = safeStringOp3(uuid, { s =>
      val now = System.currentTimeMillis()
      val timed = s.take(24) + now
      timed.toUpperCase
      })

//    val uuid = java.util.UUID.randomUUID().toString
//    val timedUUID = safeStringOp4(uuid) { s =>
//      val now = System.currentTimeMillis()
//      val timed = s.take(24) + now
//      timed.toUpperCase
//    }

    println(timedUUID)

    def timer[A](f: => A): A = {
      def now = System.currentTimeMillis
      val start = now; val a = f; val end = now
      println(s"Executed in ${end - start} ms")
      a
    }

    val veryRandomAmount = timer {
      util.Random.setSeed(System.currentTimeMillis)
      for (i <- 1 to 100000) util.Random.nextDouble
      util.Random.nextDouble
    }
    println(veryRandomAmount)



  }
}
