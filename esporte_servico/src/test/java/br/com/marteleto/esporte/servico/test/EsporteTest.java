package br.com.marteleto.esporte.servico.test;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

import br.com.marteleto.esporte.servico.controller.GrupoControllerIntegrationTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GrupoControllerIntegrationTest.class,
})
public class EsporteTest implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static final transient Logger logger = Logger.getLogger(EsporteTest.class.getName());
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(EsporteTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}
