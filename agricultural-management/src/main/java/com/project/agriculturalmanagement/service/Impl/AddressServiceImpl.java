package com.project.agriculturalmanagement.service.Impl;

import com.project.agriculturalmanagement.dto.AddressDto;
import com.project.agriculturalmanagement.entity.Address;
import com.project.agriculturalmanagement.entity.Customer;
import com.project.agriculturalmanagement.repository.AddressRepository;
import com.project.agriculturalmanagement.repository.CustomerRepository;
import com.project.agriculturalmanagement.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public List<Address> getAddresses(Customer customer) {
        return addressRepository.findByCustomerId(customer.getId());
    }

    @Override
    public AddressDto getAddressDto(long id) {
        Address address = addressRepository.getReferenceById(id);
        return toDto(address);
    }

    @Override
    public Address addAddress(AddressDto addressDto, Customer customer) {
        Address address = new Address();
        address.setProvince(addressDto.getProvince());
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());
        address.setRecipientName(addressDto.getRecipientName());
        address.setRecipientPhone(addressDto.getRecipientPhone());
        address.setDetail(addressDto.getDetail());
        address.setCustomer(customerRepository.getReferenceById(customer.getId()));
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long id,AddressDto addressDto) {
        Address address = addressRepository.getReferenceById(id);
        address.setProvince(addressDto.getProvince());
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());
        address.setDetail(addressDto.getDetail());
        address.setRecipientName(addressDto.getRecipientName());
        address.setRecipientPhone(addressDto.getRecipientPhone());
        address.setCustomer(address.getCustomer());
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }
    public AddressDto toDto(Address address){
        return mapper.map(address,AddressDto.class);
    }
}
