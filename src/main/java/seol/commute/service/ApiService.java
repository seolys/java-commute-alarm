package seol.commute.service;

import java.io.IOException;
import java.util.Map;
import org.json.simple.parser.ParseException;

public interface ApiService {

	Map<String, String> login() throws IOException;

	String getWorkInTime(Map<String, String> loginCookie) throws IOException, ParseException;
}
