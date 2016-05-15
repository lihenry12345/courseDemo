package tw.idv.liang.courseDemo.entity;

public class User {
	private int id = 0;
    private String userName = "";
    private String password = "";
    private String realName = "";
    private String email = "";
    private String pictureSource = "Assets/01.png";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPictureSource() {
		return pictureSource;
	}
	public void setPictureSource(String pictureSource) {
		this.pictureSource = pictureSource;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
    

    
}
