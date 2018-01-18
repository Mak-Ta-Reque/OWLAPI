import static org.junit.Assert.*;

public class ExtensionPropartyTest {

    @org.junit.Test
    public void testInitVal(){
        ExtensionProparty.extensionDepth = 3;
        ExtensionProparty.extensionDepth -= 1;
        assertEquals(ExtensionProparty.extensionDepth,2);
    }


}