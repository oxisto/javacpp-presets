// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** \defgroup nn_ops Nn Ops
 *  \{
 <p>
 *  Performs average pooling on the input.
 * 
 *  Each entry in {@code output} is the mean of the corresponding size {@code ksize}
 *  window in {@code value}.
 * 
 *  Arguments:
 *  * scope: A Scope object
 *  * value: 4-D with shape {@code [batch, height, width, channels]}.
 *  * ksize: The size of the sliding window for each dimension of {@code value}.
 *  * strides: The stride of the sliding window for each dimension of {@code value}.
 *  * padding: The type of padding algorithm to use.
 * 
 *  Optional attributes (see {@code Attrs}):
 *  * data_format: Specify the data format of the input and output data. With the
 *  default format "NHWC", the data is stored in the order of:
 *      [batch, in_height, in_width, in_channels].
 *  Alternatively, the format could be "NCHW", the data storage order of:
 *      [batch, in_channels, in_height, in_width].
 * 
 *  Returns:
 *  * {@code Output}: The average pooled output tensor. */
@Namespace("tensorflow::ops") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class AvgPool extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AvgPool(Pointer p) { super(p); }

  /** Optional attribute setters for AvgPool */
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
     *  default format "NHWC", the data is stored in the order of:
     *      [batch, in_height, in_width, in_channels].
     *  Alternatively, the format could be "NCHW", the data storage order of:
     *      [batch, in_channels, in_height, in_width].
     * 
     *  Defaults to "NHWC" */
    public native @ByVal Attrs DataFormat(@StringPiece BytePointer x);
    public native @ByVal Attrs DataFormat(@StringPiece String x);

    public native @StringPiece BytePointer data_format_(); public native Attrs data_format_(BytePointer setter);
  }
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece BytePointer padding) { super((Pointer)null); allocate(scope, value, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece BytePointer padding);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece String padding) { super((Pointer)null); allocate(scope, value, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece String padding);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece BytePointer padding) { super((Pointer)null); allocate(scope, value, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece BytePointer padding);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece String padding) { super((Pointer)null); allocate(scope, value, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece String padding);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece BytePointer padding) { super((Pointer)null); allocate(scope, value, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece BytePointer padding);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece String padding) { super((Pointer)null); allocate(scope, value, ksize, strides, padding); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece String padding);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece BytePointer padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece BytePointer padding, @Const @ByRef Attrs attrs);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece String padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece String padding, @Const @ByRef Attrs attrs);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece BytePointer padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece BytePointer padding, @Const @ByRef Attrs attrs);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece String padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntPointer ksize, @ArraySlice IntPointer strides,
          @StringPiece String padding, @Const @ByRef Attrs attrs);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece BytePointer padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice IntBuffer ksize, @ArraySlice IntBuffer strides,
          @StringPiece BytePointer padding, @Const @ByRef Attrs attrs);
  public AvgPool(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece String padding, @Const @ByRef Attrs attrs) { super((Pointer)null); allocate(scope, value, ksize, strides, padding, attrs); }
  private native void allocate(@Const @ByRef Scope scope, @ByVal Input value, @ArraySlice int[] ksize, @ArraySlice int[] strides,
          @StringPiece String padding, @Const @ByRef Attrs attrs);
  public native @ByVal @Name("operator tensorflow::Output") Output asOutput();
  public native @ByVal @Name("operator tensorflow::Input") Input asInput();
  public native Node node();

  public static native @ByVal Attrs DataFormat(@StringPiece BytePointer x);
  public static native @ByVal Attrs DataFormat(@StringPiece String x);

  public native @ByRef Operation operation(); public native AvgPool operation(Operation setter);
  public native @ByRef Output output(); public native AvgPool output(Output setter);
}
