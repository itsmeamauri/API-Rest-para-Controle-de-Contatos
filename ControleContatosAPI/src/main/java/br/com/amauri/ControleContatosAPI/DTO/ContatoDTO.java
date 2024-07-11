package br.com.amauri.ControleContatosAPI.DTO;

public record ContatoDTO(long id, int tipo, String contato, long pessoaId) {

	public long getPessoaId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTipo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getContato() {
		// TODO Auto-generated method stub
		return null;
	}

}
