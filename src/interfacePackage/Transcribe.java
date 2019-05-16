
package interfacePackage;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import methods.Methods;

/**
 *
 * @author Daniel Plaza Fernández
 */
public class Transcribe extends Application{
    
    private Stage mainStage;//Main stage
    private Methods methods;//Object of methods.Methods
    
    @Override
    public void start(Stage stage) throws Exception {
        //Instance all variables
        this.mainStage=stage;
        this.methods=Methods.getInstance();
        //Open window
        goToMainFrame();
    }
    
    private void goToMainFrame() {
        //Open main window
        MainFrameController wMain = (MainFrameController) replaceSceneContent();
        wMain.builder(this, methods);
    }
    
    private Initializable replaceSceneContent() {
        //Change/Set the content of the main window
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("MainFrame.fxml");
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(url);
        try {
            Parent page = (Parent) loader.load();
            Scene scene = new Scene(page);
            mainStage.getIcons().add(new Image("file:resources\\icon.png"));
            mainStage.setScene(scene);
            mainStage.setTitle(StringsSpanish.programName);
            mainStage.show();
            return (Initializable) loader.getController();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Main method
    public static void main(String args[]) {
        launch(args);
    }
}
