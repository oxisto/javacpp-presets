// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** Adds {@code bias} to {@code value}.
 * 
 *  This is a special case of {@code tf.add} where {@code bias} is restricted to be 1-D.
 *  Broadcasting is supported, so {@code value} may have any number of dimensions.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * value: Any number of dimensions.
 *  * bias: 1-D with size the last dimension of {@code value}.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * data_format: Specify the data format of the input and output data. With the
 *  default format "NHWC", the bias tensor will be added to the last dimension
 *  of the value tensor.
 *  Alternatively, the format could be "NCHW", the data storage order of:
 *      [batch, in_channels, in_height, in_width].
 *  The tensor will be added to "in_channels", the third-to-the-last
 *      dimension.
 * 
 *  Returns:
 *  * {@code Output}: Broadcasted sum of {@code value} and {@code bias}. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class BiasAdd extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public BiasAdd(Pointer p) { super(p); }

  /** Optional attribute setters for BiasAdd */
  public static class Attrs extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Attrs() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Attrs(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Attrs(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Attrs position(long position) {
          return (Attrs)super.position(position);
      }
      @Override public Attrs getPointer(long i) {
          return new Attrs((Pointer)this).offsetAddress(i);
      }
  
    /** Specify the data format of the input and output data. With the
     *  default format "NHWC", the bias tensor will be added to the last dimension
     *  of the value tensor.
     *  Alternatively, the format could be "NCHW", the data storage order of:
     *      [batch, in_channels, in_height, in_width].
     *  The tensor will be added to "in_channels", the third-to-the-last
     *      dimension.
     * 
     *  Defaults to "NHWC" */
    public native @ByVal Attrs DataFormat(@StringPiece BytePointer x);
    public native @ByVal Attrs DataFormat(@StringPiece String x);

    public native @StringPiece BytePointer data_format_(); public native Attrs data_format_(BytePointer setter);
  }
  public BiasAdd(@Const @ByRef Scope scope, @ByVal Input value,
          @ByVal Input bias) { super((Pointer)null); allocate(scope, value, bias); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value,
          @ByVal Input bias);
  public BiasAdd(@Const @ByRef Scope scope, @ByVal Input value,
          @ByVal Input bias, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, bias, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value,
          @ByVal Input bias, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs DataFormat(@StringPiece BytePointer x);
  public static native @ByVal Attrs DataFormat(@StringPiece String x);

  public native @ByRef Operation operation(); public native BiasAdd operation(Operation setter);
  public native @ByRef Output output(); public native BiasAdd output(Output setter);
}
