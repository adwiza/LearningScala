package org.learn.scala

object TryCollections {
  def main(args: Array[String]): Unit = {

    //    throw new Exception("No DB connection, exiting...")
    def loopAndFail(end: Int, failAt: Int): Int = {
      for (i <- 1 to end) {
        println(s"$i) ")
        if (i == failAt) throw new Exception("To many iterations")
      }
      end
    }

    loopAndFail(10, 11)

    val t1 = util.Try( loopAndFail(2, 3))
    println(t1)
    val t2 = util.Try{ loopAndFail(4, 2)}
    println(t2)

    def nextError = util.Try{ 1 / util.Random.nextInt(2) }
    val x = nextError
    val y = nextError
    println(x)
    println(y)

    val input = " 123 "
    val result = util.Try(input.toInt) orElse util.Try(input.trim.toInt)
    result foreach { r => println(s"Parsed '$input' to $r! ${r.getClass}") }
    val xx  = result match {
      case util.Success(xx) => Some(xx)
      case util.Failure(ex) => {
        println(s"Couldn't parse input '$input'")
        None
      }
    }
    println(xx)



  }
}
