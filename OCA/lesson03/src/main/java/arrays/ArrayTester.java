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
 * $Id: ArrayTester.java 4 2011-01-10 20:34:25Z jyeary $
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class ArrayTester {

    private int[] ints = new int[10];
    private String[] strings = new String[10];

    public void intPrinter() {
        int[] x;
        x = new int[10];
        System.out.print(Arrays.toString(x));
    }

    public static void main(String... args) {
        ArrayTester arrayTester = new ArrayTester();
        System.out.println(Arrays.toString(arrayTester.ints));
        System.out.println("~~~~~~~~~~~~~~");
        System.out.print(Arrays.toString(arrayTester.strings));
        System.out.println("\n~~~~~~~~~~~~~~");
        arrayTester.intPrinter();
        System.out.println("\n~~~~~~~~~~~~~~");
        double[] doubles;
        //Will not compile
//        System.out.println(Arrays.toString(doubles));

        // Local arrays are automatically assigned default values
        double[] doubleCheck = new double[3];
        int k = 0;
        for (double d : doubleCheck) {
            System.out.println("d[" + k+++ "] == " + d); // What kind of syntax is this?
        }
        System.out.println("~~~~~~~~~~~~~~");
        Object objects[] = new Object[3];
        for (Object o : objects) {
            System.out.println("o[" + k--+ "] == " + o);
        }

        int[][] vals = new int[10][]; // Legal
        vals[0] = new int[2];
        vals[0][0] = 100;
        vals[0][1] = 101;

        Object[][][][] defined = new Object[5][4][3][2];
        Object[][][][] noObjecto = new Object[5][][][];

        // initialization and assignment
        int[] puzzles = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[][] puzzlers = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}, {0}};

        Number[] numbers = new Number[7];
        numbers[0] = new Byte((byte) 16);
        numbers[1] = new Short((short) 32);
        numbers[3] = new Integer(1024);
        numbers[4] = new Long(2048L);
        numbers[5] = new Float(1F);
        numbers[6] = new Double(2.0);

        System.out.println(Arrays.toString(numbers)); // What do we expect here?

        Comparable[] comparables = new Comparable[3];
        comparables[0] = "Hello World";
        comparables[1] = new Integer(99);
        comparables[2] = new Comparable() { // Is this legal?

            public int compareTo(Object o) {
                if (this.equals(o)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
    }
}
