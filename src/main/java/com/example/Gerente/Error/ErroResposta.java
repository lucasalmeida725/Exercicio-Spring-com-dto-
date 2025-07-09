package com.example.Gerente.Error;

public class ErroResposta {
	private String mensagem;

	public ErroResposta(String mensagem) {

		this.mensagem = mensagem;
	}

	public static ErroResposta respostaPadrao(String mensagem) {
		return new ErroResposta(mensagem);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
