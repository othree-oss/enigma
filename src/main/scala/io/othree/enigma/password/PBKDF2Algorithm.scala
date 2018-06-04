package io.othree.enigma.password

object PBKDF2Algorithm extends Enumeration {
  val PBKDF2WithHmacSHA256, PBKDF2WithHmacSHA512 = Value
}
