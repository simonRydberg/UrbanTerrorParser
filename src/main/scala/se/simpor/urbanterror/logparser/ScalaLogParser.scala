package se.simpor.urbanterror.logparser

/**
 * Created with IntelliJ IDEA.
 * User: simon.rydberg
 * Date: 2012-11-01
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
object ScalaLogParser {

  class Player {
    var name = ""
    var kill = 0
    var deaths = 0
  }



  def parseLog(logFile: String) {
    val source = scala.io.Source.fromFile(logFile)
    val lines: Iterator[String] = source.getLines

    for (row <- lines) {

      row match {
        case x if row.contains("InitRound:") => initRound(row)
        case x if row.contains("Hit:") => hit(row)
        case x if row.contains("Kill:") => kill(row)
        case x if row.contains("SurvivorWinner:") => survivorWinner(row)
        case _ =>
      }
    }
    source.close()
  }

  def initRound(row: String) {
    println(row)
  }

  def kill(row: String) {
    println(row)
  }

  def hit(row: String) {
    println(row)
  }

  def survivorWinner(row: String) {
    println(row)
  }


  def main(args: Array[String]) {
    parseLog("games.log")
  }

}
