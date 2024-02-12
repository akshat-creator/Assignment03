package org.example


fun main() {
    val n = arrayOf(
        "#########",
        "#......S#",
        "#.#.#####",
        "#...#...#",
        "#.#####.#",
        "#.......#",
        "#.#####.#",
        "#.#T....#",
        "#########"
    )

    val path = findPathInMaze(n)
    path.forEach { println("${it.first} ${it.second}") }
}
