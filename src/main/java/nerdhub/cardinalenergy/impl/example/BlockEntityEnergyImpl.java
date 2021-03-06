package nerdhub.cardinalenergy.impl.example;

import nerdhub.cardinalenergy.api.IEnergyHandler;
import nerdhub.cardinalenergy.impl.EnergyStorage;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

/**
 * An example impl of {@link IEnergyHandler}
 */
public class BlockEntityEnergyImpl extends BlockEntity implements IEnergyHandler {

    /**
     * Create an EnergyStorage instance that stores 10,000 energy
     * BlockComponentProvider is implemented on the Block to reference this
     */
    public EnergyStorage storage = new EnergyStorage(10000);

    public BlockEntityEnergyImpl(BlockEntityType<?> blockEntityType) {
        super(blockEntityType);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        //Write energy to nbt
        this.storage.toTag(tag);
        return tag;
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        //Read energy from nbt
        this.storage.fromTag(tag);
    }
}
