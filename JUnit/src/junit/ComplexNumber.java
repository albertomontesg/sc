package junit;

public class ComplexNumber {
	
	//Constant amb el valor 0.
    public static final ComplexNumber ZERO = new ComplexNumber(0.0, 0.0);

    //Atribut: Part real
    private double real;

    //Atribut: Part imaginaria
    private double imaginary;

    /**
     * Constructor: Inicialitza un nombre complex.
     *
     * @param r - Part real.
     * @param i  - Part imaginari.
     */
    public ComplexNumber(double r, double i) {
        // Asigna valores de parte real y parte imaginary segun argumentos
        this.real = r;
        this.imaginary = i;
    }

    /**
     * Accessor de lectura: Retorna la part real.
     *
     * @return Part real.
     */
    public Double getReal() {
        return this.real;
    }

    /**
     * Accessor d'escriptura: Retorna la part imaginaria.
     *
     * @return Part imaginaria.
     */
    public Double getImaginary() {
        return this.imaginary;
    }

    @Override
	public boolean equals(Object c){
    	if (c instanceof ComplexNumber) {
			ComplexNumber cc = (ComplexNumber) c;
			return (this.real==cc.real && this.imaginary==cc.imaginary);
		}
    	else return false;
    }
    /**
     * Suma dos numeros complexos. El resultat es la add de cada part de manera.
     * individual
     *
     * @param nc Nombre complex a sumar
     * @return Nombre complex resultant.
     */
    public ComplexNumber add(ComplexNumber c) {
        ComplexNumber resultat = new ComplexNumber(this.real + c.getReal().doubleValue(), this.imaginary + c.getImaginary().doubleValue());
        return resultat;
    }
    /**
     * Transforma aquest nombre complex a una cadena de text.
     *
     * @return Cadena de text en format.
     */
    @Override
    public String toString() {
        String resultat = this.real + "";
        if (this.imaginary >= 0.0) {
            resultat += "+" + this.imaginary + "i";
        } else {
            resultat += this.imaginary + "i";
        }
        return resultat;
    }

    /** Acumula els valor d'un nombre complex sobre aquest.
     *
     * @param c Nombre complex a sumar
     */
    public void accumulate(ComplexNumber c) {
        this.real = this.real + c.getReal();
        this.imaginary = this.imaginary + c.getImaginary();
    }

    /**
     * Calcula a Modul de format polar. 
     * 
     * @return Modul
     */
    public double getModulus() {
        if (real!=0 || imaginary!=0) {
            return Math.sqrt(real*real+imaginary*imaginary);
        } else {
            return 0d;
        }
    }

    /**
     * Calcula arc de format polar.
     *
     * @return modul
     */
    public double getArc() {
        return Math.toDegrees(Math.atan2(imaginary,real));
    }

    
    public ComplexNumber getComplexConjugate() {
    	return new ComplexNumber(this.real, -this.imaginary);
    }
    
    public ComplexNumber product(ComplexNumber c) {
		Double r = this.real*c.getReal()-this.imaginary*c.getImaginary();
    	Double i = this.imaginary*c.getReal() + this.real*c.getImaginary();
    	
    	return new ComplexNumber(r,i);
    	
    }
    
    public ComplexNumber division(ComplexNumber c) {
    	ComplexNumber temp = this.product(c.getComplexConjugate());
    	double r = temp.real / (c.getModulus()*c.getModulus());
    	double i = temp.imaginary / (c.getModulus()*c.getModulus());
    	
    	return new ComplexNumber(r,i);
    }

}
