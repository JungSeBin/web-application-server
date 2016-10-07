package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import util.HttpRequest;
import util.RequestLine.HttpMethod;

public class HttpRequestTest {
	private String testDirectory = "./src/test/resource/";
	
	@Test
	public void request_GET() throws Exception {
		InputStream in = new FileInputStream(new File(testDirectory + "Http_GET.txt"));
		
		HttpRequest request = new HttpRequest(in);
		
		assertEquals(HttpMethod.GET, request.getMethod());
		assertEquals("/user/create", request.getPath());
		assertEquals("keep-alive", request.getHeader("Connection"));
		assertEquals("seb", request.getParameter("userId"));
	}
	
	public void request_POST() throws Exception {
	    InputStream in = new FileInputStream(new File(testDirectory + "Http_POST.txt"));
		
		HttpRequest request = new HttpRequest(in);
		
		assertEquals(HttpMethod.POST, request.getMethod());
		assertEquals("/user/create", request.getPath());
		assertEquals("keep-alive", request.getHeader("Connection"));
		assertEquals("seb", request.getParameter("userId"));
	} 
}     