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
 * $Id: Tester02.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester02 {

    @SuppressWarnings("unchecked")
    public static void main(String... args) {

        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add(42);
        list.add("Deep Thought");
        list.add(new ArrayList());

        String[] things = {"Chicken", "Soup", "Soul"};
        list.add(things);

        // See anything wrong here?
        ((ArrayList) list.get(4)).add(things);
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (Object o : list) {
            System.out.println(o);
            if (o.getClass().getName().equalsIgnoreCase("java.util.ArrayList")) {

                Object[] objs = ((ArrayList) o).toArray();
                for (Object object : objs) {
                    System.out.println(Arrays.toString((Object[]) object));
                }
                System.out.println(Arrays.toString(((ArrayList) o).toArray()));

            }
        }
    }
}
