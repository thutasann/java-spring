package MemorizingSamples;

import java.lang.ref.WeakReference;

public class MemorizingSamples {
    public void InMemoryCacheSample() {
        System.out.println("\n==> In Memory Cache");
        InMemoryCache<String, String> cache = new InMemoryCache<String, String>();
        cache.put("1", "One");
        System.out.println("GET '1' " + cache.get("1"));
    }

    public void ObjectPoolSample() {
        System.out.println("\n==> Object Pool Sample");
        ObjectPool<String> pool = new ObjectPool<String>(5);

        pool.release("Object1");
        pool.release("Object2");

        System.out.println("Acquired: " + pool.acquire()); // Output: Acquired: Object1
        System.out.println("Acquired: " + pool.acquire());
    }

    public void LRUCacheSample() {
        System.out.println("\n==> LRU Cache Sample");
        LRUCache<Integer, String> lru = new LRUCache<Integer, String>(3);
        lru.put(1, "One");
        lru.put(2, "Two");
        lru.put(3, "Three");
        lru.get(1);
        lru.put(4, "Four"); // Evicts 2
        System.out.println(lru);
    }

    public void ReferenceCounterSample() {
        System.out.println("\n==> Reference Counter Sample");
        ReferenceCounter referenceCounter = new ReferenceCounter();
        referenceCounter.addReference();
        referenceCounter.addReference();
        System.out.println("Reference Count: " + referenceCounter.getReferenceCount());

        referenceCounter.removeReference();
        System.out.println("Reference Count: " + referenceCounter.getReferenceCount());
    }

    public void WeakReferenceExample() {
        System.out.println("\n==> Weak Reference Sample");
        String strongRef = new String("Strong Reference");
        WeakReference<String> weakRef = new WeakReference<String>(strongRef);

        System.out.println("Before GC: " + weakRef.get());

        strongRef = null;
        System.gc();

        System.out.println("After GC: " + weakRef.get());
    }
}
