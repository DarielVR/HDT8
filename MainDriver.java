import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;

import junit.framework.Assert;

public class MainDriver {
    
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("Pacientes.txt");
        VectorHeap<Paciente> pacientes = new VectorHeap<>();

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

    @Test
    public void testInsercionHeap() {
        Vector<Paciente> prueba = new Vector<>();
        prueba.add(new Paciente("n","d",'A'));
        prueba.add(new Paciente("n","d",'B'));
        prueba.add(new Paciente("n","d",'E'));
        prueba.add(new Paciente("n","d",'C'));

        VectorHeap<Paciente> pacientes = new VectorHeap<>();
        pacientes.add(new Paciente("n","d",'C'));
        pacientes.add(new Paciente("n","d",'A'));
        pacientes.add(new Paciente("n","d",'E'));
        pacientes.add(new Paciente("n","d",'B'));

        Assert.assertEquals(prueba, pacientes.data);
    }

    @Test
    public void testEliminacionHeap() {
        Vector<Paciente> prueba = new Vector<>();
        prueba.add(new Paciente("n","d",'A'));
        prueba.add(new Paciente("n","d",'B'));
        prueba.add(new Paciente("n","d",'C'));
        prueba.add(new Paciente("n","d",'E'));

        VectorHeap<Paciente> pacientes = new VectorHeap<>();
        pacientes.add(new Paciente("n","d",'C'));
        pacientes.add(new Paciente("n","d",'A'));
        pacientes.add(new Paciente("n","d",'E'));
        pacientes.add(new Paciente("n","d",'B'));

        Vector<Paciente> obtenido = new Vector<>();
        obtenido.add(pacientes.remove());
        obtenido.add(pacientes.remove());
        obtenido.add(pacientes.remove());
        obtenido.add(pacientes.remove());

        Assert.assertEquals(new Vector<>(), pacientes.data);
        Assert.assertEquals(prueba, obtenido);
    }
}
