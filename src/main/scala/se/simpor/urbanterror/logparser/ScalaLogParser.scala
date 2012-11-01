package se.simpor.urbanterror.logparser

import collection.mutable

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
    var killedBy = mutable.ListBuffer[Player]()
    var killedPlayer = mutable.ListBuffer[Player]()

  }

  var players = new mutable.HashMap[String, Player]

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


    for ((key, value) <- players) {

      println(value.name + ", killed: " + value.killedPlayer.length + ", deaths: " + value.killedBy.length)
    }
  }

  def initRound(row: String) {
    println(row)
  }

  def kill(row: String) {
    println(row)
    val split = row.split("\\:")
    val text = split(3)
    val info = text.split("(killed)|(by)")

    val player1 = getPlayer(info(0))
    val player2 = getPlayer(info(1))

    if (!info(2).contains("MOD_CHANGE_TEAM")) {
      player1.killedPlayer += player2
      player2.killedBy += player1
    }
  }

  def getPlayer(player: String): Player = {
    if (!(players contains player)) {
      players += player -> new Player
      players(player).name = player.trim
    }
    players(player)
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
