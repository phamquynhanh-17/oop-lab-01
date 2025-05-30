package AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller;

import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Media;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Playable;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	
	private Cart cart;
	private Store store;
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
    private RadioButton radioBtnFilterId;
	
	@FXML
    private RadioButton radioBtnFilterTitle;
	
	@FXML
    private TextField tfFilter;
	
    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
        	try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();      
            showFilteredMedia(tfFilter.getText());  
        }
    }

//    @FXML
//    void 004cff(ActionEvent event) {
//
//    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"
            ));

            
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            loader.setController(viewStoreController);

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Store");
            stage.setScene(new Scene(root));
            stage.show();

            
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	if(cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	} else {
            tblMedia.setItems(FXCollections.observableArrayList());
        }
    	
    	updateTotalCost();
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
        	@Override
        	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		showFilteredMedia(newValue);
        	}
        });
    }
    void updateButtonBar(Media media) {
    	if(media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    void showFilteredMedia(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
            updateTotalCost();
            return;
        }

        ObservableList<Media> filteredList = FXCollections.observableArrayList();
        for (Media media : cart.getItemsOrdered()) {
            boolean match = false;
            if (radioBtnFilterId.isSelected()) {
                match = String.valueOf(media.getId()).contains(keyword);
            } else if (radioBtnFilterTitle.isSelected()) {
                match = media.getTitle().toLowerCase().contains(keyword.toLowerCase());
            }

            if (match) {
                filteredList.add(media);
            }
        }

        tblMedia.setItems(filteredList);
        updateTotalCost();
    }
    void updateTotalCost() {
        float total = 0f;
        for (Media media : tblMedia.getItems()) {
            total += media.getCost();
        }
        costLabel.setText(String.format("Total Cost: $%.2f", total));
    }

}

