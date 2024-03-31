import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleBuilderTest {

    @Test
    public void testAppend() {
        SimpleStringBuilder builder = new SimpleStringBuilder();
        builder.append("Hello");
        builder.append(", ");
        builder.append("world!");

        assertEquals("Hello, world!", builder.toString());
    }

    @Test
    public void testAppendWithCapacity() {
        SimpleStringBuilder builder = new SimpleStringBuilder(10);
        builder.append("Hello");
        builder.append(", ");
        builder.append("world!");

        assertEquals("Hello, world!", builder.toString());
    }

    @Test
    public void testEnsureCapacity() {
        SimpleStringBuilder builder = new SimpleStringBuilder(8);
        builder.append("Hello, world!");

        assertEquals(16, builder.getBufferSize());
    }
}
