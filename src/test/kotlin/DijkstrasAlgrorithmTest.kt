package org.example
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class DijkstraShortestPathTest {

    @Test
    fun testShortestPath() {
        val graph = DirectedWeightedGraphs<String>()
        graph.addEdge("A", "B", 5.0)
        graph.addEdge("A", "C", 3.0)
        graph.addEdge("B", "C", 1.0)
        graph.addEdge("B", "D", 2.0)
        graph.addEdge("C", "D", 3.0)

        val shortestPath = dijkstraShortestPath(graph, "A", "D")
        assertEquals(listOf("A", "C", "D"), shortestPath)
    }

    @Test
    fun testNoPath() {
        val graph = DirectedWeightedGraphs<String>()
        graph.addEdge("A", "B", 5.0)
        graph.addEdge("B", "C", 3.0)
        graph.addEdge("C", "A", 2.0)

        val shortestPath = dijkstraShortestPath(graph, "A", "D")
        assertNull(shortestPath)
    }

    @Test
    fun testNegativeEdgeWeights() {
        val graph = DirectedWeightedGraphs<String>()
        graph.addEdge("A", "B", -2.0)
        graph.addEdge("B", "C", 3.0)
        graph.addEdge("C", "D", 2.0)

        val shortestPath = dijkstraShortestPath(graph, "A", "D")
        assertEquals(listOf("A", "B", "C", "D"), shortestPath)
    }

}
