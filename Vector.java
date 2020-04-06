package com.eonsahead.swing;

/**
 * 
 *  The 4 elements for Exercise 1. By creating this file, I searched a lot of 
 *  sourse from google and using some ideas from classmates to get the exercise.
 * @author Minrui Yang
 * @version 4 April 2020
 */
public class Vector {
    
    private double a;
    private double b;
    private double c;
    private double h;
    
// just setting up values
    public Vector() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.h = 0;
    }// setting these 4 values into 0. 
    
    
    
    /**
     * using these vectors to represent x,y,z coordinates.
     * a represent x-axis 
     * b represent y-axis
     * c represent z-axis
     * h represent the homogeneous coordinate is set to 1.
     */
    public Vector(double a, double b double c {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = 1;
    }// Vector(double, double, double)
    
    /**
     * Creates a 4 element vector where each element is specified.
    
     */
    public Vector(double x, double y, double z, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }// Vector(double, double, double, double)

    
    /**
     * Returns the values in these vectors
     * 
     * 
     * 
     * @param position represent the value in this position
     */
    public double get(int position) {
        if(position < 0 || position > 3) {
            throw new ArrayIndexOutOfBoundsException("Position " + position 
                                                    + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            case 2:
                return this.c;
        }// switch
        return this.h;
    } // get(int)

    
     /**
     * Changes the value at a specified position in this vector.
     * This is created just in case for some accident happened.
     * 
     * @param position An integer from 0 to 3 representing the position of the 
     * change in this vector.
     * @param value The new number that the position will be changed to.
     */
    public void set(int position, double value) {
        if(position < 0 || position > 3) {
            throw new ArrayIndexOutOfBoundsException("Position " + position 
                                                    + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                this.a = value;
            case 1:
                this.b = value;
            case 2:
                this.c = value;
            case 3:
                this.h = value;
        }// switch
    }// set(int, double)
    
    
    /**
     * Returns a string representation of this vector.
     * 
     * @return A string representation of this vector.
     */
    @Override
    public String toString() {
        return "(" + this.a + ", " + this.b+ ", " 
                + this.c + ", " + this.h + ")";
    }// toString()
    
    
    /**
     * Adds the x, y, and z positions of this vector and 
     * another vector of 4 elements together.
     * 
     * @param v A vector of 4 elements to be added to this vector.
     * @return A vector of 4 elements that is the sum of the other two vectors 
     * at the x, y and z positions. The homogeneous coordinate position is 
     * set equal to 1.
     */
    public Vector add(Vector v) {
        double sumA = this.a + v.a;
        double sumB = this.b + v.b;
        double sumC = this.c + v.c;
        return new Vector(sumA, sumB, sumC);
    }// add(Vector)
    
    
    /**
     * Subtracts the x, y, and z positions of this vector and
     * another vector 4 elements. 
     * 
     * @param v A vector of 4 elements to be subtracted from this vector.
     * @return A vector of 4 elements that is the difference of the other
     * two vectors at the x, y, and z positions. The homogeneous coordinate
     * position is set to 1.
     */
    public Vector subtract(Vector v) {
        double diffA = this.a - v.a;
        double diffB = this.b = v.b;
        double diffC = this.c - v.c;
        return new Vector(diffA, diffB, diffC);
    }// subtract(Vector)
    
    
    /**
     * Dot multiplies the x, y, and z positions in this vector 
     * with the x, y, and z positions of another vector of 4 elements.
     * 
     * @param v A vector of 4 elements to be multiplied with this vector.
     * @return A number that is the product of the dot multiplication of the 
     * x, y, and z positions other two vectors.
     */
    public double dot(Vector v) {
        return this.a * v.a + this.b * v.b + this.c * v.c;
    }// dot(Vector v)
    
    
    /**
     * Returns the magnitude of this vector using the x, y, and z positions.
     * 
     * 
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }// magnitude()
    
    
    /**
     * Normalizes this vector such that it has the same direction but has
     * a magnitude (length) equal to 1 according to the x, y, and z positions.
     * 
     * @return A new vector with the same direction as this vector but a
     * magnitude equal to 1 according to the x, y, and z positions. The 
     * homogeneous coordinate position is set to 1.
     */
    public Vector normalize() {
        double magnitude = this.magnitude();
        Vector newV = new Vector();
        for(int i = 0; i < 3; i++) {
            double newValue = this.get(i) / magnitude;
            newV.set(i, newValue);
        }// for
        newV.set(3, 1);
        return newV;
    }// normalize()
    
    
    /**
     * Creates a 4 element vector that is the result of a cross multiplication
     * between this vector and another 4 element vector.
     * 
     * 
     * @param v Another 4 element vector which is to be cross multiplied with 
     * this 4 element vector.
     * @return A 4 element vector that represents a vector in 3D space that 
     * is perpendicular to the other two vectors. 
     */
    public Vector cross(Vector v) {
        double newA = this.b * v.c - this.c * v.b;
        double newB = this.c * v.a - this.a * v.c;
        double newC = this.a * v.b - this.b * v.a;
        return new Vector(newA, newB, newC);
    }// cross()
    
}// Vector
