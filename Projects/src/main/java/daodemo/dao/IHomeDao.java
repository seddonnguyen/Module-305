package daodemo.dao;

import daodemo.model.Homes;

import java.util.List;

public interface IHomeDao {

    List<Homes> getAllHomes();

    List<Homes> getAllByCountry(String country);

    Homes getHome(int id);

    void addHome(Homes home);

    void removeHome(int id);
}