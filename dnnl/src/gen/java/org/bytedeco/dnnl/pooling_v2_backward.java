// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** Pooling v2 (dilated pooling) backward propagation primitive. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class pooling_v2_backward extends primitive {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pooling_v2_backward(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public pooling_v2_backward(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public pooling_v2_backward position(long position) {
        return (pooling_v2_backward)super.position(position);
    }
    @Override public pooling_v2_backward getPointer(long i) {
        return new pooling_v2_backward((Pointer)this).offsetAddress(i);
    }

    /** Descriptor for a pooling backward propagation primitive. */
    @NoOffset public static class desc extends Pointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public desc(Pointer p) { super(p); }
    
        
        ///
        ///
        public native @ByRef dnnl_pooling_v2_desc_t data(); public native desc data(dnnl_pooling_v2_desc_t setter);

        /** Constructs a descriptor for pooling v2 (dilated pooling) backward
         *  propagation primitive.
         * 
         *  Arrays \p strides, \p kernel, \p dilation, \p padding_l
         *  and \p padding_r contain values for spatial dimensions only and
         *  hence must have the same number of elements as there are spatial
         *  dimensions. The order of values is the same as in the tensor:
         *  depth (for 3D tensors), height (for 3D and 2D tensors), and width.
         * 
         *  @param aalgorithm Pooling algorithm kind: either
         *      #dnnl::algorithm::pooling_max,
         *      #dnnl::algorithm::pooling_avg_include_padding,
         *      or #dnnl::algorithm::pooling_avg (same as
         *      #dnnl::algorithm::pooling_avg_exclude_padding).
         *  @param diff_src_desc Diff source memory descriptor.
         *  @param diff_dst_desc Diff destination memory descriptor.
         *  @param strides Vector of strides for spatial dimension.
         *  @param kernel Vector of kernel spatial dimensions.
         *  @param dilation Array of dilations for spatial dimension.
         *  @param padding_l Vector of padding values for low indices for each
         *      spatial dimension {@code ([[front,] top,] left)}.
         *  @param padding_r Vector of padding values for high indices for
         *      each spatial dimension {@code ([[back,] bottom,] right)}. */
        public desc(algorithm aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_r) { super((Pointer)null); allocate(aalgorithm, diff_src_desc, diff_dst_desc, strides, kernel, dilation, padding_l, padding_r); }
        private native void allocate(algorithm aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_r);
        public desc(@Cast("dnnl::algorithm") int aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_r) { super((Pointer)null); allocate(aalgorithm, diff_src_desc, diff_dst_desc, strides, kernel, dilation, padding_l, padding_r); }
        private native void allocate(@Cast("dnnl::algorithm") int aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_r);
        public desc(algorithm aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_r) { super((Pointer)null); allocate(aalgorithm, diff_src_desc, diff_dst_desc, strides, kernel, dilation, padding_l, padding_r); }
        private native void allocate(algorithm aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_r);
        public desc(@Cast("dnnl::algorithm") int aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_r) { super((Pointer)null); allocate(aalgorithm, diff_src_desc, diff_dst_desc, strides, kernel, dilation, padding_l, padding_r); }
        private native void allocate(@Cast("dnnl::algorithm") int aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongPointer padding_r);
        public desc(algorithm aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_r) { super((Pointer)null); allocate(aalgorithm, diff_src_desc, diff_dst_desc, strides, kernel, dilation, padding_l, padding_r); }
        private native void allocate(algorithm aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef LongBuffer padding_r);
        public desc(@Cast("dnnl::algorithm") int aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_r) { super((Pointer)null); allocate(aalgorithm, diff_src_desc, diff_dst_desc, strides, kernel, dilation, padding_l, padding_r); }
        private native void allocate(@Cast("dnnl::algorithm") int aalgorithm, @Const @ByRef memory.desc diff_src_desc,
                        @Const @ByRef memory.desc diff_dst_desc, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] strides,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] kernel, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] dilation,
                        @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_l, @Const @Cast({"dnnl_dim_t*", "std::vector<dnnl_dim_t>&"}) @StdVector("dnnl_dim_t") @ByRef long[] padding_r);
    }

    /** Primitive descriptor for a pooling v2 (dilated pooling) backward
     *  propagation primitive. */
    public static class primitive_desc extends org.bytedeco.dnnl.primitive_desc {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public primitive_desc(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public primitive_desc(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public primitive_desc position(long position) {
            return (primitive_desc)super.position(position);
        }
        @Override public primitive_desc getPointer(long i) {
            return new primitive_desc((Pointer)this).offsetAddress(i);
        }
    
        /** Default constructor. Produces an empty object. */
        
        ///
        public primitive_desc() { super((Pointer)null); allocate(); }
        private native void allocate();

        /** Constructs a primitive descriptor for a pooling v2
         *  (dilated pooling) backward
         *  propagation primitive.
         * 
         *  @param adesc Descriptor for a pooling backward propagation primitive.
         *  @param aengine Engine to use.
         *  @param hint_fwd_pd Primitive descriptor for a pooling forward
         *      propagation primitive. It is used as a hint for deciding which
         *      memory format to use.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd,
                        @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(adesc, aengine, hint_fwd_pd, allow_empty); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd,
                        @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd) { super((Pointer)null); allocate(adesc, aengine, hint_fwd_pd); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd);

        /** Constructs a primitive descriptor for a pooling v2
         *  (dilated pooling) backward
         *  propagation primitive.
         * 
         *  @param adesc Descriptor for a pooling backward propagation primitive.
         *  @param attr Primitive attributes to use.
         *  @param aengine Engine to use.
         *  @param hint_fwd_pd Primitive descriptor for a pooling forward
         *      propagation primitive. It is used as a hint for deciding which
         *      memory format to use.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd,
                        @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(adesc, attr, aengine, hint_fwd_pd, allow_empty); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd,
                        @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd) { super((Pointer)null); allocate(adesc, attr, aengine, hint_fwd_pd); }
        private native void allocate(@Const @ByRef desc adesc, @Const @ByRef primitive_attr attr,
                        @Const @ByRef engine aengine,
                        @Const @ByRef pooling_v2_forward.primitive_desc hint_fwd_pd);

        /** Constructs a primitive descriptor for a pooling v2
         *  (dilated pooling) backward
         *  propagation primitive from a C API primitive descriptor that must
         *  have a matching kind.
         * 
         *  @param pd C API primitive descriptor for a pooling backward
         *      propagation primitive. */
        public primitive_desc(dnnl_primitive_desc pd) { super((Pointer)null); allocate(pd); }
        private native void allocate(dnnl_primitive_desc pd);

        /** \copydoc dnnl::primitive_desc_base::src_desc()const */
        public native @ByVal memory.desc diff_src_desc();

        /** \copydoc dnnl::primitive_desc_base::diff_dst_desc()const */
        public native @ByVal memory.desc diff_dst_desc();

        /** \copydoc dnnl::primitive_desc_base::workspace_desc()const */
        public native @ByVal memory.desc workspace_desc();
    }

    /** Default constructor. Produces an empty object. */
    public pooling_v2_backward() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** Constructs a pooling v2 (dilated pooling) backward
     *  propagation primitive.
     *  @param pd Primitive descriptor for a pooling backward propagation
     *      primitive. */
    public pooling_v2_backward(@Const @ByRef primitive_desc pd) { super((Pointer)null); allocate(pd); }
    private native void allocate(@Const @ByRef primitive_desc pd);
}
