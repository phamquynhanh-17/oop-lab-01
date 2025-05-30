package AimsProject.src.hust.soict.hedspi.aims.screen.customer.store;

import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.LimitExceededException;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.CartController;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
    private static Cart cart;
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";

        FXMLLoader loader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

        CartController cartController = new CartController(store, cart);
        loader.setController(cartController);

        Parent root = loader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();
        store = new Store(); 

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            System.err.println(e.getMessage());
        }

        launch(args);
    }
}
