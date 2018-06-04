package io.othree.enigma.encryption

import io.othree.aok.BaseTest
import io.othree.enigma.encoding.Base64Provider
import io.othree.enigma.random.SHA1Randomizer
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AESEncryptorTest extends BaseTest {

  "AESEncryptor" must {
    "be able to encrypt and encrypt a message" in {
      val encryptor = new AESEncryptor

      val base64Provider = new Base64Provider
      val ivRandomizer = new SHA1Randomizer(16)
      val key = ivRandomizer.nextBytes(new Array[Byte](32))
      val iv = ivRandomizer.random()

      val aMessage = "Hello Othree!"

      val encryptedMessage = encryptor.encrypt(key, iv, aMessage.getBytes("UTF-8"))

      val decryptedMessage = encryptor.decrypt(key, iv, encryptedMessage)

      aMessage shouldEqual new String(decryptedMessage)
    }
  }

}
