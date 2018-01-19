package ru.otus.l081.io;

import java.io.*;

/**
 * Created by tully.
 */
class JavaIOHelper {
    static void writeObject(String file, Serializable student) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    static <T> T readObject(String file, Class<T> clazz) {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object object = ois.readObject();
            if (clazz.isAssignableFrom(object.getClass())) {
                return (T) object;
            } else {
                throw new RuntimeException(object.getClass() + " can't be casted to " + clazz);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // io version of java.nio.file.Files.write()
    static void writeToFile(byte[] bytes, String fileName) throws IOException {
        try (FileOutputStream stream = new FileOutputStream(fileName)) {
            stream.write(bytes);
        }
    }

    //io version of java.nio.file.Files.readAllBytes()
    static byte[] readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        int fileLength = (int) file.length();
        byte[] bytes = new byte[fileLength];
        try (FileInputStream stream = new FileInputStream(fileName)) {
            int read = stream.read(bytes);
            if (read != fileLength) {
                throw new RuntimeException("Read: " + read + " of " + fileLength);
            }
        }
        return bytes;
    }

    static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}
