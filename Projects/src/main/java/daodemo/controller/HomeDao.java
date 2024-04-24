package daodemo.controller;

import daodemo.dao.IHomeDao;
import daodemo.model.Homes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeDao implements IHomeDao {
    private final Connection connection;

    public HomeDao(Connection connection) {
        this.connection = connection;

        try {
            String tableQuery = """
                                CREATE TABLE IF NOT EXISTS homes
                                (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    windows INT,
                                    bathrooms INT,
                                    doors INT,
                                    levels INT,
                                    addressid INT,
                                    FOREIGN KEY (addressid) REFERENCES addresses(id)
                                );""";
            this.connection.prepareStatement(tableQuery).executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Homes> getAllHomes() {
        List<Homes> homes = new ArrayList<>();
        String query = "SELECT * FROM homes;";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int windows = rs.getInt("windows");
                int bathrooms = rs.getInt("bathrooms");
                int doors = rs.getInt("doors");
                int levels = rs.getInt("levels");
                int addressId = rs.getInt("addressId");

                Homes home = new Homes(addressId);
                home.setId(id);
                home.setWindows(windows);
                home.setBathrooms(bathrooms);
                home.setDoors(doors);
                home.setLevels(levels);
                home.setAddressId(addressId);
                homes.add(home);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return homes;
    }

    @Override
    public List<Homes> getAllByCountry(String country) {
        List<Homes> homes = new ArrayList<>();
        String query = "SELECT h.* FROM homes h JOIN addresses a ON a.id = h.addressId AND a.country = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, country);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                int windows = rs.getInt("windows");
                int bathrooms = rs.getInt("bathrooms");
                int doors = rs.getInt("doors");
                int levels = rs.getInt("levels");
                int addressId = rs.getInt("addressId");

                Homes home = new Homes(addressId);
                home.setId(id);
                home.setWindows(windows);
                home.setBathrooms(bathrooms);
                home.setDoors(doors);
                home.setLevels(levels);
                home.setAddressId(addressId);
                homes.add(home);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return homes;
    }

    @Override
    public Homes getHome(int id) {
        String query = "SELECT * FROM homes WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int windows = rs.getInt("windows");
                int bathrooms = rs.getInt("bathrooms");
                int doors = rs.getInt("doors");
                int levels = rs.getInt("levels");
                int addressId = rs.getInt("addressId");

                Homes home = new Homes(addressId);
                home.setId(id);
                home.setWindows(windows);
                home.setBathrooms(bathrooms);
                home.setDoors(doors);
                home.setLevels(levels);
                home.setAddressId(addressId);
                return home;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public int addHome(Homes home) {
        String query = "INSERT INTO homes (windows, bathrooms, doors, levels, addressId) VALUES(?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, home.getWindows());
            stmt.setInt(2, home.getBathrooms());
            stmt.setInt(3, home.getDoors());
            stmt.setInt(4, home.getLevels());
            stmt.setInt(5, home.getAddressId());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    home.setId(generatedKeys.getInt(1));
                    return home.getId();
                }
            } catch (SQLException e) { e.printStackTrace(); }
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    @Override
    public void removeHome(int id) {
        String query = "DELETE FROM homes WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}