package org.learn.scala

import java.io.File

object Arrays {
  def main(args: Array[String]): Unit = {

    val colors = Array("red", "green", "blue")
    colors(0) = "purple"
    println(colors.toList)
    val files = new File(".").listFiles
    println(files.toList)

    val idea = files map(_.getName) filter(_ endsWith ".idea")
    println(idea.toList)




  }
}
