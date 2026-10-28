fun main() {
    fun part1(input: String): Int {
        return (input + input[0])
            .toCharArray()
            .map { it.toString().toInt() }
            .zipWithNext()
            .filter { (x, y) -> x == y }
            .sumOf { (x, _) -> x }
    }

    fun part2(input: String): Int {
        return input.filterIndexed { index, ch ->
            ch == input[(index + input.length / 2) % input.length]
        }
            .sumOf { it.toString().toInt() }
    }

    // Test if implementation meets criteria from the description, like:
    check(part1("1122") == 3)
    check(part1("1111") == 4)
    check(part1("1234") == 0)
    check(part1("91212129") == 9)

    check(part2("1212") == 6)
    check(part2("1221") == 0)
    check(part2("123425") == 4)
    check(part2("123123") == 12)
    check(part2("12131415") == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01").first()
    part1(input).println()
    part2(input).println()
}
