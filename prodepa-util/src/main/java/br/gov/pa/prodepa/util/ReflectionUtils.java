package br.gov.pa.prodepa.util;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReflectionUtils {

	protected ReflectionUtils() {
		//Impede instanciar subclasses desse tipo.
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the parametized type used with a concrete implementation of
	 * a class that accepts generics.
	 * 
	 * Ex: If you declare
	 * <pre><code>
	 * public class SpecializedCollection implements Collection<SpecializedType> {
	 *   // ...
	 * }
	 * </code></pre>
	 * 
	 * then the code <code>getGenericTypeArgument(SpecializedCollection.class , 0);</code> will
	 * return the type <code>SpecializedType</code>.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
		final Type type = clazz.getGenericSuperclass();

		ParameterizedType paramType;
		try {
			paramType = (ParameterizedType) type;
		} catch (ClassCastException cause) {
			return getGenericTypeArgument((Class<T>) type, idx);
		}

		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}

	/**
	 * <p>Return the parametized type passed to field types that accepts Generics.</p>
	 * 
	 * <p>Ex: If you declare
	 * <pre><code>
	 * public class MyClass{
	 *    private Collection&lt;String&gt; myStringCollection;
	 * }
	 * </code></pre>
	 * 
	 * then the code <code>getGenericTypeArgument( MyClass.class.getDeclaredField("myStringCollection") , 0);</code> will
	 * return the type <code>String</code>.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Field field, final int idx) {
		final Type type = field.getGenericType();
		final ParameterizedType paramType = (ParameterizedType) type;
		
		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}

	/**
	 * <p>Return the parametized type passed to members (fields or methods) that accepts Generics.</p>
	 * 
	 * @see #getGenericTypeArgument(Field field, int idx)
	 * 
	 */
	public static <T> Class<T> getGenericTypeArgument(final Member member, final int idx) {
		Class<T> result = null;

		if (member instanceof Field) {
			result = getGenericTypeArgument((Field) member, idx);
		} else if (member instanceof Method) {
			result = getGenericTypeArgument((Method) member, idx);
		}

		return result;
	}

	/**
	 * <p>Return the parametized type passed to methods that accepts Generics.</p>
	 * 
	 * @see #getGenericTypeArgument(Field field, int idx)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Method method, final int pos) {
		return (Class<T>) method.getGenericParameterTypes()[pos];
	}

	/**
	 * Returns the value contained in the given field. 
	 * 
	 * @param field
	 * 			field to be extracted the value.
	 * @param object
	 * 			object that contains the field.
	 * @return value of the field.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Field field, Object object) {
		T result = null;

		try {
			boolean acessible = field.isAccessible();
			field.setAccessible(true);
			result = (T) field.get(object);
			field.setAccessible(acessible);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * Sets a value in a field.
	 * 
	 * @param field
	 * 			field to be setted.
	 * @param object
	 * 			object that contains the field.
	 * @param value
	 * 			value to be setted in the field.
	 */
	public static void setFieldValue(Field field, Object object, Object value) {
		try {
			boolean acessible = field.isAccessible();
			field.setAccessible(true);
			field.set(object, value);
			field.setAccessible(acessible);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return All non static fields from a certain type. Inherited fields are not returned, so if you
	 * need to get inherited fields you must iterate over this type's hierarchy.  
	 */
	public static Field[] getNonStaticDeclaredFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();

		if (type != null) {
			for (Field field : type.getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers()) && !field.getType().equals(type.getDeclaringClass())) {
					fields.add(field);
				}
			}
		}

		return fields.toArray(new Field[0]);
	}

	/**
	 * @return All non static fields from a certain type, including fields declared in superclasses of this type. 
	 */
	public static List<Field> getNonStaticFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();

		if (type != null) {
			Class<?> currentType = type;
			while(currentType!=null && !"java.lang.Object".equals(currentType.getCanonicalName())){
				fields.addAll(Arrays.asList(getNonStaticDeclaredFields(currentType)));
				currentType = currentType.getSuperclass();
			}
		}

		return fields;
	}

	/**
	 * Instantiate an object of the given type. The default constructor with no parameters is used. 
	 */
	public static <T> T instantiate(Class<T> clazz) {
		T object = null;
		try {
			object = clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	/**
	 * Verifies if a given class could be converted to a given type. 
	 * 
	 * @param clazz
	 * 			class to be checked.
	 * @param type
	 * 			type to be checked.
	 * @return {@link Boolean}
	 * 			true if the given class can be converted to a given type, and false otherwise.
	 */
	public static boolean isOfType(Class<?> clazz, Class<?> type) {
		return type.isAssignableFrom(clazz) && clazz != type;
	}

	/**
	 * Obtains the {@link ClassLoader} for the given class, from his canonical name.
	 * 
	 * @param canonicalName
	 * 			canonical name of the the given class.
	 * @return {@link ClassLoader}
	 * 			ClassLoader for the given class.
	 */
	public static ClassLoader getClassLoaderForClass(final String canonicalName) {
		return ReflectionUtils.getClassLoaderForResource(canonicalName.replaceAll("\\.", "/") + ".class");
	}

	/**
	 * Obtains the {@link ClassLoader} for the given resource.
	 * 
	 * @param resource
	 * 			
	 * @return {@link ClassLoader}
	 * 			ClassLoader for the given resource.
	 */
	public static ClassLoader getClassLoaderForResource(final String resource) {
		final String stripped = resource.charAt(0) == '/' ? resource.substring(1) : resource;

		URL url = null;
		ClassLoader result = Thread.currentThread().getContextClassLoader();

		if (result != null) {
			url = result.getResource(stripped);
		}

		if (url == null) {
			result = ReflectionUtils.class.getClassLoader();
			url = ReflectionUtils.class.getClassLoader().getResource(stripped);
		}

		if (url == null) {
			result = null;
		}

		return result;
	}

	/**
	 * Return an URL to access a resource available to the active classloader for the calling thread.
	 */
	public static URL getResourceAsURL(final String resource) {
		ClassLoader classLoader = getClassLoaderForResource(resource);
		return classLoader != null ? classLoader.getResource(resource) : null;
	}

	/**
	 * Loads a class with the given name using the active classloader for the current thread.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> forName(final String className) throws ClassNotFoundException {
		ClassLoader classLoader = getClassLoaderForClass(className);
		return (Class<T>) Class.forName(className, true, classLoader);
	}
}
