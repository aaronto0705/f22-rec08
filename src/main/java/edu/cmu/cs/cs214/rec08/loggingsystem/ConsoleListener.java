package edu.cmu.cs.cs214.rec08.loggingsystem;

public class ConsoleListener implements Listener {
	public ConsoleListener() {
		System.out.println("Console logger started up.");
	}

	@Override
	public void onDebugEvent(String message) {
		System.out.println("[Debug] " + message);
	}

	@Override
	public void onErrorEvent(String error) {
		System.out.println("[Error] " + error);
	}

	@Override
	public void onCloseEvent() {
		System.out.println("Logger shutting down.");
	}

}