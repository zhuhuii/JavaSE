//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {
    // key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    // Ingeter是Number的一个子类,并不能传进来。这是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue(Generic<Number> obj) {
        System.out.println("泛型测试：key value is " + obj.getKey());
    }

    // ?：通配符表示任何类型，这也是一个普通的方法，只不过使用了泛型通配符?
    public void showKeyValue222(Generic<?> obj) {
        System.out.println("泛型测试：key value is " + obj.getKey());
    }

    //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
    //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
    //所以在这个方法中才可以继续使用 T 这个泛型。
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Generic() {
    }

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    /**
     * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
     * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
     */
//    public E setKey(E key) {
//        this.key = keu
//    }
}