package org/rjv/treeMap;

import java.util.*;

class MyCalendar {

    TreeMap< Integer, Integer > bookMap = null;
    
    public MyCalendar() {
        bookMap = new TreeMap< Integer, Integer >();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = bookMap.floorKey( start );
        Integer ceilKey = bookMap.ceilingKey( start );
        
        if( floorKey != null ) {
            int floorVal = bookMap.get( floorKey );
            if( floorVal > start ) return false;
        }
        
        if( ceilKey != null )
            if( ceilKey < end ) return false;
        
        bookMap.put( start, end );
        return true;
    }
}


// Input: ["MyCalendar", "book", "book", "book"]
//        [[], [10, 20], [15, 25], [20, 30]]

// Output: [null, true, false, true]
