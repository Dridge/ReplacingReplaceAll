import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestStringReplacer {
    StringReplacer replacer;

    @Test
    public void testReplaceAllChars() {
        replacer = new StringReplacer("atest");
        replacer.replaceChar('t', 'x');
        Assert.assertEquals("axesx", replacer.toString());
    }

    @Test
    public void testReplaceAllCharsRecursion() {
        replacer = new StringReplacer("atest");
        replacer.replaceCharWithRecursion('t', 'x');
        Assert.assertEquals("axesx", replacer.toString());
    }

    @Test
    public void testReplaceAllCharsAlternativeIteration() {
        replacer = new StringReplacer("atest");
        replacer.replaceCharWithCollectionIteration('t', 'x');
        Assert.assertEquals("axesx", replacer.toString());
    }

    @Test
    public void testReplaceAllCharsStreamAndMapReplacing() {
        replacer = new StringReplacer("atest");
        replacer.replaceCharWithStreamFiltering('t', 'x');
        Assert.assertEquals("axesx", replacer.toString());
    }

    @Test
    public void testReplaceAllCharsSimpleReplace() {
        replacer = new StringReplacer("atest");
        replacer.replaceCharWithSimpleReplace('t', 'x');
        Assert.assertEquals("axesx", replacer.toString());
    }
}
