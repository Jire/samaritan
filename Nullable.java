package samaritan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.PARAMETER })
public @interface Nullable {
}