package core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileSystemDemo {

	public static void main(String[] args) {
		String[] data = { "Line 1", "Line 2 2", "Line 3 3 3", "Line 4 4 4 4", "Line 5 5 5 5 5" };

		try (FileSystem zipFs = openZip(Paths.get("data.zip"))) {

			copyZip(zipFs);
			writeToFileInZip1(zipFs, data);
			writeToFileInZip2(zipFs, data);
		} catch (Exception ex) {
			System.out.println("Exception ");
		}

	}

	private static void copyZip(FileSystem zipFs) throws IOException {

		Path sourceFile = Paths.get("file1.txt");
		// Path sourceFile = FileSystems.getDefault().getPath("file1.txt");
		Path destFile = zipFs.getPath("file1Copied.txt");

		Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
	}

	private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
		Map<String, String> providerProps = new HashMap<>();
		providerProps.put("create", "true");

		URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);

		return FileSystems.newFileSystem(zipUri, providerProps);
	}

	private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {

		try (BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))) {

			for (String vals : data) {
				writer.write(vals);
				writer.newLine();
			}

		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
	}

	private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {

		Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(),
				StandardOpenOption.CREATE);
		
	}
}
