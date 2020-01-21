package limit;

/**
 * Description: 泛型的约束和局限性
 */
public class GenericRestrict<T> {
    static class NormalClass {
    }

    private T data;

    /**
     * 不能实例化泛型类
     * Type parameter 'T' cannot be instantiated directly
     */
    public void setData() {
        //this.data = new T();
    }

    /**
     * 静态变量或方法不能引用泛型类型变量
     * 'com.jay.java.泛型.restrict.GenericRestrict1.this' cannot be referenced from a static context
     */
//    private static T result;

//    private static T getResult() {
//        return result;
//    }

    /**
     * 静态泛型方法是可以的
     */
    private static <K> K getKey(K k) {
        return k;
    }

    public static void main(String[] args) {
        NormalClass normalClassA = new NormalClass();
        NormalClass normalClassB = new NormalClass();

        /**
         * 基本类型无法作为泛型类型
         */
//        GenericRestrict1<int> genericRestrictInt = new GenericRestrict1<>();
        GenericRestrict<Integer> genericRestrictInteger = new GenericRestrict<>();
        GenericRestrict<String> genericRestrictString = new GenericRestrict<>();

        /**
         * 无法使用instanceof关键字判断泛型类的类型
         * Illegal generic type for instanceof
         */
//        if(genericRestrictInteger instanceof GenericRestrict1<Integer>){
//            return;
//        }

        /**
         * 无法使用“==”判断两个泛型类的实例
         * Operator '==' cannot be applied to this two instance
         */
//        if (genericRestrictInteger == genericRestrictString) {
//            return;
//        }

        /**
         * 泛型类的原生类型与所传递的泛型无关，无论传递什么类型，原生类是一样的
         */
        System.out.println(normalClassA == normalClassB);//false
        System.out.println(genericRestrictInteger == genericRestrictInteger);//ture
        System.out.println(genericRestrictInteger.getClass() == genericRestrictString.getClass()); //true
        System.out.println(genericRestrictInteger.getClass());//limit.GenericRestrict
        System.out.println(genericRestrictString.getClass());//limit.GenericRestrict

        /**
         * 泛型数组可以声明但无法实例化
         * Generic array creation
         */
        GenericRestrict<String>[] genericRestricts;
//        genericRestrict1s = new GenericRestrict1<String>[10];
        genericRestricts = new GenericRestrict[10];
        genericRestricts[0] = genericRestrictString;
    }

}