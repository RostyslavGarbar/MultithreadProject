public class CommonRecourses {
	public static int N1 = 3;
	public static int N2 = 1024 * 1024;
	public static int N3 = 32;
	public static char[] data = {'a','b','c'};
	
	public static final Object myLock = new Object();
	public static byte[] buffer = new byte[N1 * N2];
	public static int buffer_index = 0;
}
