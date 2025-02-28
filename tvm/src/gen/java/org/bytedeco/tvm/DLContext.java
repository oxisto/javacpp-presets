// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tvm;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;
import static org.bytedeco.mkl.global.mkl_rt.*;

import static org.bytedeco.tvm.global.tvm_runtime.*;


/**
 * \brief A Device context for Tensor and operator.
 */
@Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class DLContext extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public DLContext() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DLContext(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DLContext(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public DLContext position(long position) {
        return (DLContext)super.position(position);
    }
    @Override public DLContext getPointer(long i) {
        return new DLContext((Pointer)this).offsetAddress(i);
    }

  /** \brief The device type used in the device. */
  public native @Cast("DLDeviceType") int device_type(); public native DLContext device_type(int setter);
  /** \brief The device index */
  public native int device_id(); public native DLContext device_id(int setter);
}
