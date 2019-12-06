/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.bussines.RequisitoBusiness;
import cr.ac.ucr.sicie.domain.PlanEstudios;
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

public class RequisitoBusinessTest {
    @Autowired
	private RequisitoBusiness requisitoBusiness;

        @Test
	public void requisitoTest() {
            
           requisitoBusiness.buscarCursosRequisito("");
        }
}
