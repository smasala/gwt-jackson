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

package com.github.nmorel.gwtjackson.guava.client.deser;

import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.google.common.collect.LinkedHashMultiset;

/**
 * Default {@link JsonDeserializer} implementation for {@link LinkedHashMultiset}.
 *
 * @param <T> Type of the elements inside the {@link LinkedHashMultiset}
 *
 * @author Nicolas Morel
 */
public final class LinkedHashMultisetJsonDeserializer<T> extends BaseMultisetJsonDeserializer<LinkedHashMultiset<T>, T> {

    /**
     * @param deserializer {@link JsonDeserializer} used to deserialize the objects inside the {@link LinkedHashMultiset}.
     * @param <T> Type of the elements inside the {@link LinkedHashMultiset}
     *
     * @return a new instance of {@link LinkedHashMultisetJsonDeserializer}
     */
    public static <T> LinkedHashMultisetJsonDeserializer<T> newInstance( JsonDeserializer<T> deserializer ) {
        return new LinkedHashMultisetJsonDeserializer<T>( deserializer );
    }

    /**
     * @param deserializer {@link JsonDeserializer} used to deserialize the objects inside the {@link LinkedHashMultiset}.
     */
    private LinkedHashMultisetJsonDeserializer( JsonDeserializer<T> deserializer ) {
        super( deserializer );
    }

    @Override
    protected LinkedHashMultiset<T> newCollection() {
        return LinkedHashMultiset.create();
    }
}
