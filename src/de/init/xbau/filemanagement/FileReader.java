package de.init.xbau.filemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {

	private volatile InputStream is;
	private volatile InputStreamReader isr;
	private volatile BufferedReader br;

	public String readFile(File file) throws IOException {
		try {
			// open input stream test.txt for reading purpose.
			is = new FileInputStream(file);

			// create new input stream reader
			isr = new InputStreamReader(is);

			// create new buffered reader
			br = new BufferedReader(isr);

			String fileContent = "";
			String line;

			// reads to the end of the stream
			while ((line = br.readLine()) != null) {
				fileContent = fileContent + line + "\n";
			}
			return fileContent;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// releases resources associated with the streams
			if (is != null)
				is.close();
			if (isr != null)
				isr.close();
			if (br != null)
				br.close();
		}
		return null;
	}
}
