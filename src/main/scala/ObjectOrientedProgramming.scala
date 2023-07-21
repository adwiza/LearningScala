package org.learn.scala

import java.util.Date

object ObjectOrientedProgramming {
  def main(args: Array[String]): Unit = {

    class User

    val u = new User
    println(u)
    val isAnyRef = u.isInstanceOf[AnyRef]
    println(isAnyRef)

  class Usr {
    val name: String = "Yubaba"
    def greet: String = s"Hello from $name"
    override def toString = s"User ($name)"
  }

  val uu = new Usr
  println(uu.greet)
    class Usrn(n: String) {
      val name: String = n

      def greet: String = s"Hello from $name"

      override def toString = s"User ($name)"
    }
  val uuu = new Usrn("Ziniba")
  println(uuu.greet)


  class Userr(val name: String) {
    def greet: String = s"Hello from $name"
    override def toString = s"User ($name)"
  }

  val users = List(new Userr("Shoto"), new Userr("Art3mis"),
    new Userr("Aesch"))
  println(users)
  val sizes = users map(_.name.size)
  println(sizes)
  val sorted = users sortBy(_.name)
  val third = users find (_.name contains("3"))
  val greet = third map (_.greet) getOrElse "hi"

  println(sorted)
  println(greet)

  class A {
    def hi = "hello from A"
    override def toString = getClass.getName
  }
    class B extends A
    class C extends B { override def hi = "hi C -> " + super.hi}

    val hiA = new A().hi
    println(hiA)
    val hiB = new B().hi
    val hiC = new C().hi
    println(hiB)
    println(hiC)

    val a: A = new A
    println(a)
    val aa: A = new B
//    val b: B = new A Type mismatch error
    val b: B = new B
    println(aa)
    println(b)

    val misc = List(new C, new A, new B)
    println(misc)

    val messages = misc.map(_.hi).distinct.sorted
    println(messages)

//    Syntax: Defining a Simple Class
//    class <identifier> [extends <identifier>] [{fields, methods, and classes}]

    class Car(val make: String, var reserved: Boolean) {
      def reserve(r: Boolean): Unit = { reserved = r}
    }

    val t = new Car("Toyota", false)
    t.reserve(true)
    println(s"My ${t.make} is now reserved? ${t.reserved}")

    val t2 = new Car(reserved = false, make = "Tesla")
    println(t2.make)

    class Lotus(val color: String, reserved: Boolean) extends Car("Lotus", reserved)
    val l = new Lotus("Silver", false)
    println(s"Requested a ${l.color} ${l.make} ${l.reserved}")

    class Carr(val make: String, var reserved: Boolean = true,
               val year: Int = 2015) {
      override def toString = s"$year, $make, reserved = $reserved"

      }

    val acr = new Carr("Acura")
    val ll = new Carr("Lexus", year = 2010)
    val p = new Carr(reserved = false, make = "Porsche")
    println(acr)
    println(ll)
    println(p)

    class Singular[A](element: A) extends Iterable[A] {
      override def foreach[B](f: A => B): Unit = f(element)

      def iterator: Iterator[A] = ???
    }
    val pp = new Singular("Planes")
    pp foreach println

    abstract class Caar {
      val year: Int
      val automatic: Boolean = true
      def color: String
    }
//    new Caar() # class Caar is abstract; cannot be instantiated
    class RedMini(val year: Int) extends Caar {
      def color = "Red"
    }
    val m: Caar = new RedMini(2005)
    class  Mini(val year: Int, val color: String) extends Caar
    val redmMini: Caar = new Mini(2005, "Red")
    println(s"Got a ${redmMini.color} Mini")

    abstract class Listener { def trigger }
    val myListener = new Listener {
      def trigger { println(s"Trigger at ${new Date()}") }
    }
    myListener.trigger

    class Listening {
      var listener: Listener = null
      def register(l: Listener) { listener = l}
      def sendNotification() { listener.trigger }
    }
    val notification = new Listening()
    notification.register(new Listener {
      def trigger { println(s"Trigger at ${new Date()}") }
    })
    notification.sendNotification()

    class Printer(msg: String) {
      def print(s: String): Unit = println(s"$msg: $s")
      def print(l: Seq[String]): Unit = print(l.mkString(", "))
    }
    new Printer("Today's Report").print("Foggy" :: "Rainy" :: "Hot" :: Nil).toString








  }
}
