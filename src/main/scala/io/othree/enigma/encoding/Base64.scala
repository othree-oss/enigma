package io.othree.enigma.encoding

trait Base64 {

  def encode(value: Array[Byte]) : String
  def decode(value: String) : Array[Byte]

}
