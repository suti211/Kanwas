package data;

import java.util.ArrayList;
import java.util.List;

import module.Module;
import module.TextPage;

public class GypsyModules {
	List<Module> modules = new ArrayList<>();

	public GypsyModules() {
		TextPage tp1 = new TextPage("Kill yoursel already", "Nobody cares, f*** off!", 1, true);
		TextPage tp2 = new TextPage("Kill yoursel already", "Nobody cares, f*** off!", 2, true);
		TextPage tp3 = new TextPage("Kill yoursel already", "Nobody cares, f*** off!", 3, true);
		TextPage tp4 = new TextPage("Kill yoursel already", "Nobody cares, f*** off!", 4, true);
		
		modules.add(tp1);
		modules.add(tp2);
		modules.add(tp3);
		modules.add(tp4);
	}

	public List<Module> getModules() {
		return modules;
	}
	
	
}
