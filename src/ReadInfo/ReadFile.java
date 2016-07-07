// Reads Credentials from Utility.properties file AND writes commands to ScriptCommands.sh file.

package ReadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
public class ReadFile {

	// Returns the Credential's value from the .properties file
	public static String Read_file(String key){	

		File file = new File("Utility.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	// Writes commands to the .sh file
	public static void writeToFile(String args, List<String> ls) {
		try {
			PrintWriter pw = new PrintWriter(args);
			for(String line: ls)
			{
				pw.println(line);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
