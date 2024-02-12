package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DirectedWeightedGraphsTest {
    @Test
    fun testAddEdge() {
        val graph = DirectedWeightedGraphs<Int>()
        graph.addEdge(1, 2, 3.5)
        graph.addEdge(2, 3, 2.0)
        graph.addEdge(3, 4, 1.0)

        assertEquals(3.5, graph.getEdges(1)[2])
        assertEquals(2.0, graph.getEdges(2)[3])
        assertEquals(1.0, graph.getEdges(3)[4])
    }

    @Test
    fun testGetVertices() {
        val graph = DirectedWeightedGraphs<Int>()
        graph.addEdge(1, 2, 3.5)
        graph.addEdge(2, 3, 2.0)
        graph.addEdge(3, 4, 1.0)

        val vertices = graph.getVertices()
        assertTrue(vertices.contains(1))
        assertTrue(vertices.contains(2))
        assertTrue(vertices.contains(3))
        assertTrue(vertices.contains(4))
        assertEquals(4, vertices.size)
    }

    @Test
    fun testClear() {
        val graph = DirectedWeightedGraphs<Int>()
        graph.addEdge(1, 2, 3.5)
        graph.addEdge(2, 3, 2.0)
        graph.addEdge(3, 4, 1.0)

        graph.clear()

        assertEquals(emptyMap<Int, Double>(), graph.getEdges(1))
        assertEquals(emptyMap<Int, Double>(), graph.getEdges(2))
        assertEquals(emptyMap<Int, Double>(), graph.getEdges(3))
        assertEquals(emptyMap<Int, Double>(), graph.getEdges(4))
        assertTrue(graph.getVertices().isEmpty())
    }
}
