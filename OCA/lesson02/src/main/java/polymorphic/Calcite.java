/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: Calcite.java 3 2011-01-10 20:33:09Z jyeary $
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
package polymorphic;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Calcite extends Mineral {

    private double w = 1.0;
    private double h = 1.0;

    public void grow() {
        System.out.println("size w:" + w + " h:" + h);
        this.h = h + (2 * h);
        this.w = 0.5 * (w + h);
    }
}
