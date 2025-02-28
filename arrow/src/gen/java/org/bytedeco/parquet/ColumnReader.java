// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ColumnReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ColumnReader(Pointer p) { super(p); }


  public static native @SharedPtr ColumnReader Make(
        @Const ColumnDescriptor descr, @UniquePtr PageReader pager,
        MemoryPool pool/*=arrow::default_memory_pool()*/);
  public static native @SharedPtr ColumnReader Make(
        @Const ColumnDescriptor descr, @UniquePtr PageReader pager);

  // Returns true if there are still values in this column.
  public native @Cast("bool") boolean HasNext();

  public native org.bytedeco.parquet.Type.type type();

  public native @Const ColumnDescriptor descr();

  // Get the encoding that can be exposed by this reader. If it returns
  // dictionary encoding, then ReadBatchWithDictionary can be used to read data.
  //
  // \note API EXPERIMENTAL
  public native ExposedEncoding GetExposedEncoding();
}
