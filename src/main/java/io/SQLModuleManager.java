package io;

import java.sql.ResultSet;
import java.sql.SQLException;

import module.Module;

public class SQLModuleManager {
	private SQLConnector sqlConnector;	
	
	public SQLModuleManager() {
		sqlConnector = new SQLConnector();
	}
	
	public int getNumOfModules() throws SQLException{
		ResultSet rs = sqlConnector.getData("SELECT COUNT(*) FROM modules");
		int numOfModules = 0;
		while(rs.next()){
			numOfModules = rs.getInt("COUNT(*)");
		}
		return numOfModules;
	}

	private void updateIndexIDtoId(){
		sqlConnector.sendQuery("SET SQL_SAFE_UPDATES = 0");
		sqlConnector.sendQuery("UPDATE modules SET IndexID = id WHERE IndexID is null and id is not null");
	}
	
	public void sendTextPageToDB(Module textpage){
		sqlConnector.sendQuery("INSERT INTO `kanwas`.`modules`(`Title`,`Content`,`Type`,`MaxScore`,`Published`) "
				+ "VALUES(" +"'"
				+ textpage.getTitle()+"'"+","+"'"
				+ textpage.getContent()+"'"+","+"'"
				+"text"+"'"+","+"'"
				+"0"+"'"+","+ "'"
				+textpage.isPublished()+"'"+")");
		
		updateIndexIDtoId();
	}
	
	
	
	
}
