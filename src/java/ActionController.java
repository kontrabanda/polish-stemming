import java.util.*;

public class ActionController {
	private TimeLogger timeLogger;
	private FileControllerListGetter fileListGetter;
	private ArrayList<FileController> csvFiles;
	private ArrayList<FileController> txtFiles;

	public ActionController(InputParams params) {
		fileListGetter = new FileControllerListGetter(params);
		timeLogger = new TimeLogger();

		csvFiles = fileListGetter.getFileList(".csv");
		txtFiles = fileListGetter.getFileList(".txt");
	}

	public void performAction() {
		performActionForEachInList(csvFiles);
		performActionForEachInList(txtFiles);
	}

	private void performActionForEachInList(ArrayList<FileController> list) {
		for(FileController fileControler: list) {
			timeLogger.start();

			fileControler.performParse();

			timeLogger.end();

			System.out.println("Parse " + fileControler.getFileName() + " took:");
			timeLogger.printFullTime();
			System.out.println();
		}	
	}
}