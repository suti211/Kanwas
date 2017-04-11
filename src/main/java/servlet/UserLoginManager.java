package servlet;

public class UserLoginManager {
	   private static UserLoginManager instance = null;
	   protected UserLoginManager() {
	      // Exists only to defeat instantiation.
	   }
	   public static UserLoginManager getInstance() {
	      if(instance == null) {
	         instance = new UserLoginManager();
	      }
	      return instance;
	   }
	}
