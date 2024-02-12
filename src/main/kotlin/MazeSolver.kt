package org.example

fun findPathInMaze(maze: Array<String>): List<Pair<Int, Int>> {

    val n = maze.size
    val m = maze[0].length

    // Create a DirectedWeightedGraphs instance to represent the maze as a graph
    val graph = DirectedWeightedGraphs<Pair<Int, Int>>()

    // Add edges to the graph based on the maze
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (maze[i][j] == '#') continue // Skip walls
            val currentVertex = Pair(i, j)
            graph.addEdge(currentVertex, currentVertex, 0.0) // Add self-loop for each cell

            // Check neighbors
            val neighbors = listOf(
                Pair(i - 1, j),
                Pair(i + 1, j),
                Pair(i, j - 1),
                Pair(i, j + 1)
            )
            for (neighbor in neighbors) {
                if (neighbor.first in 0 until n && neighbor.second in 0 until m && maze[neighbor.first][neighbor.second] != '#') {
                    graph.addEdge(currentVertex, neighbor, 1.0) // Add edge to neighbor
                }
            }
        }
    }

    // Find shortest path from 'S' to 'T' using Dijkstra's algorithm
    val start = Pair(0, 0) // Assuming 'S' is always at position (0, 0)
    val destination = findDestination(maze)
    return dijkstraShortestPath(graph, start, destination)!!.map { it.first to it.second }
}

fun findDestination(maze: Array<String>): Pair<Int, Int> {
    val n = maze.size
    val m = maze[0].length
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (maze[i][j] == 'T') {
                return Pair(i, j)
            }
        }
    }
    throw IllegalStateException("Destination 'T' not found in maze.")
}

fun main(){

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
