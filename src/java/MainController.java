import java.io.*;

public class MainController {
	public MainController(InputParams params) {
		ActionController ac = new ActionController(params);
		ac.performAction();
	}

	public static void main(String[] args) {
		InputParams params = new InputParams();

		params.actionType = args[0];
		params.outputPath = "./target/output/";
		params.inputPath = "./src/resource/";
		
		MainController controller = new MainController(params);
	}
};