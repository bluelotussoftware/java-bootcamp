/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2010 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: Boxer.java 4 2011-01-10 20:34:25Z jyeary $
 */
package autobox;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Boxer {

    public static void main(String[] args) {
        int k = new Integer(42); // Auto-Unbox
        Integer z = k; // Auto-Box

        Integer y = 10;
        Integer x = 10;
        System.out.println("Is y == 10? " + ((y == 10) ? true : false)); //???
        System.out.println("Is y == x? " + ((y == x) ? true : false));  // Same Object
        System.out.println("Is y.equals(10) ? " + ((y.equals(10)) ? true : false)); // Equivalent according to equals() method based on value
        System.out.println("Is y.equals(x) ? " + ((y.equals(x)) ? true : false));  // Equivalent according to equals() method based on value

        Double d = null;
        double dd = 0.0;

        try {
            dd = d;
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

        System.out.println("d = dd ? " + (d = dd));

//        Byte b = 128; // Can not auto-box a value with a loss of precision
        byte b = new Integer(42).byteValue();

        byte bb = 5;
        short s = 10;
        char c = '\u0001';
        float f = 5.0f;
        Short short1 = new Short("10");
        int p = 5;
        double q = 10;


        //Overloaded methods widening
        widener(bb); // byte to  int
        widener(s); // short to int
        widener(c); // char to int
        widener(f); // float to double
//        upward(short1); // Won't work! The types must be correct
//        upward(s); // Wrong type
        upward(p);
        upward(q);

//        boxerWidener(1, 1, 1, 1, 1, 1); // Ambigous
//        boxerWidener(new Integer("1"), new Integer(110)); //Ambigous
        bx(1);
        bx(1, 1);
        bx(1, 1, 1);
    }

    static void widener(int x) {
        System.out.println("x: " + x + " was an int");
    }

    static void widener(long x) {
        System.out.println("x: " + x + " was a long");
    }

    static void widener(double x) {
        System.out.println("x: " + x + " was a double");
    }

    static void upward(Integer x) {
        System.out.println("x: " + x + " was an Integer");
    }

    static void upward(Double x) {
        System.out.println("x: " + x + " was an Double");
    }

    static void boxerWidener(Integer v, Integer... ints) {
        System.out.println("boxerVararger was called");
    }

    static void boxerWidener(float... longs) {
        System.out.println("boxWidener was called");
    }

    static void bx(Integer x, Integer... xx) {
        System.out.println("bx with var-args");
    }

    static void bx(Integer x, Integer y) {
        System.out.println("bx with two args");
    }
}
