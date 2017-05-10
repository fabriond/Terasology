/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.physics.engine;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.voxel.VoxelInfo;
import com.bulletphysics.collision.shapes.voxel.VoxelPhysicsWorld;

import org.terasology.math.geom.Vector3i;
import org.terasology.world.WorldProvider;
import org.terasology.world.block.Block;

/**
 * This class links Terasology's voxel world with the physics engine, providing it with the collision information for each block location.
 *
 */
public class PhysicsWorldWrapper implements VoxelPhysicsWorld {

    private WorldProvider world;

    public PhysicsWorldWrapper(WorldProvider world) {
        this.world = world;
    }
    
    @Override
    public VoxelInfo getCollisionShapeAt(int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        return new TeraVoxelInfo(block, block.isTargetable(), !block.isPenetrable(), new Vector3i(x, y, z));
    }

    public void dispose() {
        world = null;
    }

    private static class TeraVoxelInfo extends VInfo {

         TeraVoxelInfo(Block block, boolean colliding, boolean blocking, Vector3i position) {
            super(block, position);
            CollisionShape shape = this.getCollisionShape();
        	this.setColliding(shape != null && colliding);
            this.setBlocking(shape != null && blocking);
        }

    }
}
