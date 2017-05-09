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
 * $Id: Tester.java 4 2011-01-10 20:34:25Z jyeary $
 */
package constructors;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Creating a new instance of class D");
        D d = new D();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\n\n");

//        System.out.println("Calling A.x for first time. A.x = " + A.x);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Calling A.x for the second time. A.x = " + A.x);
//        System.out.println("The static block initializer did not get called because the class is already loaded in the JVM");
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Creating a new A() instance a");
//        A a = new A();
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("The constructor set the A.x value to a new value. A.x = " + A.x);
//        System.out.println("Class instance a. a.y = " + a.getY());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(B.s2);
        System.out.println("Why was B static initializer not called?");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\n\n");
        System.out.println("Creating a new B() instance b");
        B b = new B();
        System.out.println(b.getZ());
    }
}
