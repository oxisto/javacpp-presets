// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;

@Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class onnxSetGraphIOFunction extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    onnxSetGraphIOFunction(Pointer p) { super(p); }
    protected onnxSetGraphIOFunction() { allocate(); }
    private native void allocate();
    public native @Cast("onnxStatus") int call(
    onnxGraph graph,
    @Cast("uint32_t") int inputsCount,
    @Const onnxTensorDescriptorV1 inputDescriptors,
    @Cast("uint32_t") int outputsCount,
    @Const onnxTensorDescriptorV1 outputDescriptors);
}
