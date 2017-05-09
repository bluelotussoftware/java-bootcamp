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
package matching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\bjohn");
        Matcher m = p.matcher("abklfsdfjbasihvbasg;johnbdsjkalsdfjohn");

        while (m.find()) {
            System.out.println(m.start() + " " + m.group());
        }

        String sx = "dsfjnfwqpotkwqgqmg ;vsqdfgsqg123499bele";
        System.out.println(sx.matches("123"));
        System.out.println(sx.matches("\\d{6}"));

        String sy = "90210";
        System.out.println(sy.matches("\\d{5}"));

        String sz = "9021090210";
        System.out.println(sz.matches("\\d{5,}"));

        Pattern px = Pattern.compile("\\d{5}");
        Matcher mx = px.matcher(sz);

        while (mx.find()) {
            System.out.println(mx.start() + " " + mx.group());
        }

        Pattern py = Pattern.compile("\\b\\w");
        Matcher my = py.matcher(sx);

        while (my.find()) {
            System.out.println(my.start() + " " + my.group());
        }
    }
}
