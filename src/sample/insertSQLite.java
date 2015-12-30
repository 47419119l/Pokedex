package sample;


import java.sql.*;

/**
 * Created by 47419119l on 25/11/15.
 */
public class insertSQLite {
    /**
     * Metode per insertar pokemons.
     * @param ID
     * @param NAME
     */
    public static void insertPokemon(String ID, String NAME) {

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");


            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POKEMONS" +
                    " (ID,NAME) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID);
            preparedStatement.setString(2, NAME);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }

    /**
     * Metode per insertar moves
     * @param ID
     * @param NAME
     * @param DESCRIPTION
     */
    public static void insertMoves(String ID, String NAME, String DESCRIPTION) {

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");


            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POKEMONS" +
                    " (ID,DESCRIPTION,NAME) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID);
            preparedStatement.setString(2, DESCRIPTION);
            preparedStatement.setString(3, NAME);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }

    /**
     * Metode per insertar la relacio pokemon moves
     * @param ID_POK
     * @param ID_MOVE
     */
    public static void insert_poke_mov(String ID_POK,String ID_MOVE){

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");

            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POK_TIP" +
                    " (ID_POK,ID_MOVE) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID_POK);
            preparedStatement.setString(2, ID_MOVE);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }
    }

    /**
     * Metode per insertar la relacio pokemons tipos
     * @param ID_poke
     * @param ID_tipo
     */
    public static void insertpoke_tipo(String ID_poke, String ID_tipo) {

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");

            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POK_TIP" +
                    " (ID_POK,ID_TIPO) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID_poke);
            preparedStatement.setString(2, ID_tipo);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }

    /**
     * Metode per insertar tipos de Pokemons
     * @param ID_poke
     * @param name
     */
    public static void inserttipo(String ID_poke, String name) {


        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");

            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO TIPO" +
                    " (ID,NAME) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID_poke);
            preparedStatement.setString(2, name);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }
}