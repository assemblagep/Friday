import infrastructure.spring.model.Address;
import infrastructure.spring.service.AddressParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConf.class, loader = AnnotationConfigContextLoader.class)
public class AddressServiceTests {

    @Autowired
    public AddressParser addressParser;

    @Test
    public void testSimpleAddressWithSimpleNumber() {
        Address address = addressParser.parseAddress("Winterallee 3");
        assertEquals(address.getNumber(),"3");
        assertEquals(address.getStreet(),"Winterallee");
    }

    @Test
    public void testSimpleAddressWithComplexNumber() {
        Address address = addressParser.parseAddress("Musterstrasse 45");
        assertEquals(address.getNumber(),"45");
        assertEquals(address.getStreet(),"Musterstrasse");
    }

    @Test
    public void testAddressWithComplexNumberAndLetter() {
        Address address = addressParser.parseAddress("Blaufeldweg 123B");
        assertEquals(address.getNumber(),"123B");
        assertEquals(address.getStreet(),"Blaufeldweg");
    }

    @Test
    public void testComplexAddressWithComplexNumber() {
        Address address = addressParser.parseAddress("Am Bächle 23");
        assertEquals(address.getNumber(),"23");
        assertEquals(address.getStreet(),"Am Bächle");
    }

    @Test
    public void testComplexAddressWithComplexNumberAndLetter() {
        Address address = addressParser.parseAddress("Auf der Vogelwiese 23 b");
        assertEquals(address.getNumber(),"23b");
        assertEquals(address.getStreet(),"Auf der Vogelwiese");
    }

    @Test
    public void testComplexAddressWithComplexNumberAndComma() {
        Address address = addressParser.parseAddress("4, rue de la revolution");
        assertEquals(address.getNumber(),"4");
        assertEquals(address.getStreet(),"rue de la revolution");
    }

    @Test
    public void testComplexAddressWithComplexNumberInBackDirection() {
        Address address = addressParser.parseAddress("200 Broadway Av");
        assertEquals(address.getNumber(),"200");
        assertEquals(address.getStreet(),"Broadway Av");
    }
}