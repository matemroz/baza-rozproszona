package pw.bdwsr.bazarozproszona.webapp.util;

import java.io.PrintWriter;

public class CommunicationsHelper {
	public static void writeErrorCommunicate(PrintWriter writer, String errorCommunicate){
		writer.write("<h3>Error: <font color = \"red\">" + errorCommunicate + "</font></h3>");
	}
	
	public static void writeSuccessCommunicate(PrintWriter writer, String successCommunicate){
		writer.write("<h3>" + successCommunicate + "</h3>");
	}
}
