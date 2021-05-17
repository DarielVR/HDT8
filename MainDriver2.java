import java.util.ArrayList;
import java.util.PriorityQueue;

public class MainDriver2 {
    
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("Pacientes.txt");
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

        //Ingreso de pacientes en el documento de texto
        ArrayList<String[]> dataPaciente = fileManager.stringList(",");
        for (String[] strings : dataPaciente) {
            Paciente nuevoPaciente = new Paciente(strings[0], strings[1], strings[2].charAt(0));
            pacientes.add(nuevoPaciente);
        }

        //Salida de cada paciente
        while (!pacientes.isEmpty()) {
            Paciente pacienteAtendido = pacientes.remove();
            System.out.println(pacienteAtendido.toString());
        }
    }

}
