// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::compute") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class MakeStructOptions extends FunctionOptions {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MakeStructOptions(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public MakeStructOptions(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public MakeStructOptions position(long position) {
        return (MakeStructOptions)super.position(position);
    }
    @Override public MakeStructOptions getPointer(long i) {
        return new MakeStructOptions((Pointer)this).offsetAddress(i);
    }

  public MakeStructOptions(@ByVal StringVector n, @ByVal BoolVector r,
                      @ByVal KeyValueMetadataVector m) { super((Pointer)null); allocate(n, r, m); }
  private native void allocate(@ByVal StringVector n, @ByVal BoolVector r,
                      @ByVal KeyValueMetadataVector m);
  public MakeStructOptions(@ByVal StringVector n) { super((Pointer)null); allocate(n); }
  private native void allocate(@ByVal StringVector n);
  public MakeStructOptions() { super((Pointer)null); allocate(); }
  private native void allocate();
  @MemberGetter public static native byte kTypeName(int i);
  @MemberGetter public static native String kTypeName();

  /** Names for wrapped columns */
  public native @ByRef StringVector field_names(); public native MakeStructOptions field_names(StringVector setter);

  /** Nullability bits for wrapped columns */
  public native @ByRef BoolVector field_nullability(); public native MakeStructOptions field_nullability(BoolVector setter);

  /** Metadata attached to wrapped columns */
  public native @ByRef KeyValueMetadataVector field_metadata(); public native MakeStructOptions field_metadata(KeyValueMetadataVector setter);
}
