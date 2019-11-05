package cr.ac.ucr.sicie.domain;

import java.io.File;

public class ProgramaCurso {

    private int version;
    private boolean vigente;
    private File programaCursoBase;

    public ProgramaCurso() {
    }

    public ProgramaCurso(int version, boolean vigente, File programaCursoBase) {
        this.version = version;
        this.vigente = vigente;
        this.programaCursoBase = programaCursoBase;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public File getProgramaCursoBase() {
        return programaCursoBase;
    }

    public void setProgramaCursoBase(File programaCursoBase) {
        this.programaCursoBase = programaCursoBase;
    }
        
    

}