package implementation;

import java.util.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the howManyGames function below.
fun howManyGames(p: Int, d: Int, m: Int, s: Int): Int {
    // Return the number of games you can buy
    var k = p
    var r = s
    var count = 0
    while (r >= k) {
        count++
        r -= k
        k = Math.max(k - d, m)
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val pdms = scan.nextLine().split(" ")

    val p = pdms[0].trim().toInt()

    val d = pdms[1].trim().toInt()

    val m = pdms[2].trim().toInt()

    val s = pdms[3].trim().toInt()

    val answer = howManyGames(p, d, m, s)

    println(answer)
}