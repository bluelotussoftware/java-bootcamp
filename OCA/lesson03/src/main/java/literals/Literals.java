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
 * $Id: Literals.java 4 2011-01-10 20:34:25Z jyeary $
 */
package literals;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Literals {

    public static void main(String... args) {
        double d = 0xdD;
        double dd = 1.0;
        double ddd = 1.0D;
        float f = 1.0f;
        float ff = 1.0F;
        int k = 8;
        int l = 010;
        int m = 0x8;
        int java = 0xCAFEBABE;
        long confusion = 0xffl;
        long lessConfusing = 01L;


        Number[] numbers = new Number[]{
            0xdD,
            1.0,
            1.0D,
            1.0f,
            1.0F,
            8,
            010,
            0x8,
            0xCAFEBABE,
            0xffl,
            01L
        };

        for (Number n : numbers) {
            System.out.println(n.getClass().getSimpleName() + " : " + n.toString());
        }

        boolean b = true;
        boolean bool = Boolean.TRUE;
        char a = 'a';
        char z = 'b';

        for (int i = 65; i < 91; i++) {
            System.out.print((char) i);
            if (i == 90) {
                System.out.println();
            }
        }

        char[] characters = new char[] {
            (char)65,
            (char)66,
            (char)67
        };

        System.out.print("Do you know your ");
        for(char c : characters) {
            System.out.print(c);
        }
        System.out.println("\'s?");

    }
}
