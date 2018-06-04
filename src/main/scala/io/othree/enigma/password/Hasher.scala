package io.othree.enigma.password

import io.othree.enigma.models.RandomPassword

trait Hasher {

  def generatePassword(password: String, salt: Array[Byte]): Array[Byte]

  def validatePassword(originalPass: String, storedPass: Array[Byte], salt: Array[Byte]): Boolean

  def getSalt(): Array[Byte]

  def generateRandomPassword(length: Int): RandomPassword
}
