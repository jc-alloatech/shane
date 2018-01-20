import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Proprietary and Confidential
 *           AlloaTech, LLC.
 *   
 * 	This document contains material which is proprietary and confidential 
 *  property of ThorCode.
 *   
 *  The right to view, reproduce, modify, distribute, or in any way display
 *  this work is prohibited without the expressed written consent of 
 *  ThorCode
 *
 *  Copyright &copy; 2018
 *  Initial commit:  Jan 19, 201811:16:03 AM
 *  User:  thor 
 */
/**
 * @author thor
 */
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
