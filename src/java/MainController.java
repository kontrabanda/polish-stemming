import java.io.*;

public class MainController {
	private final String inputPath = "./src/resource/";
	private final String outputPath = "./target/output/";

	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private StemmingController stemmingController;

	public MainController(String fileName) {
		stemmingController = new StemmingController();

		openStreams(fileName);
	}

	private void openStreams(String fileName) {
		try {
			fileReader = new FileReader(inputPath + fileName);
			bufferedReader = new BufferedReader(fileReader);

			fileWriter = new FileWriter(outputPath + "output-" +fileName, true);
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
				String output = stemmingController.getStemmedString(line);

				bufferedWriter.write(output);
				bufferedWriter.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainController controller = new MainController(args[0]);
	
		long startTime = System.currentTimeMillis();

		controller.performStemming();
		
		long endTime = System.currentTimeMillis();

		System.out.println();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		controller.closeStreams();
	}
};