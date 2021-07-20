package individualFinance.model;

import individualFinance.saveLoad.SaveData;

abstract public class Common {

	public Common(){}
	public String getValueForComboBox(){
		return null;
	}

	public void postAdd(SaveData data){}
	public void postEdit(SaveData data){}
	public void postRemove(SaveData data){}
}
