/*
 *  Copyright 2010-2012 Blue Lotus Software, LLC.
 *  Copyright 2010-2012 John Yeary
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
 * $Id: BeAssertive.java 19 2012-10-26 03:44:07Z jyeary $
 */
package com.bluelotussoftware.module6.assertions;

/**
 *
 * @author John Yeary
 * @version 1.1
 */
public class BeAssertive {

    private static boolean beeAssertive() {
        Integer x = 15;
        boolean b = false;
        switch (x) {
            case 10: {
                b = true;
                break;
            }
            case 5: {
                b = true;
                break;
            }
            case 0: {
                b = true;
                break;
            }
            default:
                assert false;
        }
        return b;
    }

    private static boolean b3assertive(int k) {
        assert (k > 0) : "k = " + k + " was less than, or equal to zero";
        return true; // We should have checked this logic
    }

    public static void main(String... args) {

        int v = 435;

        if (v % 2 == 0) {
            System.out.println("Really?");
        } else {
            assert v % 3 == 0 : v;
        }

        try {
            BeAssertive.beeAssertive();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            // This is very bad! It disrupts the flow of the application.
            System.out.println("BE ASSERTIVE!");
        }
        BeAssertive.b3assertive(0);
    }
}
