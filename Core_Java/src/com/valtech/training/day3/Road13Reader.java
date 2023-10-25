package com.valtech.training.day3;

import java.io.IOException;
import java.io.Reader;

public class Road13Reader extends Reader {
	
	private Reader source;
	 
	public Road13Reader(Reader source) {
		this.source = source;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int bytesRead = source.read(cbuf,off,len);
		for (int i = 0; i < cbuf.length; i++) {
			cbuf[off+i] = Road13Helper.rotate((char)(cbuf[off+i]));
		}
		return bytesRead;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		source.close();
	}

}
