package net.luis.nero.api.common.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructurePiece;

// TODO: test move boundingBox xyz-, test move pos in get world pos + -> after fix Orientation bug
public abstract class ModStructurePiece extends StructurePiece {

	protected final int width;
	protected final int height;
	protected final int depth;

	protected ModStructurePiece(IStructurePieceType pieceType, Random rng, int x, int y, int z, int width, int height, int depth) {
		super(pieceType, 0);
		this.width = width;
		this.height = height;
		this.depth = depth;
//		this.setOrientation(Direction.NORTH); // Don't work
		this.setOrientation(Direction.Plane.HORIZONTAL.getRandomDirection(rng)); // Work
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			this.boundingBox = new MutableBoundingBox(x, y, z, x + (width * 2) - 1, y + (height * 2) - 1, z + (depth * 2) - 1);
		} else {
			this.boundingBox = new MutableBoundingBox(x, y, z, x + (depth * 2) - 1, y + (height * 2) - 1, z + (width * 2) - 1);
		}
	} 
	
	protected ModStructurePiece(IStructurePieceType pieceType, CompoundNBT nbt) {
		super(pieceType, nbt);
		this.width = nbt.getInt("Width");
		this.height = nbt.getInt("Height");
		this.depth = nbt.getInt("Depth");
	}
	 
	@Override
	protected void addAdditionalSaveData(CompoundNBT nbt) {
		nbt.putInt("Width", this.width);
		nbt.putInt("Height", this.height);
		nbt.putInt("Depth", this.depth);
	}
	
	protected int getX(int x) {
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			return x + this.width;
		} else {
			return x + this.depth;
		}
	}
	
	protected int getY(int y) {
		return y + this.height;
	}
	
	protected int getZ(int z) {
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			return z + this.depth;
		} else {
			return z + this.width;
		}
	}
	
	/*	@Override
	protected void placeBlock(ISeedReader seedReader, BlockState state, int x, int y, int z, MutableBoundingBox boundingBox) {
		super.placeBlock(seedReader, state, x, y, z, boundingBox);
		BlockPos startPos = new BlockPos(boundingBox.x0, boundingBox.y0, boundingBox.z0);
		BlockPos endPos = new BlockPos(boundingBox.x1, boundingBox.y1, boundingBox.z1);
		BlockPos pos = new BlockPos(this.getWorldX(x, z), this.getWorldY(y), this.getWorldZ(x, z));
		Nero.LOGGER.debug("BoundingBox from {} to {}, and is pos {} inside: {}", startPos, endPos, pos, boundingBox.isInside(pos));
	}*/
	
}
