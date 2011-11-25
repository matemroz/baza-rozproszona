package pw.bdwsr.bazarozproszona.webapp.util;

import java.io.PrintWriter;

public class CommunicationsHelper {
	public static void writeErrorCommunicate(PrintWriter writer, String errorCommunicate){
		writer.write("<font color = \"red\"><h3>" + errorCommunicate + "</h3></font>");
	}
	
	public static void writeSuccessCommunicate(PrintWriter writer, String successCommunicate){
		writer.write("<h3>" + successCommunicate + "</h3>");
	}
}
