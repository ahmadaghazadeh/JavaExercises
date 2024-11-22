package com.sky.collections;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");

        Set<String> set2 = new HashSet<String>();
        set2.add("A1");
        set2.add("B");
        set2.add("C1");
        set2.add("D");
        set2.add("E1");

        Set<String> AUnionB = new HashSet<String>();
        AUnionB.addAll(set);
        AUnionB.addAll(set2);
        System.out.println("A ∪ B ="+AUnionB);

        Set<String> intersectionAB = new HashSet<String>(set);
        intersectionAB.retainAll(set2);
        System.out.println("A ∩ (\u2229) B = "+intersectionAB);

        Set<String> AMinusB = new HashSet<String>(set);
        AMinusB.removeAll(set2);
        System.out.println("A - B = "+AMinusB);

        Set<String> BMinusA = new HashSet<String>(set2);
        BMinusA.removeAll(set);
        System.out.println("B - A = "+BMinusA);

        Set<String> symmetricDiff = new HashSet<String>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        System.out.println("symmetricDiff A and B= "+symmetricDiff);

        Set<String> symmetricDiff2 = new HashSet<String>(AUnionB);
        symmetricDiff2.removeAll(intersectionAB);
        System.out.println("symmetricDiff A and B= "+symmetricDiff2);
    }
}
