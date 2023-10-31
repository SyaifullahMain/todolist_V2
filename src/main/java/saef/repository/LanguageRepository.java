package saef.repository;

import com.zaxxer.hikari.HikariDataSource;
import saef.core.models.Language;
import saef.usecase.interfaces.ILanguageRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageRepository implements ILanguageRepository {


//    create table languages(
//            thelanguage varchar(5) not null,
//            country varchar(5) not null
//    ) engine = InnoDB;
//    insert into languages (thelanguage, country) values ('en', 'US');
    private final HikariDataSource dataSource;

    public LanguageRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Language> getAll() {
        String sql = "SELECT thelanguage, country FROM languages";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<Language> list = new ArrayList<>();
            while (resultSet.next()) {
                Language language = new Language();
                language.setLanguage(resultSet.getString("thelanguage"));
                language.setCountry(resultSet.getString("country"));

                list.add(language);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(String language, String country) {
        String sql = "UPDATE languages SET thelanguage = ? , country = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, language);
            statement.setString(2, country);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
