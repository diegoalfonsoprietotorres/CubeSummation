package org.edu.cube_summation;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author diego
 */
public class TestCubeSummation {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    
    @Test
    public void test1() {
        try {
            //Set test
            String[] args = null;
            final InputStream original = System.in;
            final FileInputStream fips = new FileInputStream(new File("src/test/resources/test1.txt"));
            System.setIn(fips);

            //Solve test
            CubeSummation.main(args);

            //Validate answer
            String answer = "";
            String current;
            BufferedReader br = new BufferedReader(new FileReader("src/test/resources/answer1.txt"));
            while ((current = br.readLine()) != null) {
                answer += (current + "\n");
            }
            
            String response = outContent.toString();
            assertTrue(answer.equals(response));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
}
