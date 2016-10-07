package test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import util.RequestLine;
import util.RequestLine.HttpMethod;

public class RequestLineTest {
	@Test
	public void create_method() {
		RequestLine line = new RequestLine("GET /index.html HTTP/1.1");
		assertEquals(HttpMethod.GET, line.getMethod());
		assertEquals("/index.html", line.getPath());
		
		line = new RequestLine("POST /index.html HTTP/1.1");
		assertEquals("/index.html", line.getPath());
	}
	
	public void create_path_and_params() {
		RequestLine line = new RequestLine(
				"GET /user/create?userId=seb&password=123 HTTP/1.1");
		assertEquals(HttpMethod.GET, line.getMethod());
		assertEquals("/user/create", line.getPath());
		Map<String, String> params = line.getParams();
		assertEquals(2, params.size());
	}
}