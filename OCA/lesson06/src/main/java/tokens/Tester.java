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
 * $Id: Tester.java 7 2011-01-10 20:37:04Z jyeary $
 */
package tokens;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        String s = "abc,abcd,abcde,abcdef,abcdefg,fedcba,edcba,dcba,cba";
        String[] tokens = s.split(",");

        for (String st : tokens) {
            System.out.println(st);
        }

        StringTokenizer st = new StringTokenizer("12:00:32:990099:Error in Windows Operating System:System must shutdown.", ":");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println("Scanning...");
        try {
            Scanner ss = new Scanner(System.in);
            String token = "meat";
            String found = "";
            while (!token.equalsIgnoreCase(found)) {
                found = ss.findInLine(token);
                if (token.equalsIgnoreCase(found)) {
                    System.out.println("What did we find... We found " + found);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }
}
