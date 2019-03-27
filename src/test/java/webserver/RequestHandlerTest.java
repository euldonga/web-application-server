package webserver;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.HttpRequestUtils;

public class RequestHandlerTest {
	private static final Logger logger = LoggerFactory.getLogger(RequestHandlerTest.class);

	@Test
	public void bytes() throws Exception {
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

	@Test
	public void queryString() throws Exception {
		String query = "/create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net ";

		int index = query.indexOf("?");
		String requestPath = query.substring(0, index);
		String param = query.substring(index + 1);

		logger.debug("index: {}", index);
		logger.debug("requestPath: {}", requestPath);
		logger.debug("param: {}", param);

		Map<String, String> map = HttpRequestUtils.parseQueryString(param);
		logger.debug("map: {}", map.toString());
	}
	
	@Test
	public void setHeader() throws Exception {
		String[] headers = new String[9];
		headers[0] = "GET / HTTP/1.1";
		headers[1] = "Host: localhost:8080";
		headers[2] = "Connection: keep-alive";
		headers[3] = "Cache-Control: max-age=0";
		headers[4] = "Upgrade-Insecure-Requests: 1";
		headers[5] = "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36";
		headers[6] = "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
		headers[7] = "Accept-Encoding: gzip, deflate, br";
		headers[8] = "Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7";
		
		for (String string : headers) {
			logger.debug("{}", string);
		}
		
		
		
	}


















}
