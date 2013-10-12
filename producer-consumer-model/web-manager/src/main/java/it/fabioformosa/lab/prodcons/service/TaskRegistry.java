package it.fabioformosa.lab.prodcons.service;

import it.fabioformosa.lab.prodcons.model.SimpleManager;
import it.fabioformosa.lab.prodcons.spi.workers.Manager;

import java.util.HashMap;
import java.util.Map;

public class TaskRegistry {

	private static Map<Integer, Manager> registry = new HashMap<Integer, Manager>();

	public static int taskId = 0;

	public static int getNewTaskId() {
		return ++taskId;
	}

	public static Manager lookupManager(int taskId) {
		Manager manager = null;
		if (registry.containsKey(taskId))
			manager = registry.get(taskId);
		return manager;
	}

	public static void register(SimpleManager manager) {
		registry.put(manager.getTaskId(), manager);
	}

}
