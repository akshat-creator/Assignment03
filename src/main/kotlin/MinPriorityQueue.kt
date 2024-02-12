package org.example

/**
 * ``MinPriorityQueue`` maintains a priority queue where the lower
 *  the priority value, the sooner the element will be removed from
 *  the queue.
 *  @param T the representation of the items in the queue
 */
class PriorityQueue<T>:MinPriorityQueue<T> {

    private val heap: MinHeap<T> = MinHeap()
    /**
     * @return true if the queue is empty, false otherwise
     */
    override fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    /**
     * Add [elem] with at level [priority]
     */
    override fun addWithPriority(elem: T, priority: Double) {
        heap.insert(elem,priority)

    }

    /**
     * Get the next (lowest priority) element.
     * @return the next element in terms of priority.  If empty, return null.
     */
    override fun next(): T?{
        // Check if the heap is empty
        if (heap.isEmpty()) {
            return null // If empty, return null
        }

        // Get the minimum value from the heap and remove it
        return heap.getMin()
    }
    /**
     * Adjust the priority of the given element
     * @param elem whose priority should change
     * @param newPriority the priority to use for the element
     *   the lower the priority the earlier the element int
     *   the order.
     */
    override fun adjustPriority(elem: T, newPriority: Double){
        // Check if the element exists in the priority queue
        if (!heap.contains(elem)) {
            return  // Element doesn't exist, no action needed
        }

        // Adjust the priority of the element in the heap
        heap.adjustHeapNumber(elem, newPriority)
    }
}