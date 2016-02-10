package piper.us;

/**
 * @author 733474 & 704055
 */
public class Type1 extends Pipe{   
    
    public Type1(double userLengthM, double userDiameterI, String userGrade, boolean userChemres){
        super(userLengthM, userDiameterI, userGrade, userChemres);
    }
    public double cost(){
        return chemResCost(basicCost());
    }
}