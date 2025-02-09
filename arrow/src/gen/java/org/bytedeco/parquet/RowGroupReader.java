// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class RowGroupReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RowGroupReader(Pointer p) { super(p); }

  // Forward declare a virtual class 'Contents' to aid dependency injection and more
  // easily create test fixtures
  // An implementation of the Contents class is defined in the .cc file
  public static class Contents extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Contents(Pointer p) { super(p); }
  
    public native @UniquePtr PageReader GetColumnPageReader(int i);
    public native @Const RowGroupMetaData metadata();
    public native @Const ReaderProperties properties();
  }

  public RowGroupReader(@UniquePtr Contents contents) { super((Pointer)null); allocate(contents); }
  private native void allocate(@UniquePtr Contents contents);

  // Returns the rowgroup metadata
  public native @Const RowGroupMetaData metadata();

  // Construct a ColumnReader for the indicated row group-relative
  // column. Ownership is shared with the RowGroupReader.
  public native @SharedPtr ColumnReader Column(int i);

  // Construct a ColumnReader, trying to enable exposed encoding.
  //
  // For dictionary encoding, currently we only support column chunks that are fully
  // dictionary encoded, i.e., all data pages in the column chunk are dictionary encoded.
  // If a column chunk uses dictionary encoding but then falls back to plain encoding, the
  // encoding will not be exposed.
  //
  // The returned column reader provides an API GetExposedEncoding() for the
  // users to check the exposed encoding and determine how to read the batches.
  //
  // \note API EXPERIMENTAL
  public native @SharedPtr ColumnReader ColumnWithExposeEncoding(
        int i, ExposedEncoding encoding_to_expose);
  public native @SharedPtr ColumnReader ColumnWithExposeEncoding(
        int i, @Cast("parquet::ExposedEncoding") int encoding_to_expose);

  public native @UniquePtr PageReader GetColumnPageReader(int i);
}
