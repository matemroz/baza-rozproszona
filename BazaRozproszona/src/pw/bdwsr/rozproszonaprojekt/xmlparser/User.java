package pw.bdwsr.rozproszonaprojekt.xmlparser;

public class User implements Comparable<User>{
	
	private String mName;
	private String mLastName;
	private String mStreet;
	private int mStreetNumber;
	private int mHomeNumber;
	private int mPhoneNumber;
	private String mIDNumber;
	private long mPassportNumber;
	private long mPesel;
	private int i;
	private int[] accounts;
	/**
	 * Nie wszystkie bêd¹ wymagane, póki co s¹ wymagane wszystkie
	 * 
	 * @param Name
	 * @param LastName
	 * @param Street
	 * @param SNumber
	 * @param HNumber
	 * @param PNumber
	 * @param IDNumber
	 * @param PASSNumber
	 * @param PESEL
	 */
	
	public User(String Name, String LastName, String Street, int SNumber, int HNumber, int PNumber,
			String IDNumber, long PASSNumber, long PESEL){
		this.mName = Name;
		this.mLastName = LastName;
		this.mStreet = Street;
		this.mStreetNumber = SNumber;
		this.mHomeNumber = HNumber;
		this.mPhoneNumber = PNumber;
		this.mIDNumber = IDNumber;
		this.mPassportNumber = PASSNumber;
		this.mPesel = PESEL;
		
		this.accounts = new int[10];
		i=1;
	}
	public User(){
		this.accounts = new int[10];
		i = 1;
	}

	public boolean addAcount(int number){
		if (i<10){
			this.accounts[i] = number;
			i++;
			return true;
		}
		return false;
	}

	public void setPesel(long l) {
		this.mPesel = l;
	}


	public long getPesel() {
		return mPesel;
	}


	public void setmPassportNumber(long l) {
		this.mPassportNumber = l;
	}


	public long getmPassportNumber() {
		return mPassportNumber;
	}


	public void setmIDNumber(String mIDNumber) {
		this.mIDNumber = mIDNumber;
	}


	public String getmIDNumber() {
		return mIDNumber;
	}


	public void setmPhoneNumber(int mPhoneNumber) {
		this.mPhoneNumber = mPhoneNumber;
	}


	public int getmPhoneNumber() {
		return mPhoneNumber;
	}


	public void setmHomeNumber(int mHomeNumber) {
		this.mHomeNumber = mHomeNumber;
	}


	public int getmHomeNumber() {
		return mHomeNumber;
	}


	public void setmStreetNumber(int mStreetNumber) {
		this.mStreetNumber = mStreetNumber;
	}


	public int getmStreetNumber() {
		return mStreetNumber;
	}


	public void setmStreet(String mStreet) {
		this.mStreet = mStreet;
	}


	public String getmStreet() {
		return mStreet;
	}


	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}


	public String getmLastName() {
		return mLastName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getmName() {
		return mName;
	}
	@Override
	public int compareTo(User otherUser) {
		if (this.getPesel() > otherUser.getPesel()) return 1;
		else if (this.getPesel() == otherUser.getPesel()) return 0;
		else return -1;
	}
	
	@Override
	public String toString(){
		return this.mName + " " + this.mLastName;
	}
	
}
