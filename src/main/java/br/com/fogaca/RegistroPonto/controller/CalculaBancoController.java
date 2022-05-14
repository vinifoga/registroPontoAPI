package br.com.fogaca.RegistroPonto.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fogaca.RegistroPonto.controller.dto.ColaboradorDto;
import br.com.fogaca.RegistroPonto.model.Registro;
import br.com.fogaca.RegistroPonto.service.CalculaBancoService;
import br.com.fogaca.RegistroPonto.service.RegistroService;

@RestController
@RequestMapping("/calcula-banco")
public class CalculaBancoController {
	
	@Autowired CalculaBancoService calculaService;
	@Autowired RegistroService registroService;
	
	@GetMapping("/{id}")
	public ResponseEntity<LocalTime> calculaBanco(@PathVariable Long id) {
		LocalTime hoje = LocalTime.now();
		LocalTime calculaBanco;
		try {
			List<Registro> listaRegistro = registroService.findByColaborador_Matricula(id);
			calculaBanco = calculaService.calculaBanco(id,listaRegistro);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(calculaBanco);
		
	}
	
}
