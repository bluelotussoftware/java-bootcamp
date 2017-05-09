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
package com.bluelotussoftware.module4.collections.comparisons;

import com.bluelotussoftware.module4.generics.Producer;
import com.bluelotussoftware.module4.generics.Widget;
import com.bluelotussoftware.module4.generics.WidgetProducer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) throws InterruptedException {

        Deque<Widget> widgetQueue = new ArrayDeque<>();
        Producer<Widget> producer = new WidgetProducer();

        for (int i = 0; i < 10; i++) {
            widgetQueue.add(producer.produce());
        }

        Iterator<Widget> its = widgetQueue.descendingIterator();
        System.out.println("~~~~~~~~~~~~~~~ Widget Queue Descending Iterator ~~~~~~~~~~~~~~~ ");
        while (its.hasNext()) {
            System.out.println(its.next());
        }

        // How do I shuffle them?
        Random r = new Random();
        Iterator<Widget> itx = widgetQueue.iterator();
        List<Widget> top = new ArrayList<>();
        List<Widget> bottom = new ArrayList<>();

        while (itx.hasNext()) {
            Widget w = itx.next();
            itx.remove();
            if (r.nextInt(2) == 0) {
                top.add(w);
            } else {
                bottom.add(w);
            }
        }

        Collections.shuffle(top);
        Collections.shuffle(bottom);

        for (Widget w : top) {
            widgetQueue.add(w);
        }

        for (Widget w : bottom) {
            widgetQueue.addLast(w);
        }

        System.out.println("~~~~~~~~~~~~~~~ Widget Queue Shuffled ~~~~~~~~~~~~~~~ ");
        for (Widget w : widgetQueue) {
            System.out.println(w);
        }

        List<Widget> sorted = new ArrayList<>(widgetQueue);
        Collections.sort(sorted);
        System.out.println("~~~~~~~~~~~~~~~ Widgets Sorted  ~~~~~~~~~~~~~~~ ");
        for (Widget w : sorted) {
            System.out.println(w);

            // This will produce what kind of result?
//            widgetQueue.addFirst(w);
//            widgetQueue.pollLast();
            // This will produce what kind of result?
            widgetQueue.addLast(w);
            widgetQueue.pollFirst();
        }

        System.out.println("~~~~~~~~~~~~~~~ Widget Queue Sorted ~~~~~~~~~~~~~~~ ");
        for (Widget w : widgetQueue) {
            System.out.println(w);
        }

        Deque<Widget> widgetQueueCopy = new ArrayDeque(widgetQueue);

        System.out.println("~~~~~~~~~~~~~~~ Widget Queue Elements ~~~~~~~~~~~~~~~ ");
        Widget wx = widgetQueue.pop();
        Widget qx = widgetQueue.peekLast();
        System.out.println("\nWidgetQueue contains wx? " + widgetQueue.contains(wx));
        System.out.println("\nWidgetQueue contains qx? " + widgetQueue.contains(qx));

        Collections.shuffle(top);
        System.out.println("\nwidgetQueueCopy contains top? " + widgetQueueCopy.containsAll(top));

        Collections.sort(top);
        System.out.println("\nwidgetQueueCopy contains top? " + widgetQueueCopy.containsAll(top));

        Collections.reverse(top);
        System.out.println("\nwidgetQueueCopy contains top? " + widgetQueueCopy.containsAll(top));

        System.out.println("\nwidgetQueueCopy contains top? " + widgetQueueCopy.containsAll(top));
        System.out.println("\nwidgetQueueCopy contains bottom? " + widgetQueueCopy.containsAll(bottom));

        top.addAll(bottom);
        System.out.println("\nwidgetQueueCopy contains top + bottom? " + widgetQueueCopy.containsAll(top));
        widgetQueueCopy.poll();
        System.out.println("\nwidgetQueueCopy contains top + bottom? " + widgetQueueCopy.containsAll(top));
    }
}
