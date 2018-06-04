package io.othree.enigma.encoding

import java.util.{Base64 => B64}

class Base64Provider extends Base64 {
  override def encode(value: Array[Byte]): String = {
    B64.getEncoder.encodeToString(value)
  }

  override def decode(value: String): Array[Byte] = {
    B64.getDecoder.decode(value)
  }
}
