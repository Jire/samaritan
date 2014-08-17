package samaritan;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Inherited
@Target({ ANNOTATION_TYPE, CONSTRUCTOR, FIELD, METHOD, TYPE, PACKAGE })
public @interface Experimental {
}