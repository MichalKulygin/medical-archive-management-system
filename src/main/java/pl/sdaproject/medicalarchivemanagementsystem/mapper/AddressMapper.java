package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.model.Address;

@Component
public class AddressMapper {

    public AddressResponse mapAddressToAddressResponse(Address address) {

        return AddressResponse.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .build();
    }
}
