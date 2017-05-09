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
package polymorphic;

import java.util.Arrays;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        Growable[] growers = new Growable[3];
        Cat cat = new Cat();
        Calcite calcite = new Calcite();
        Carrot carrot = new Carrot();

        growers[0] = cat;
        growers[1] = calcite;
        growers[2] = carrot;

        for (Growable g : growers) {
            g.grow();
        }

        System.out.println(Arrays.toString(growers));

        Animal animal = new Cat();

        Mammal m = (Mammal) animal;

        Animal animus = new Bird();

        System.out.println("Is m an Object? " + (m instanceof Object));
        System.out.println("Is cat an Object? " + (cat instanceof Object));
        System.out.println("Is cat a Cat? " + (cat instanceof Cat));
        System.out.println("Is cat a Mammal? " + (cat instanceof Mammal));
        System.out.println("Is cat an Animal? " + (cat instanceof Animal));
        System.out.println("Is cat a Mineral? " + (cat instanceof Growable));
        System.out.println("Is an Animal a cat? " + (animal instanceof Cat));
        System.out.println("Is an animus a cat? " + (animus instanceof Cat));
        System.out.println("... Just kidding... it is Growable though.");

//        This will not work because you can not cast a cat to a Mineral, i.e.  Mineral mineral = (Mineral) cat;
//       System.out.println("Is cat a Mineral? " + (cat instanceof Mineral));
    }
}
