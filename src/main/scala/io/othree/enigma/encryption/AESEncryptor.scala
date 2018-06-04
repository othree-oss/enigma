package io.othree.enigma.encryption

import io.othree.enigma.exceptions.EnigmaException
import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}

class AESEncryptor extends Encryptor {
  override def encrypt(key: Array[Byte], iv: Array[Byte], message: Array[Byte]): Array[Byte] = {
    transform(Cipher.ENCRYPT_MODE, key, iv, message)
  }

  override def decrypt(key: Array[Byte], iv: Array[Byte], message: Array[Byte]): Array[Byte] = {
    transform(Cipher.DECRYPT_MODE, key, iv, message)
  }

  private def transform(mode: Int, key: Array[Byte], iv: Array[Byte], message: Array[Byte]): Array[Byte] = {
    val secretKey = new SecretKeySpec(key, "AES")
    val ivSpec = new IvParameterSpec(iv)

    try {
      val cipher = Cipher.getInstance("AES/CTR/NoPadding")
      cipher.init(mode, secretKey, ivSpec)

      cipher.doFinal(message)
    } catch {
      case e: Throwable =>
        throw new EnigmaException("Failed to transform message", e)
    }
  }
}
