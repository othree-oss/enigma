package io.othree.enigma.encoding

import io.othree.aok.BaseTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Base64ProviderTest extends BaseTest {
  "Base64Provider" when {
    val base64 = new Base64Provider

    "encoding bytes to Base64" must {
      "return a valid string" in {
        val result = base64.encode("user:password".getBytes)

        result shouldBe "dXNlcjpwYXNzd29yZA=="
      }
    }

    "decoding bytes to Base64" must {
      "return the expected Array of bytes" in {
        val expected = "user:password".getBytes

        val result = base64.decode("dXNlcjpwYXNzd29yZA==")

        result.deep shouldBe expected.deep
      }
    }
  }
}
