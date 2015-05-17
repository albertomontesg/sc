package junit;

public class Main {

	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(1.0,1.0);
        System.out.println("Hem creat el Nombre Complex: " + c1);
        System.out.println("\t Part real = " + c1.getReal());
        System.out.println("\t Part imaginaria = " + c1.getImaginary());
        System.out.println("\t -----------------");
        System.out.println("\t Modul = " + c1.getModulus());
        System.out.println("\t Arc = " + c1.getArc() + "º");
	}

}
