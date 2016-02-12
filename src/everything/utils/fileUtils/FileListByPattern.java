package everything.utils.fileUtils;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * User: Makar Kalancha
 * Date: 11/09/14
 * Time: 4:45 PM
 */
public class FileListByPattern {
    public static void main(String[] args) {
        String pattern = "*.jar";
        String rootDir = "D:\\SRC\\JavaEE_work_dir\\HibernateProject\\lib";

        Path rootDirPath = Paths.get(rootDir);
        try{
            Files.walkFileTree(rootDirPath, new FileVisitor(rootDirPath,pattern));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {
        private PathMatcher _pathMatcher;
        private Path _destination;
        public FileVisitor(Path destination, String pattern) {
            this._destination = destination;
            try {
                this._pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid pattern; did you forget to prefix \"glob:\"? (as in glob:*.java)");
                System.exit(-1);
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("file name:"+file.getFileName());
            find(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("--------------dir name:" + dir);
            find(dir);
            return FileVisitResult.CONTINUE;
        }

        private void find (Path path) {
            Path name = path.getFileName();
            if (_pathMatcher.matches(name)) {
                System.out.println("Matching file: "+path.getFileName());
                Path destPath = Paths.get(_destination.toAbsolutePath() + FileSystems.getDefault().getSeparator() + path.getFileName());
                System.out.println("dest full path " + destPath);
//                System.out.println("relative path "+_destination.relativize(path));
//                System.out.println("relative destPath "+path.relativize(_destination));
                try{
                    Files.move(path, destPath, StandardCopyOption.REPLACE_EXISTING);
//                    Files.copy(path, destPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
