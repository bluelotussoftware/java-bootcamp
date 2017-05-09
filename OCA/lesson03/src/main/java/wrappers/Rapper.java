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
 * $Id: Rapper.java 4 2011-01-10 20:34:25Z jyeary $
 */
package wrappers;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Rapper {

    public static void main(String... args) {

        Integer iz = new Integer("42");
        Integer iy = new Integer(42);
        Short pxz = new Short((short)42); // requires explicit cast
        Long donger = new Long(42); //Widening conversion

        Double d = Double.valueOf("999.99");
        System.out.println(d);
        System.out.println(d.intValue());
        System.out.println(d.shortValue());
        System.out.println(d.floatValue());
        System.out.println(d.longValue());

        System.out.println(Boolean.parseBoolean("false"));

        System.out.println(iz.toString());
        System.out.println(Integer.toBinaryString(42));
        System.out.println(Double.toHexString(300.00));
        System.out.println(Double.valueOf(Double.toHexString(300.00)));
    }
}
