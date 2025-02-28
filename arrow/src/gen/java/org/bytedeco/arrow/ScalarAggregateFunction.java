// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::compute") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ScalarAggregateFunction extends Function {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ScalarAggregateFunction(Pointer p) { super(p); }


  public ScalarAggregateFunction(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                            @Const FunctionOptions default_options/*=nullptr*/) { super((Pointer)null); allocate(name, arity, doc, default_options); }
  private native void allocate(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                            @Const FunctionOptions default_options/*=nullptr*/);
  public ScalarAggregateFunction(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc) { super((Pointer)null); allocate(name, arity, doc); }
  private native void allocate(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc);
  public ScalarAggregateFunction(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                            @Const FunctionOptions default_options/*=nullptr*/) { super((Pointer)null); allocate(name, arity, doc, default_options); }
  private native void allocate(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                            @Const FunctionOptions default_options/*=nullptr*/);
  public ScalarAggregateFunction(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc) { super((Pointer)null); allocate(name, arity, doc); }
  private native void allocate(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc);

  /** \brief Add a kernel (function implementation). Returns error if the
   *  kernel's signature does not match the function's arity. */
  public native @ByVal Status AddKernel(@ByVal ScalarAggregateKernel kernel);
}
