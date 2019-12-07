/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.Bloque;
import cr.ac.ucr.sicie.domain.Curso;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest

public class BloqueDataTest {
    
       @Autowired
	private Bloque bloque;
        private BloqueData bloqueData;
	
        
        @Test
	public void listarBloque() {
           bloqueData.buscarBloquePorCurso("");
        }
}
