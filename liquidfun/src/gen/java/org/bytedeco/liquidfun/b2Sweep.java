// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.liquidfun;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.liquidfun.global.liquidfun.*;


/** This describes the motion of a body/shape for TOI computation.
 *  Shapes are defined with respect to the body origin, which may
 *  no coincide with the center of mass. However, to support dynamics
 *  we must interpolate the center of mass position. */
@Properties(inherit = org.bytedeco.liquidfun.presets.liquidfun.class)
public class b2Sweep extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public b2Sweep() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public b2Sweep(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public b2Sweep(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public b2Sweep position(long position) {
        return (b2Sweep)super.position(position);
    }
    @Override public b2Sweep getPointer(long i) {
        return new b2Sweep((Pointer)this).offsetAddress(i);
    }

	/** Get the interpolated transform at a specific time.
	 *  @param beta is a factor in [0,1], where 0 indicates alpha0. */
	public native void GetTransform(b2Transform xfb, @Cast("float32") float beta);

	/** Advance the sweep forward, yielding a new initial state.
	 *  @param alpha the new initial time. */
	public native void Advance(@Cast("float32") float alpha);

	/** Normalize the angles. */
	public native void Normalize();

	/** local center of mass position */
	public native @ByRef b2Vec2 localCenter(); public native b2Sweep localCenter(b2Vec2 setter);
	/** center world positions */
	public native @ByRef b2Vec2 c0(); public native b2Sweep c0(b2Vec2 setter);
	public native @ByRef b2Vec2 c(); public native b2Sweep c(b2Vec2 setter);
	/** world angles */
	public native @Cast("float32") float a0(); public native b2Sweep a0(float setter);
	public native @Cast("float32") float a(); public native b2Sweep a(float setter);

	/** Fraction of the current time step in the range [0,1]
	 *  c0 and a0 are the positions at alpha0. */
	public native @Cast("float32") float alpha0(); public native b2Sweep alpha0(float setter);
}
