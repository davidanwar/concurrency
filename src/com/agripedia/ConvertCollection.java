package com.agripedia;

import java.util.Collections;
import java.util.List;

public class ConvertCollection {
    public static void main(String[] args) {
        List<String> list = List.of("David", "Anwar", "Mundzir");
        // convert list biasa ke list untuk thread
        List<String> synchronizeList = Collections.synchronizedList(list);
        System.out.println(list);
        System.out.println(synchronizeList);
    }
}
