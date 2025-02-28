// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Options for the LocalFileSystem implementation. */
@Namespace("arrow::fs") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class LocalFileSystemOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public LocalFileSystemOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public LocalFileSystemOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LocalFileSystemOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public LocalFileSystemOptions position(long position) {
        return (LocalFileSystemOptions)super.position(position);
    }
    @Override public LocalFileSystemOptions getPointer(long i) {
        return new LocalFileSystemOptions((Pointer)this).offsetAddress(i);
    }

  /** Whether OpenInputStream and OpenInputFile return a mmap'ed file,
   *  or a regular one. */
  public native @Cast("bool") boolean use_mmap(); public native LocalFileSystemOptions use_mmap(boolean setter);

  /** \brief Initialize with defaults */
  public static native @ByVal LocalFileSystemOptions Defaults();

  public native @Cast("bool") boolean Equals(@Const @ByRef LocalFileSystemOptions other);

  public static native @ByVal LocalFileSystemOptionsResult FromUri(@Const @ByRef Uri uri,
                                                  @StdString @Cast({"char*", "std::string*"}) BytePointer out_path);
}
