/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: Tester.java 3 2011-01-10 20:33:09Z jyeary $
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
package constructors;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        SuperClassA s1 = new SuperClassA();
        SuperClassA s2 = new SuperClassA("I am Super!");
        System.out.println("SuperClassA with default constructor: " + s1.getStringSetByConstructor());
        System.out.println("SuperClassA with String constructor: " + s2.getStringSetByConstructor());
        ClassA a = new ClassA();
        System.out.println("ClassA with default dirty trick constructor: " +
                a.getStringSetByConstructor() + ". This should be null");
        SuperClassB s3 = new SuperClassB("I am SuperClassB hear me roar!");
        ClassB s4 = new ClassB("I am a sub-classsed.");
        SuperClassB s5 = new ClassB("Boo Yah!");
        ClassC s6 = new ClassC();
        SuperClassD s7 = new ClassD();
        SuperClassE s8 = SuperClassE.getInstance();
        System.out.println(s8);
        ClassF  f = new ClassF();
    }
}
