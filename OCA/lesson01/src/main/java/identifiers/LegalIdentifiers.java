/*
 *
 * Blue Lotus Software, LLC
 *
 * $Id: LegalIdentifiers.java 36 2013-11-30 21:39:10Z jyeary $
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
package identifiers;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class LegalIdentifiers {
    // Legal
    int _a;
    int $1;
    int a;
    int €1 = 100;
    int _¢_ = 42_000_000;
    
    // Illegal
//    int z###;
//    int 1$;
//    int %var;
//    int .9x;
//    int volatile;
}
