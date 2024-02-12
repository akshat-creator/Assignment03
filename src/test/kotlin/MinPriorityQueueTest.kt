import org.example.PriorityQueue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinPriorityQueueTest {
    @Test
    fun testIsEmpty() {
        val priorityQueue = PriorityQueue<Int>()
        assertTrue(priorityQueue.isEmpty())
        priorityQueue.addWithPriority(1, 0.0)
        assertFalse(priorityQueue.isEmpty())
    }

    @Test
    fun testAddWithPriority() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.addWithPriority(1, 0.0)
        priorityQueue.addWithPriority(2, 1.0)
        assertEquals(1, priorityQueue.next())
        assertEquals(2, priorityQueue.next())
    }

    @Test
    fun testNext() {
        val priorityQueue = PriorityQueue<Int>()
        assertNull(priorityQueue.next())
        priorityQueue.addWithPriority(1, 0.0)
        assertEquals(1, priorityQueue.next())
        assertNull(priorityQueue.next())
    }

    @Test
    fun testAdjustPriority() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.addWithPriority(1, 0.0)
        priorityQueue.adjustPriority(1, 2.0)
    }
}
