package io.othree.enigma.password

import io.othree.aok.BaseTest
import io.othree.enigma.random.SHA1Randomizer
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PBKDF2KeyGeneratorTest extends BaseTest {
  "othree.enigma.password.PBKDF2KeyGenerator" when {
    "calling method generateKey" must {
      "generate a randomkey " in {
        val salt = new SHA1Randomizer(64*8).random()
        val pbk = new PBKDF2KeyGenerator(PBKDF2Algorithm.PBKDF2WithHmacSHA256,1000,64*8)
        val key = pbk.generateKey("carlos",salt)
        key.length shouldBe 64
        key.getClass shouldEqual classOf[Array[Byte]]
      }
    }
    "calling method generateKey" must {
      "validate that 2 passwordhashed with the same password and salt is the same" in {
        val salt = new SHA1Randomizer(64*8).random()
        val pbk = new PBKDF2KeyGenerator(PBKDF2Algorithm.PBKDF2WithHmacSHA256,1000,64*8)
        val key = pbk.generateKey("carlos",salt)
        val key2 = pbk.generateKey("carlos",salt)
        key shouldEqual key2
      }
    }
    "calling method generateKey" must {
      "validate that 2 passwordhashed with the different password and same salt is different" in {
        val salt = new SHA1Randomizer(64*8).random()
        val pbk = new PBKDF2KeyGenerator(PBKDF2Algorithm.PBKDF2WithHmacSHA256,1000,64*8)
        val key = pbk.generateKey("carlos",salt)
        val key2 = pbk.generateKey("juan",salt)
        key should not equal key2
      }
    }
  }
}
