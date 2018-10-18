package com.gradescope.hw4;

/**
 * Complex class
 * 
 * This class creates objects that can represent complex numbers
 * 
 * It uses two data members, real and imaginary, both doubles
 * 
 */
public class Complex {

    /**
     * Fields
     */
    private double real;
    private double imaginary;

    /**
     * Constructors
     */
    public Complex(double real_in, double imag_in) {
        this.real = real_in;
        this.imaginary = imag_in;
    }

    public Complex() {
        this(0.0,0.0);  // calls the constructor above
    }

    /**
     * Getters and setters
     */
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // more info about getClass():
        // https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#getClass()
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        // The parentheses on the next line of code are doing a "cast"
        // We'll learn about this later in CS60.
        Complex other = (Complex) obj; 
        double epsilon = 0.0001;
        if (Math.abs(this.getReal() - other.getReal()) > epsilon) {
            return false;
        }
        if (Math.abs(this.getImaginary() - other.getImaginary()) > epsilon) {
            return false;
        }
        return true;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
		return "Complex [real=" + this.real + ", imaginary=" + this.imaginary + "]";
    }

    /**
     * add computes a new Complex obj that is the sum of this and other
     * 
     * Addition of two complex numbers 'a + bi' and 'c + di' is defined as: 
     *     (a + bi) + (c + di) = (a+c) + (b+d)i
     *     
     * @param other the second addend
     * @return the new Complex object
     */
    public Complex add(Complex other) {
    	return new Complex(this.real + other.real, this.imaginary + other.imaginary); 	
    }


    /**
     * addDest is a _destructive_ addition of another complex number into this
     * one; the input does not change
     * @param other another Complex number
     */
    public void addDest(Complex other) {
    	Complex added = this.add(other);
    	this.real = added.getReal();
    	this.imaginary = added.getImaginary();
    }

    /**
     * returns the product of this and other
     *
     * Multiplication of two complex numbers 'a + bi' and 'c + di' 
     * is defined as: 
     *     (a + bi) * (c + di) 
     *   = ac + adi + bci + bd(i^2)
     *   = (ac - bd) + (ad + bc)i 
     *
     * @param other another Complex object
     * @return their product
     */
    public Complex multiply(Complex other) {
        double real = this.real * other.real - this.imaginary * other.imaginary;
        double imaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex (real, imaginary);
    }

    /**
     * negate returns a new Complex, the additive inverse of this
     * @return the additive inverse of this (a new object)
     */
    public Complex negate() {
        return new Complex (-1*this.real, -1*this.imaginary);
    }

    /**
     * negateDest does *not* create a new Complex, but simply changes the
     * fields of this object (this.real and this.imaginary)
     */
    public void negateDest() {
        Complex negated = this.negate();
        this.real = negated.getReal();
        this.imaginary = negated.getImaginary();
        
    }

    /**
     * conjugate creates a new Complex object holding this's conjugate
     * 
     * The conjugate of a Complex number 'a + bi' is defined as:
     *    a - bi
     * 
     * @return the conjugate of this
     */
    public Complex conjugate() {
        return new Complex(this.real, -this.imaginary);
    }

    /**
     * conjugateDest does *not* create a new Complex, but simply changes the
     * fields of this object (this.real and this.imaginary)
     */
    public void conjugateDest() {
        Complex conjugation = this.conjugate();
        this.real = conjugation.getReal();
        this.imaginary = conjugation.getImaginary();
    }

    /**
     * compute the distance of this from the origin
     * 
     * The Pythagorean Theorem tells us that the magnitude of a complex number
     * 'a + bi' is given by: 
     *     square-root( a*a + b*b )
     * 
     * @return the magnitude of this
     */
    public double magnitude() {
        return Math.sqrt(this.real*this.real + this.imaginary*this.imaginary);
    }

    /**
     * returns the quotient:  this/other 
     * 
     * If other == 0, returns Double.NaN + Double.NaN * i
     * 
     * The quotient of two complex numbers 'a + bi' and 'c + di' can be computed
     * using the conjugate of the numerator:
     * 
     *        a + bi
     *        ------
     *        c + di
     *    
     *        
     *        a + bi     c - di
     *   =    ------  .  ------
     *        c + di     c - di
     *        
     *        
     *        ac - adi + bci - bdii
     *   =    ---------------------
     *              cc - ddii
     *
     *
     *   =    (ac + bd) + (bc - ad)i
     *        ----------------------
     *               cc + dd
     *    
     *             
     *        (ac + bd)   (bc - ad)
     *   =    --------- + --------- i
     *         cc + dd     cc + dd
     * 
     * @param other the divisor
     * @return the quotient
     */
    public Complex divide(Complex other) {
    	double a = this.getReal();
    	double b = this.getImaginary();
    	double c = other.getReal();
    	double d = other.getImaginary();
        return new Complex((a*c+b*d)/(c*c+d*d), (b*c-a*d)/(c*c+d*d));
    }
}

