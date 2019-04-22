import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class isPalindromTest{
    isPalindrom palindrom;
    
    @Before
    public void setUp() throws Exception {
        palindrom = new isPalindrom("foobar"); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionEmptyString() {
        palindrom.setSequence("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionNullString() {
        String s;
        palindrom.setSequence("");
    }

    @Test
    public void testSimplePalindrom() {
        palindrom.setSequence("KayaK");
        Assert.assertTrue(palindrom.iterativ());
        Assert.assertEquals(palindrom.iterativ(), palindrom.rekursiv());
    }

    @Test
    public void testCaseNotSensitive() {
        palindrom.setSequence("Kayak");
        Assert.assertFalse(palindrom.iterativ());
        Assert.assertEquals(palindrom.iterativ(), palindrom.rekursiv());
    }

    @Test
    public void testNotPalindrom() {
        palindrom.setSequence("Schloss");
        Assert.assertFalse(palindrom.iterativ());
        Assert.assertEquals(palindrom.iterativ(), palindrom.rekursiv());
    }
}