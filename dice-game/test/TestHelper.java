import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestHelper {
    
    
    
    public static boolean hasCopyConst(Class clazz) {
        boolean result = false;
        Constructor[] constr = clazz.getDeclaredConstructors();
        for (Constructor constructor : constr) {
            if (isPublic(constructor.getModifiers()) && constructor.getParameterCount() == 1
                    && constructor.getParameterTypes()[0].isAssignableFrom(clazz)) {
                result = true;
            }
        }
        return result;
    }

   
    public static boolean hasDeclaredField(Class clazz, String fieldName, String type) {
        boolean result = false;
        try {
            result = true;
            Field field = clazz.getDeclaredField(fieldName);
            result &= isPrivate(field.getModifiers());
            result &= type.equals(field.getType().getName());
        }
        catch (NoSuchFieldException | SecurityException e) {}
        return result;
    }

    
    
    public static boolean hasDefaultConst(Class clazz) {
        boolean result = false;
        Constructor[] constr = clazz.getDeclaredConstructors();
        for (Constructor constructor : constr) {
            if (isPublic(constructor.getModifiers()) && constructor.getParameterCount() == 0) {
                result = true;
            }
        }
        return result;
    }
    
    public static boolean isPublic(int modifiers) {
        return Modifier.isPublic(modifiers);
    }

    public static boolean isPrivate(int modifiers) {
        return Modifier.isPrivate(modifiers);
    }

}
