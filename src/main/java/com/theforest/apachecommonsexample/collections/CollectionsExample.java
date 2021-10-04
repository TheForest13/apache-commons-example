package com.theforest.apachecommonsexample.collections;

import org.apache.commons.collections.*;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.LinkedMap;

/**
 * Extends or augments the Java Collections Framework.
 */
public class CollectionsExample {

    public static void main(String[] args) {
        mapIterator();
        orderedMaps();
        bidirectionalMaps();
        bags();
    }

    /**
     * Bags
     * A new interface hierarchy has been added to support bags - Bag.
     * These represent collections where a certain number of copies of each element is held.
     * Implementations are provided for both unsorted and sorted Bags.
     */
    private static void bags() {
        Bag bag = new HashBag();
        bag.add("ONE", 6);  // add 6 copies of "ONE"
        bag.remove("ONE", 2);  // removes 2 copies of "ONE"
        bag.getCount("ONE");  // returns 4, the number of copies in the bag (6 - 2)
    }

    /**
     * Bidirectional Maps
     * A new interface hierarchy has been added to support bidirectional maps - BidiMap.
     * These represent maps where the key can lookup the value and the value can lookup the key with equal ease.
     */
    private static void bidirectionalMaps() {
        BidiMap bidi = new TreeBidiMap();
        bidi.put("SIX", "6");
        bidi.get("SIX");  // returns "6"
        bidi.getKey("6");  // returns "SIX"
        bidi.removeValue("6");  // removes the mapping
        BidiMap inverse = bidi.inverseBidiMap();  // returns a map with keys and values swapped
        System.out.println(inverse);
    }

    /**
     * Ordered Maps
     * A new interface is provided for maps that have an order but are not sorted - OrderedMap.
     * Two implementations are provided - LinkedMap and ListOrderedMap (a decorator).
     * This interface supports the map iterator, and also allows iteration both forwards and backwards through the map.
     */
    private static void orderedMaps() {
        OrderedMap map = new LinkedMap();
        map.put("FIVE", "5");
        map.put("SIX", "6");
        map.put("SEVEN", "7");
        System.out.println(map.firstKey());  // returns "FIVE"
        System.out.println(map.nextKey("FIVE"));  // returns "SIX"
        System.out.println(map.nextKey("SIX"));  // returns "SEVEN
        System.out.println(map);
    }

    /**
     * Map Iteration
     * The JDK Map interface always suffered from being difficult to iterate over.
     * API users are forced to either iterate over an EntrySet or over the KeySet.
     * Commons-Collections now provides a new interface - MapIterator that allows simple iteration over maps.
     */
    private static void mapIterator() {
        IterableMap map = new HashedMap();
        map.put("String", "case");
        MapIterator it = map.mapIterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object value = it.getValue();
            it.setValue("kuku");
            System.out.println(it);
        }
    }
}
