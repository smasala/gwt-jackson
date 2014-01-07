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

package com.github.nmorel.gwtjackson.client.stream;

import java.io.IOException;

public interface JsonWriter {

    /**
     * Sets the indentation string to be repeated for each level of indentation
     * in the encoded document. If {@code indent.isEmpty()} the encoded document
     * will be compact. Otherwise the encoded document will be more
     * human-readable.
     *
     * @param indent a string containing only whitespace.
     */
    void setIndent( String indent );

    /**
     * Configure this writer to relax its syntax rules. By default, this writer
     * only emits well-formed JSON as specified by <a
     * href="http://www.ietf.org/rfc/rfc4627.txt">RFC 4627</a>. Setting the writer
     * to lenient permits the following:
     * <ul>
     *   <li>Top-level values of any type. With strict writing, the top-level
     *       value must be an object or an array.
     *   <li>Numbers may be {@link Double#isNaN() NaNs} or {@link
     *       Double#isInfinite() infinities}.
     * </ul>
     */
    void setLenient( boolean lenient );

    /**
     * Sets whether object members are serialized when their value is null.
     * This has no impact on array elements. The default is true.
     */
    void setSerializeNulls( boolean serializeNulls );

    boolean getSerializeNulls();

    /**
     * Begins encoding a new array. Each call to this method must be paired with
     * a call to {@link #endArray}.
     *
     * @return this writer.
     */
    JsonWriter beginArray() throws IOException;

    /**
     * Ends encoding the current array.
     *
     * @return this writer.
     */
    JsonWriter endArray() throws IOException;

    /**
     * Begins encoding a new object. Each call to this method must be paired
     * with a call to {@link #endObject}.
     *
     * @return this writer.
     */
    JsonWriter beginObject() throws IOException;

    /**
     * Ends encoding the current object.
     *
     * @return this writer.
     */
    JsonWriter endObject() throws IOException;

    /**
     * Encodes the property name.
     *
     * @param name the name of the forthcoming value. May not be null.
     * @return this writer.
     */
    JsonWriter name( String name ) throws IOException;

    /**
     * Encodes {@code value}.
     *
     * @param value the literal string value, or null to encode a null literal.
     * @return this writer.
     */
    JsonWriter value( String value ) throws IOException;

    /**
     * Encodes {@code null}.
     *
     * @return this writer.
     */
    JsonWriter nullValue() throws IOException;

    JsonWriter cancelName();

    /**
     * Encodes {@code value}.
     *
     * @return this writer.
     */
    JsonWriter value( boolean value ) throws IOException;

    /**
     * Encodes {@code value}.
     *
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     * @return this writer.
     */
    JsonWriter value( double value ) throws IOException;

    /**
     * Encodes {@code value}.
     *
     * @return this writer.
     */
    JsonWriter value( long value ) throws IOException;

    /**
     * Encodes {@code value}.
     *
     * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
     *     {@link Double#isInfinite() infinities}.
     * @return this writer.
     */
    JsonWriter value( Number value ) throws IOException;

    /**
     * Encodes {@code value}.toString() as is.
     *
     * @param value a value .
     * @return this writer.
     */
    JsonWriter rawValue( Object value ) throws IOException;

    /**
     * Ensures all buffered data is written to the underlying {@link StringBuilder}
     * and flushes that writer.
     */
    void flush() throws IOException;

    /**
     * Flushes and closes this writer and the underlying {@link StringBuilder}.
     *
     * @throws IOException if the JSON document is incomplete.
     */
    void close() throws IOException;

    /**
     * @return the output when the serialization is over
     */
    String getOutput();
}
