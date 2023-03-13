package main.exameninterfaces;

public class Alumno {
    private String nombre;
    private String apellidos;
    private int ad;
    private int sge;
    private int di;
    private int pmdm;
    private int psp;
    private int eie;
    private int hlc;

    public Alumno(String nombre, String apellidos, int ad, int sge, int di, int pmdm, int psp, int eie, int hlc) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ad = ad;
        this.sge = sge;
        this.di = di;
        this.pmdm = pmdm;
        this.psp = psp;
        this.eie = eie;
        this.hlc = hlc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getAd() {
        return ad;
    }

    public int getSge() {
        return sge;
    }

    public int getDi() {
        return di;
    }

    public int getPmdm() {
        return pmdm;
    }

    public int getPsp() {
        return psp;
    }

    public int getEie() {
        return eie;
    }

    public int getHlc() {
        return hlc;
    }

    public double getNotaMedia() {
        int[] notas = {ad, sge, di, pmdm, psp, eie, hlc};
        int suma = 0;
        int numAprobados = 0;
        for (int nota : notas) {
            suma += nota;
            if (nota >= 5) {
                numAprobados++;
            }
        }
        int media = suma / notas.length;
        return numAprobados == notas.length ? media : -1;
    }

    public int getNumModulosSuspensos() {
        double[] notas = {ad, sge, di, pmdm, psp, eie, hlc};
        int numSuspensos = 0;
        for (double nota : notas) {
            if (nota < 5) {
                numSuspensos++;
            }
        }
        return numSuspensos;
    }

    public boolean comprobacionNotas(int ad, int sge, int di, int pmdm, int psp, int eie, int hlc) {
        double[] notas = {ad, sge, di, pmdm, psp, eie, hlc};
        for (double nota : notas) {
            if (nota < 0 || nota > 10) {
                return false;
            }
        }
        return true;
    }
}
