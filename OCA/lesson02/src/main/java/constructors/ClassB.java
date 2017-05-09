/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: ClassB.java 3 2011-01-10 20:33:09Z jyeary $
 * 
 * Copyright 2008 John Yeary 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package constructors;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class ClassB extends SuperClassB {
    
    /* This will not compile without a constructor being 
     * provided with a String parameter. Remember that the constructors
     * are called for the super-class before the sub-classes. Since there is no
     * no-args constructor available, we must call super(String s)
     */
    public ClassB(String s) {
        super(s);
    }
}
