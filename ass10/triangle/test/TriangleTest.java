
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class TriangleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @org.junit.Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @org.junit.Test
    public void judgeTriangle() throws Exception{
        int result = new Triangle().JudgeTriangle(1, 2, 7);
        assertEquals(result, 0);
        result = new Triangle().JudgeTriangle(3, 4, 5);
        assertEquals(result, 1);
    }

    @org.junit.Test
    public void judgeDTriangle() throws Exception{
        int result = new Triangle().JudgeDTriangle(5, 5, 5);
        assertEquals(result, 1);
        result = new Triangle().JudgeDTriangle(5, 5, 7);
        assertEquals(result, 1);
        result = new Triangle().JudgeDTriangle(3, 5, 6);
        assertEquals(result, 0);
    }

    @org.junit.Test
    public void judgeRTriangle() throws Exception{
        int result = new Triangle().JudgeRTriangle(3, 4, 5);
        assertEquals(result, 1);
        result = new Triangle().JudgeRTriangle(3, 5, 6);
        assertEquals(result, 0);
    }

    @org.junit.Test
    public void main() throws Exception{
        Triangle triangle = new Triangle();
        triangle.main(new String[] {"1", "2", "7", "8"});
        assertEquals("请输入3个参数\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"1", "2"});
        assertEquals("请输入3个参数\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"-1", "0", "1"});
        assertEquals("你输入的三边不合法！\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"199", "200", "201"});
        assertEquals("你输入的三边不合法！\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"1", "2", "7"});
        assertEquals("不能构成三角形!\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"5", "5", "5"});
        assertEquals("能够构成三角形！\r\n该三角形是等边三角形！\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"5", "5", "7"});
        assertEquals("能够构成三角形！\r\n该三角形是普通的等腰三角形！\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"3", "4", "5"});
        assertEquals("能够构成三角形！\r\n该三角形是直角三角形！\r\n", outContent.toString());
        outContent.reset();
        triangle.main(new String[] {"3", "5", "6"});
        assertEquals("能够构成三角形！\r\n该三角形是一般三角形!\r\n", outContent.toString());


    }
}
