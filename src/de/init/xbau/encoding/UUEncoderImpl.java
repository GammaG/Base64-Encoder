package de.init.xbau.encoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tools.ant.util.UUEncoder;

public class UUEncoderImpl {

	public File encode(File inputfile) throws IOException {

		UUEncoder uuec = new UUEncoder("encode");

		File outFile = File.createTempFile("encoded", "uue");
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(inputfile);
			os = new FileOutputStream(outFile);
			uuec.encode(is, os);
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
			try {
				os.close();
			} catch (Exception e) {
			}
		}
		return outFile;

	}

}
