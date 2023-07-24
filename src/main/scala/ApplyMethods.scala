package org.learn.scala

import java.util.Date
import scala.collection.mutable
import scala.util.Random.{javaRandomToRandom, nextInt, nextString}

object ApplyMethods {
  def main(args: Array[String]): Unit = {

   class Multiplier(factor: Int) {
     def apply(input: Int) = input * factor
   }

    val tripleMe = new Multiplier(3)
    println(tripleMe)
    val tripled = tripleMe.apply(10)
    println(tripled)
    val tripled2 = tripleMe(10)
    println(tripled2)

    val l = List('a', 'b', 'c')
    val character = l(1)
    println(character)

    class Randompoint {
      val x = { println("creating x"); util.Random.nextInt }
      lazy val y = { println("now y"); util.Random.nextInt }
    }

    val p = new Randompoint()
    println(s"Location is ${p.x}, ${p.y}")
    println(s"Location is ${p.x}, ${p.y}")

    println("Your new UUID is " + {import java.util.UUID; UUID.randomUUID})

    import java.util
    val d = new util.Date
    println(d)

    import collection.mutable._
    val b = new ArrayBuffer[String]
    b += "Hello"
    println(b)
    val q = new Queue[Int]
    q.enqueue(3, 4, 5)
    val pop = q.dequeue
    println(pop)
    println(q)

   import collection.mutable.{Queue, ArrayBuffer}
   val qq = new mutable.Queue[Int]
   val bb = new ArrayBuffer[String]
   val m = Map(1 -> 2)
   println(qq, bb, m)

   import collection.mutable.{Map=>MutMap}
   val m1 = Map(1 -> 2)
   println(m1)
   val m2 = MutMap(2 -> 3)
   m2.remove(2); println(m2)


   class User { protected val passwd = nextString(10); println(passwd)}
   class ValidUser extends User { def isValid = ! passwd.isEmpty }

   val isValid = new ValidUser().isValid
   println(isValid)

   class Userr(private var password: String) {
    def update(p: String): Unit = {
     println("Modifying the password!")
     password = p
    }
    def validate(p: String) = p == password
   }

   val u = new Userr("1234")
   println(u)
   val isValidd = u.validate("4567")
   println(isValidd)
   u.update("4567")
   val isValiddd = u.validate("4567")
   println(isValiddd)






  }
}
