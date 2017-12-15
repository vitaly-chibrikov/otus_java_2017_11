package ru.otus.l51.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
//@Target({ElementType.TYPE_USE})
@Target({ElementType.TYPE_PARAMETER})
public @interface Immutable {
}
