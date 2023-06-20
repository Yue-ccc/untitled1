package 静态方法;

public class test静态方法 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void print(){
        System.out.println("test的静态方法");
    }
}
class t1{
    public static void main(String[] args) {
        test静态方法 test = new test静态方法();
        test.setName("yuer");
        test.print();
    }
}
