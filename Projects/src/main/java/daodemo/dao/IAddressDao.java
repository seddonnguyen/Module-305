package daodemo.dao;

import daodemo.model.Addresses;

import java.util.List;

public interface IAddressDao {

    List<Addresses> getAllAddresses();

    List<Addresses> getAllByCountry(String country);

    Addresses getAddress(int id);

    void addAddress(Addresses addr);

    void removeAddress(int id);
}