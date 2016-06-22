package chap1.methodasfirstclass;

import java.io.File;
import java.io.FileFilter;

public class FilterHiddenFiles {

    public File[] getHiddenFiles() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        return hiddenFiles;
    }

    public File[] getHiddenFilesMethodReference() {
        File[] allFiles = new File(".").listFiles(File::isHidden);
        return allFiles;
    }

}
