// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// Read interface classes. We do not fully deserialize the flatbuffers so that
// individual fields metadata can be retrieved from very large schema without
//

/** \class Message
 *  \brief An IPC message including metadata and body */
@Namespace("arrow::ipc") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class Message extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Message(Pointer p) { super(p); }

  /** \brief Construct message, but do not validate
   * 
   *  Use at your own risk; Message::Open has more metadata validation */
  public Message(@SharedPtr ArrowBuffer metadata, @SharedPtr ArrowBuffer body) { super((Pointer)null); allocate(metadata, body); }
  private native void allocate(@SharedPtr ArrowBuffer metadata, @SharedPtr ArrowBuffer body);

  /** \brief Create and validate a Message instance from two buffers
   * 
   *  @param metadata [in] a buffer containing the Flatbuffer metadata
   *  @param body [in] a buffer containing the message body, which may be null
   *  @return the created message */
  
  ///
  public static native @ByVal MessageUniqueResult Open(@SharedPtr ArrowBuffer metadata,
                                                 @SharedPtr ArrowBuffer body);

  /** \brief Read message body and create Message given Flatbuffer metadata
   *  @param metadata [in] containing a serialized Message flatbuffer
   *  @param stream [in] an InputStream
   *  @return the created Message
   * 
   *  \note If stream supports zero-copy, this is zero-copy */
  
  ///
  public static native @ByVal MessageUniqueResult ReadFrom(@SharedPtr ArrowBuffer metadata,
                                                     InputStream stream);

  /** \brief Read message body from position in file, and create Message given
   *  the Flatbuffer metadata
   *  @param offset [in] the position in the file where the message body starts.
   *  @param metadata [in] containing a serialized Message flatbuffer
   *  @param file [in] the seekable file interface to read from
   *  @return the created Message
   * 
   *  \note If file supports zero-copy, this is zero-copy */
  
  ///
  public static native @ByVal MessageUniqueResult ReadFrom(@Cast("const int64_t") long offset,
                                                     @SharedPtr ArrowBuffer metadata,
                                                     RandomAccessFile file);

  /** \brief Return true if message type and contents are equal
   * 
   *  @param other another message
   *  @return true if contents equal */
  
  ///
  public native @Cast("bool") boolean Equals(@Const @ByRef Message other);

  /** \brief the Message metadata
   * 
   *  @return buffer */
  public native @SharedPtr ArrowBuffer metadata();

  /** \brief Custom metadata serialized in metadata Flatbuffer. Returns nullptr
   *  when none set */
  
  ///
  public native @SharedPtr @Cast({"const arrow::KeyValueMetadata*", "std::shared_ptr<const arrow::KeyValueMetadata>"}) KeyValueMetadata custom_metadata();

  /** \brief the Message body, if any
   * 
   *  @return buffer is null if no body */
  public native @SharedPtr ArrowBuffer body();

  /** \brief The expected body length according to the metadata, for
   *  verification purposes */
  public native @Cast("int64_t") long body_length();

  /** \brief The Message type */
  public native MessageType type();

  /** \brief The Message metadata version */
  public native MetadataVersion metadata_version();

  
  ///
  public native @Const Pointer header();

  /** \brief Write length-prefixed metadata and body to output stream
   * 
   *  @param file [in] output stream to write to
   *  @param options [in] IPC writing options including alignment
   *  @param output_length [out] the number of bytes written
   *  @return Status */
  public native @ByVal Status SerializeTo(OutputStream file, @Const @ByRef IpcWriteOptions options,
                       @Cast("int64_t*") LongPointer output_length);
  public native @ByVal Status SerializeTo(OutputStream file, @Const @ByRef IpcWriteOptions options,
                       @Cast("int64_t*") LongBuffer output_length);
  public native @ByVal Status SerializeTo(OutputStream file, @Const @ByRef IpcWriteOptions options,
                       @Cast("int64_t*") long[] output_length);

  /** \brief Return true if the Message metadata passes Flatbuffer validation */
  public native @Cast("bool") boolean Verify();

  /** \brief Whether a given message type needs a body. */
  public static native @Cast("bool") boolean HasBody(MessageType type);
  public static native @Cast("bool") boolean HasBody(@Cast("arrow::ipc::MessageType") int type);
}
