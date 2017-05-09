/*
 * Copyright 2012 John Yeary.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bluelotussoftware.module4.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            String s = "node: ";
            s += String.valueOf(i);
            list.add(s);
            set.add(s);
            deque.add(s);
        }

        System.out.println("~~~~~~~~~~~~~~~ List ~~~~~~~~~~~~~~~ ");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("~~~~~~~~~~~~~~~ Set ~~~~~~~~~~~~~~~ ");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("~~~~~~~~~~~~~~~ Deque ~~~~~~~~~~~~~~~ ");
        for (String s : deque) {
            System.out.println(s);
        }

        Collections.shuffle(list);
        System.out.println("~~~~~~~~~~~~~~~ Shuffle ~~~~~~~~~~~~~~~ ");
        for (String s : list) {
            System.out.println(s);
        }

        Collections.sort(list);
        System.out.println("~~~~~~~~~~~~~~~ Sort ~~~~~~~~~~~~~~~ ");
        for (String s : list) {
            System.out.println(s);
        }

        Collections.reverse(list);
        System.out.println("~~~~~~~~~~~~~~~ Reverse ~~~~~~~~~~~~~~~ ");
        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> its = deque.descendingIterator();
        System.out.println("~~~~~~~~~~~~~~~ Deque Descending Iterator ~~~~~~~~~~~~~~~ ");
        while (its.hasNext()) {
            System.out.println(its.next());
        }


        Comparator c1 = Collections.reverseOrder();
        Comparator c2 = Collections.reverseOrder(c1);
        Comparator c3 = Collections.reverseOrder(c2);
        System.out.println("Comparator (C1) -> " + c1);
        System.out.println("Comparator (C2) -> " + c2);
        System.out.println("Comparator (C3) -> " + c3);
        System.out.println("Does C1 equal C2? " + c1.equals(c2)); // Comparator.equals();
        System.out.println("Does C1 equal C3? " + c1.equals(c3)); // Comparator.equals();

        System.out.println("~~~~~~~~~~~~~~~ List ~~~~~~~~~~~~~~~ ");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("~~~~~~~~~~~~~~~ ReverseOrder Comparator ~~~~~~~~~~~~~~~ ");
        Collections.sort(list, c1);
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("~~~~~~~~~~~~~~~ ReverseOrder(Comparator) Comparator ~~~~~~~~~~~~~~~ ");
        Collections.sort(list, c2);
        for (String s : list) {
            System.out.println(s);
        }

        class X {

            private int x;

            X() {
                x = new AtomicInteger(0).getAndIncrement();
            }
        }

        class Y implements Comparable<Y> {

            private int y;

            @Override
            public int compareTo(Y o) {
                return Integer.compare(y, o.y);
            }

            @Override
            public int hashCode() {
                int hash = 7;
                hash = 59 * hash + this.y;
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final Y other = (Y) obj;
                if (this.y != other.y) {
                    return false;
                }
                return true;
            }
        }

        Set<X> xset = new HashSet<>();
        X xyz = new X();
        xset.add(xyz);
        xset.add(xyz);
        for (int i = 0; i < 10; i++) {
            xset.add(new X());
        }

        // What is the output?
        int n = 0;
        for (X x : xset) {
            System.out.println("X (" + n++ + ") -> " + x);
        }

        Set<Y> yset = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            yset.add(new Y());
        }

        // What is the output?
        for (Y y : yset) {
            System.out.println("Y -> " + y);
        }
    }
}
