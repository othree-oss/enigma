package io.othree.enigma.password

import io.othree.aok.BaseTest
import io.othree.enigma.random.Randomizer
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class PasswordHasherTest extends BaseTest {

  "othree.enigma.password.Password" when {
    "calling method generatePassword" must {
      "generate a password hashed " in {
        val randomizer = mock[Randomizer]
        val keyGenerator = mock[KeyGenerator]
        val password = new PasswordHasher(randomizer, keyGenerator)
        val salt = password.getSalt()
        when(keyGenerator.generateKey("pollo", salt)).thenReturn(Array[Byte](10))
        val passHashed = password.generatePassword("pollo", salt)
        passHashed.length shouldBe 1
        passHashed(0) shouldBe 10
      }
    }

    "calling method getSalt" must {
      "generate a random salt " in {

        val randomizer = mock[Randomizer]
        when(randomizer.random()).thenReturn(Array[Byte](12))
        val keyGenerator = mock[KeyGenerator]
        val pass = new PasswordHasher(randomizer, keyGenerator)
        val salt = pass.getSalt()
        salt.length shouldBe 1
        salt(0) shouldBe 12
      }
    }
    "calling method validatepassword" must {
      "validate same password" in {
        val randomizer = mock[Randomizer]
        val keyGenerator = mock[KeyGenerator]
        val password = new PasswordHasher(randomizer, keyGenerator)
        val salt = password.getSalt()
        when(keyGenerator.generateKey("Hola", salt))
          .thenReturn(Array[Byte](10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10))
          .thenReturn(Array[Byte](10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10))
        val passhashed = password.generatePassword("Hola", salt)
        val istrue = password.validatePassword("Hola", passhashed, salt)
        istrue shouldEqual true
      }
    }
    "calling method generateRandomPassword" must {
      "return an RandomPassword Object" in {
        val randomizer = mock[Randomizer]
        when(randomizer.random()).thenReturn(Array[Byte](10))
        when(randomizer.randomAlphaNumeric(10)).thenReturn("hola")
        val keyGenerator = mock[KeyGenerator]
        when(keyGenerator.generateKey("hola",Array[Byte](10))).thenReturn((Array[Byte])(10,10))
        val passwordHasher = new PasswordHasher(randomizer, keyGenerator)
        val randomPassword = passwordHasher.generateRandomPassword(10)

        randomPassword.password shouldBe  Array[Byte](10,10)
        randomPassword.salt shouldBe Array[Byte](10)
      }
    }
  }


}
