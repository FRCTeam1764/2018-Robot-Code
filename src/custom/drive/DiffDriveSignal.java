package custom.drive;

public class DiffDriveSignal {
	public static final DiffDriveSignal NEUTRAL = new DiffDriveSignal(0, 0);
	public double left, right;
	
	// TODO Possible set this up to use interfaces so that there can be generalized functions for add and subtract
	public DiffDriveSignal(double left, double right)
	{
		this.left = left;
		this.right = right;
	}
	
	public DiffDriveSignal add(DiffDriveSignal s)
	{
		return new DiffDriveSignal(this.left + s.left, this.right + s.right);
	}
}
