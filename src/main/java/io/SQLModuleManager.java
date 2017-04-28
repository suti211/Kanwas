package io;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Module> getModulesFromDB() {
		SQLConnector sqlc = new SQLConnector();
		ResultSet rs = sqlc.getData("SELECT * FROM kanwas.modules;");
		List<Module> modulDB = new ArrayList<>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String type = rs.getString("Type");
				int maxScore = rs.getInt("MaxScore");
				int published = rs.getInt("Published");
				int indexid = rs.getInt("IndexID");
				modulDB.add(new Module(id, title, content, type, maxScore, published, indexid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modulDB;
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
