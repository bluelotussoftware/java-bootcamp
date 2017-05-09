/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: PrivateProtectedInterfaceExample.java 36 2013-11-30 21:39:10Z jyeary $
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
package interfaces;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class PrivateProtectedInterfaceExample {

    public void test() {
        X x = new X();
        x.test();
    }

    public void yTest() {
        System.out.println(A.Y);
    }

    protected interface A {

        int Y = 10;
    }

    private interface B {

        int XI = 12;

        void test();
    }

    public static interface C extends A {
    }

    class X implements A, B {

        public void test() {
            System.out.println("Test Complete");
        }
    }

    public static void main(String... args) {
        PrivateProtectedInterfaceExample ix = new PrivateProtectedInterfaceExample();
        ix.yTest();
        System.out.println(PrivateProtectedInterfaceExample.A.Y);
        System.out.println(PrivateProtectedInterfaceExample.B.XI);
        System.out.println(C.Y);

        System.out.println(X.XI);
        System.out.println(X.Y);
        ix.test();
    }
}
