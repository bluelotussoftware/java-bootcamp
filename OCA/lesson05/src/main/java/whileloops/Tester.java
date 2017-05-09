/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: Tester.java 6 2011-01-10 20:36:09Z jyeary $
 * 
 * Copyright 2008 John Yeary 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package whileloops;

import java.util.Random;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        System.out.println("Loop #1");

        while (true) {
            System.out.println("Looping in #1");
            if ((new Random().nextInt(10)) == 2) {
                break;
            }
        }

        System.out.println("\nLoop #2");

        do {
            System.out.println("In a loop...");
        } while (false);

        System.out.println("\nLoop #3");

//        do {
//            int k = (new Random()).nextInt(10);
//            System.out.println(k);
//        } while (k != 0);


        System.out.println("\nLoop #4");
        
        int k = 0;
        do {
            k = new Random().nextInt(10);
            System.out.println(k);
        } while (k != 0);

        System.out.println("\nLoop #5");

        while (k < 10) {
            System.out.println(k++);
        }

    }
}
