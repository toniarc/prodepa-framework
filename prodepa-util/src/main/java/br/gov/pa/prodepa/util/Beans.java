package br.gov.pa.prodepa.util;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.AmbiguousResolutionException;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.naming.InitialContext;

public final class Beans implements Serializable {

	private static final long serialVersionUID = -5292634645026136653L;
	
	private static BeanManager beanManager;

	private Beans() {
	}

	public static void setBeanManager(BeanManager manager) {
		beanManager = manager;
	}

	public static BeanManager getBeanManager() {
		try {
			if(beanManager == null){
				beanManager = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
			}
		} catch (Exception e) {
			return null;
		}
		return beanManager;
	}

	/**
	 * Obtains a injectble instance of a bean, which have the given required type and qualifiers, and are available for
	 * injection in the point where this method was call.
	 * 
	 * @param beanClass
	 *            the beanClass which instace is requested to be obtained.
	 * @param qualifiers
	 *            a set of qualifiers with any quantity of elements (zero including).
	 * @return Type a instace of the injected beanClass.
	 * @throws DemoiselleException
	 *             if no bean are avaliable to be injected for the given Class and qualifiers.
	 */
	public static <T> T getReference(final Class<T> beanClass, Annotation... qualifiers) {
		T instance;

		try {
			instance = (T) getReference(getBeanManager().getBeans(beanClass, qualifiers), beanClass, qualifiers);

		} catch (NoSuchElementException cause) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(beanClass.getCanonicalName());

			for (Annotation qualifier : qualifiers) {
				buffer.append(", ");
				buffer.append(qualifier.getClass().getCanonicalName());
			}

			throw new RuntimeException(cause);
		}

		return instance;
	}

	/**
	 * Obtains a injectble instance of a bean, which have the given required type and are available for injection in the
	 * point where this method was call.
	 * 
	 * @param beanClass
	 *            the beanClass which instace is requested to be obtained.
	 * @return Type a instace of the injected beanClass.
	 * @throws DemoiselleException
	 *             if no bean are avaliable to be injected for the given Class.
	 */
	public static <T> T getReference(final Class<T> beanClass) {
		T instance;

		try {
			instance = (T) getReference(getBeanManager().getBeans(beanClass), beanClass);

		} catch (NoSuchElementException cause) {
			throw new RuntimeException(cause);
		}

		return instance;
	}

	/**
	 * Obtains a injectble instance of a bean, which have the given EL name and are available for injection in the point
	 * where this method was call.
	 * 
	 * @param beanName
	 *            the EL name for the requested bean.
	 * @return Type a instace of the injected beanClass.
	 * @throws DemoiselleException
	 *             if no bean are avaliable to be injected for the given bean name.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getReference(String beanName) {
		T instance;

		try {
			instance = (T) getReference(getBeanManager().getBeans(beanName));

		} catch (NoSuchElementException cause) {
			throw new RuntimeException(cause);
		}

		return instance;
	}

	@SuppressWarnings("unchecked")
	private static <T> T getReference(Set<Bean<?>> beans, Class<T> beanClass, Annotation... qualifiers) {
		if (beans.size() > 1) {
			throw new AmbiguousResolutionException();
		}

		Bean<?> bean = beans.iterator().next();
		CreationalContext<?> context = getBeanManager().createCreationalContext(bean);
		Type beanType = beanClass == null ? bean.getBeanClass() : beanClass;
		InjectionPoint injectionPoint = new CustomInjectionPoint(bean, beanType, qualifiers);

		return (T) getBeanManager().getInjectableReference(injectionPoint, context);
	}

	private static <T> T getReference(Set<Bean<?>> beans) {
		return getReference(beans, (Class<T>) null);
	}

	static class CustomInjectionPoint implements InjectionPoint {

		private final Bean<?> bean;

		private final Type beanType;

		private final Set<Annotation> qualifiers;

		public CustomInjectionPoint(Bean<?> bean, Type beanType, Annotation... qualifiers) {
			this.bean = bean;
			this.beanType = beanType;
			this.qualifiers = new HashSet<Annotation>(Arrays.asList(qualifiers));
		}

		public Type getType() {
			return this.beanType;
		}

		public Set<Annotation> getQualifiers() {
			return this.qualifiers;
		}

		public Bean<?> getBean() {
			return this.bean;
		}

		public Member getMember() {
			return null;
		}

		public boolean isDelegate() {
			return false;
		}

		public boolean isTransient() {
			return false;
		}

		public Annotated getAnnotated() {
			return new Annotated() {

				public Type getBaseType() {
					// TODO Auto-generated method stub
					return null;
				}

				public Set<Type> getTypeClosure() {
					// TODO Auto-generated method stub
					return null;
				}

				@SuppressWarnings("unchecked")
				public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
					T result = null;

					for (Annotation annotation : getAnnotations()) {
						if (annotation.annotationType() == annotationType) {
							result = (T) annotation;
							break;
						}
					}

					return result;
				}

				public Set<Annotation> getAnnotations() {
					return qualifiers;
				}

				public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
					return qualifiers.contains(annotationType);
				}
			};
		}
	}
}
