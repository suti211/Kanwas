package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginManager {
	
	public boolean isUserLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession(false);
		if(session == null){
			System.out.println("No user logged in, redirected to login page...(AddTexTPageServlet)");
			return false;
		}
		else{
			return true;
		}
	}
	
	
   private static UserLoginManager instance = null;
   protected UserLoginManager() {
   }
   public static UserLoginManager getInstance() {
      if(instance == null) {
         instance = new UserLoginManager();
      }
      return instance;
   }
}
