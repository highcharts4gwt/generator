package com.github.highcharts4gwt.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

/**
 * This annotation can be applied to a package or class to indicate that the classes' method in that element are nonnull by default unless there is
 * <ul>
 * <li>an explicit nullness annotation
 * <li>a default field annotation applied to a more tightly nested element.
 * </ul>
 * http://stackoverflow.com/questions/13414474/alternative-to-findbugs-defaultannotation-for-javax-annotation-for-fields-and-me/13429051#13429051
 */
@Documented
@Nonnull
@TypeQualifierDefault(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodsAreNonnullByDefault
{
}
