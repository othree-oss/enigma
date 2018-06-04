package io.othree.enigma.random

import io.othree.aok.BaseTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SHA1RandomizerTest extends BaseTest {
  "io.othree.enigma.random.SHA1Randomizer" when {
    "calling method random" must {
      "generate a random Array" in {
        val sha1 = new SHA1Randomizer(10)
        val rand = sha1.random()
        rand.length shouldBe 10
      }
    }
    "calling method nextBytes" must {
      "modify a random Array" in {
        val sha1 = new SHA1Randomizer(10)
        val arr = Array[Byte](0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        val rand = sha1.nextBytes(arr)
        arr shouldEqual rand
        rand.count(byte => byte == 0) should be < arr.length

      }
    }
    "callig method randomAlphaNumeric" must {
      "generate a random string" in {
        val sha1 = new SHA1Randomizer(10).randomAlphaNumeric(10)
        sha1.getClass shouldBe classOf[String]
        sha1.length shouldBe 10
      }
    }
  }
}
