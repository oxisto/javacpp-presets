// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Control Mode kernel behavior
 * 
 *  Returns top-n common values and counts.
 *  By default, returns the most common value and count. */
@Namespace("arrow::compute") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ModeOptions extends FunctionOptions {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ModeOptions(Pointer p) { super(p); }

  public ModeOptions(@Cast("int64_t") long n/*=1*/) { super((Pointer)null); allocate(n); }
  private native void allocate(@Cast("int64_t") long n/*=1*/);
  public ModeOptions() { super((Pointer)null); allocate(); }
  private native void allocate();
  @MemberGetter public static native byte kTypeName(int i);
  @MemberGetter public static native String kTypeName();
  public static native @ByVal ModeOptions Defaults();

  public native @Cast("int64_t") long n(); public native ModeOptions n(long setter);
}
