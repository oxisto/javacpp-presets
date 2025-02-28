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


// #if 0
// #endif

/**
 * IMU output
 *
 * Contains combined output for all possible modes. Only the enabled outputs are populated.
 */
@Namespace("dai") @Properties(inherit = org.bytedeco.depthai.presets.depthai.class)
public class IMUPacket extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IMUPacket() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IMUPacket(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IMUPacket(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IMUPacket position(long position) {
        return (IMUPacket)super.position(position);
    }
    @Override public IMUPacket getPointer(long i) {
        return new IMUPacket((Pointer)this).offsetAddress(i);
    }

    public native @ByRef IMUReportAccelerometer acceleroMeter(); public native IMUPacket acceleroMeter(IMUReportAccelerometer setter);
    public native @ByRef IMUReportGyroscope gyroscope(); public native IMUPacket gyroscope(IMUReportGyroscope setter);
    public native @ByRef IMUReportMagneticField magneticField(); public native IMUPacket magneticField(IMUReportMagneticField setter);
    public native @ByRef IMUReportRotationVectorWAcc rotationVector(); public native IMUPacket rotationVector(IMUReportRotationVectorWAcc setter);

// #if 0
// #endif
}
