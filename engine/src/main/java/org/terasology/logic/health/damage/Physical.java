package org.terasology.logic.health.damage;

import org.terasology.entitySystem.prefab.Prefab;
import org.terasology.utilities.Assets;

public class Physical implements EngineDamageTypes {
	
	private final String prefabId = "engine:physicalDamage";

	@Override
	public Prefab get() {
		return Assets.getPrefab(prefabId).get();
	}

}
