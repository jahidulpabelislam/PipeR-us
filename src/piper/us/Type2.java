package piper.us;

/**
 * @author 733474 & 704055
 */
public class Type2 extends Pipe{   
    
    public Type2(double userLengthM, double userDiameterI, String userGrade, boolean userChemres){
        super(userLengthM, userDiameterI, userGrade, userChemres);
    }

    public double cost(){
        double basiccost = basicCost();
        return basiccost * 0.12 + chemResCost(basiccost);
    }
}