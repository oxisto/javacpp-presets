// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


@Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TF_ImportGraphDefOptions extends org.bytedeco.tensorflow.AbstractTF_ImportGraphDefOptions {
    static { Loader.load(); }
    /** Default native constructor. */
    public TF_ImportGraphDefOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TF_ImportGraphDefOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TF_ImportGraphDefOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TF_ImportGraphDefOptions position(long position) {
        return (TF_ImportGraphDefOptions)super.position(position);
    }
    @Override public TF_ImportGraphDefOptions getPointer(long i) {
        return new TF_ImportGraphDefOptions((Pointer)this).offsetAddress(i);
    }

  public native @ByRef ImportGraphDefOptions opts(); public native TF_ImportGraphDefOptions opts(ImportGraphDefOptions setter);

  // Backing memory for TensorId fields in opts.
  // TODO(skyewm): it'd be better if ImportGraphDefOptions owned this.
  public native @ByRef StringList tensor_id_data(); public native TF_ImportGraphDefOptions tensor_id_data(StringList setter);
}
