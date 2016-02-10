package piper.us;

/**
 * @author 733474 & 704055
 */
public abstract class Pipe {

    protected double lengthM;
    protected double diameterI;
    protected String grade;
    protected boolean chemres;
    
    public Pipe(double userLengthM, double userDiameterI, String userGrade, boolean userChemres){
        lengthM = userLengthM;
        diameterI = userDiameterI;
        grade = userGrade;
        chemres = userChemres;
    }
    
    public String getGrade(){
        return grade;
    }
    
    public double getLength(){
        return lengthM;
    }
   
    public double getDiameter(){
        return diameterI;
    }
    
    public boolean getChemres(){
        return chemres;
    }
    
    public void setGrade(String userGrade){
        grade = userGrade;
    }
    
    public void setLength(double userLength){
        lengthM = userLength;
    }
   
    public void setDiameter(double userDiameter){
        diameterI = userDiameter;
    }
    
    public void setChemres(boolean userChemres){
        chemres = userChemres;
    }
    
    protected double getVolume(){
        double lengthInch = lengthM * 39.37; //convert users length to inches
        
        double radiusouter = diameterI / 2; //calculate outer radius from users diameter
        double areaouter = Math.PI * (radiusouter * radiusouter); //calculate outer area
        
        double radiusinner = radiusouter * 0.9; //calculate inner radius from outer radius
        double areainner = Math.PI * (radiusinner * radiusinner); //calculate inner area
        
        double pipearea = areaouter - areainner; //calculate pipes area
        
        return pipearea * lengthInch; //return pipes volume
    }
    
    protected double basicCost(){
        double volume = getVolume();
        double basiccost = 0;
        int switchGrade = Integer.parseInt(grade);
        switch (switchGrade){
            case 1: basiccost = volume * 0.3;
                    break;
            case 2: basiccost = volume * 0.32;
                    break;
            case 3: basiccost = volume * 0.35;
                    break;
            case 4: basiccost = volume * 0.4;
                    break;
            case 5: basiccost = volume * 0.46;
                    break;
        }
        return Math.round(basiccost * 100) / 100;
    }
    
    protected double chemResCost(double basiccost){
        if(chemres){
           return Math.round((basiccost * 1.12) * 100) / 100;
        }
        return basiccost;
    }
    
    public abstract double cost();
}