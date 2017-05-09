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
 * $Id: Propagate.java 6 2011-01-10 20:36:09Z jyeary $
 */
package exceptions;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Propagate {

    public static void main(String... args) {
        Propagate p = new Propagate();
        try {
            System.out.println(p.reverseString("reverse"));
            p.reverseString("");
        } finally {
            System.out.println("I am finally done.");
        }
    }

    public String reverseString(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException("The string must not be zero (0) length.");
        }
        String reverseStr = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            reverseStr += s.charAt(i);
        }
        return reverseStr;
    }
}
