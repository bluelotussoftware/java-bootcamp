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
package console;

import java.io.Console;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        Console c = System.console();
        boolean b = true;
        String s = null;
        ConsoleConsumer cc = new ConsoleConsumer();
        while (b) {
            s = c.readLine("%s", "Input?: ");
            b = cc.eat(s, c);
        }

    }
}

class ConsoleConsumer {

    boolean eat(String s, Console c) {
        if (s == null || s.equals("")) {
            return false;
        } else {
            c.format("Output: %s\n", s);
            return true;
        }
    }
}
