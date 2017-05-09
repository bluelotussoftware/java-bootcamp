/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2008-2010 John Yeary <jyeary@bluelotussoftware.com>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
/*
 * $Id: Tester05.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester05 {

    public static void main(String... args) {
        // ? extends T syntax
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(42);
        list1.add(801);

        List<? extends Number> list2 = list1;

        System.out.println("Printing List<? extends Number>");
        for (Number n : list2) {
            System.out.println(n);
        }

        // ? syntax
        List<?> list3 = list1;
        System.out.println("Printing List<?>");
        for (Object o : list3) {
            System.out.println(o);

        }

        // ? super T syntax
        List<? super Integer> list4 = list1;

        System.out.println("Printing List<? super Integer>");
        for (Object o : list4) {
            System.out.println(o);
        }

        List<Number> list5 = new ArrayList<Number>();
        list5.add(901);
        list5.add(12.696);

        list4 = list5;
        System.out.println("Printing List<? super Integer> using a List<Number>");
        for (Object o : list4) {
            System.out.println(o);
        }

        List<Object> list6 = new ArrayList<Object>();
        list6.add("hello");
        list6.add("world");

        list4 = list6;
        System.out.println("Printing List<? super Integer> using a List<Number>");
        for (Object o : list4) {
            System.out.println(o);
        }
    }
}
