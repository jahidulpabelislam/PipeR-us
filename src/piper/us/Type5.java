package piper.us;

/**
 * @author 733474 & 704055
 */
public class Type5 extends Pipe{   
    
    public Type5(double userLengthM, double userDiameterI, String userGrade, boolean userChemres){
        super(userLengthM, userDiameterI, userGrade, userChemres);
    }

    public double cost(){
        double basiccost = basicCost();
        return basiccost * 0.46 + chemResCost(basiccost);
    }
}