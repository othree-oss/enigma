package io.othree.enigma.random

trait Randomizer {

  def nextBytes(bytes: Array[Byte]): Array[Byte]

  def random(): Array[Byte]

  def randomAlphaNumeric(length: Int): String
}
