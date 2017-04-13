package data;

import java.util.ArrayList;
import java.util.List;

import module.Module;
import module.TextPage;

public class GypsyModules {
	List<Module> modules = new ArrayList<>();

	public GypsyModules() {
		TextPage tp1 = new TextPage("Kill yourself already", "JUST DO IT!", 0, 0, true);
		TextPage tp2 = new TextPage("Get rekt son", "WOW!", 1, 1, true);
		TextPage tp3 = new TextPage("Daamn son", "dank memes", 2, 2, true);
		TextPage tp4 = new TextPage("Git gud", "GG WP", 3, 3, true);
		
		modules.add(tp1);
		modules.add(tp2);
		modules.add(tp3);
		modules.add(tp4);
	}

	public List<Module> getModules() {
		return modules;
	}
	
	
}
