package de.init.xbau.filemanagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FileSaver {
	private volatile Writer fw;
	private volatile Writer bw;
	private volatile PrintWriter pw;

	/**
	 * Save the given text as a new file located under the given path
	 * 
	 * @param filePath
	 * @param textToSave
	 * @throws IOException
	 */
	public void saveContent(String filePath, String textToSave) throws IOException {

		File file = generateNewFileName(filePath);

		fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);

		pw.println(textToSave);
		pw.close();

		System.out.println("Saved as " + file.getAbsoluteFile());
	}

	public void saveContent(String filePath, Object resultFile) {

		File file = generateNewFileName(filePath);

	}

	/**
	 * Add a "2" in the first part of the filename and return the {@link File}
	 * 
	 * @param path
	 * @return
	 */
	private File generateNewFileName(String path) {
		File file = new File(path);
		String temp = file.getName();
		String[] array = temp.split("[.]+");
		String newPath = file.getAbsolutePath();
		newPath = newPath.substring(0, newPath.lastIndexOf(File.separator));

		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				newPath += File.separator + array[i] + "2.";
				continue;
			}
			newPath += array[i] + ".";
		}
		newPath = newPath.substring(0, newPath.length() - 1);

		file = new File(newPath);
		return file;
	}
}
