package MemorizingSamples;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectPool<T> {
    private final Queue<T> pool = new LinkedList<>();
    private final int maxSize;

    public ObjectPool(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void release(T object) {
        if (pool.size() < maxSize) {
            pool.offer(object);
        }
    }

    public synchronized T acquire() {
        return pool.poll();
    }
}
