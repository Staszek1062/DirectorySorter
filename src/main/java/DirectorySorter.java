

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DirectorySorter {
    final static private String PATH_TO_HOME_DIR = System.getProperty("user.home");
    final static private String PATH_TO_DOWNLOAD_DIR = PATH_TO_HOME_DIR + "\\Downloads";
    final static private String PATH_TO_ZIP_DIR =  "ZIP";
    final static private String PATH_TO_IMAGE_DIR = "IMAGE";
    final static private String PATH_TO_PDF_DIR = "PDF";
    final static private String PATH_TO_EXE_DIR = "EXE";
    final static private String PATH_TO_JAR_DIR = "JAR";
    final static private String PATH_TO_REST_DIR = "REST";
    final static private String PATH_TO_DATA_DIR = "SortedData";
    static List<Path> dirPathList;
   public static void run() throws IOException {
       dirPathList = new LinkedList<>();
        getPaths();
        //Counter counter = new Counter(PATH_TO_HOME_DIR) ;
        MoveFiles moveF =new  MoveFiles(dirPathList);
        File dir =new File(PATH_TO_DOWNLOAD_DIR);
        List<File> fileList = Arrays.asList(dir.listFiles());

        for(File file:fileList){
            moveF.fileMove(PATH_TO_DOWNLOAD_DIR,file.getName());
        }

    }

    private static void getPaths() {

        Path zipDirectory = createDirectory(  PATH_TO_DOWNLOAD_DIR,PATH_TO_ZIP_DIR);
        Path imageDirectory = createDirectory(PATH_TO_DOWNLOAD_DIR,PATH_TO_IMAGE_DIR);
        Path pdfDirectory = createDirectory(  PATH_TO_DOWNLOAD_DIR,PATH_TO_PDF_DIR);
        Path exeDirectory = createDirectory(  PATH_TO_DOWNLOAD_DIR,PATH_TO_EXE_DIR);
        Path jarDirectory = createDirectory(  PATH_TO_DOWNLOAD_DIR,PATH_TO_JAR_DIR);
        Path restDirectory = createDirectory( PATH_TO_DOWNLOAD_DIR,PATH_TO_REST_DIR);
        Path dataDirectory = createDirectory( PATH_TO_DOWNLOAD_DIR,PATH_TO_DATA_DIR);

        dirPathList.add(zipDirectory);
        dirPathList.add(imageDirectory);
        dirPathList.add(pdfDirectory);
        dirPathList.add(exeDirectory);
        dirPathList.add(jarDirectory);
        dirPathList.add(restDirectory);
        dirPathList.add(dataDirectory);

    }

    private static Path createDirectory(String path_to_sorted_dir, String created_dir) {
        try { return Files.createDirectories(Path.of(path_to_sorted_dir,created_dir)); }
        catch (IOException e) {throw new RuntimeException(e);}
    }
}
