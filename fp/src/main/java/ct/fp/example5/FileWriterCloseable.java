package ct.fp.example5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCloseable implements AutoCloseable {
    private final FileWriter fileWriter;

    public FileWriterCloseable(final String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public void writeLine(final String data) throws IOException {
        fileWriter.write(data);
    }

    @Override
    public void close() throws Exception {
        System.out.println("close called automatically");
        fileWriter.close();
    }
}
