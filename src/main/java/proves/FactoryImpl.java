package proves;

import java.util.*;

public class FactoryImpl {

	private static FactoryImpl f;
	Hashtable<String, Action > actions;
	
	public FactoryImpl(){
		this.actions = new Hashtable<String, Action>();
	}
	
	public static FactoryImpl getReference(){
		if(f==null)
			f = new FactoryImpl();
		return f;
	}

	public Action getAction(String param) {
	  Action action = (this.actions.get(param));
	  if (action==null) {
		  action = getInstance(param);
		  this.actions.put(param, action);
	  }
	  return action;
	}

    private String getClassName(String name)  {	
      String accio = null;
      accio = name.substring(0,1).toUpperCase()+name.substring(1); 
      return "proves.accions."+accio;
    }
	  
	private Action getInstance(String param) {
		
		String theClass= this.getClassName(param); 
		@SuppressWarnings("rawtypes")
		Class c;
		Action o = null;
		try{
			c = Class.forName(theClass);
			o = (Action) c.newInstance();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return o;
	}
}
