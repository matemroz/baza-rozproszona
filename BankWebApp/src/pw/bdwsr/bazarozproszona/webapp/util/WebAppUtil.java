package pw.bdwsr.bazarozproszona.webapp.util;

import java.io.PrintWriter;

public class WebAppUtil {
	public static void printSimpleTableRow(PrintWriter writer, String key, String value){
		writer.write("<tr><td>" + key + ":</td><td>" + value + "</td></tr>");
	}
}
