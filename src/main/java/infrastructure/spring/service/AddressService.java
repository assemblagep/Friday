package infrastructure.spring.service;

import infrastructure.spring.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressParser addressParser;

    @Autowired
    public AddressService(AddressParser addressParser) {
        this.addressParser = addressParser;
    }

    public Address getAddress(String address) {
        return addressParser.parseAddress(address);
    }
}
