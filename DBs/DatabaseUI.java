import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUI extends JFrame implements ActionListener {
    private Connection connection;

    public DatabaseUI(String url, String user, String password) throws SQLException {
        this.connection = connectToDatabase(url, user, password);
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JMenu menu = new JMenu("Options");
        JMenuItem dropTablesItem = new JMenuItem("Drop Tables");
        JMenuItem createTablesItem = new JMenuItem("Create Tables");
        JMenuItem populateTablesItem = new JMenuItem("Populate Tables");
        JMenuItem queryTablesItem = new JMenuItem("Query Tables");
        JMenuItem exitItem = new JMenuItem("Exit");

        dropTablesItem.addActionListener(this);
        createTablesItem.addActionListener(this);
        populateTablesItem.addActionListener(this);
        queryTablesItem.addActionListener(this);
        exitItem.addActionListener(this);

        menu.add(dropTablesItem);
        menu.add(createTablesItem);
        menu.add(populateTablesItem);
        menu.add(queryTablesItem);
        menu.add(exitItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    private Connection connectToDatabase(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private void dropTables() throws SQLException {
        Statement statement = connection.createStatement();
        // Example query execution, replace with your actual SQL query
        statement.execute("DROP TABLE your_table_name");
    }

    private void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        // Example query execution, replace with your actual SQL query
        statement.execute("CREATE TABLE your_table_name (column1 datatype, column2 datatype, ...)");
    }

    private void populateTables() throws SQLException {
        Statement statement = connection.createStatement();
        // Example query execution, replace with your actual SQL query
        statement.execute("INSERT INTO your_table_name (column1, column2, ...) VALUES (value1, value2, ...)");
    }

    private void queryTables() throws SQLException {
        Statement statement = connection.createStatement();
        // Example query execution, replace with your actual SQL query
        statement.execute("SELECT * FROM your_table_name");
    }

    private void exit() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("Exiting the program.");
            System.exit(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Drop Tables":
                try {
                    dropTables();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Create Tables":
                try {
                    createTables();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Populate Tables":
                try {
                    populateTables();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Query Tables":
                try {
                    queryTables();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Exit":
                exit();
                break;
        }
    }

    public static void main(String[] args) {
        try {
            // Provide your Oracle database URL, user, and password
            String url = "jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl";
            String user = "d2eliopo";
            String password = "04183485";

            SwingUtilities.invokeLater(() -> {
                try {
                    new DatabaseUI(url, user, password).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
