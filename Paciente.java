public class Paciente implements Comparable <Paciente> {

    private String nombre;
    private String descSintoma;
    private char emergencia;

    public Paciente (String nombre, String descSintoma, char emergencia) {
        this.nombre = nombre;
        this.descSintoma = descSintoma;
        this.emergencia = emergencia;
    }

    public char getEmergencia() {
        return emergencia;
    }

    @Override
    public int compareTo(Paciente paciente) {
        int emergeciaP = paciente.getEmergencia();
        if (emergeciaP < this.emergencia){
            return 1;
        } 
        if (emergeciaP > this.emergencia) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %c",this.nombre, this.descSintoma, this.emergencia);
    }
    
}
