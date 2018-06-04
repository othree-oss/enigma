package io.othree.enigma.password

import io.othree.enigma.models.RandomPassword
import io.othree.enigma.random.Randomizer

class PasswordHasher(randomizer: Randomizer,
                     keyGenerator: KeyGenerator) extends Hasher {

  def generatePassword(password: String, salt: Array[Byte]): Array[Byte] = {
    keyGenerator.generateKey(password, salt)
  }

  def getSalt(): Array[Byte] = {
    randomizer.random()
  }

  def validatePassword(userPassword: String, storedPassword: Array[Byte], salt: Array[Byte]): Boolean = {
    val toComparePass: Array[Byte] = keyGenerator.generateKey(userPassword, salt)
    storedPassword.deep == toComparePass.deep
  }

  def generateRandomPassword(length: Int): RandomPassword = {
    val passwordRandomGenerated: String = randomizer.randomAlphaNumeric(length)
    val salt = getSalt()
    val password = generatePassword(passwordRandomGenerated, salt)
    RandomPassword(password, salt)
  }

}
