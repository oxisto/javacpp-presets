// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.plasma;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.plasma.*;


/** Object buffer data structure. */
@Namespace("plasma") @Properties(inherit = org.bytedeco.arrow.presets.plasma.class)
public class ObjectBuffer extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ObjectBuffer() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ObjectBuffer(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ObjectBuffer(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ObjectBuffer position(long position) {
        return (ObjectBuffer)super.position(position);
    }
    @Override public ObjectBuffer getPointer(long i) {
        return new ObjectBuffer((Pointer)this).offsetAddress(i);
    }

  /** The data buffer. */
  public native @SharedPtr ArrowBuffer data(); public native ObjectBuffer data(ArrowBuffer setter);
  /** The metadata buffer. */
  public native @SharedPtr ArrowBuffer metadata(); public native ObjectBuffer metadata(ArrowBuffer setter);
  /** The device number. */
  public native int device_num(); public native ObjectBuffer device_num(int setter);
}
