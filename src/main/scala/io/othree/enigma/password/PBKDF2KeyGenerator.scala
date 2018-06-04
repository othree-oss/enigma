package io.othree.enigma.password

import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

class PBKDF2KeyGenerator(algorithm: PBKDF2Algorithm.Value,
                         iterations: Int,
                         keySize: Int) extends KeyGenerator {
  override def generateKey(secret: String, salt: Array[Byte]): Array[Byte] = {
    val chars: Array[Char] = secret.toCharArray()
    val spec = new PBEKeySpec(chars, salt, iterations, keySize)
    val skf = SecretKeyFactory.getInstance(algorithm.toString)
    skf.generateSecret(spec).getEncoded()
  }
}
