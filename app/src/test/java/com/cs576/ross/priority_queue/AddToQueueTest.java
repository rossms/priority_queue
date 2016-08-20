package com.cs576.ross.priority_queue;

/**
 * Created by Ross on 8/20/16.
 */

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class AddToQueueTest {
    @Test
    public void addToQueueIsCorrect() throws Exception {
        /*want to verify that adding to the queue is done so with the correct priority and order.
        this test case will add an initial value(1) to the queue,
        then will add a value(2) with a higher priority to ensure it is the first in the queue,
        then will add a value(3) with the same priority as the second value (2) to ensure it is being added
        with the correct ordering, as dictated by a stable priority queue.
        */
        Entry entryOne = new Entry(2, "First");
        Entry entryTwo = new Entry(1, "Second");
        Entry entryThree = new Entry(1, 2 );
        PriorityQueue<Entry> testPriorityQueue = new PriorityQueue<Entry>(10, new OrderedComparator());

        testPriorityQueue.add(entryOne);
        testPriorityQueue.add(entryTwo);

        Object value = testPriorityQueue.peek().getValue();
        assertEquals("Second", value);

        testPriorityQueue.add(entryThree);
        Object value2 = testPriorityQueue.peek().getValue();
        assertEquals("Second", value2);

    }
}
