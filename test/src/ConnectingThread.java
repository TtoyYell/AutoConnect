import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectingThread extends Thread{

    private volatile String url;

    public ConnectingThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            URL realUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) realUrl.openConnection();
            urlConnection.connect();
            int code = urlConnection.getResponseCode();
            System.out.println(url+"\t"+code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String writeDate) throws Exception{

        File F=new File("D:/file.txt");
        //如果文件不存在,就动态创建文件
        if(!F.exists()){
            boolean file = F.createNewFile();
        }
        //writeDate  写入的内容
        try (FileWriter fw = new FileWriter(F, true)) {
            //设置为:True,表示写入的时候追加数据
            //回车并换行
            fw.write(writeDate + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
