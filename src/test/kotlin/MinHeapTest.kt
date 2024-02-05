import org.example.MinHeap
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MinHeapTest {

    @Test
    fun insert() {
        val heap = MinHeap<String>()
        heap.insert(data="test", heapNumber=3.2)
        heap.insert(data="booh", heapNumber=5.3)
        heap.insert(data="claw", heapNumber=1.0)
        heap.insert(data="tester", heapNumber=0.2)
        heap.insert(data="qq", heapNumber=0.5)
        heap.insert(data="anotherone", heapNumber=100.0)

        assertEquals(heap.getMin(), "tester")
        assertEquals(heap.getMin(), "qq")
        assertEquals(heap.getMin(), "claw")
        assertEquals(heap.getMin(), "test")
        assertEquals(heap.getMin(), "booh")
        heap.insert(data="reentry", heapNumber=1000.0)
        assertEquals(heap.getMin(), "anotherone")
        assertEquals(heap.getMin(), "reentry")
        assertEquals(heap.getMin(), null)
    }
}