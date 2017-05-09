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
package shortcircuit;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        boolean t = true;
        boolean f = false;
        int x = 10;
        int y = 10;

        if(++x > 10 | y-- > 10) {
            System.out.println("Something here is true: x = " + x + " y = " + y );
        }


        System.out.println("! " + (t & !f) + " or " + f);
        System.out.println("eXclusive OR (xor): " + ((7 > 8) ^ (7 < 8)));
        System.out.println("This is true not " + !true);

    }
}
