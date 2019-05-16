package interfacePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import methods.Methods;

/**
 * FXML Controller class
 *
 * @author Daniel Plaza Fernández
 */
public class MainFrameController implements Initializable {

    //Attributes
    private Transcribe app;
    private Methods methods;

    //Components
    @FXML
    private TextArea taTab;//Recived tablature
    @FXML
    private TextArea taTranscribe;//Transcribed text
    @FXML
    private Button buttonTranscribe;

    //Builder
    public void builder(Transcribe app, Methods methods) {
        this.app = app;
        this.methods = methods;
    }

    //Handler of button Transcribe in the program
    @FXML
    public void handleButtonTranscribe() {
        try {
            //Reader to read every lane of the tablature, one by one
            BufferedReader reader = new BufferedReader(new StringReader(taTab.getText()));
        //It keeps the six strings as a String variable type

            //Format the array, it deletes it every time user clicks on the button
            methods.setStrings(new ArrayList());

            try {
                for (int i = 0; i < 6; i++) {
                    //Save them into the array
                    methods.getStrings().add(reader.readLine());
                }
            } catch (IOException ex) {
            }

            //Skip a lane before writing
            if (!taTranscribe.getText().isEmpty()) {
                taTranscribe.setText(taTranscribe.getText() + "\n");
            }

            StringBuilder sb;
            //Reads every string together searching for the first name
            for (int characterIndex = 0; characterIndex < methods.getLength(); characterIndex++) {
            //It reads from left to right

                //It reads the strings from sixth to first
                sb = new StringBuilder();
                for (int stringIndex = 5; stringIndex >= 0; stringIndex--) {
                    if (Character.isDigit(methods.getStrings().get(stringIndex).charAt(characterIndex))) {
                        //If keeps the text for every matching
                        String fret = String.valueOf(methods.getStrings().get(stringIndex).charAt(characterIndex));

                        //To pass the 9th fret
                        try {
                            //Replace the next character by an 'x', so 12 -> 1x
                            if (Character.isDigit(methods.getStrings().get(stringIndex).charAt(characterIndex + 1))) {
                                fret += methods.getStrings().get(stringIndex).charAt(characterIndex+1);
                                methods.getStrings().set(stringIndex, (methods.getStrings().get(stringIndex).substring(0, characterIndex + 1) + 'x' + methods.getStrings().get(stringIndex).substring(characterIndex + 2)));
                            }
                        } catch (Throwable e) {
                        }
                        int fretIndex=Integer.parseInt(fret);
                        
                        if (!sb.toString().isEmpty()) {
                            sb.append(" ");//Writes an space to separate every position
                        }
                        sb.append(StringsSpanish.string[stringIndex]).append(" ").append(StringsSpanish.fret[fretIndex]).append(StringsSpanish.separateChar);
                    }
                }
                if (!sb.toString().isEmpty()) {
                    //Writes into taTranscribe
                    if (!taTranscribe.getText().isEmpty()) {
                        //If taTranscribe has any text, it skips the line
                        taTranscribe.setText(taTranscribe.getText() + "\n");
                    }
                    taTranscribe.setText(taTranscribe.getText() + sb.toString());
                }
            }       
        } catch (Throwable e) {
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
         * uncomment the next line to make the taTrascribe text area uneditable
         */
            //taTranscribe.setEditable(false);

        /*
         * Text
         */
        buttonTranscribe.setText(StringsSpanish.buttonTranscribe);

        /*
         * Tooltips
         */
        taTab.setTooltip(new Tooltip(StringsSpanish.toolTipTab));
        taTranscribe.setTooltip(new Tooltip(StringsSpanish.toolTipTanscribe));
        buttonTranscribe.setTooltip(new Tooltip(StringsSpanish.toolTipButtonTranscribe));

        /*
         * Prompt text
         */
        taTab.setPromptText(StringsSpanish.promptTab);

    }

}
