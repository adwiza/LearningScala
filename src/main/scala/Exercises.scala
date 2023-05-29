package org.learn.scala

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


  }
}
