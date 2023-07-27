package org.learn.scala

object ObjectsCaseClassesTraits {
  def main (args: Array[String]): Unit = {

    object Hello { println("in Hello"); def hi = "hi"}

    println(Hello.hi)
    println(Hello.hi)

    object HtmlUtils {
      def removeMarkup(input: String) = {
        input

          .replaceAll("""</?\w[^>]*>""", "")
          .replaceAll("<.*>", "")
      }
    }
    val html = "<html><body><h1>Introduction</h1></body></html>"
    val text = HtmlUtils.removeMarkup(html)

    println(text)

    class Multiplier(val x: Int) { def product(y: Int) = x * y }

    object Multiplier { def apply(x: Int) = new Multiplier(x) }

    val tripler = Multiplier(3)
    val result = tripler.product(13)

    println(tripler)
    println(result)

    object DBConnection {
      private val db_url = "jdbc://localhost"
      private val db_user = "franken"
      private val db_pass = "berry"
      def apply() = new DBConnection
    }

    class DBConnection {
      private val props = Map(
        "url" -> DBConnection.db_url,
        "user" -> DBConnection.db_user,
        "pass" -> DBConnection.db_pass
      )
      println(s"Created new connection for " + props("url"))
    }

    val conn = DBConnection()
    println(conn)

    case class Character(name: String, isThief: Boolean)

    val hh = Character("Hadrian", true)
    val r = hh.copy(name = "Royce")

    println(hh == r)
    println(r)

    hh match {
      case Character(x, true) => println(s"$x is a thief")
      case Character(x, false) => println(s"$x is not a thief")
    }

    trait HtmlUtils2 {
      def removeMarkup(input: String) = {
        input
          .replaceAll("""</?\w[^>]*>""", "")
          .replaceAll("<.*>", "")
      }
    }

    class Page(val s: String) extends HtmlUtils2 {
      def asPlainText = removeMarkup(s)
    }

    println(new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText)

    trait SafeStringUtils {
      // Returns a trimmed version of the string wrapped in an Option,
      // or None if the trimmed string is empty.
      def trimToNone(s: String): Option[String] = {
        Option(s) map(_.trim) filterNot(_.isEmpty)
      }
    }
    class Page2(val s: String) extends SafeStringUtils with HtmlUtils2 {
      def asPlainText: String = {
        trimToNone(s) map removeMarkup getOrElse "n/a"
      }
    }
    println("$" * 50)
    println(new Page2("<html><body><h1>Introduction</h1></body></html>").asPlainText)
    println(new Page2(" ").asPlainText)
    println(new Page2(null).asPlainText)

    trait Base { override def toString = "Base"}

    class A extends Base { override def toString = "A->" + super.toString }
    trait B extends Base { override def toString = "B->" + super.toString}
    trait C extends Base { override def toString = "C->" + super.toString }
    class D extends A with B with C { override def toString = "D->" + super.toString }
    println(new D())

    class RGBColor(val color: Int) { def hex = f"$color%06X"}

    val green = new RGBColor(255 << 8).hex
    println(green)
    trait Opaque extends RGBColor { override def hex = s"${super.hex}FF" }
    trait Sheer extends RGBColor { override def hex = s"${super.hex}33" }

    class Paint(color: Int) extends RGBColor(color) with Opaque

    class Overlay(color: Int) extends RGBColor(color) with Sheer

    val red =  new Paint(128 << 16).hex
    val blue = new Overlay(192).hex
    println(red, blue)

    class AA { def hi = "hi"}

    trait BB { self: AA =>
      override def toString = "B: " + hi
    }
    class CC extends AA with BB

    println(new CC())

    class TestSuite(suiteName: String) { def start() {} }
    trait RandomSeed { self: TestSuite =>
      def randomStart(): Unit = {
        util.Random.setSeed(System.currentTimeMillis)
        self.start()
      }
    }
    class IdSpec extends TestSuite("ID Test") with RandomSeed {
      def testId() { println(util.Random.nextInt != 1) }

      override def start() { testId() }
      println("Starting...")
      randomStart()
    }
    class AAA
    trait BBB { self: AAA => }
    val a = new AAA with BBB {}
    println(a)

    class User(val name: String) {
      def suffix = ""
      override def toString = s"$name$suffix"
    }
    trait Attorney { self: User => override def suffix = ", esq." }
    trait Wizard { self: User => override def suffix = ", Wizard" }
    trait Reverser { override def toString = super.toString.reverse }
    val h = new User("Harry P") with Wizard
    val g = new User("Ginny W") with Attorney
    val l = new User("Luna L") with Wizard with Reverser
    println(h, g, l)

    case class Raceipt(id: Int, amount: Double, who: String, title: String)

    {
      val latteReceipt = Raceipt(123, 4.12, "fred", "Mediul Latte")
      import latteReceipt._
      println(s"Sold a $title for $amount$$ to $who")
    }

    import util.Random._
    val letters = alphanumeric.take(20).toList.mkString
    val numbers = shuffle(1 to 20)
    println(letters)
    println(numbers)



  }
}
