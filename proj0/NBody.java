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
		String filename = args[3];
		double radius = readRadius(filename);
		readPlanets(filename);
		// set the scale of the coordinate system
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        while (true) { 

            // bounce off wall according to law of elastic collision
            // if (Math.abs(rx + vx) + radius > 1.0) {
            //     vx = -vx;
            //     StdAudio.play("pipebang.wav");
            // }
            // if (Math.abs(ry + vy) + radius > 1.0) {
            //     vy = -vy;
            //     StdAudio.play("pipebang.wav");
            // }

            // // update position
            // rx = rx + vx; 
            // ry = ry + vy; 

            // set the background to light gray
            //StdDraw.clear(StdDraw.LIGHT_GRAY);

            // draw ball on the screen
            StdDraw.picture(0.0, 0.0, "images/starfield.jpg");

            // display and pause for 20ms
            StdDraw.show();
            //StdDraw.pause(20); 
        } 
	}









}