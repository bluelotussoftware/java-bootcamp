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
 * $Id: Contact.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections.misc;

import java.util.UUID;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Contact {

    private String lastname;
    private String firstname;
    private UUID uuid;

    public Contact(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
        uuid = UUID.randomUUID();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UUID getUuid() {
        return uuid;
    }
}
