package client;

import compute.Task;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read implements Task<Answer>, Serializable {

    private final int type;
    private final String code;

    public Read(int type, String code) {
        this.type = type;
        this.code = code;
    }

    public Answer execute() {
        return loadAnswer(type, code);
    }

    public Answer loadAnswer(int type, String code) {

        int status;
        long lStartTime = System.nanoTime();

        String message = getInformation(type, code);

        long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;

        if ( message == "" ) status = 0;
        else status = 1;

        Answer result = new Answer(status, message, output/1000);
        return result;
    }

    public String getInformation(int type, String code) {
        ArrayList<Discipline> dsps = readfile();

        String msg = "", tmp;
        if ( type == 1 ) {
            for (Discipline d : dsps) {
                tmp = all_to_string(d);
                msg += "\n" + tmp;
            }
        }
        else if ( type == 2 ) {
            for (Discipline d : dsps) {
                tmp = info_to_string(d);
                msg += "\n" + tmp;
            }
        }
        else if ( type == 3 ) {
            for (Discipline d : dsps) {
                if ( d.code.equals(code) ) msg = "\n" + all_to_string(d);
            }
        }
        else if ( type == 4 ) {
            for (Discipline d : dsps) {
                if ( d.code.equals(code) ) msg = "\n" + syllabus_to_string(d);
            }
        }
        else if ( type == 5 ) {
            for (Discipline d : dsps) {
                if ( d.code.equals(code) ) msg = "\n" + next_class_to_string(d);
            }
        }
        return msg;
    }

    public String all_to_string(Discipline dsp) {
        return ("Código: " + dsp.code + 
                "\nDisciplina: " + dsp.title +
                "\nEmenta: " + dsp.syllabus +
                "\nSala: " + dsp.classroom +
                "\nHorário: " + dsp.time +
                "\nPróxima aula: " + dsp.next_class + "\n");
    }

    public String info_to_string(Discipline dsp) {
        return ("Código: " + dsp.code + "\nDisciplina: " + dsp.title + "\n");
    }

    public String syllabus_to_string(Discipline dsp) {
        return ("Disciplina: " + dsp.title + "\nEmenta: " + dsp.syllabus + "\n");
    }

    public String next_class_to_string(Discipline dsp) {
        return ("Disciplina: " + dsp.title + "\nPróxima aula: " + dsp.next_class + "\n");
    }

    public ArrayList<Discipline> readfile() {
        int n;

        ArrayList<Discipline> dsps = new ArrayList<Discipline>(10);

        try {

            Scanner scanner = new Scanner(new File("database/database.dat"));
            scanner.useDelimiter(";|\\n");

            n = Integer.parseInt(scanner.next().replace(" " , ""));

            for ( int i = 0; i < n; i++ ){
                Discipline dsp = new Discipline();

                dsp.title = scanner.next();
                dsp.syllabus = scanner.next();
                dsp.classroom = scanner.next();
                dsp.next_class = scanner.next();
                dsp.code = scanner.next();
                dsp.time = Integer.parseInt(scanner.next().replace(" " , ""));

                dsps.add(dsp);
            }
            scanner.close();

        } catch (FileNotFoundException e){
            System.err.println("Weird.");
            e.printStackTrace();
        }

        return dsps;
    }



}