package com.project.agriculturalmanagement.service;

import com.project.agriculturalmanagement.dto.AddressDto;
import com.project.agriculturalmanagement.entity.Address;
import com.project.agriculturalmanagement.entity.Customer;

import java.util.List;

public interface AddressService {
    public List<Address> getAddresses(Customer customer);
    public AddressDto getAddressDto(long id);
    public Address addAddress(AddressDto addressDto, Customer customer);
    public Address updateAddress(long id,AddressDto addressDto);
    public void deleteAddress(long id);

}
