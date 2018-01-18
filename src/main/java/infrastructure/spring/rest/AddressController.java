package infrastructure.spring.rest;

import infrastructure.spring.model.Address;
import infrastructure.spring.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/addressapi")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{address}")
    ResponseEntity<?> getParsedAddress(@PathVariable String address) {
        Address w = addressService.getAddress(address);
        logger.info("Parsing adress: {} " ,address);
        return new ResponseEntity(w, HttpStatus.OK);
    }

}
