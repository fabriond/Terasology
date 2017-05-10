package org.terasology.logic.health;

import java.util.HashMap;

import org.terasology.entitySystem.prefab.Prefab;
import org.terasology.logic.health.damage.Direct;
import org.terasology.logic.health.damage.Drowning;
import org.terasology.logic.health.damage.EngineDamageTypes;
import org.terasology.logic.health.damage.Explosive;
import org.terasology.logic.health.damage.Healing;
import org.terasology.logic.health.damage.Physical;

public class PrefabFactory {
	
	private static final HashMap<String, EngineDamageTypes> prototypes = new HashMap<String, EngineDamageTypes>();
	
	static{
		prototypes.put("direct", new Direct());
		prototypes.put("physical", new Physical());
		prototypes.put("explosive", new Explosive());
		prototypes.put("drowning", new Drowning());
		prototypes.put("healing", new Healing());
	}
	
	public static Prefab get(String damageType){
		
		return prototypes.get(damageType).get();        
		
	}

}
