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
 * $Id: Tester.java 5 2011-01-10 20:35:17Z jyeary $
 */
package arithmetic;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public final int x;
    public int y;
    public final int z;

    // Initializer block
    {
        z = y;
    }

    public Tester() {
        x = 10; // Assignment of final variable in constructor ?
    }

    public static void main(String... args) {

        System.out.println("Is x == 0? " + (new Tester().x == 0));
        System.out.println("Is y == 0? " + (new Tester().y == 0));
        System.out.println("Is z == 0? " + (new Tester().z == 0));
        System.out.println("Is z > 0? " + (new Tester().z > 0));
        System.out.println("What is the value of z? " + new Tester().z);
        Tester t = new Tester();
        System.out.println("++t.y : " + ++t.y);
        System.out.println("t.y++ : " + t.y++);
        System.out.println("t.y += 10 : " + (t.y += 10));
        System.out.println("Is 3.0 == 3L? " + (3.0 == 3L));
        System.out.println("Is 3.14 == 3L? " + (3.14 == 3L));
        System.out.println("Is 3.14 == 3.14F? " + (3.14 == 3.14F));
        System.out.println("What is the value of t.y += 2*5? " + (t.y += 2 * 5)); // What are the order of operations here?
        t.y = 22;
        System.out.println("t.y % t.x = " + t.y % t.x);
        System.out.println("t.z % t.x =  " + t.z % t.x);

        System.out.println("ty =+ t.z = " + (t.y = +t.z));
        System.out.println("ty += t.z = " + (t.y += t.z));
//        System.out.println("ty = ++t.z = " + (t.y = ++t.z));

    }
}
