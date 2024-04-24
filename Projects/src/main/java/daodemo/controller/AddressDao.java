package daodemo.controller;

import daodemo.dao.IAddressDao;
import daodemo.model.Addresses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements IAddressDao {
    private final Connection connection;

    public AddressDao(Connection connection) {
        this.connection = connection;

        try {
            String tableQuery = """
                                CREATE TABLE IF NOT EXISTS addresses
                                (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    state VARCHAR(255),
                                    country VARCHAR(255)
                                );""";
            this.connection.prepareStatement(tableQuery).executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Addresses> getAllAddresses() {
        List<Addresses> addressList = new ArrayList<>();
        String query = "SELECT * FROM addresses";

        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String state = rs.getString("state");
                String country = rs.getString("country");

                Addresses currentAddress = new Addresses();
                currentAddress.setId(id);
                currentAddress.setState(state);
                currentAddress.setCountry(country);
                addressList.add(currentAddress);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return addressList;
    }

    @Override
    public List<Addresses> getAllByCountry(String country) {
        List<Addresses> addressList = new ArrayList<>();
        String query = "SELECT * FROM addresses WHERE country = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setString(1, country);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int currentId = rs.getInt("id");
                String currentState = rs.getString("state");
                String currentCountry = rs.getString("country");

                Addresses currentAddress = new Addresses();
                currentAddress.setId(currentId);
                currentAddress.setState(currentState);
                currentAddress.setCountry(currentCountry);
                addressList.add(currentAddress);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return addressList;
    }

    @Override
    public Addresses getAddress(int id) {
        String query = "SELECT * FROM addresses WHERE id = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Addresses targetAddress = new Addresses();
                String currentState = rs.getString("state");
                String currentCountry = rs.getString("country");

                targetAddress.setState(currentState);
                targetAddress.setCountry(currentCountry);
                return targetAddress;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public int addAddress(Addresses address) {
        String query = "INSERT INTO addresses (state, country) VALUES (?, ?)";

        try (PreparedStatement stmt = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, address.getState());
            stmt.setString(2, address.getCountry());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    address.setId(generatedKeys.getInt(1));
                    return address.getId();
                }
            } catch (SQLException e) { e.printStackTrace(); }
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    @Override
    public void removeAddress(int id) {
        String query = "DELETE FROM addresses WHERE id = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}