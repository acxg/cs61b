public class NBody{
    private static String imgToDraw = "images/starfield.jpg";
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int numPl = in.readInt();
        double radius = in.readDouble();
        return radius;	
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
	int numPlanets = in.readInt();
	double radius = in.readDouble();
	Planet[] planets = new Planet[numPlanets];
	int cnt = 0;
	while(numPlanets > cnt){
	    double xxPos = in.readDouble();
	    double yyPos = in.readDouble();
            double xxVel = in.readDouble();
	    double yyVel = in.readDouble();
	    double mass = in.readDouble();
	    String imgFileName = in.readString();
	    Planet p = new Planet(xxPos,yyPos, xxVel, yyVel, mass, imgFileName);
	    planets[cnt]= new Planet(p);
	    cnt = cnt + 1;
	}
	return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	double radius = readRadius(filename);
	Planet[] planets = readPlanets(filename);

	StdDraw.setScale(-radius,radius);
	StdDraw.clear();
	StdDraw.picture(0,0,imgToDraw);
	
	for(Planet p: planets){
	    p.draw();
	}

	StdDraw.enableDoubleBuffering();
	double timeCnt = 0;
	int numPlanets = planets.length;
	while(timeCnt < T){
	    double[] xForce = new double[numPlanets];
            double[] yForce = new double[numPlanets];
	    for(int count = 0; count < numPlanets; count++){
	        xForce[count] = planets[count].calcNetForceExertedByX(planets);
		yForce[count] = planets[count].calcNetForceExertedByY(planets);
	    }
	    for(int count = 0; count < numPlanets; count ++){
		planets[count].update(dt,xForce[count],yForce[count]);
	    }
	    
		StdDraw.picture(0,0,imgToDraw);
	    for(Planet p: planets){
	        p.draw();
	    }
		StdDraw.show();
		StdDraw.pause(10);
	
	    timeCnt = timeCnt + dt;
	}

	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n",radius);
	for (int i = 0; i < planets.length; i++){
	    StdOut.printf("%11.4e % 11.4e %11.4e %11.4e %11.4e %12s\n",
			    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
			    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
	}

    }


    
}
