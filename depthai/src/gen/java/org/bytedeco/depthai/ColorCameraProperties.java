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
 *  Specify properties for ColorCamera such as camera ID, ...
 */
@Namespace("dai") @Properties(inherit = org.bytedeco.depthai.presets.depthai.class)
public class ColorCameraProperties extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ColorCameraProperties() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ColorCameraProperties(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ColorCameraProperties(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ColorCameraProperties position(long position) {
        return (ColorCameraProperties)super.position(position);
    }
    @Override public ColorCameraProperties getPointer(long i) {
        return new ColorCameraProperties((Pointer)this).offsetAddress(i);
    }

    @MemberGetter public static native int AUTO();
    public static final int AUTO = AUTO();

    public static class IspScale extends Pointer {
        static { Loader.load(); }
        /** Default native constructor. */
        public IspScale() { super((Pointer)null); allocate(); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public IspScale(long size) { super((Pointer)null); allocateArray(size); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public IspScale(Pointer p) { super(p); }
        private native void allocate();
        private native void allocateArray(long size);
        @Override public IspScale position(long position) {
            return (IspScale)super.position(position);
        }
        @Override public IspScale getPointer(long i) {
            return new IspScale((Pointer)this).offsetAddress(i);
        }
    
        public native int horizNumerator(); public native IspScale horizNumerator(int setter);
        public native int horizDenominator(); public native IspScale horizDenominator(int setter);
        public native int vertNumerator(); public native IspScale vertNumerator(int setter);
        public native int vertDenominator(); public native IspScale vertDenominator(int setter);
    }

    /**
     * Select the camera sensor resolution
     */
    public enum SensorResolution { THE_1080_P(0), THE_4_K(1), THE_12_MP(2);

        public final int value;
        private SensorResolution(int v) { this.value = v; }
        private SensorResolution(SensorResolution e) { this.value = e.value; }
        public SensorResolution intern() { for (SensorResolution e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }

    /**
     * For 24 bit color these can be either RGB or BGR
     */
    public enum ColorOrder { BGR(0), RGB(1);

        public final int value;
        private ColorOrder(int v) { this.value = v; }
        private ColorOrder(ColorOrder e) { this.value = e.value; }
        public ColorOrder intern() { for (ColorOrder e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }

    /*
     * Initial controls applied to ColorCamera node
     */
    public native @ByRef RawCameraControl initialControl(); public native ColorCameraProperties initialControl(RawCameraControl setter);

    /**
     * Which socket will color camera use
     */
    public native CameraBoardSocket boardSocket(); public native ColorCameraProperties boardSocket(CameraBoardSocket setter);

    /**
     * Camera sensor image orientation / pixel readout
     */
    public native CameraImageOrientation imageOrientation(); public native ColorCameraProperties imageOrientation(CameraImageOrientation setter);

    /**
     * For 24 bit color these can be either RGB or BGR
     */
    public native ColorOrder colorOrder(); public native ColorCameraProperties colorOrder(ColorOrder setter);
    /**
     * Are colors interleaved (R1G1B1, R2G2B2, ...) or planar (R1R2..., G1G2..., B1B2)
     */
    public native @Cast("bool") boolean interleaved(); public native ColorCameraProperties interleaved(boolean setter);
    /**
     * Are values FP16 type (0.0 - 255.0)
     */
    public native @Cast("bool") boolean fp16(); public native ColorCameraProperties fp16(boolean setter);

    /**
     * Preview frame output height
     */
    public native @Cast("uint32_t") int previewHeight(); public native ColorCameraProperties previewHeight(int setter);
    /**
     * Preview frame output width
     */
    public native @Cast("uint32_t") int previewWidth(); public native ColorCameraProperties previewWidth(int setter);

    /**
     * Preview frame output width
     */
    public native int videoWidth(); public native ColorCameraProperties videoWidth(int setter);

    /**
     * Preview frame output height
     */
    public native int videoHeight(); public native ColorCameraProperties videoHeight(int setter);

    /**
     * Preview frame output width
     */
    public native int stillWidth(); public native ColorCameraProperties stillWidth(int setter);

    /**
     * Preview frame output height
     */
    public native int stillHeight(); public native ColorCameraProperties stillHeight(int setter);

    /**
     * Select the camera sensor resolution
     */
    public native SensorResolution resolution(); public native ColorCameraProperties resolution(SensorResolution setter);
    /**
     * Camera sensor FPS
     */
    public native float fps(); public native ColorCameraProperties fps(float setter);

    /**
     * Initial sensor crop, -1 signifies center crop
     */
    public native float sensorCropX(); public native ColorCameraProperties sensorCropX(float setter);
    public native float sensorCropY(); public native ColorCameraProperties sensorCropY(float setter);

    /**
     * Whether to wait for config at 'inputConfig' io
     */
    public native @Cast("bool") boolean inputConfigSync(); public native ColorCameraProperties inputConfigSync(boolean setter);

    /**
     * Whether to keep aspect ratio of input (video size) or not
     */
    public native @Cast("bool") boolean previewKeepAspectRatio(); public native ColorCameraProperties previewKeepAspectRatio(boolean setter);

    /**
     * Configure scaling for {@code isp} output.
     */
    public native @ByRef IspScale ispScale(); public native ColorCameraProperties ispScale(IspScale setter);
}
