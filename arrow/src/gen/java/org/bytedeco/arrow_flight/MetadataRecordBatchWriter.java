// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief An interface to write IPC payloads with metadata. */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class MetadataRecordBatchWriter extends RecordBatchWriter {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MetadataRecordBatchWriter(Pointer p) { super(p); }

  /** \brief Begin writing data with the given schema. Only used with \a DoExchange. */
  public native @ByVal Status Begin(@Const @SharedPtr @ByRef Schema schema,
                         @Const @ByRef IpcWriteOptions options);
  public native @ByVal Status Begin(@Const @SharedPtr @ByRef Schema schema);
  public native @ByVal Status WriteMetadata(@SharedPtr ArrowBuffer app_metadata);
  public native @ByVal Status WriteWithMetadata(@Const @ByRef RecordBatch batch,
                                     @SharedPtr ArrowBuffer app_metadata);
}
