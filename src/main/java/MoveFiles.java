import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;


public class MoveFiles {

    List<Path> dirPathList;
    public MoveFiles(List<Path> dirPathList) {
        this.dirPathList=dirPathList;
    }

    public void fileMove(String sorted_dir, String file) throws IOException {

        Path pathToFile = Path.of(sorted_dir + "\\" + file);
        BasicFileAttributes fileAttributes = Files.readAttributes(pathToFile, BasicFileAttributes.class);
        if (!fileAttributes.isDirectory()){
            if (isZipFile(pathToFile))
                Files.move(pathToFile, Path.of(dirPathList.get(0).toString(), file), StandardCopyOption.REPLACE_EXISTING);
            else if (isImageFile(pathToFile))
                Files.move(pathToFile, Path.of(dirPathList.get(1).toString(), file), StandardCopyOption.REPLACE_EXISTING);
            else if (isPdfFile(pathToFile))
                Files.move(pathToFile, Path.of(dirPathList.get(2).toString(), file), StandardCopyOption.REPLACE_EXISTING);
            else if (isExeFile(pathToFile))
                Files.move(pathToFile, Path.of(dirPathList.get(3).toString(), file), StandardCopyOption.REPLACE_EXISTING);
            else if (isJarFile(pathToFile))
                Files.move(pathToFile, Path.of(dirPathList.get(4).toString(), file), StandardCopyOption.REPLACE_EXISTING);
            else
                Files.move(pathToFile, Path.of(dirPathList.get(5).toString(), file), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(dirPathList.get(3));
    }
}

    private boolean isZipFile(Path pathToFile) {
        String[] imageExtensions ={".zip",".tar",".7z"};
        for(String extension:imageExtensions)
            if(pathToFile.toString().endsWith(extension))
                return true;
        return false;
    }
    private boolean isImageFile(Path pathToFile) {
        String[] imageExtensions ={".jpg",".jpeg",".png"};
        for(String extension:imageExtensions)
            if(pathToFile.toString().endsWith(extension))
                return true;
        return false;
    }
    private boolean isPdfFile(Path pathToFile) {
        String extension =".pdf";
        if(pathToFile.toString().endsWith(extension))
            return true;
        return false;
    }
    private boolean isExeFile(Path pathToFile) {
        String extension =".exe";
        if(pathToFile.toString().endsWith(extension))
            return true;
        return false;
    }
    private boolean isJarFile(Path pathToFile) {
        String extension =".jar";
        if(pathToFile.toString().endsWith(extension))
            return true;
        return false;
    }


}
