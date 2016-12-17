import java.io.*;

public class MainController {
	FileReader fileReader;
	FileWriter fileWriter;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;

	public MainController() {
		openStreams();
	}

	private void openStreams() {
		try {
			fileReader = new FileReader("./src/resource/text.txt");
			bufferedReader = new BufferedReader(fileReader);

			fileWriter = new FileWriter("./target/output/output.txt", true);
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


	public void performStemming() {
		try {
			for(String line; (line = bufferedReader.readLine()) != null;) {
				System.out.println(line);
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainController controller = new MainController();
		controller.performStemming();
		controller.closeStreams();
	}
};