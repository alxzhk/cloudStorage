import java.io.*;

public class IoIntro {


    private  static  final byte [] buffer = new byte[1024];
    private static final String APP_NAME = "server/";
    private static final String ROOT_DIR = "server/root/";


    private void createServerDir(String dirName){
     File dir = new File(APP_NAME + dirName);
     if(!dir.exists()){
         dir.mkdir();
     }

    }

    private  String resourceAsString(String resourceName) throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream(resourceName);
        int read = resourceAsStream.read(buffer);
        return new String(buffer,0,read);

    }

    private void transfer(File scr , File dst){
        try (FileInputStream is = new FileInputStream(scr);
            FileOutputStream os = new FileOutputStream(dst)){
            int read;
            while ((read = is.read(buffer)) != -1){
                os.write(buffer,0,read);
                os.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        IoIntro ioIntro = new IoIntro();
//        ioIntro.createServerDir("root");
//        ioIntro.transfer(new File("C:\\Users\\Alexander\\IdeaProjects\\cloudStorage\\server\\src\\main\\resources\\hello.txt"),
//                         new File(ROOT_DIR + "copy.txt"));
        


    }
}
