package org.terasology.physics.engine;

import org.terasology.math.VecMath;
import org.terasology.math.geom.Vector3f;
import org.terasology.math.geom.Vector3i;
import org.terasology.world.block.Block;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.voxel.VoxelInfo;

public abstract class VInfo implements VoxelInfo{

    private boolean colliding;
    private boolean blocking;
    private CollisionShape shape;
    private Vector3i position;
    private Vector3f offset;

     VInfo(Block block, Vector3i position) {
        this.shape = block.getCollisionShape();
        this.offset = block.getCollisionOffset();
        this.position = position;
    }
    
    @Override
    public boolean isColliding() {
        return colliding;
    }
    
    protected void setColliding(boolean colliding) {
        this.colliding = colliding;
    }
    
    @Override
    public Object getUserData() {
        return position;
    }
    
    @Override
    public CollisionShape getCollisionShape() {
        return shape;
    }
    
    @Override
    public javax.vecmath.Vector3f getCollisionOffset() {
        return VecMath.to(offset);
    }
    
    @Override
    public boolean isBlocking() {
        return blocking;
    }
    
    protected void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }
	
}
