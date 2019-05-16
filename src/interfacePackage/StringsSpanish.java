
package interfacePackage;

/**
 *
 * @author Daniel Plaza Fernández
 */

public class StringsSpanish {
    
    //Cannot be instanced
    private StringsSpanish(){}
    
    /*
     * Contains the strings used in the program and also some names
     */
    private static final String fretTraslation="traste ";
    
    //Program name
    public static String programName="Tab Transcriptor";
    
    //Program text
    public static String[] fret=new String[]{"al aire",fretTraslation+"1",fretTraslation+"2",fretTraslation+"3",fretTraslation+"4",fretTraslation+"5",fretTraslation+"6",fretTraslation+"7",fretTraslation+"8",fretTraslation+"9",fretTraslation+"10",fretTraslation+"11",fretTraslation+"12",fretTraslation+"13",fretTraslation+"14",fretTraslation+"15",fretTraslation+"16",fretTraslation+"17",fretTraslation+"18",fretTraslation+"19",fretTraslation+"20",fretTraslation+"21",fretTraslation+"22",fretTraslation+"23",fretTraslation+"24"};
    public static String[] string=new String[]{"primera cuerda","segunda cuerda","tercera cuerda","cuarta cuerda","quinta cuerda","sexta cuerda"};
    public static String separateChar=";";
    
    //Buttons
    public static String buttonTranscribe="Transcribir";
    
    //Tooltips
    public static String toolTipTab="Tablatura lista para ser transcrita. Se leerá una sola linea";
    public static String toolTipTanscribe="Tablatura transcrita a texto. Es editable";
    public static String toolTipButtonTranscribe="Transcribe la tablatura el área de texto "
                                        +"\nsuperior. La tablatura se escribirá al"
                                        +"\nfinal respetando el texto que ya contega"
                                        +"\nel área de texto inferior";
    
    //Prompt texts
    public static String promptTab="Pegue la tablatura aquí";
}
