package edu.cmu.cs.cs214.rec08.loggingsystem;

public interface Listener {
	void onDebugEvent(String message);
	void onErrorEvent(String error);
	void onCloseEvent();
}