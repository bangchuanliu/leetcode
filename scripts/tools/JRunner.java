import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Tiny reflection-based runner used by the `jrun` script so individual
 * solution files can be executed without writing any extra code.
 *
 * Usage:
 *   java JRunner <fullyQualifiedClassName>                       // runs main(String[])
 *   java JRunner <fullyQualifiedClassName> <methodName> [args..] // runs one method
 *
 * Arguments for the method are parsed as: int, long, double, boolean, char,
 * String, or comma-separated arrays of those (e.g. "1,2,3" for int[]).
 */
public class JRunner {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: JRunner <className> [methodName] [args...]");
            System.exit(1);
        }

        Class<?> clazz = Class.forName(args[0]);

        if (args.length == 1) {
            runMain(clazz);
            return;
        }

        String methodName = args[1];
        String[] rawArgs = java.util.Arrays.copyOfRange(args, 2, args.length);
        runMethod(clazz, methodName, rawArgs);
    }

    private static void runMain(Class<?> clazz) throws Exception {
        Method main;
        try {
            main = clazz.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            System.err.println(clazz.getName() + " has no public static void main(String[]) method.");
            System.err.println("Run a specific method instead: jrun " + clazz.getSimpleName() + " <methodName> [args...]");
            System.exit(1);
            return;
        }
        main.invoke(null, (Object) new String[0]);
    }

    private static void runMethod(Class<?> clazz, String methodName, String[] rawArgs) throws Exception {
        List<Method> candidates = new ArrayList<>();
        for (Method m : clazz.getMethods()) {
            if (m.getName().equals(methodName) && m.getParameterCount() == rawArgs.length) {
                candidates.add(m);
            }
        }

        if (candidates.isEmpty()) {
            System.err.println("No public method '" + methodName + "' with " + rawArgs.length
                    + " argument(s) found on " + clazz.getName() + ".");
            System.err.println("Available methods:");
            for (Method m : clazz.getMethods()) {
                if (m.getDeclaringClass() == clazz) {
                    System.err.println("  " + m);
                }
            }
            System.exit(1);
            return;
        }

        Method target = candidates.get(0);
        Object[] convertedArgs = new Object[rawArgs.length];
        for (int i = 0; i < rawArgs.length; i++) {
            convertedArgs[i] = convert(rawArgs[i], target.getParameterTypes()[i]);
        }

        Object instance = null;
        if (!Modifier.isStatic(target.getModifiers())) {
            instance = newInstance(clazz);
        }

        Object result = target.invoke(instance, convertedArgs);
        System.out.println(describe(result));
    }

    private static Object newInstance(Class<?> clazz) throws Exception {
        try {
            Constructor<?> ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            return ctor.newInstance();
        } catch (NoSuchMethodException e) {
            System.err.println(clazz.getName() + " has no no-arg constructor, so its instance methods can't be "
                    + "run directly. Add a quick main(String[]) method instead.");
            System.exit(1);
            return null;
        }
    }

    private static Object convert(String raw, Class<?> type) {
        if (type.isArray()) {
            Class<?> component = type.getComponentType();
            if (raw.isEmpty()) {
                return Array.newInstance(component, 0);
            }
            String[] parts = raw.split(",");
            Object array = Array.newInstance(component, parts.length);
            for (int i = 0; i < parts.length; i++) {
                Array.set(array, i, convertScalar(parts[i].trim(), component));
            }
            return array;
        }
        return convertScalar(raw, type);
    }

    private static Object convertScalar(String raw, Class<?> type) {
        if (type == int.class || type == Integer.class) return Integer.parseInt(raw);
        if (type == long.class || type == Long.class) return Long.parseLong(raw);
        if (type == double.class || type == Double.class) return Double.parseDouble(raw);
        if (type == float.class || type == Float.class) return Float.parseFloat(raw);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(raw);
        if (type == char.class || type == Character.class) return raw.charAt(0);
        if (type == String.class) return raw;
        throw new IllegalArgumentException("Unsupported parameter type: " + type.getName()
                + " — add a main(String[]) method instead for complex inputs.");
    }

    private static String describe(Object result) {
        if (result == null) return "null";
        Class<?> type = result.getClass();
        if (type.isArray()) {
            if (result instanceof Object[]) return java.util.Arrays.deepToString((Object[]) result);
            if (result instanceof int[]) return java.util.Arrays.toString((int[]) result);
            if (result instanceof long[]) return java.util.Arrays.toString((long[]) result);
            if (result instanceof double[]) return java.util.Arrays.toString((double[]) result);
            if (result instanceof float[]) return java.util.Arrays.toString((float[]) result);
            if (result instanceof boolean[]) return java.util.Arrays.toString((boolean[]) result);
            if (result instanceof char[]) return java.util.Arrays.toString((char[]) result);
        }
        return String.valueOf(result);
    }
}
