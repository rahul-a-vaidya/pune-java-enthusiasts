package ct.fp.example5;

public class FileWriterTest {

    public static void main(String[] args) {

        // with a closeable file writer
        try (FileWriterCloseable f = new FileWriterCloseable("test.txt")) {

            f.writeLine("hello world");

            System.out.println("done using resource");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // with a lambda-powered file writer
        try {
            FileWriterLambda.use("lambda-test.txt", writer -> writer.write("lambdas are cool!"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
