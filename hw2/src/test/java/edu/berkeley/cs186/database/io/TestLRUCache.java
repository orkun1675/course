package edu.berkeley.cs186.database.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
* Tests LRU Cache; should be optional test for students
* @author  Sammy Sidhu
* @version 1.0
*/

public class TestLRUCache {
  private final String fName = "TestLRUCache.temp";

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void testLRUCache() throws IOException {
    File tempFile = tempFolder.newFile(fName);
    RandomAccessFile raf = new RandomAccessFile(tempFile, "rw");
    FileChannel fc = raf.getChannel();
    Page p = new Page(fc, 0, 0);
    LRUCache<Page> l = new LRUCache<Page>(10);
    for (long i = 0; i < 10; i++) {
      l.put(i,p);
      assertEquals(i + 1, l.size());
    }
    for (long i = 10; i < 20; i++) {
      l.put(i,p);
      assertEquals(10, l.size());
      assertTrue(l.containsKey(i));
      assertFalse(l.containsKey(i-10));
    }
    fc.close();
    raf.close();
  }
}
