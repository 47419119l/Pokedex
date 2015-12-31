package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    ImageView ImagePokemon;
    @FXML
    Text nomPokemon;

    Image image;

    public void initialize() throws IOException, SAXException, ParserConfigurationException {

        refresh();
    }
    public void refresh() throws IOException, SAXException, ParserConfigurationException {
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

        //Extreu els tipos.
      // DAOPokemondb.llistatTipo();

        //Imatge del pokemon

        omplirImatge(ImagePokemon,"1.png");
       // nomPokemon.setText(DAOPokemondb.nomPokemon("4"));



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
}
