package edu.cmu.cs.cs214.rec08.loggingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Supports writing of debug and error messages (with different prefixes) to
 * either the console or an output file. Configurable via constant fields within
 * the class.
 * 
 * TODO Rewrite the code such that different loggers can be configured and
 * added.
 */
public class Logger {
	private final List<Listener> listeners = new ArrayList<>();
	
	public Logger() { }

	/**
	 * Writes a debug message to the logging system.
	 * 
	 * @param message
	 *            The debug message to write.
	 */
	public void writeDebug(String message) {
		for (var listener : listeners) {
			listener.onDebugEvent(message);
		}
	}

	/**
	 * Writes an error message to the logging system.
	 * 
	 * @param error
	 *            The error message to write.
	 */
	public void writeError(String error) {
		for (var listener : listeners) {
			listener.onErrorEvent(error);
		}
	}

	/**
	 * Shuts down the logging system. After this method is called, the logger
	 * should not be used.
	 */
	public void close() {
		for (var listener : listeners) {
			listener.onCloseEvent();
		}
	}
	
	public void subscribe(Listener listener) {
		listeners.add(listener);
	}

}