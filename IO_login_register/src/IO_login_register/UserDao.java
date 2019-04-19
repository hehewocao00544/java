package IO_login_register;

public interface UserDao {
	
	public abstract boolean isLogin(String username, String password);
	
	public abstract boolean register();
}
