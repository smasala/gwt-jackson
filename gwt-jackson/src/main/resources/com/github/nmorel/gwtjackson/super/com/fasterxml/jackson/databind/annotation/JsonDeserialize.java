package com.fasterxml.jackson.databind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Super source for {@link com.fasterxml.jackson.databind.annotation.JsonDeserialize} to remove the use of java.lang.reflect.* classes
 *
 * Annotation use for configuring deserialization aspects, by attaching
 * to "setter" methods or fields, or to value classes.
 * When annotating value classes, configuration is used for instances
 * of the value class but can be overridden by more specific annotations
 * (ones that attach to methods or fields).
 *<p>
 * An example annotation would be:
 *<pre>
 *  &#64;JsonDeserialize(using=MySerializer.class,
 *    as=MyHashMap.class,
 *    keyAs=MyHashKey.class,
 *    contentAs=MyHashValue.class
 *  )
 *</pre>
 *<p>
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@com.fasterxml.jackson.annotation.JacksonAnnotation
public @interface JsonDeserialize
{
    /**
     * Concrete type to deserialize values as, instead of type otherwise
     * declared. Must be a subtype of declared type; otherwise an
     * exception may be thrown by deserializer.
     *<p>
     * Bogus type {@link Void} can be used to indicate that declared
     * type is used as is (i.e. this annotation property has no setting);
     * this since annotation properties are not allowed to have null value.
     *<p>
     * Note: if {@link #using} is also used it has precedence
     * (since it directly specified
     * deserializer, whereas this would only be used to locate the
     * deserializer)
     * and value of this annotation property is ignored.
     */
    public Class<?> as() default Void.class;

    /**
     * Concrete type to deserialize keys of {@link java.util.Map} as,
     * instead of type otherwise declared.
     * Must be a subtype of declared type; otherwise an exception may be
     * thrown by deserializer.
     */
    public Class<?> keyAs() default Void.class;

    /**
     * Concrete type to deserialize content (elements
     * of a Collection/array, values of Maps) values as,
     * instead of type otherwise declared.
     * Must be a subtype of declared type; otherwise an exception may be
     * thrown by deserializer.
     */
    public Class<?> contentAs() default Void.class;
}
