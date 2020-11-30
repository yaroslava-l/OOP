import java.net.*;

public class ClassSelector{
        private String className;
        private String packageName;

        public ClassSelector(String packageName, String className) {
            this.packageName = packageName;
            this.className = className;
        }

        public Class load() throws ClassNotFoundException {
            ClassLoader loader = ClassSelector.class.getClassLoader();
            Class obj = loader.loadClass(packageName + className);
            return obj;
        }
}
