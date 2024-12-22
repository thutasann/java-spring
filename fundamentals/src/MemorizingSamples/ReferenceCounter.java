package MemorizingSamples;

public class ReferenceCounter {
    private int count = 0;

    public void addReference() {
        count++;
    }

    public void removeReference() {
        if (count > 0) {
            count--;
        }
    }

    public int getReferenceCount() {
        return count;
    }
}
