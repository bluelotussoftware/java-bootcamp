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
 * $Id: Tester.java 6 2011-01-10 20:36:09Z jyeary $
 */
package forloops;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 2.0
 */
public class Tester {

    private static Boolean boole = true;

    public static void main(String... args) {
        System.out.println("Loop #1");
        for (int x = 0; x < 10; x++) {
            System.out.println(x);
            ++x;
        }

        System.out.println("\nLoop #2");

        Integer y = 10;
        for (; y > 0; y--) {
            System.out.println(y);
        }

        System.out.println("\nLoop #3");

        for (; y < 10;) {
            System.out.println(y);
            y++;
        }

        System.out.println("\nLoop #4");

        for (int a = 10, b = 5, c = 1; y > 0; System.out.println(y--)) {
            System.out.println("\nLoop #5");
        }


        for (int a = 10, b = 0; b < 10; a--, b++, System.out.println("[" + a + "," + b + "]")) {
        }

        System.out.println("\nLoop #6");

        y = 10;
        for (; true;) {
            System.out.println(y);
            y--;
            if (y == 0) {
//                throw new RuntimeException();
                break;
            }

        }


        // Infinite loop
//        for (; boole;) {
//            System.out.println("Charles Boole was a great man.");
//        }

        // Infinite loop
//        for (;;) {
//        }

        Collection<ABC> x  = new ArrayList<ABC>();

        for (int k=0; k < 100; k++) {
            ABC abc = new ABC();
            x.add(abc);
        }

        for (XYZ xyz : x) {
            System.out.print(".");
        }
        System.out.println("");
        
//        ABC cba = null; // cba must be a local variable to the enhanced for loop.
//        for (cba : x) {
//            System.out.print(".");
//        }


    }
}
