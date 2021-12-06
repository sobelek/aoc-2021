fun main() {
    fun part1(input: List<String>): Int {
        var horizontal: Int = 0
        var depth: Int = 0

        for (command_tuple in input) {
            val commands = command_tuple.split(' ')
            val command = commands[0]
            val value = commands[1].toInt()
            when (command){
                "forward" -> horizontal += value
                "down" -> depth += value
                "up" -> depth -=value
            }

        }
        println("Horizontal: " + horizontal + " depth: " + depth)
        return horizontal*depth
    }

    fun part2(input: List<String>): Int {
        var horizontal: Int = 0
        var depth: Int = 0
        var aim: Int = 0

        for (command_tuple in input) {
            val commands = command_tuple.split(' ')
            val command = commands[0]
            val value = commands[1].toInt()
            when (command){
                "forward" -> {
                    horizontal += value
                    depth += (aim * value)
                }
                "down" -> aim += value
                "up" -> aim -=value
            }

        }
        println("Horizontal: " + horizontal + " depth: " + depth)
        return horizontal*depth
    }
    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}