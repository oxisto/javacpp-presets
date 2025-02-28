// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.hdf5;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.hdf5.global.hdf5.*;

/** <!-- [H5O_token_t_snip] -->
<p>
/**
 * Allocation statistics info struct
 */
@Properties(inherit = org.bytedeco.hdf5.presets.hdf5.class)
public class H5_alloc_stats_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public H5_alloc_stats_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public H5_alloc_stats_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public H5_alloc_stats_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public H5_alloc_stats_t position(long position) {
        return (H5_alloc_stats_t)super.position(position);
    }
    @Override public H5_alloc_stats_t getPointer(long i) {
        return new H5_alloc_stats_t((Pointer)this).offsetAddress(i);
    }

    /** Running count of total # of bytes allocated */
    public native @Cast("unsigned long long") long total_alloc_bytes(); public native H5_alloc_stats_t total_alloc_bytes(long setter);
    /** Current # of bytes allocated */
    public native @Cast("size_t") long curr_alloc_bytes(); public native H5_alloc_stats_t curr_alloc_bytes(long setter);
    /** Peak # of bytes allocated */
    public native @Cast("size_t") long peak_alloc_bytes(); public native H5_alloc_stats_t peak_alloc_bytes(long setter);
    /** Largest block allocated */
    public native @Cast("size_t") long max_block_size(); public native H5_alloc_stats_t max_block_size(long setter);
    /** Running count of total # of blocks allocated */
    public native @Cast("size_t") long total_alloc_blocks_count(); public native H5_alloc_stats_t total_alloc_blocks_count(long setter);
    /** Current # of blocks allocated */
    public native @Cast("size_t") long curr_alloc_blocks_count(); public native H5_alloc_stats_t curr_alloc_blocks_count(long setter);
    /** Peak # of blocks allocated */
    public native @Cast("size_t") long peak_alloc_blocks_count(); public native H5_alloc_stats_t peak_alloc_blocks_count(long setter);
}
