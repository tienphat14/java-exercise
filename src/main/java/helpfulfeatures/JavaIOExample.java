package helpfulfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Objects;

public class JavaIOExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaIOExample.class);
    private static final String FILE_NAME_TXT = "example.txt";
    private static final String FILE_NAME_BIN = "example.bin";

    public static void main(String[] args) {
        JavaIOExample example = new JavaIOExample();

        example.readByteArray("Hello World!!!".getBytes());
        example.readCharArray("你好，世界".toCharArray());

        example.readFileWithInputStream();
        example.readFileWithReader();

        example.readFileWithDataInputStream();
    }

    private void readByteArray(byte[] bytes) {
        LOGGER.info("Read a byte array");
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes, 6, 5)) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                LOGGER.info("Byte {} = {}", count++, data);
                sb.append((char)data);
            }
            LOGGER.info("{}", sb);

        } catch (IOException e) {
            LOGGER.error("IOException: {}", e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
        }
    }

    private void readCharArray(char[] chars) {
        LOGGER.info("Read a char array");
        try (CharArrayReader reader = new CharArrayReader(chars)) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (reader.ready()) {
                int data = reader.read();
                LOGGER.info("Char {} = {}", count++, data);
                sb.append((char)data);
            }
            LOGGER.info("{}", sb);

        } catch (IOException e) {
            LOGGER.error("IOException: {}", e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
        }
    }

    private void readFileWithInputStream() {
        LOGGER.info("Reading file with InputStream");
        String file = Objects.requireNonNull(JavaIOExample.class.getClassLoader().getResource(FILE_NAME_TXT)).getFile();
        try (InputStream inputStream = new FileInputStream(file)) {

            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                LOGGER.info("Byte {} = {}", count++, data);
                sb.append((char) data);
            }
            LOGGER.info("{}", sb);

        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: {}", e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error("IOException: {}", e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
        }
    }

    private void readFileWithReader() {
        LOGGER.info("Reading file with Reader");
        String file = Objects.requireNonNull(JavaIOExample.class.getClassLoader().getResource(FILE_NAME_TXT)).getFile();
        try (Reader reader = new FileReader(file)) {

            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (reader.ready()) {
                int data = reader.read();
                LOGGER.info("Character {} = {}", count++, data);
                sb.append((char) data);
            }

            LOGGER.info("{}", sb);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: {}", e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error("IOException: {}", e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
        }
    }

    private void readFileWithDataInputStream() {
        LOGGER.info("Reading file with DataInputStream");
        String file = Objects.requireNonNull(JavaIOExample.class.getClassLoader().getResource(FILE_NAME_BIN)).getFile();
        try (OutputStream outputStream = new FileOutputStream(file);
             DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
             InputStream inputStream = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(inputStream)) {

            dataOutputStream.writeInt(123);
            dataOutputStream.writeFloat(123.45F);
            dataOutputStream.writeLong(789);
            int   int123     = dataInputStream.readInt();
            float float12345 = dataInputStream.readFloat();
            long  long789    = dataInputStream.readLong();

            LOGGER.info("int123 = {}", int123);
            LOGGER.info("float12345 = {}", float12345);
            LOGGER.info("long789 = {}", long789);

        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: {}", e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error("IOException: {}", e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
        }
    }
}