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
 * $Id: Tester.java 6 2011-01-10 20:36:09Z jyeary $
 */
package conditional;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

//    final static int var = 200;
    public static void main(String... args) {

        final int q = 100;
//        char var = '¢';
//        char var = 'c';
        final int var = 98;
//        int var = 99;
//        int var = 2;

        switch (var) {
            default: {
                System.out.println("default");
                break;
            }
            case 1: {
                System.out.println("case 1");
                break;
            }
            case 2:
                System.out.println("case 2");
            case '¢': {
                System.out.println("case ¢");
                break;
            }
            case '\u0063': {
                System.out.println("case \u0063");
                break;
            }
//            case 99: {
//                System.out.println("Doh!");
//                break;
//            }
//            case var: {
//                System.out.println("What?");
//            }
            case q: {
                System.out.println("Where is Q?");
            }
        }

    }
}
