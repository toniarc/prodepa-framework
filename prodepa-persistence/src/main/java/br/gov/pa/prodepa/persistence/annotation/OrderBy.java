package br.gov.pa.prodepa.persistence.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderBy {

	int order() default 1;

	String suffix() default "";

	boolean desc() default false;
}