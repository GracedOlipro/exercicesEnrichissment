package commun;

import java.util.*;

public class Outils {
	public static final MyRandom Aleatoire = new MyRandom();
	
	public static class MyRandom extends Random {
		public MyRandom() {
			super();
			seedSet = false;
		}
		
		public MyRandom(long seed) {
			super(seed);
			seedSet = true;
		}
		
		public void setSeed(long seed) {
			if (seedSet) {
				System.err.println("\n***** MODIFICATION DU SEED REFUSÉE *****");
			} else {
				super.setSeed(seed);
				seedSet = true;
			}
		}
		
		public void resetSeedSet() {
			System.err.println("\n***** DEMANDE DE MODIFICATION DU SEED *****");
			seedSet = false;	
		}
		
		private boolean seedSet;
		private static final long serialVersionUID = 1L;
	}
	
	public static final String VB = "[ ";
	public static final String VS = " : ";
	public static final String VE = " ]";
	public static final String MB = "[ ";
	public static final String MS = " :\n  ";
	public static final String ME = " ]";
	public static final String OB = "{ ";
	public static final String OE = " }";
	
	// print
    public static void print(boolean x) 	{ System.out.print(x); }
    public static void print(char x) 	 	{ System.out.print("'" + x + "'"); }
    public static void print(int x) 	 	{ System.out.print(x); }
    public static void print(long x) 		{ System.out.print(x+"L"); }
    public static void print(float x) 		{ System.out.print(x+"f"); }
    public static void print(double x) 		{ System.out.print(x); }
    public static void print(String x) 		{ System.out.print("\"" + x + "\""); }
    public static void print(Object x) 		{ System.out.print(OB + x + OE); }

    // println
    public static void println() 			{ System.out.println(); }
    public static void println(boolean x) 	{ System.out.println(x); }
    public static void println(char x) 		{ System.out.println("'" + x + "'"); }
    public static void println(int x) 		{ System.out.println(x); }
    public static void println(long x) 		{ System.out.println(x+"L"); }
    public static void println(float x) 	{ System.out.println(x+"f"); }
    public static void println(double x) 	{ System.out.println(x); }
    public static void println(String x) 	{ System.out.println("\"" + x + "\""); }
    public static void println(Object x) 	{ System.out.println(OB + x + OE); }

    // print []
    public static void print(boolean[] x) { 
		System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
	}
    public static void print(char[] x) {
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }
    public static void print(int[] x) { 
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }
    public static void print(long[] x) { 
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }
    public static void print(float[] x) { 
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }
    public static void print(double[] x) { 
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }
    public static void print(String[] x) {
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }
    public static void print(Object[] x) { 
    	System.out.print(VB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(VS);
			print(x[i]);
		}
		System.out.print(VE);
    }

    // println []
	public static void println(boolean[] x) {
		print(x);
		println();
	}
	public static void println(char[] x) {
		print(x);
		println();
	}
	public static void println(int[] x) {
		print(x);
		println();
	}
	public static void println(long[] x) {
		print(x);
		println();
	}
	public static void println(float[] x) {
		print(x);
		println();
	}
	public static void println(double[] x) {
		print(x);
		println();
	}
	public static void println(String[] x) {
		print(x);
		println();
	}
	public static void println(Object[] x) {
		print(x);
		println();
	}

    // print [][]
    public static void print(boolean[][] x) { 
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
	}
    public static void print(char[][] x) {
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    public static void print(int[][] x) { 
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    public static void print(long[][] x) { 
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    public static void print(float[][] x) { 
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    public static void print(double[][] x) { 
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    public static void print(String[][] x) {
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    public static void print(Object[][] x) { 
    	System.out.print(MB);
		if (x.length>0) { print(x[0]); }
		for (int i = 1; i < x.length; ++i) {
			System.out.print(MS);
			print(x[i]);
		}
		System.out.print(ME);
    }
    
    // println [][]
	public static void println(boolean[][] x) {
		print(x);
		println();
	}
	public static void println(char[][] x) {
		print(x);
		println();
	}
	public static void println(int[][] x) {
		print(x);
		println();
	}
	public static void println(long[][] x) {
		print(x);
		println();
	}
	public static void println(float[][] x) {
		print(x);
		println();
	}
	public static void println(double[][] x) {
		print(x);
		println();
	}
	public static void println(String[][] x) {
		print(x);
		println();
	}
	public static void println(Object[][] x) {
		print(x);
		println();
	}
}
