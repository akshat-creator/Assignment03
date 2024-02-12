package org.example

class DirectedWeightedGraphs<VertexType> : Graph<VertexType>{
    private val adjacencyMap: MutableMap<VertexType, MutableMap<VertexType, Double>> = mutableMapOf()
    /**
     * This is a simple ``Graph`` that represents a directed graph
     * @param VertexType the representation of a vertex in the graph
     */
        /**
         * @return the vertices in the graph
         */
        override fun getVertices(): Set<VertexType> {
            val vertices = mutableSetOf<VertexType>()
            for (vertex in adjacencyMap.keys) {
                vertices.add(vertex)
                for (neighbor in adjacencyMap[vertex]!!.keys) {
                    vertices.add(neighbor)
                }
            }
            return vertices
        }


        /**
         * Add an
         */

        override fun addEdge(from: VertexType, to: VertexType, cost: Double) {
            // Check if 'from' vertex exists in the adjacency map
            val fromVertexMap = adjacencyMap.computeIfAbsent(from) { mutableMapOf() }
            // Add the edge to the adjacency map
            fromVertexMap[to] = cost
        }

        /**
         *
         */
        override fun getEdges(from: VertexType): Map<VertexType, Double>{
            return adjacencyMap[from] ?: return emptyMap()

        }

        /**
         * Remove all edges and vertices from the graph
         */
        override fun clear(){
            adjacencyMap.clear()
        }
}
