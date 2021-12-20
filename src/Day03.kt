import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        val gamma_ones: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0)
        val gamma: MutableList<String> = mutableListOf("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0")
        val epsilon: MutableList<String> = mutableListOf("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0","0")

        for (code in input){
            for ((index, char) in code.withIndex()){
                println(index)
                when (char) {
                    '1' -> gamma_ones[index] += 1
                }
            }
        }

        val input_size = input.size

        for (index in 0.. 11) {
            if (gamma_ones[index] > input_size/2 )
            {
                gamma[index] = "1"
            }else {
                epsilon[index] = "1"
            }
        }
        var gamma_string = gamma.joinToString("")
        var gamma_int = toDecimal(gamma_string)
        var epsilon_string = epsilon.joinToString("")
        var epsilon_int = toDecimal(epsilon_string)
        println("gamma: " + gamma_string)
        println("epsilon: " +epsilon_string)
        println("result: " + gamma_int * epsilon_int)
        return gamma_int* epsilon_int
    }

    fun count_ones(inputs: List<String>): List<Int>{
        val max_index = inputs[0].length -1

        val ones: MutableList<Int> = Collections.nCopies(max_index + 1, 0).toMutableList()
        for (code in inputs){
            for ((index, char) in code.withIndex()){
                when (char) {
                    '1' -> ones[index] += 1
                }
            }
        }
        return ones
    }
    fun count_oxygen(ones: List<Int>, max_index: Int, input_size: Int): List<Char>{
        val oxygen: MutableList<Char> = Collections.nCopies(max_index + 1, '0').toMutableList()
        for (index in 0.. max_index) {
            if (ones[index] >= input_size/2 )
            {
                oxygen[index] = '1'
            }
        }
        return oxygen
    }
    fun part2(input: List<String>): Int {
        val max_index = input[0].length -1
        val input_size = input.size

        val co2: MutableList<Char> = Collections.nCopies(max_index + 1, '0').toMutableList()
        var ones = count_ones(input)
        var oxygen = count_oxygen(ones, max_index, input_size)


        var oxygens = input
        var looked_for = '0'
        for (index in 0..max_index){
            val count_of_ones = oxygens.count({it[index] == '1'})
            if (count_of_ones >= oxygens.size - count_of_ones){
                looked_for = '1'
            } else{
                looked_for = '0'
            }
           oxygens = oxygens.filter { it[index] == looked_for }
            if (oxygens.size == 1) {
                break
            }
        }
        println(oxygens)
        println(toDecimal(oxygens[0]))
        val oxygen_int = toDecimal(oxygens[0])

        var co2s = input
        var looked_for_co2 = '0'
        for (index in 0..max_index){
            val count_of_ones = co2s.count({it[index] == '1'})
            if (count_of_ones < co2s.size - count_of_ones){
                looked_for_co2 = '1'
            } else{
                looked_for_co2 = '0'
            }
            co2s = co2s.filter { it[index] == looked_for_co2 }
            if (co2s.size == 1) {
                break
            }
        }
        println(co2s)
        println(toDecimal(co2s[0]))
        val co2_int = toDecimal(co2s[0])

    return oxygen_int * co2_int
    }
    var input = readInput("Day03")
    println(part1(input))
    println(part2(input))


}