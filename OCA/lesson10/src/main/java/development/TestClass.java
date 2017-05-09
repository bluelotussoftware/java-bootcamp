/*
 *  Copyright 2010-2011 Blue Lotus Software, LLC.
 *  Copyright 2008-2011 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: TestClass.java 12 2011-02-02 01:29:13Z jyeary $
 */
package development;

import static java.lang.System.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class TestClass {

    public static void main(String... args) {
        out.println("Hello World");
        Properties props = getProperties();

        if (props != null) {
            props.list(out);
        }

        Map<String, String> map = System.getenv();
        Set<String> keys = map.keySet();

        for (String s : keys) {
            System.out.println(s + " : " + map.get(s));
        }
    }
}
