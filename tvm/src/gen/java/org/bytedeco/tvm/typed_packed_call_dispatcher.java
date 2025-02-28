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


@Name("tvm::runtime::detail::typed_packed_call_dispatcher<void>") @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class typed_packed_call_dispatcher extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public typed_packed_call_dispatcher() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public typed_packed_call_dispatcher(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public typed_packed_call_dispatcher(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public typed_packed_call_dispatcher position(long position) {
        return (typed_packed_call_dispatcher)super.position(position);
    }
    @Override public typed_packed_call_dispatcher getPointer(long i) {
        return new typed_packed_call_dispatcher((Pointer)this).offsetAddress(i);
    }

}
