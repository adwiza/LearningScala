package org.learn.scala

object MutableCollections {
  def main(args: Array[String]): Unit = {
    val m = Map("AAPL" -> 597, "MSFT" -> 40)
    println(m)
    val n = m - "AAPL" + ("GOOG" -> 521)
    println(n)
    println(m)

    val nums = collection.mutable.Buffer(1)
    for (i <- 2 to 10) nums += i
    println(nums)

    val nums2 = collection.mutable.Buffer[Int]()
    for (i <- 1 to 10) nums2 += i
    println(nums2)

    val l = nums2.toList
    println(l)

    val b = m.toBuffer
    println(b)
    println(b dropInPlace 1)

    b += ("GOOG" -> 521)

    val nn = b.toMap
    println("nn " + nn)

    b += ("GOOG" -> 521)
    val ll = b.toList
    val s = b.toSet
    println(ll)
    println(s)




  }
}
