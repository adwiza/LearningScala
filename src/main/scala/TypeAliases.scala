package org.learn.scala

object TypeAliases {
  def main(args: Array[String]): Unit = {

    object TypeFun {
      type Whole = Int
      val x: Whole = 5

      type UserInfo = Tuple2[Int, String]
      val u: UserInfo = new UserInfo(123, "George")

      type T3[A, B, C] = Tuple3[A, B, C]
      val things = new T3(1, 'a', true)
    }

    val x = TypeFun.x
    val u = TypeFun.u
    val things = TypeFun.things
    println(x, u, things)

    class User(val name: String)
    trait Factory { type A; def create: A}
    trait UserFactory extends Factory {
      type A = User
      def create = new User("")
    }

    trait Factory2[A] {def create: A }
    trait UserFactory2 extends Factory2[User] { def create = new User("")}

    class BaseUser(val name: String)
    class Admin(name: String, val level: String) extends BaseUser(name)
    class Customer(name: String) extends BaseUser(name)
    class PreferredCustomer(name: String) extends Customer(name)

    def check[A <: BaseUser](u: A) { if (u.name.isEmpty) println("Fail!") }

    check(new Customer("Fred"))
    check(new Admin("", "strict"))

    def recruit[A >: Customer](u: Customer): A = u match {
      case p: PreferredCustomer => new PreferredCustomer(u.name)
      case c: Customer => new Customer(u.name)
    }

    val customer = recruit(new Customer("Fred"))
    val preferred = recruit(new PreferredCustomer("George"))

    abstract class  Card {
      type UserType <: BaseUser
      def verify(u: UserType): Boolean
    }
    class SecurityCard extends Card {
      type UserType = Admin
      def verify(u: Admin) = true
    }

    val v1 = new SecurityCard().verify(new Admin("George", "high"))
    println(v1)

    class GiftCard extends Card {
      type UserType = Customer
      def verify(u: Customer) = true
    }

    val v2 = new GiftCard().verify(new Customer("Fred"))
    println(v2)

    class Car1 { override def toString = "Car1()" }

    class Volvo1 extends Car1 { override def toString = "Volvo1()" }
    val c: Car1 =  new Volvo1()

    case class Item[+A](a: A) { def get: A = a }
    val cc: Item[Car1] = new Item[Volvo1](new Volvo1)

    val auto = cc.get
    println(auto)

    class Check[-A] { def check(a: A) = {} }
    class Check2[A] { def check(a: A) = {} }

    class Car; class Volvo extends Car; class VolvoWagon extends Volvo

    def item(v: Item[Volvo]) { val c: Car = v.get }
//    def check(v: Check[Volvo]) { v.check(new VolvoWagon()) }

//    item( new Item[Car](new Car()))
    item( new Item[Volvo](new Volvo))
    item( new Item[VolvoWagon](new VolvoWagon))
//    check( new Check[Car]())
//    check( new Check[Volvo]() )
  }

}
