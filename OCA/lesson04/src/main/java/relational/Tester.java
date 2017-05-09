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
package relational;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String[] args) {
        char tm = '™';
        char cent = '¢';

        if (tm > cent) {
            System.out.println("Trade Marks ™ are worth more than a ¢");
            System.out.println("A '™' is worth: " + (int) tm + "¢");
            System.out.println("A '¢' is worth: " + (int) cent + "¢");
        } else {
            System.out.println("Trade Marks ™ are worth less than a ¢");
            System.out.println("A '™' is worth: " + (int) tm + "¢");
            System.out.println("A '¢' is worth: " + (int) cent + "¢");
        }

        System.out.println("Is 10 > 5? " + (10 > 5));
        System.out.println("Is 10 < 5? " + (10 < 5));
        System.out.println("Is 10 <=9? " + (10 <= 9));
        System.out.println("Is 10 <=10? " + (10 <= 10));
        System.out.println("Is 10 >= 11? " + (10 >= 11));
        System.out.println("Is 3.14F > 3.14? " + (3.14F > 3.14)); // What should this print?
        System.out.println("Is 3.14 > 3.14F? " + (3.14 > 3.14F)); // What should this print?
        System.out.println("cent >162 ? true : false ==> " + (cent > 162 ? true : false));
    }
}
