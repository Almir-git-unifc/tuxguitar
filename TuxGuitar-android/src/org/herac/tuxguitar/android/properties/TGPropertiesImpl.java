package org.herac.tuxguitar.android.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.herac.tuxguitar.util.properties.TGProperties;

public class TGPropertiesImpl implements TGProperties{
	
	private Map<String, String> properties;
	
	public TGPropertiesImpl(){
		this.properties = new HashMap<String, String>();
	}

	public Map<String, String> getMap() {
		return this.properties;
	}
	
	public String getValue(String key) {
		return this.properties.get(key);
	}

	public void setValue(String key, String value) {
		this.properties.put(key, value);
	}
	
	public void remove(String key) {
		this.properties.remove(key);
	}
	
	public void clear() {
		this.properties.clear();
	}

	public void update(Properties newProperties) {
		HashMap<String, String> newPropertiesMap = new HashMap<>();
		for (Map.Entry<Object, Object> entry : newProperties.entrySet()) {
			newPropertiesMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
		}
		this.properties.putAll(newPropertiesMap);
	}

}
