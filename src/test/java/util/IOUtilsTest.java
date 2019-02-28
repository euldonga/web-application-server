package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOUtilsTest {
	private static final Logger logger = LoggerFactory.getLogger(IOUtilsTest.class);
	
	@Test
	public void readData() throws Exception {
		String data = "abcd123";
		StringReader sr = new StringReader(data);
		BufferedReader br = new BufferedReader(sr);
		
		logger.debug("parse body : {}", IOUtils.readData(br, data.length()));
	}
	
	@Test
	public void someTest() throws Exception {
		byte[] body = "Hello World".getBytes();
		logger.debug("getBytes : {}", body);
	}
	
	@Test
	public void filePath() throws Exception {
		logger.debug("path 1 : {}", new File("./webapp").getCanonicalPath());
		logger.debug("path 2 : {}", new File(".").getCanonicalPath());
		logger.debug("path 3 : {}", new File("../").getCanonicalPath());
		logger.debug("path 4 : {}", new File("../../").getCanonicalPath());
	}
	
	@Test
	public void byteToChar() throws Exception {
		byte[] body = Files.readAllBytes(new File("./webapp/index.html").toPath());
		logger.debug("bytes: {}", new String(body));
	}
}
