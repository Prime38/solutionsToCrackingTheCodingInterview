package arraysAndStrings;

public class TestString {


    public static void main(String[] args) {
        String s1="testString";
        String s2 = "testString";

        String s3 = new String("testString");
        Something something;
        try {
            Thread.sleep(3000);
            something=new Something("testString");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Runnable thread=new Runnable(){
//            @Override
//            public void run() {
//                Something s=new Something("testString");
//            }
//        };
//        thread.run();

        Something otherThing=new Something("testString");
    }
}
class Something{
    String s;
    Something(String s){
        this.s=s;
    }
}
