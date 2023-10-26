package saef.repository;

import com.zaxxer.hikari.HikariDataSource;
import saef.core.models.TodoList;
import saef.usecase.interfaces.ITodoListRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepository implements ITodoListRepository {
    private final HikariDataSource dataSource;

    public TodoListRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<TodoList> getAll() {
        String sql = "SELECT id, todo FROM todolist";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<TodoList> list = new ArrayList<>();
            while (resultSet.next()) {
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setTodo(resultSet.getString("todo"));

                list.add(todoList);
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(TodoList todoList) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, todoList.getTodo());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isExists(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, number);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void remove(Integer number) {
        if (isExists(number)) {
            String sql = "DELETE FROM todolist WHERE id = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, number);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
