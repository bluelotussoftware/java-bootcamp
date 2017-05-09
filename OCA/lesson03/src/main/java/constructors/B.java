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
 * $Id: B.java 4 2011-01-10 20:34:25Z jyeary $
 */
package constructors;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class B extends A {

    public static final String s1 = "String s1";
    public static final String s2;
    private int z;

    public B() {
        System.out.println("Inside B constructor");
        System.out.println("Class B z =" + z);
        System.out.println("super.x called. super.x = " + super.x);
    }

    public int getZ() {
        return this.z;
    }
    

    {
        System.out.println("Inside B initialization block.");
        z = 1;
    }
    

    static {
        s2 = "Hello Jose";
        System.out.println("Inside B static initialization block.");
        System.out.println(s1);
    }
}
