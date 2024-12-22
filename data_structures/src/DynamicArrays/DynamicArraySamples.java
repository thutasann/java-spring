package DynamicArrays;

import Shared.DynamicArray;

public class DynamicArraySamples {
    public void SampleOne() {
        System.out.println("\n===> Dynamic Array Sample One");
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");

        dynamicArray.insert(0, "X");

        dynamicArray.delete("A");

        System.out.println("B Index --> " + dynamicArray.search("B"));

        System.out.println("capacity -> " + dynamicArray.capacity());

        System.out.println("size -> " + dynamicArray.size());

        System.out.println("toString --> " + dynamicArray.toString());

        System.out.println("isEmpty --> " + dynamicArray.isEmpty());
    }
}
