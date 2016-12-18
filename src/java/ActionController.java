import java.util.*;

public class ActionController {
	private FileControllerListGetter fileListGetter;
	private ArrayList<FileController> csvFiles;
	private ArrayList<FileController> txtFiles;

	public ActionController(InputParams params) {
		fileListGetter = new FileControllerListGetter(params);

		csvFiles = fileListGetter.getFileList(".csv");
		txtFiles = fileListGetter.getFileList(".txt");
	}

	public void performAction() {
		performActionForEachInList(csvFiles);
		performActionForEachInList(txtFiles);
	}

	private void performActionForEachInList(ArrayList<FileController> list) {
		for(FileController fileControler: list) {
			long startTime = System.currentTimeMillis();

			fileControler.performParse();

			long endTime = System.currentTimeMillis();
			System.out.println();
			System.out.println(fileControler.getFileName() + ": took " + (endTime - startTime) + " milliseconds");
		}	
	}
}