package org.learn.scala
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
object JsonParse {
  def main(args: Array[String]): Unit = {

    val jsonText =
      """
        {
          "labels": [
            {
            "url": "https://api.github.com/repos/scala/scala/labels/tested",
            "name": "tested",
            "color": "d7e102"
            }
          ]
        }
    """
    case class Label(url: String, name: String)
    case class LabelDocument(labels: List[Label])
    implicit val formats = DefaultFormats
    val labelDoc = JsonMethods.parse(jsonText).extract[LabelDocument]
    val labels = labelDoc.labels
    val firstLabel = labels.headOption.map(_.name)
    println(firstLabel)
  }

}
