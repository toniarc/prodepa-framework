package br.gov.pa.prodepa.security.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AuthorizationsRestCrud {
	@Nonbinding String[] search() default {};
	@Nonbinding String[] insert() default {};
	@Nonbinding String[] update() default {};
	@Nonbinding String[] remove() default {};
	@Nonbinding String[] enable() default {};
	@Nonbinding String[] disable() default {};
	@Nonbinding String[] load() default {};
}
