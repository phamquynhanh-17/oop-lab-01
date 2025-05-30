package AimsProject.src.hust.soict.hedspi.aims.screen.customer;

import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;

public class Main extends Application {
	private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));

        ViewStoreController controller = new ViewStoreController(store, cart);
        loader.setController(controller);

        Parent root = loader.load();
        primaryStage.setTitle("AIMS Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
    	store = new Store();
    	cart = new Cart();
        
        // Tao cac doi tuong DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Action", "Lana Wachowski", 136, 21.50f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 22.00f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 18.50f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 25.00f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 23.00f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Harry Potter and the Sorcerer's Stone", "Fantasy", "Chris Columbus", 152, 19.99f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 20.50f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 24.99f);
        DigitalVideoDisc dvd12 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 18.00f);
        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Pirates of the Caribbean", "Adventure", "Gore Verbinski", 143, 22.50f);
        DigitalVideoDisc dvd14 = new DigitalVideoDisc("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 178, 26.00f);
        DigitalVideoDisc dvd15 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 25.00f);
        DigitalVideoDisc dvd16 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 17.00f);
        DigitalVideoDisc dvd17 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 21.00f);
        DigitalVideoDisc dvd18 = new DigitalVideoDisc("The Lion King 2", "Animation", "Rob Minkoff", 79, 19.00f);


        // Them DVD vao store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(dvd7);
        store.addMedia(dvd8);
        store.addMedia(dvd9);
        store.addMedia(dvd10);
        store.addMedia(dvd11);
        store.addMedia(dvd12);
        store.addMedia(dvd13);
        store.addMedia(dvd14);
        store.addMedia(dvd15);
        store.addMedia(dvd16);
        store.addMedia(dvd17);
        store.addMedia(dvd18);
    	
        launch(args);
    }
}