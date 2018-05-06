package com.simoncat.front.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCodeHandler {

	public static String decode(File source) {
		MultiFormatReader formatReader = new MultiFormatReader();
		try {
			BufferedImage image = ImageIO.read(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
			hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
			Result result = formatReader.decode(binaryBitmap, hints);
			return result.getText();
		} catch (IOException | NotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void encode(String source, Path output) {
		QrCodeHandler.encode(source, output, 100, 100, "png");
	}
	
	public static void encode(String source, Path output, int width, int height, String format) {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(source, BarcodeFormat.QR_CODE, width, height, hints);
			MatrixToImageWriter.writeToPath(bitMatrix, format, output);
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
	}
}
