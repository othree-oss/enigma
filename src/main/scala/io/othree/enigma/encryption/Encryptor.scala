package io.othree.enigma.encryption

trait Encryptor {

  def encrypt(key: Array[Byte], iv: Array[Byte], message: Array[Byte]): Array[Byte]
  def decrypt(key: Array[Byte], iv: Array[Byte], message: Array[Byte]): Array[Byte]

}
