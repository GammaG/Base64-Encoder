package de.init.xbau.encoding;

import java.io.IOException;

import org.mule.transformers.codec.UUDecoder;
import org.mule.umo.transformer.TransformerException;

public class UUDecoderImpl {

	public Object decode(String encoded) throws TransformerException, IOException {

		UUDecoder decoder = new UUDecoder();

		return decoder.transform(encoded);

	}

}
