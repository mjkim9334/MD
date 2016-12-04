import java.io.*;


public class FileWriteHelper {
    static //private Writer writer;
            Writer writer;

    private static FileWriteHelper instance;

    private FileWriteHelper() throws IOException {
        try {
            //writer = new PrintWriter("output.txt", "UTF-8");

            writer = new PrintWriter(new FileWriter("output.html", true));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    };



    public void print(String s) throws IOException {

        writer = new PrintWriter(new FileWriter("output.html", true));
        //writer = new PrintWriter("output.txt", "UTF-8");
        ((PrintWriter)writer).print(s);
        writer.close();


    }

    public void println(String s) throws IOException {

        writer = new PrintWriter(new FileWriter("output.html", true));
        //writer = new PrintWriter("output.txt", "UTF-8");
        ((PrintWriter)writer).println(s);
        writer.close();
    }

    public static FileWriteHelper getInstance() throws IOException {
        if(instance == null)
            instance = new FileWriteHelper();

        return instance;
    }
}