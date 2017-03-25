package application;

import java.util.ArrayList;

/**
 * @author Brett Allen 
 *
 */
public class ZoningCategory {
	private String zoningID;
	private ArrayList<String> definition;
	
	public ZoningCategory(String zoningID){
		this.zoningID = zoningID;
		definition = new ArrayList<String>();
	}
	
	/**
	 * Adds a line to the definition of the zoning category
	 * 
	 * @param line the line to be added to the definition
	 * */
	public void addLine(String line){
		definition.add(line);
	}
	
	/**
	 * Set the entire definition of the zoning category to the specified definition
	 * 
	 * @param definition the ArrayList representing the definition to be copied into this zoning category
	 * */
	public void setDefinition(ArrayList<String> definition){
		this.definition = definition;
	}
	
	/**
	 * Set the zoning identification
	 * 
	 * @param zondingID the specific identification that will represent this zoning identification
	 * */
	public void setZoningID(String zoningID){
		this.zoningID = zoningID;
	}
	
	@Override
	public String toString(){
		String display = "";
		
		display += zoningID + ":\n\n";
		
		if(definition != null){
			for(String line : definition){
				display += line + "\n";
			}
		}
		
		return display;
	}
}
