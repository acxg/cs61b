public class TestPlanet{
    public static void main(String[] args){
        Planet sun = new Planet(1e12,2e11,0,0,2e30,"jupiter.gif");
	Planet saturn  = new Planet(2.3e12, 9.5e11,0,0,6e26,"jupiter.gif");
	System.out.println(sun.calcForceExertedByX(saturn));
	System.out.println(sun.calcForceExertedByY(saturn));
    }
}
