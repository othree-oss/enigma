package io.othree.enigma.random

import java.security.SecureRandom

import scala.util.Random

class SHA1Randomizer(randomSize: Int) extends Randomizer {
  val secureRandom = SecureRandom.getInstance("SHA1PRNG")

  override def nextBytes(bytes: Array[Byte]): Array[Byte] = {
    secureRandom.nextBytes(bytes)
    bytes
  }

  override def random(): Array[Byte] = {
    val result = new Array[Byte](randomSize)
    nextBytes(result)
  }

  override def randomAlphaNumeric(length: Int): String = {
    Random.alphanumeric.take(randomSize).mkString
  }
}
