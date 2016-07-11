package de.init.xbau.encoding;

import java.nio.charset.StandardCharsets;

import org.mule.util.Base64;

/**
 * Helper class for Base64 encoding/decoding
 * 
 * @author mseidler
 *
 */
public class Base64Util {

	/**
	 * Encode the given text and return the result as String
	 * 
	 * @param text
	 *            the text for to be encoded
	 * @return the encoding
	 * @throws Exception
	 */
	public String encode(String text) throws Exception {
		return Base64.encodeBytes(text.getBytes(StandardCharsets.UTF_8));
		// encode with padding
	}

	/**
	 * Decode a given encoded String
	 * 
	 * @param encoded
	 *            the text to decode
	 * @return the decoded String
	 * @throws Exception
	 */
	public String decode(String encoded) throws Exception {

		// decode a String
		byte[] bytes = Base64.decode(encoded);
		return new String(bytes, StandardCharsets.UTF_8);

	}

}
