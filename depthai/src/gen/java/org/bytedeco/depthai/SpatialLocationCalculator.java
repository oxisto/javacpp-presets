// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.depthai;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

import static org.bytedeco.depthai.global.depthai.*;


/**
 * \brief SpatialLocationCalculator node. Calculates spatial location data on a set of ROIs on depth map.
 */
@Namespace("dai::node") @NoOffset @Properties(inherit = org.bytedeco.depthai.presets.depthai.class)
public class SpatialLocationCalculator extends Node {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SpatialLocationCalculator(Pointer p) { super(p); }

    public native @StdString @Override BytePointer getName();

    public SpatialLocationCalculator(@SharedPtr PipelineImpl par, @Cast("int64_t") long nodeId) { super((Pointer)null); allocate(par, nodeId); }
    private native void allocate(@SharedPtr PipelineImpl par, @Cast("int64_t") long nodeId);

    /**
     * Initial config to use when calculating spatial location data.
     */
    @MemberGetter public native @ByRef SpatialLocationCalculatorConfig initialConfig();

    /**
     * Input SpatialLocationCalculatorConfig message with ability to modify parameters in runtime.
     * Default queue is non-blocking with size 4.
     */
    @MemberGetter public native @ByRef Input inputConfig();
    /**
     * Input message with depth data used to retrieve spatial information about detected object.
     * Default queue is non-blocking with size 4.
     */
    @MemberGetter public native @ByRef Input inputDepth();

    /**
     * Outputs SpatialLocationCalculatorData message that carries spatial location results.
     */
    @MemberGetter public native @ByRef Output out();

    /**
     * Passthrough message on which the calculation was performed.
     * Suitable for when input queue is set to non-blocking behavior.
     */
    @MemberGetter public native @ByRef Output passthroughDepth();

    // Functions to set properties
    /**
     * Specify whether or not wait until configuration message arrives to inputConfig Input.
     * @param wait True to wait for configuration message, false otherwise.
     */
    public native void setWaitForConfigInput(@Cast("bool") boolean _wait);
}
