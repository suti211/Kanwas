import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

import com.mysql.cj.api.mysqla.result.Resultset;

import io.SQLConnector;
import io.SQLModuleManager;
import module.Module;
import servlet.AddTextPageServlet;

public class AddTextPage_UnitTest {

	@Test
	public void addNewModule() throws SQLException{
		SQLModuleManager sqlModuleManager = new SQLModuleManager();
		SQLConnector sqlc = new SQLConnector();
		Module textpage = new Module(0, "TestTitle", "TestText", "text", 0, 1, 0);
		
		int numOfModulesBefore = sqlModuleManager.getNumOfModules();
		System.out.println(sqlModuleManager.getNumOfModules());
		
		sqlModuleManager.sendTextPageToDB(textpage);
		
		int numOfModulesAfter = sqlModuleManager.getNumOfModules();
		System.out.println(sqlModuleManager.getNumOfModules());
		
		assertEquals(String.valueOf(numOfModulesBefore),String.valueOf(numOfModulesAfter - 1));
	}
	
}
