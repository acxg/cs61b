public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
	yyPos = yP;
	xxVel = xV;
	yyVel = yV;
	mass = m;
	imgFileName = img;

    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
	this.yyPos = p.yyPos;
	this.xxVel = p.xxVel;
	this.yyVel = p.yyVel;
	this.mass = p.mass;
	this.imgFileName = p.imgFileName;
    }

    /**calculate the distance between two planets
     */
    public double calcDistance(Planet p){
        return Math.sqrt((p.xxPos-this.xxPos)*(p.xxPos-this.xxPos) + (p.yyPos - this.yyPos)*(p.yyPos-this.yyPos));
    }

    /**calculate the force exerted on this planet by the given planet
     */
    public double calcForceExertedBy(Planet p){
	double r = this.calcDistance(p);
        return G*this.mass*p.mass/(r*r);
    }

    /**calculate force exerted by the given planet in the x direction
     */
    public double calcForceExertedByX(Planet p){
        double r = this.calcDistance(p);
	double F = this.calcForceExertedBy(p);
	return F*(p.xxPos-this.xxPos)/r;
    }

    /** calculate force exerted by the given planet in the y direction
     */
    public double calcForceExertedByY(Planet p){
        double r = this.calcDistance(p);
	double F = this.calcForceExertedBy(p);
	return F*(p.yyPos-this.yyPos)/r;
    }

    /** calculate net force by an array of planets 
     */
    public double calcNetForceExertedByX(Planet[] ps){
	double r, F, Fx = 0;
        for(Planet p: ps){
	    if(this.equals(p) != true){
	        r = this.calcDistance(p);
		F = this.calcForceExertedBy(p);
		Fx = Fx + F*(p.xxPos-this.xxPos)/r;
	    }
	}
	return Fx;
    }
    public double calcNetForceExertedByY(Planet[] ps){
	double r, F, Fy = 0;
        for(Planet p: ps){
	    if(this.equals(p) != true){
	        r = this.calcDistance(p);
		F = this.calcForceExertedBy(p);
		Fy = Fy + F*(p.yyPos-this.yyPos)/r;
	    }
	}
	return Fy;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX/this.mass;
	double ay = fY/this.mass;
	this.xxVel = this.xxVel + dt*ax;
	this.yyVel = this.yyVel + dt*ay;
	this.xxPos = this.xxPos + dt*this.xxVel;
	this.yyPos = this.yyPos + dt*this.yyVel;
    }


}
