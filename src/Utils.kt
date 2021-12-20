import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun power(base: Int, exponent: Int) = Math.pow(base.toDouble(), exponent.toDouble()).toInt()

fun toDecimal(binaryNumber : String) : Int {
    var sum = 0
    binaryNumber.reversed().forEachIndexed {
            k, v -> sum += v.toString().toInt() * power(2, k)
    }
    return sum
}