/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nmorel.gwtjackson.client.ser.map.key;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.JsonSerializationContext;

/**
 * @author Nicolas Morel
 */
public abstract class AbstractKeySerializerTest<T> extends GwtJacksonTestCase {

    protected abstract KeySerializer createSerializer();

    public void testSerializeNullValue() {
        assertSerialization( null, null );
    }

    protected String serialize( T value ) {
        JsonSerializationContext ctx = JsonSerializationContext.builder().build();
        return createSerializer().serialize( value, ctx );
    }

    protected void assertSerialization( String expected, T value ) {
        assertEquals( expected, serialize( value ) );
    }

    public abstract void testSerializeValue();
}
