
package methods;

import java.util.ArrayList;

/**
 *
 * @author Daniel Plaza Fernández
 */

public class Methods {
    /*
     * Singleton class for logic operations
     */
    
    private static Methods INSTANCE;
    
    private Methods(){}//private builder
    
    public static Methods getInstance(){
        //rReturns a new instance for methods
        INSTANCE=new Methods();
        return INSTANCE;
    }
    
    //Attributes
    
    private ArrayList<String> strings;
    
    
    //Set and Get methods
    
    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
    } 
    
    /*
     * LOGIC
     */
    
    public int getLength(){
        //returns the lowest length in the strings
        int length;
        length=strings.get(0).length();
        for(int i=1;i<6;i++){
            if(length>strings.get(i).length()){
                length=strings.get(i).length();
            }
        }
        return length;
    }
}
