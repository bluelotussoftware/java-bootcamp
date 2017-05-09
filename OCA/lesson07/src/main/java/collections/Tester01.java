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
 * $Id: Tester01.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester01 {

    public static void main(String[] args) {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String[] elements = {"Hydrogen", "Helium", "Carbon"};
        System.out.println("Created a new array of Strings");
        for (String e : elements) {
            System.out.println(e);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Sorting the array");
        Arrays.sort(elements);
        for (String e : elements) {
            System.out.println(e);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Converting array to list");
        List<String> list = Arrays.asList(elements);
        System.out.println(list.getClass().getName());

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // What happens when I add or remove a new "element" to the list
//        list.add("Berylium");
//        list.remove("Helium");

//        Iterator iterator = list.iterator();
//        iterator.next();
//        iterator.remove();
//
//        for (String e : elements) {
//            System.out.println("Arrgh " + e);
//        }
//
//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Shuffling list");
        Collections.shuffle(list);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Sorting the list");
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Creating a new planets list");
        List<String> planets = new ArrayList<String>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");

        for (String p : planets) {
            System.out.println(p);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Sorting planets by name");
        Collections.sort(planets);
        for (String p : planets) {
            System.out.println(p);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("Converting planets to an array");
        String[] planetaryArray = planets.toArray(new String[planets.size()]);
        for (String p : planetaryArray) {
            System.out.println(p);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("Adding Pluto");
        planets.add("Pluto");
        System.out.print("Checking planetary array\n");
        for (String p : planetaryArray) {
            System.out.println(p);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Shuffling and checking planetary list");
        Collections.shuffle(planets);
        for (String p : planets) {
            System.out.println(p);
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String[] temp = new String[planetaryArray.length + 1];
        System.arraycopy(planetaryArray, 0, temp, 0, planetaryArray.length);
        planetaryArray = temp;
        planetaryArray[planetaryArray.length - 1] = "Heehaw";

        for (String p : planetaryArray) {
            System.out.println(p);
        }

    }
}
