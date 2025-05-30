package AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller;

import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.LimitExceededException;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Media;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Playable;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;

public class ItemController {
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    private Cart cart;
    private Media media;

    public ItemController() {
    }

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (media != null) {
            try {
                cart.addMedia(media);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(media.getTitle() + " da duoc them vao gio hang");
                alert.showAndWait();
                
            } catch (LimitExceededException e) {
                System.err.println(e.getMessage());
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Loi them vao gio hang");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }


    @FXML
    void btnPlayClicked(ActionEvent event) {
    	if (media != null && media instanceof Playable) {
        	try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + "$");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
