/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.bussines.EnfasisBusiness;
import cr.ac.ucr.sicie.domain.Enfasis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EnfasisDataTest {

    @Autowired

    EnfasisData enfasisData;
    
    @Test
    public void insertarEnfasis(){
        Enfasis enfasis = new Enfasis(null, 01, "Redes");
        enfasisData.insertarEnfasis(enfasis);
    }
    
    @Test
    public void listarEnfasis() {
        
        Iterator<String> x =  enfasisData.buscarEnfasisBySiglaCurso("if555");
        while(x.hasNext()) {
            System.out.print(x.next());
        }
    }
    
    @Test
    public void buscarEnfasisBySiglaCurso(){
        enfasisData.buscarEnfasisBySiglaCurso("IF500");
    }
    
    @Test
    public void eliminarEnfasis(){
        enfasisData.eliminarEnfasis("01");
    }
}
