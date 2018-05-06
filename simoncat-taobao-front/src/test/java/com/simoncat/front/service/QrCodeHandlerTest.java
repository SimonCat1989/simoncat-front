package com.simoncat.front.service;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class QrCodeHandlerTest {

	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();
	
	@Test
	public void testEncode() throws IOException {
		Path output1 = testFolder.newFile("english.png").toPath();
		Path output2 = testFolder.newFile("chinese.png").toPath();
		QrCodeHandler.encode("Hello World !!!", output1);
		QrCodeHandler.encode("中文测试", output2);
		assertTrue(output1.toFile().exists());
		assertTrue(output2.toFile().exists());
	}
	
	@Test
	public void testDecode() throws IOException {
		File source1 = new File(this.getClass().getResource("/qrcode").getFile(), "english.png");
		File source2 = new File(this.getClass().getResource("/qrcode").getFile(), "chinese.png");
		String result1 = QrCodeHandler.decode(source1);
		String result2 = QrCodeHandler.decode(source2);
		assertTrue("Hello World !!!".equals(result1));
		assertTrue("中文测试".equals(result2));
	}
}
