package ua.nure.vasilchenko.practice8.db;

import ua.nure.vasilchenko.practice8.db.entity.Team;
import ua.nure.vasilchenko.practice8.db.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DBManager {
    private String connectionUrl;

    ////////////////////////////////
    // queries

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM practice8.users";
    private static final String SQL_FIND_ALL_GROUPS = "SELECT * FROM practice8.teams";
    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM practice8.users WHERE login=?";
    private static final String SQL_GET_GROUP_BY_USER_ID =
            "SELECT team_id FROM practice8.users_teams WHERE user_id = ?";
    private static final String SQL_GET_GROUP_NAME_BY_ID = "SELECT name FROM practice8.teams WHERE id = ?";
    private static final String SQL_FIND_GROUP_BY_NAME = "SELECT * FROM practice8.teams WHERE name=?";
    private static final String SQL_INSERT_USER = "INSERT INTO practice8.users VALUES (DEFAULT, ?)";
    private static final String SQL_INSERT_GROUP = "INSERT INTO practice8.teams VALUES (DEFAULT, ?)";
    private static final String SQL_USERS_GROUPS_PAIR_CHECK =
            "SELECT COUNT(*) FROM practice8.users_teams WHERE user_id = ? AND team_id = ?";
    private static final String SQL_INSERT_USERS_GROUPS = "INSERT INTO practice8.users_teams VALUES (?, ?)";
    private static final String SQL_DELETE_GROUP_WHERE_ID = "DELETE from practice8.teams where id = ?";
    private static final String SQL_UPDATE_GROUP_WHERE_ID = "UPDATE practice8.teams SET name = ? WHERE id = ?";

    ///////////////////////////////
    // singleton

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            connectionUrl = properties.getProperty("connection.url");
        }
    }

    ////////////////////////////////
    // logic

    public void insertUser(User user) throws DBExceptions {
        try (Connection con = getConnection()) {
            if (getUser(user.getLogin()) != null) {
                return;
            }
            PreparedStatement ps = con.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            if (ps.executeUpdate() > 0) {
                ResultSet set = ps.getGeneratedKeys();
                if (set.next()) {
                    user.setId(set.getInt(1));
                }
            }
        } catch (SQLException ex) {
            throw new DBExceptions(ex);
        }
    }

    public void insertTeam(Team group) {
        try (Connection con = getConnection()) {
            if (getTeam(group.getName()) != null) {
                return;
            }
            PreparedStatement ps = con.prepareStatement(SQL_INSERT_GROUP, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, group.getName());
            if (ps.executeUpdate() > 0) {
                ResultSet set = ps.getGeneratedKeys();
                if (set.next()) {
                    group.setId(set.getInt(1));
                }
            }
        } catch (SQLException | DBExceptions e) {
            e.printStackTrace();
        }
    }

    public Team getTeam(String name) {
        try (Connection con = getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQL_FIND_GROUP_BY_NAME);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return extractTeam(rs);
            }
        } catch (SQLException | DBExceptions e) {
            e.printStackTrace();
        }
        return null;
    }


    public User getUser(String login) throws DBExceptions {
        PreparedStatement statement;
        ResultSet rs;
        try (Connection con = getConnection()) {
            statement = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            statement.setString(1, login);
            rs = statement.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        } catch (SQLException e) {
            throw new DBExceptions(e);
        }
        return null;
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_USERS);
            while (rs.next()) {
                User user = extractUser(rs);
                users.add(user);
            }
        } catch (SQLException | DBExceptions e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Team> findAllTeams() {
        List<Team> groups = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_GROUPS);
            while (rs.next()) {
                Team group = extractTeam(rs);
                groups.add(group);
            }
        } catch (SQLException | DBExceptions e) {
            e.printStackTrace();
        }
        return groups;
    }

    /////////////////////////
    // util methods

    public Connection getConnection() throws DBExceptions {
        try {
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new DBExceptions(e);
        }
    }

    public Team extractTeam(ResultSet rs) throws SQLException {
        Team group = new Team();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        return group;
    }

    public User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        return user;
    }

    // setting up multiple group - user pairs
    public void setTeamsForUser(User user, Team... groups) throws SQLException {
        if (groups.length <= 0) {
            return;
        }
        Connection con = null;
            try {
                con = getConnection();
                PreparedStatement statement;
                con.setAutoCommit(false);
                for (Team group : groups) {
                    statement = con.prepareStatement(SQL_USERS_GROUPS_PAIR_CHECK);
                    statement.setString(1, String.valueOf(user.getId()));
                    statement.setString(2, String.valueOf(group.getId()));
                    ResultSet rs = statement.executeQuery();
                    if (rs.next() && rs.getInt(1) >= 1) {
                        throw new SQLException();
                    }
                    statement = con.prepareStatement(SQL_INSERT_USERS_GROUPS);
                    statement.setString(1, String.valueOf(user.getId()));
                    statement.setString(2, String.valueOf(group.getId()));
                    statement.executeUpdate();
                }
                con.commit();
            } catch (SQLException e) {
                assert con != null;
                con.rollback();
            } catch (DBExceptions dbExceptions) {
                dbExceptions.printStackTrace();
            } finally {
                assert con != null;
                con.close();
            }
    }

    public List<Team> getUserTeams(User user) throws DBExceptions {
        List<Team> groups = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQL_GET_GROUP_BY_USER_ID);
            statement.setString(1, String.valueOf(user.getId()));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Team group = new Team();
                group.setId(rs.getInt("team_id"));
                groups.add(group);
            }
            for (Team group : groups) {
                statement = con.prepareStatement(SQL_GET_GROUP_NAME_BY_ID);
                statement.setString(1, String.valueOf(group.getId()));
                rs = statement.executeQuery();
                if (rs.next()) {
                    group.setName(rs.getString(1));
                }
            }

        } catch (SQLException e) {
            throw new DBExceptions(e);
        }
        return groups;

    }

    public void deleteTeam(Team group) {
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_GROUP_WHERE_ID);
            ps.setString(1, String.valueOf(group.getId()));
            ps.executeUpdate();
        } catch (SQLException | DBExceptions e) {
            e.printStackTrace();
        }
    }

    public void updateTeam(Team team) {
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_GROUP_WHERE_ID);
            ps.setString(1, team.getName());
            ps.setString(2, String.valueOf(team.getId()));
            ps.executeUpdate();
        } catch (SQLException | DBExceptions e) {
            e.printStackTrace();
        }
    }
}
