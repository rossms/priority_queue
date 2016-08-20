package com.cs576.ross.priority_queue;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ross on 8/20/16.
 */
public class CheckQueueMaxTest {
    @Test
    public void checkQueueMaxIsCorrect() throws Exception {
        /*
            want to add a few entries into the stable priority queue to ensure that the max returned
            is the expected value.
            Once this is verified, run extract Max, and check that the expected value was removed from
            the queue.
            First add initial value to the priority queue.
            Second add a new entry to the priority queue with a higher priority and check max.
            Third add a new entry to the priority queue with the same priority and check max.
            Finally run extract Max and ensure that the expected value was removed from the queue.
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

        Object value3 = testPriorityQueue.poll().getValue();
        assertEquals("Second", value3);
    }

}
