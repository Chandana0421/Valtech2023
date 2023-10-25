package com.valtech.training.day3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Road13Writer extends Writer{
	
	private Writer dest;
	
	public Road13Writer(Writer dest) {
		this.dest = dest;
	}
	
	
	@Override
	public void write(int c) throws IOException {
		dest.write(Road13Helper.rotate((char) c));
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = 0; i < cbuf.length; i++) {
			cbuf[off+i] = Road13Helper.rotate((char)(cbuf[off+i]));
		}
		dest.write(cbuf,off,len);
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		dest.flush();
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		dest.close();
		
	}
}
