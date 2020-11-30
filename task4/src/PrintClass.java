import java.lang.reflect.*;

public class PrintClass {
    public static String printFields(Class obj) {
        System.out.println("\nFIELDS:");
        String str = "";
        Field[] fields = obj.getFields();
        for (Field i : fields) {
            str += "\t" + i.getType() + ": " + i.getName() + "\n";
        }
        return str;
    }

    public static String printMethods(Class obj) {
        System.out.println("\nMETHODS:");
        String str = "";
        Method[] methods = obj.getMethods();
        for (Method i : methods) {
            str += "\t" + i.getReturnType() + " " + i.getName() + "(";
            Parameter[] parameters = i.getParameters();
            for (Parameter j : parameters) {
                str += j.getType() + " " + j.getName() + "; ";
            }
            str += ")\n";
        }
        return str;
    }

    public static String printCostructors(Class obj) {
        System.out.println("\nCONSTRUCTORS:");
        String str = "";
        Constructor[] constructors = obj.getConstructors();
        for (Constructor i : constructors) {
            str += "\t" + i.getName() + "(";
            Parameter[] parameters = i.getParameters();
            for (Parameter j : parameters) {
                str += j.getType() + " " + j.getName() + "; ";
            }
            str += ")";
        }
        return str;
    }
}
