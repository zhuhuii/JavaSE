import javax.naming.Name;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: zhuhui
 */
@TestAnnotation(id = 400, name = "陈安安")
public class Run {

    static class Dog {
        private String name;

        @TestField(author = "lisi",description = "品种")
        private String breed;

        @TestMethod(description = "肯骨头方法", parameters = {}, returns = {})
        private void gnaw() {
            System.out.println("Animal gnaw（啃骨头）..");
        }

        protected void eat() {
            System.out.println("Animal eat（喝汤）...");
        }

        public void bite() {
            System.out.println("Animal bite（咬人）...");
        }

        public static void main(String[] args) throws NoSuchMethodException {
            Class<Dog> dogClass = Dog.class;
            Method gnaw = dogClass.getDeclaredMethod("gnaw");
            boolean annotationPresent = gnaw.isAnnotationPresent(TestMethod.class);
            if (annotationPresent){
                TestMethod annotation = gnaw.getAnnotation(TestMethod.class);
                System.out.println(annotation.toString());
            }

            System.out.println("============================================================");

            Field[] fields = dogClass.getDeclaredFields();
            for (Field field : fields) {
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    System.out.println(field + " <===> " +annotation);
                }
            }
        }
    }

    public static void main(String[] args) {
        Class<Run> runClass = Run.class;
        boolean annotationPresent = runClass.isAnnotationPresent(TestAnnotation.class);
        if (annotationPresent) {
            TestAnnotation testAnnotation = runClass.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("name" + testAnnotation.name());
            System.out.println("------------------------------");

            Annotation[] annotations = runClass.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
                System.out.println(annotation.annotationType().getSimpleName());
            }
        }
    }
}
