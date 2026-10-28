fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { row ->
            val values = row.split("\\s+".toRegex())
                .map { it.toInt() }
            values.max() - values.min()
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { row ->
            val values = row.split("\\s+".toRegex()).map { it.toInt() }
                .sortedDescending()

            values.asSequence()
                .flatMap { first ->
                    values.map { second -> first to second }
                }
                .filter { (first, second) -> first > second }
                .filter { (first, second) -> first % second == 0 }
                .map { (first, second) -> first / second }
                .first()
        }
    }

    val testPart1 = readInput("Day02_test_part1")
    check(part1(testPart1) == 18)

    val testPart2 = readInput("Day02_test_part2")
    check(part2(testPart2) == 9)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
