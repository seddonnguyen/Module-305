package daodemo.runner;

import daodemo.controller.AddressDao;
import daodemo.controller.HomeDao;
import daodemo.model.Addresses;
import daodemo.model.Homes;
import util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.connect("homeDemo")) {
            AddressDao addrDAO = new AddressDao(DBConnection.connect("homeDemo"));
            HomeDao homeDAO = new HomeDao(connection);

            Addresses addr = new Addresses();
            addr.setState("CO");
            addr.setCountry("USA");
            int addrId = addrDAO.addAddress(addr);
            System.out.printf("Address id: %d\n\n", addrId);

            Homes home = new Homes(addrId);
            home.setLevels(1);
            home.setWindows(1);
            home.setDoors(1);
            home.setBathrooms(1);
            home.setAddressId(addr.getId());
            homeDAO.addHome(home);
            System.out.printf("Home id: %d\n", home.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}