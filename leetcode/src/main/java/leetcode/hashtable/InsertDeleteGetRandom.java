package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {


    Map<Integer, Integer> indexValue;
    Map<Integer, Integer> valueIndex;
    Random ran = new Random();

    public InsertDeleteGetRandom() {
        indexValue = new HashMap<>();
        valueIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valueIndex.containsKey(val)) {
            return false;
        }
        int size = indexValue.size();
        indexValue.put(size, val);
        valueIndex.put(val, size);

        return true;
    }

    public boolean remove(int val) {
        if (!valueIndex.containsKey(val)) {
            return false;
        }

        int index = valueIndex.get(val);
        int lastIndex = valueIndex.size() - 1;

        indexValue.put(index, indexValue.get(lastIndex));
        valueIndex.put(indexValue.get(lastIndex), index);
        indexValue.remove(lastIndex);
        valueIndex.remove(val);

        return true;
    }

    public int getRandom() {
        if (indexValue.size() == 0) {
            return 0;
        }
        int v = ran.nextInt(indexValue.size());
        return indexValue.get(v);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom randomizedSet = new InsertDeleteGetRandom();
        randomizedSet.insert(0); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(1);
//        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
//        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(0); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.remove(1); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
