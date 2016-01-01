package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Controller {
    @FXML
    ListView ListPokemon = new ListView();
    @FXML
    ListView llistaMov = new ListView();
    @FXML
    ListView listtype = new ListView();
    @FXML
    ImageView ImagePokemon;
    @FXML
    Text nomPokemon,nom,descrip;

    Image image;

    /**
     * Metode que crida a la funció que s'ha d'executar al iniciar l'aplicació
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void initialize() throws IOException, SAXException, ParserConfigurationException {
        iniciar();
    }

    /**
     * Metode que s'executa per defecte
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void iniciar() throws IOException, SAXException, ParserConfigurationException {
        /**
         * Omplir llistat de pokemons.
         */
        ListPokemon.setVisible(true);
        ObservableList<String> items = FXCollections.observableArrayList();
        DAOPokemondb.llistatPokemon(items);
        ListPokemon.setItems(items);

        /**
         * Omplir llista de moviments
         */
        llistaMov.setVisible(true);
        ObservableList <String> itemsMov = FXCollections.observableArrayList();
        DAOPokemondb.llistatMov(itemsMov);
        llistaMov.setItems(itemsMov);

        listtype.setVisible(true);
        ObservableList <String> itemsType = FXCollections.observableArrayList();
        DAOPokemondb.llistatTipo(itemsType);
        listtype.setItems(itemsType);

        //Imatge del pokemon

        omplirImatge(ImagePokemon,"1.png");
        /**
         *
         */
        nomPokemon.setText(DAOPokemondb.nomPokemon("1"));
        String [] move = new String[2];
        move = DAOPokemondb.extreuMov("Bind");
        nom.setText(move[0]);
        descrip.setText(move[1]);





    }

    /**
     * Funció per omplir imatges
     * @param imagePokemon
     * @param nom
     */
    public void omplirImatge(ImageView imagePokemon,String nom){

        image = new Image(nom);
        imagePokemon.setImage(image);
        imagePokemon.setPreserveRatio(true);
        imagePokemon.setSmooth(true);
        imagePokemon.setCache(true);

    }

    public void escollirPoke(Event event) {
        ListPokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int id = ListPokemon.getSelectionModel().getSelectedIndex() +1;
                omplirImatge(ImagePokemon,id+".png");
                /**
                 *
                 */
                nomPokemon.setText(DAOPokemondb.nomPokemon(String.valueOf(id)));
                String [] move = new String[2];
                move = DAOPokemondb.extreuMov("Bind");
                nom.setText(move[0]);
                descrip.setText(move[1]);
            }
        });{

        }
    }

    public void escollitMove(Event event) {
    }
}
