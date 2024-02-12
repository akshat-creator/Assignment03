package org.example

fun <VertexType> dijkstraShortestPath(
    graph: DirectedWeightedGraphs<VertexType>,
    start: VertexType,
    destination: VertexType
): List<VertexType>? {
    val distanceMap = mutableMapOf<VertexType, Double>() // Store the shortest known distance to each vertex
    val predecessorMap = mutableMapOf<VertexType, VertexType?>() // Store the predecessor of each vertex
    val priorityQueue = PriorityQueue<VertexType>() // Priority queue to store vertices based on their tentative distances

    // Initialize distances and predecessorMap
    graph.getVertices().forEach { vertex ->
        distanceMap[vertex] = Double.POSITIVE_INFINITY
        predecessorMap[vertex] = null
    }
    distanceMap[start] = 0.0 // Distance from start to start is 0

    priorityQueue.addWithPriority(start, 0.0)

    while (!priorityQueue.isEmpty()) {
        val currentVertex = priorityQueue.next() ?: break // Dequeue vertex with smallest tentative distance
        if (currentVertex == destination) {
            // Reconstruct shortest path
            val path = mutableListOf<VertexType>()
            var vertex: VertexType? = destination
            while (vertex != null) {
                path.add(vertex)
                vertex = predecessorMap[vertex]
            }
            return path.reversed()
        }

        val neighbors = graph.getEdges(currentVertex)
        for ((neighbor, cost) in neighbors) {
            val tentativeDistance = distanceMap[currentVertex]!! + cost
            if (tentativeDistance < distanceMap[neighbor]!!) {
                distanceMap[neighbor] = tentativeDistance
                predecessorMap[neighbor] = currentVertex
                priorityQueue.addWithPriority(neighbor, tentativeDistance)
            }
        }
    }

    // If destination node is not reached
    return null
}
