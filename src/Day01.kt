import java.lang.Exception
import kotlin.streams.toList

fun main() {
    fun part1(input: List<Int>): Int {
        var prev = 0
        var num_of_increased = -1
        for (depth in input){
            if (depth > prev){
                num_of_increased += 1
            }
            prev = depth
        }
        return num_of_increased
    }

    fun part2(input: List<Int>): Int {
        var prev = 0
        var num_of_increased = -1
        var new_depths = mutableListOf<Int>()
        try {
            for ((index, depth) in input.withIndex()) {
                new_depths.add(depth + input[index + 1] + input[index + 2])
            }
        } catch(ex: Exception){
            println("Index out of range, expected :)")
        }
        for (depth in new_depths){
            if (depth > prev){
                num_of_increased += 1
            }
            prev = depth
        }
        return num_of_increased
    }
    val input = readInput("Day01").stream().map { it.toInt() }.toList()
    println(part1(input))
    println(part2(input))
}
