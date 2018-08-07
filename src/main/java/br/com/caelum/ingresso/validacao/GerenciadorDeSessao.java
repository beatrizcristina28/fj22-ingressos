package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala){
		this.sessoesDaSala = sessoesDaSala;
	}
	
	private static boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova){
		
		boolean terminaAntes = sessaoNova.getHorarioTermino()
				.isBefore(sessaoExistente.getHorario());
		boolean comecaDepois = sessaoNova.getHorario()
				.isAfter(sessaoExistente.getHorarioTermino());
		
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;
		


	}
	
	public boolean cabe(Sessao sessaoNova){
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> 
		horarioIsConflitante(sessaoExistente, sessaoNova));
	}
}
