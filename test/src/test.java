import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("https://www.baidu.com");
        list.add("https://search.bilibili.com");
        list.add("https://www.csdn.net");
        list.add("https://www.163.com");
        for (String s : list) {
            new ConnectingThread(s).start();
        }
    }
}
