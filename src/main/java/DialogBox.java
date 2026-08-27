import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DialogBox extends HBox {

    private static final double DISPLAY_PICTURE_SIZE = 100.0;

    private final Label text;
    private final ImageView displayPicture;

    public DialogBox(String text, Image image) {
        this.text = new Label(text);
        displayPicture = new ImageView(image);

        this.text.setWrapText(true);
        this.text.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(this.text, Priority.ALWAYS);

        displayPicture.setFitWidth(DISPLAY_PICTURE_SIZE);
        displayPicture.setFitHeight(DISPLAY_PICTURE_SIZE);
        displayPicture.setPreserveRatio(true);

        setAlignment(Pos.TOP_RIGHT);
        setSpacing(10.0);
        getChildren().addAll(this.text, displayPicture);
    }

    /**
     * Flips the dialog box such that the image is on the left and text is on the right.
     */
    private void flip() {
        setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        FXCollections.reverse(children);
        getChildren().setAll(children);
    }

    public static DialogBox getUserDialog(String text, Image image) {
        return new DialogBox(text, image);
    }

    public static DialogBox getDukeDialog(String text, Image image) {
        DialogBox dialogBox = new DialogBox(text, image);
        dialogBox.flip();
        return dialogBox;
    }
}
