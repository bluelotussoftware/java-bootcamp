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
 * $Id: Castor.java 4 2011-01-10 20:34:25Z jyeary $
 */
package casting;

import java.math.BigInteger;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Castor {

    static Boolean bool;
    static final Integer inx = Integer.MAX_VALUE;
    static Number number = Long.MAX_VALUE;

    public static void main(String... args) throws InterruptedException {

        byte b = 16;
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println("b: " + b);
        System.out.println("~~~~~~~~~~~~~~~");
        int k = b; // Widening conversion
        System.out.println("k: " + k);
        System.out.println("~~~~~~~~~~~~~~~");
//        byte me = b + k; // Narrowing conversion requires an explicit cast
        byte meAgain = (byte) (b + k); // Narrowing conversion with explicit cast
        System.out.println("meAgain: " + meAgain);
        System.out.println("~~~~~~~~~~~~~~~");
//        float me = 3000.00; // Will not compile. It requires either an explicit cast, or an "F" or "f"
        float f = 3000.00f;
        System.out.println("f: " + f);
        System.out.println("~~~~~~~~~~~~~~~");
        float F = 1000F;
        System.out.println("F: " + F);
        System.out.println("~~~~~~~~~~~~~~~");
        long one = BigInteger.ONE.longValue();
        System.out.println("one: " + one);
        System.out.println("~~~~~~~~~~~~~~~");
        long longer = 1L + one;
        System.out.println("longer: " + longer);
        System.out.println("~~~~~~~~~~~~~~~");
        long longest = Long.MAX_VALUE;
        System.out.println("longest: " + longest);
        System.out.println("~~~~~~~~~~~~~~~");
        long biggerOne = 1; // Widening conversion
        System.out.println("biggerOne: " + biggerOne);
        System.out.println("~~~~~~~~~~~~~~~");
        long biggerStill = k; //Widening conversion
        System.out.println("biggerStill: " + biggerStill);
        System.out.println("~~~~~~~~~~~~~~~");
//        k = longest; // Narrowing conversion requiring an explicit cast
        k = (int) longest; // Narrowing conversion with explict cast
        System.out.println("k: " + k);
        System.out.println("~~~~~~~~~~~~~~~");
        double d = k; //Widening conversion
        System.out.println("d: " + d);
        System.out.println("~~~~~~~~~~~~~~~");
//        float floater = d; //Narrowing conversion requires explicit cast.
        float floater = (float) 1.0D;
        System.out.println("floater: " + floater);
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println("What kind of cast is this?");
        char c = (char) (b * 2 + b * 32);
        System.out.println("c: " + c);
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println("Widening and Narrowing");
//        byte tooBigAByte = 128; // Loss of precision. Requires an explicit cast
        byte goodSizeByte = 127;
        System.out.println("goodSizeByte: " + goodSizeByte);
        System.out.println("~~~~~~~~~~~~~~~");
        short shorty = 1 + 3;
        System.out.println("shorty: " + shorty);
        System.out.println("~~~~~~~~~~~~~~~");

        //Exceptions
        //NullPointerException
        try {
            boolean truth = bool;
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

        //ClassCastException
        try {
            short n = (Short) number;
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

        //OutOfMemoryError
        try {
            Integer[] intx = new Integer[inx / 512];
            for (int x = 0; x < inx / 512; x++) {
                intx[x] = x;
            }
        } catch (Error e) {
            System.out.println(e.getClass());
        }

    }
}
