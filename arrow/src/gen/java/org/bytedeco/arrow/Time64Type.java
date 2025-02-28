// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Concrete type class for 64-bit time data (as number of microseconds or nanoseconds
 *  since midnight) */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Time64Type extends TimeType {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Time64Type(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Time64Type(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Time64Type position(long position) {
        return (Time64Type)super.position(position);
    }
    @Override public Time64Type getPointer(long i) {
        return new Time64Type((Pointer)this).offsetAddress(i);
    }

  @MemberGetter public static native @Cast("const arrow::Type::type") int type_id();
  public static final int type_id = type_id();

  public static native String type_name();

  public native int bit_width();

  public Time64Type(TimeUnit.type unit/*=arrow::TimeUnit::NANO*/) { super((Pointer)null); allocate(unit); }
  private native void allocate(TimeUnit.type unit/*=arrow::TimeUnit::NANO*/);
  public Time64Type() { super((Pointer)null); allocate(); }
  private native void allocate();
  public Time64Type(@Cast("arrow::TimeUnit::type") int unit/*=arrow::TimeUnit::NANO*/) { super((Pointer)null); allocate(unit); }
  private native void allocate(@Cast("arrow::TimeUnit::type") int unit/*=arrow::TimeUnit::NANO*/);

  public native @StdString String ToString();

  public native @StdString String name();
}
