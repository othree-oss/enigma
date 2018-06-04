package io.othree.enigma.password

trait KeyGenerator {

  def generateKey(secret: String, salt: Array[Byte]): Array[Byte]
}
