package io.othree.enigma.models

case class RandomPassword(password: Array[Byte],
                          salt: Array[Byte])
