public class NBody{




	public static double readRadius(String path){
		In in = new In(path);

		/* Every time you call a read method from the In class,
		 * it reads the next thing from the file, assuming it is
		 * of the specified type. */

		/* Compare the calls below to the contents of BasicInDemo_input_file.txt */

		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		// String thirdItemInFile = in.readString();
		// String fourthItemInFile = in.readString();
		// double fifthItemInFile = in.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String path){
		In in = new In(path);

		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();

		//ArrayList<String> names = new ArrayList<String>();
		//Set<String> uniqueNames = new Set<String>();
		//Set<String> uniqueNames = new HashSet<String>();
		Planet[] planets = new Planet[numberOfPlanets];
		int i=0;
		while (i<numberOfPlanets){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			//names.add(name);
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
			i++; 
			//uniqueNames.add(name);
		}
		//Set<String> uniqueNames = new HashSet<String>(names);
		//Set<String> uniquePlanets = new HashSet<String>(names);
		//String[] uniquePlanets = uniqueNames.toArray(new String[uniqueNames.size()]);
		return planets;
		
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		// set the scale of the coordinate system
        StdDraw.setScale(-radius, radius);
        //StdDraw.setYscale(-radius, radius);
		StdDraw.clear();

        double time = 0 ;


        //StdDraw.enableDoubleBuffering();
        StdDraw.enableDoubleBuffering();

        while (time<=T){
        	double[] xForce = new double[planets.length];
        	double[] yForce = new double[planets.length];


	        // int i=0;
	        for (int i = 0; i<planets.length; i++){
	        	xForce[i] = planets[i].calcNetForceExertedByX(planets); 
        		yForce[i] = planets[i].calcNetForceExertedByY(planets); 
	        }
	        for (int i = 0; i<planets.length; i++){
        		planets[i].update(dt, xForce[i], yForce[i]);
        		//planets[i].draw();
	        }
	       	StdDraw.picture(0, 0, "images/starfield.jpg");

	        for (int i = 0; i<planets.length; i++){
        		//planets[i].update(dt, xForce[i], yForce[i]);
        		planets[i].draw();
	        }
 			StdDraw.show();
			StdDraw.pause(10);
			time+=dt;
        }

        StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

		//System.out.println(planets[1].img);

    	//planets[2].draw();
        
	}









}