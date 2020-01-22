import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMethod {
    String author() default "zhuhui";

    String description();

    long id() default 1L;

    String[] parameters();

    String[] returns();

}
