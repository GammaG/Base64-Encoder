package de.init.xbau.main;

import java.io.File;

import de.init.xbau.encoding.Base64Util;
import de.init.xbau.encoding.UUDecoderImpl;
import de.init.xbau.encoding.UUEncoderImpl;
import de.init.xbau.filemanagement.FileReader;
import de.init.xbau.filemanagement.FileSaver;

public class Main {
	private String path;

	/**
	 * Main class for XBau base 64 Encoding
	 * 
	 * @param args
	 *            the file to encode
	 */
	public static void main(String[] args) {
		// String text =
		// "SADFASDFASaslkudfiuawnsieunifuanwiuenfuianw8ejniuaw487ch3aqz48o7hf8anwdf";
		String text;
		try {
			String path = args[0];

			// if (text == null)
			// throw new IllegalArgumentException("Dokument content is null");
			Main main = new Main();
			main.setPath(path);
			FileReader reader = new FileReader();

			UUEncoderImpl uuEncoding = new UUEncoderImpl();
			System.out.println("Start UUEcoding of " + path);
			File file = uuEncoding.encode(new File(path));
			String fileContent = reader.readFile(file);
			fileContent = main.testRun(fileContent);
			System.out.println("Start UUDecoding of " + path);
			UUDecoderImpl uudcoder = new UUDecoderImpl();
			Object resultFile = uudcoder.decode(fileContent);

			new FileSaver().saveContent(path, resultFile.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Test the Encoding and Decoding with the given parameters
	 * 
	 * @param text
	 * @throws Exception
	 */
	private String testRun(String text) throws Exception {
		Base64Util base64Util = new Base64Util();
		System.out.println("Org: " + text + "\n\n");
		String encoded = base64Util.encode(text);
		System.out.println("Enc: " + encoded + "\n\n");
		String decoded = base64Util.decode(encoded);
		System.out.println("Dec: " + decoded + "\n\n");

		System.out.println("Original text and decoded match: " + text.equals(decoded));
		return decoded;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
