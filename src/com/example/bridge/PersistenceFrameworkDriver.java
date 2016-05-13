package com.example.bridge;

import com.example.bridge.Imp.DabatasePersistenceImplementor;
import com.example.bridge.Imp.FileSystemPersistenceImplementor;
import com.example.bridge.Imp.PersistenceImp;

public class PersistenceFrameworkDriver {
	
	public static void main(String[] args) {
		PersistenceImplementor implementor = null;
		
		if(databaseDriverExists()){
			implementor = new DabatasePersistenceImplementor();
		}else{
			implementor = new FileSystemPersistenceImplementor();		
		}
		
		Persistence persistenceAPI = new PersistenceImp(implementor);
		Object o = persistenceAPI.findById("12343755");
		// do changes to the object 
		// then persist
		persistenceAPI.persist(o);
		
		// can also change implementor
		persistenceAPI = new PersistenceImp(new DabatasePersistenceImplementor()); 
		
		//delet
		persistenceAPI.deleteById("2323");		
	}

	private static boolean databaseDriverExists() {
	
		return false;
	}
}