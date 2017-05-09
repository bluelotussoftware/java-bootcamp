/*
 *  Copyright 2011 Blue Lotus Software, LLC.
 *  Copyright 2011 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: PhoneEntry.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections.misc;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class PhoneEntry implements Entry {

    private String phoneNumber;

    public PhoneEntry(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String get() {
        return phoneNumber;
    }
}
