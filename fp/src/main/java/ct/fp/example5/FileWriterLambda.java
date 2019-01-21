package ct.fp.example5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterLambda {
    private final FileWriter fileWriter;


    private FileWriterLambda(final String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called automatically");
        fileWriter.close();
    }

    public void write(final String data) throws IOException {
        fileWriter.write(data);
    }

    public static void use(final String fileName,
                           final UseInstance<FileWriterLambda, IOException> block) throws IOException {

        final FileWriterLambda f = new FileWriterLambda(fileName);

        try {
            block.accept(f);
        }
        finally {
            f.close();
        }
    }
}
