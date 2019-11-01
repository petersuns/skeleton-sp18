public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double gravConstant = 6.67e-11;

	public Planet (double xP, double yP, double xV,
				   double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	};

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	};

	public double calcDistance(Planet p){
		double dx=p.xxPos-this.xxPos;
		double dy=p.yyPos-this.yyPos;
		//r=
		return Math.sqrt(dx*dx+dy*dy); 
	};


	public double calcForceExertedBy(Planet p){
		return (gravConstant*this.mass*p.mass)/(this.calcDistance(p)*this.calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		//Fx=F*dx/r
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		//Fx=F*dy/r
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet a[]){
		Planet p;
		double f=0;

		for (int i=0; i< a.length; i++){
			p=a[i];
			if(this.equals(p)){
				continue;
			}else{
				f+=this.calcForceExertedByX(p);
			}
		}
		return f;

	}

	public double calcNetForceExertedByY(Planet a[]){
		Planet p;
		double f=0;

		for (int i=0; i< a.length; i++){
			p=a[i];
			if(this.equals(p)){
				continue;
			}else{
				f+=this.calcForceExertedByY(p);
			}
		}
		return f;

	}

	public void draw(){
		StdDraw.enableDoubleBuffering();
        //StdDraw.clear();
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
            // display and pause for 20ms
        StdDraw.show();


	}

	public void update(double dt, double fx, double fy){
		// acceleration ax=Fx/m
		//double fx=this.calcNetForceExertedByY;
		double ax=fx/this.mass;
		double ay=fy/this.mass;
		this.xxVel = this.xxVel + dt*ax;
		this.yyVel = this.yyVel + dt*ay;
		this.xxPos = this.xxPos + dt*this.xxVel;
        this.yyPos = this.yyPos + dt*this.yyVel;
	}





}