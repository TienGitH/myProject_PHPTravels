package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class logFile {
	
	public void createNewFile(String fileName)
	{
		try {
			File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
			String filePath = tempDirectory.getAbsolutePath() + fileName;
			System.out.println(filePath);
			//main.getDirectory(System.getProperty("user.dir") + "//src//test//java");
			File myObj = new File(filePath);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred." + e);
		      e.printStackTrace();
		    }
	}
	
	public void writeToFile(String fileName, String text)
	{
		try {
		      FileWriter myWriter = new FileWriter(fileName);
		      myWriter.write(text);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred." + e);
		      e.printStackTrace();
		    }
	}
}
