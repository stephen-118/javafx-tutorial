import javafx.geometry.Pos;
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
}
