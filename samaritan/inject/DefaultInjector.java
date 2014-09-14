package samaritan.inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class DefaultInjector extends AbstractInjector {

	public DefaultInjector(Binder binder, Module... modules) {
		super(binder, modules);
	}

	@Override
	public <T> T getInstance(Class<? extends T> type) {
		try {
			Class<? extends T> implementation = getBinder().get(type);
			Constructor<T> constructor = findConstructor(implementation);
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			Object[] parameters = new Object[parameterTypes.length];
			for (int i = 0; i < parameters.length; i++) {
				Class<?> parameter = parameterTypes[i];
				if (parameter.isPrimitive()) {
					parameters[i] = getBinder().get(parameter);
					continue;
				}
				parameters[i] = getInstance(parameter);
			}
			return constructor.newInstance(parameters);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e); // delegate
		}
	}

	@SuppressWarnings("unchecked")
	private <T> Constructor<T> findConstructor(Class<? extends T> implementation)
			throws NoSuchMethodException, SecurityException {
		for (Constructor<?> constructor : implementation.getConstructors())
			if (constructor.isAnnotationPresent(Inject.class))
				return (Constructor<T>) constructor;
		return (Constructor<T>) implementation.getConstructor();
	}

}