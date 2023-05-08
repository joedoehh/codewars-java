package com.joedoe.cwjava;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicSocketServerTest {

  void testSomething() throws InterruptedException {
    Thread server = new Thread(BasicSocketServer::runServer);
    server.start();
    try (Socket client = new Socket()) {
      client.connect(new InetSocketAddress("127.0.0.1", 80));
      OutputStream outputStream = client.getOutputStream();
      InputStream inputStream = client.getInputStream();
      byte[] buffer = new byte[1024];
      int length;
      String actual;
      for (String expected : new String[] { "there\n", "is\n", "a\n", "house\n", "in\n", "new\n", "orleans\n" }) {
        outputStream.write(expected.getBytes());
        outputStream.flush();
        length = inputStream.read(buffer);
        actual = new String(buffer, 0, length);
        assertEquals(expected, actual);
      }
      outputStream.write("exit".getBytes());
      outputStream.flush();
      Thread.sleep(1000);
      assertThrows(IOException.class, () -> {
        outputStream.write("First send will \"work\"".getBytes());
        outputStream.flush();
        outputStream.write("Second will throw an exception".getBytes());
        outputStream.flush();
      });
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
    try {
      server.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}