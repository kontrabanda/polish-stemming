import java.io.*;
import java.util.*;

public class FileControllerListGetter {
	private InputParams params;

	public FileControllerListGetter(InputParams params) {
		this.params = params;
	}

	public ArrayList<FileController> getFileList(String extension) {
		ArrayList<FileController> result = new ArrayList<FileController>();

		File directory = new File(params.inputPath);
		File[] fileList = directory.listFiles();

		for(File file : fileList) {
			if(file.isFile() && file.getName().endsWith(extension)) {
				result.add(new FileController(file, params));
			}
		}

		return result;
	}
}