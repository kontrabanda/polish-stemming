import java.io.*;

public class FileController {
	private Parser parser;
	private InputParams params;
	private File file;

	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	public FileController(File file, InputParams params) {
		parser = Parser.getInstance(params.actionType);

		this.file = file;
		this.params = params;
	}

	private void openStreams() {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			fileWriter = new FileWriter(params.outputPath + "output-" + file.getName(), true);
			bufferedWriter = new BufferedWriter(fileWriter);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void closeStreams() {
		try {
			bufferedWriter.close();
			bufferedReader.close();
			fileReader.close();
			fileWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void performParse() {
		openStreams();

		try {
			for(String line; (line = bufferedReader.readLine()) != null;) {
				String output = parser.parse(line);

				bufferedWriter.write(output);
				bufferedWriter.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		closeStreams();
	}

	public String getFileName() {
		return file.getName();
	}
}