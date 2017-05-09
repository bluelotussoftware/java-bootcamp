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
 * $Id: TryCatchFinally.java 6 2011-01-10 20:36:09Z jyeary $
 */
package exceptions;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class TryCatchFinally {

    public static void main(String... args) {
        System.out.println("Return: " + TryCatchFinally.avoidable());
        try {
            System.out.println(TryCatchFinally.rethrowable());
        } catch (Throwable t) {
            System.out.println("Cause: " + t.getCause());
            System.out.println("Message: " + t.getMessage());
            System.out.println(t.getClass());
            throw new RuntimeException("Throwing it again my brother", t); // throw a new different exception
        } finally {
            System.out.println("finally");
            try {
            } finally {
                System.out.println("finally... really");
            }
        }
    }

    static int avoidable() {
        int[] k = {1, 2, 3, 4, 5};

        try {
            System.out.println(k[42]); // What kind of Exception will be thrown here?
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Cause: " + exception.getCause());
            System.out.println("Message: " + exception.getMessage());
            System.out.println(exception.getClass());
            return -1;
        } finally {
            System.out.println("I am sorry that this was so avoidable"); // This is called before returning
        }
        return 99;
    }

    static int rethrowable() throws Throwable {
        int[] k = {1, 2, 3, 4, 5};

        try {
            System.out.println(k[42]); // What kind of Exception will be thrown here?
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Cause: " + exception.getCause());
            System.out.println("Message: " + exception.getMessage());
            System.out.println(exception.getClass());
            throw new Throwable("Rethrowing this exception...", exception);
        } finally {
            System.out.println("I am sorry that this was so avoidable"); // This is called before returning
        }
        return 99;
    }
}
