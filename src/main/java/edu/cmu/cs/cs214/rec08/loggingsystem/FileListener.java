package edu.cmu.cs.cs214.rec08.loggingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileListener implements Listener {
	private final PrintWriter fileOut;

	public FileListener(String filename) {
		try {
			fileOut = new PrintWriter(new File(filename));
			fileOut.println("File logger started up.");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Could not open specified file.", e);
		}
	}

	@Override
	public void onDebugEvent(String message) {
		fileOut.println("[Debug] " + message);
	}

	@Override
	public void onErrorEvent(String error) {
		fileOut.println("[Error] " + error);
	}

	@Override
	public void onCloseEvent() {
		fileOut.println("Logger shutting down");
		fileOut.close();
	}

}