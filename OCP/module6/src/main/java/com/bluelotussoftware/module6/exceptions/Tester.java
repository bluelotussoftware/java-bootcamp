/*
 *  Copyright 2010-2012 Blue Lotus Software, LLC.
 *  Copyright 2008-2012 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: Tester.java 18 2012-10-25 17:18:53Z jyeary $
 */
package com.bluelotussoftware.module6.exceptions;

/**
 *
 * @author John Yeary
 * @version 2.0
 */
public class Tester {

    public static void main(String... args) {
        Tester t = new Tester();

        // Why doesn't this need a try/catch block?
        System.out.println("Running messy code.");
        t.messy();
        System.out.println("The messy code ran without exception.");

        try {
            System.out.println("\nRunning something \"special\"");
            t.special();
//        } catch (Exception e) { The super-type can not be caught before the sub-type. The order must be reveresed.
        } catch (SpecialException ex) {
            // Does not print. Why?
            System.out.println("Check this out... SpecialException throws an Exception!");
            // Is this really printed?
            System.out.println(ex.getMessage());
        } catch (Exception e) { // This will never get called in our case.
        } finally {
            System.out.println("finally is right. I thought we would never get here.");
        }

        try {
            t.anotherMess();
            return;
        } catch (Exception ex) {
            System.out.println("Exceptional!!! " + ex.getMessage());
        } finally {
            System.out.println("This gets called even if there is a return statement before it in the try{}");
        }

        try {
            System.out.println("\ntrying");
        } finally {
            System.out.println("finally");
        }


    }

    public void messy() throws ArrayIndexOutOfBoundsException, ArithmeticException, RuntimeException {
    }

    public void anotherMess() throws Exception {
    }

    public void special() throws SpecialException {
        throw new SpecialException("I am a special exception");
    }
}

class SpecialException extends Exception {

    private static final long serialVersionUID = 4200603417355723723L;

    SpecialException(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
