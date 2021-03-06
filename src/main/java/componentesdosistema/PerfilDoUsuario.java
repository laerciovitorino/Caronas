package componentesdosistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



/**
 * 
 * @author Antonio, Diego, Eduardo, Laercio, Rodolfo
 * 
 */

@SuppressWarnings("serial")
@PersistenceCapable 
public class PerfilDoUsuario implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String key;
	
	@Persistent
	private String login;
	@Persistent
	private String senha;
	@Persistent
	private String nome;
	@Persistent
	private String endereco;
	@Persistent
	private String email;

	@Persistent
	private List<String> historicoCaronas;

	@Persistent
	private List<Carona> historicoVagas;
	

	@Persistent
	private int faltasEmCaronas;
	@Persistent
	private int presencaEmCaronas;
	@Persistent
	private int caronasNaoFuncionaram;
	@Persistent
	private int	caronasSeguras;

	/**
	 * Construtor da classe Perfil do Usuario
	 * 
	 * @param login
	 *            Login do usuario
	 * @param login
	 *            Login do Usuario.
	 * @param senha
	 *            Senha do Usuario.
	 * @param nome
	 *            Nome do Usuario.
	 * @param endereco
	 *            Endereco do Usuario.
	 * @param email
	 *            Email do Usuario.
	 * @throws Exception
	 */
	public PerfilDoUsuario(String login, String senha, String nome, String endereco, String email) throws DadosUsuarioException {
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.historicoCaronas = new ArrayList<String>();
		historicoVagas = new ArrayList<Carona>();
		this.faltasEmCaronas = 0;
		this.presencaEmCaronas = 0;
		this.caronasNaoFuncionaram = 0;
		this.caronasSeguras = 0;
	}

	/**
	 * Metodo que retorna as caronas não realizadas
	 * 
	 * @return Caronas nãorealizadas
	 */
	public String getCaronasNaoFuncionaram() {
		return caronasNaoFuncionaram + "";
	}

	/**
	 * Metodo que incrementa o numero de caronas não realizadas
	 */
	public void setCaronasNaoFuncionaram() {
		this.caronasNaoFuncionaram += 1;
	}

	public void setCaronasNaoFuncionaram(String caronasNaoFuncionaram) {
		this.caronasNaoFuncionaram = Integer.parseInt(caronasNaoFuncionaram);
	}

	/**
	 * Metodo que retona as caronas bem sucedidas
	 * 
	 * @return Caronas bem sucedidas
	 */
	public String getCaronasSeguras() {
		return caronasSeguras + "";
	}

	/**
	 * Metodo que atualiza as caronas que foram bem sucedidas
	 */
	public void setCaronasSeguras() {
		this.caronasSeguras += 1;
	}

	public void setCaronasSeguras(String caronasSeguras) {
		this.caronasSeguras = Integer.parseInt(caronasSeguras);
	}

	/**
	 * Metodo que modifica o nome do usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @throws Exception
	 *             Caso o nome seja em branco ou uma String nula
	 */
	public void setNome(String nome) throws DadosUsuarioException {
		if (nome == null || nome.equals("")) {
			throw new DadosUsuarioException("Nome inválido");
		}

		this.nome = nome;
	}

	/**
	 * Metodo que retorna as presencas em caronas do usuario
	 * 
	 * @return Presenca em caronas
	 */
	public String getPresencaCaronas() {
		return String.valueOf(this.presencaEmCaronas);
	}

	/**
	 * Metodo que modifica o numero de presenças na carona, incrementando em um
	 */
	public void setPresencaCaronas() {
		this.presencaEmCaronas += 1;
	}

	/**
	 * Metodo que atualiza as presencas do usuario em caronas
	 */
	public void setPresencaCaronas(String presencaEmVagas) {
		this.presencaEmCaronas = Integer.parseInt(presencaEmVagas);
	}

	/**
	 * Metodo que retorna as faltas do usuario em Caronas
	 * 
	 * @return Faltas do usuario em caronas
	 */
	public String getFaltaCaronas() {
		return String.valueOf(this.faltasEmCaronas);
	}

	/**
	 * Metodo que adiciona uma falta no numero de caronas perdidas
	 */
	public void setFaltaCaronas() {
		this.faltasEmCaronas += 1;
	}

	public void setFaltaCaronas(String num) {
		this.faltasEmCaronas = Integer.parseInt(num);
	}

	/**
	 * Metodo que modifica o email do usuario
	 * 
	 * @param email
	 *            Email do usuario
	 * @throws Exception
	 *             Caso o email seja em branco ou uma String nula
	 */
	public void setEmail(String email) throws DadosUsuarioException {
		if (email == null || email.equals("")) {
			throw new DadosUsuarioException("Email inválido");
		}
		this.email = email;
	}

	/**
	 * Meotod que retorna a senha do usuario
	 * 
	 * @return Senha do usuario
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Metodo que modifica a senha do usuario
	 * 
	 * @param senha
	 *            Senha do usuario
	 * @throws Exception
	 *             Caso a senha seja em branco ou uma String nula
	 */
	public void setSenha(String senha) throws DadosUsuarioException {
		if(senha == null || senha.equals("")){ 
			throw new DadosUsuarioException("Senha inválida");
		}
		
		this.senha = senha;
	}

	/**
	 * Metodo que Retona o login do usuario
	 * 
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Metodo que modifica o login do usuario
	 * 
	 * @param login
	 *            Login do usuario
	 * @throws Exception
	 *             Caso o login seja em branco ou uma String nula
	 */
	public void setLogin(String login) throws DadosUsuarioException {
		if (login == null || login.equals("")) {
			throw new DadosUsuarioException("Login inválido");
		}

		this.login = login;
	}

	/**
	 * Retorna o nome do usuario
	 * 
	 * @return Nome do usuario
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna o endereco do usuario
	 * 
	 * @return Endereco do usuario
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Meotdo que modifica o endereco do usuario
	 * 
	 * @param endereco
	 *            Endereco do usuario
	 * @throws Exception
	 *             Caso o endereco seja em branco ou uma String nula
	 */
	public void setEndereco(String endereco) throws DadosUsuarioException {
		if (endereco == null || endereco.equals("")) {
			throw new DadosUsuarioException("Endereço inválido");
		}
		this.endereco = endereco;
	}

	/**
	 * Metodo que retona o email do usuario
	 * 
	 * @return Email do usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que retorna todas as caronas do usuario
	 * 
	 * @return Todos os IDS das caronas realizadas pelo usuario
	 */
	public String getHistoricoCaronas() {
		String todasCaronas = "";
		
		if (historicoCaronas.isEmpty()) {
			todasCaronas = "[]";
		} else {
			todasCaronas = "[";
			for (String c : historicoCaronas) {
				todasCaronas += c + ",";
			}
			todasCaronas = (todasCaronas + "]").replace(",]", "]");
		}
		return todasCaronas;
	}

	/**
	 * Metodo que retorna todas as vagas em caronas oferecidas pelo usuario
	 * 
	 * @return Vagas em caronas oferecidas pelo usuario
	 */
	public String getHistoricoVagas() {
		String todasVagas = "";
		
		if (this.historicoVagas.isEmpty()) {
			todasVagas = "[]";
		} else {
			todasVagas = "[";
			for (Carona c : this.historicoVagas) {
				todasVagas += c.getID() + ",";
			}
			todasVagas = (todasVagas + "]").replace(",]", "]");
		}
		return todasVagas;
	}

	/**
	 * Metodo que retona um atributo especifico do usuario
	 * 
	 * @param login
	 *            Login do usuario
	 * @param atributo
	 *            Atributo a ser retornado
	 * @return Atributo de escolha do usuario do sistema
	 * @throws Exception
	 *             Caso o atributo nao exista
	 */
	public String getAtributo(String atributo) throws AtributoIlegalException {
		if (atributo.equals("nome")) {
			return this.getNome();
		} 
		else if (atributo.equals("endereco")) {
			return this.getEndereco();
		} 
		else if (atributo.equals("email")) {
			return this.getEmail();
		} 
		else if (atributo.equals("faltas em vagas de caronas")) {
			return this.getFaltaCaronas();
		} 
		else if (atributo.equals("historico de caronas")) {
			return this.getHistoricoCaronas();
		} 
		else if (atributo.equals("historico de vagas em caronas")) {
			return this.getHistoricoVagas();
		}
		else if (atributo.equals("caronas seguras e tranquilas")) {
			return this.getCaronasSeguras();
		}
		else if (atributo.equals("caronas que não funcionaram")) {
			return this.getCaronasNaoFuncionaram();
		}
		else if (atributo.equals("faltas em vagas de caronas")) {
			return this.getFaltaCaronas();
		}
		else if (atributo.equals("presenças em vagas de caronas")) {
			return this.getPresencaCaronas();
		} 
		else {
			throw new AtributoIlegalException("Atributo inexistente");
		}
	}

	/**
	 * Metodo que adiciona uma carona a lista de caronas do usuario
	 * 
	 * @param idCarona
	 *            ID da Carona a ser adicionada
	 */
	public void adicionaCarona(String idCarona) {
		historicoCaronas.add(idCarona);
	}

	/**
	 * Metodo que adiciona uma vaga na carona
	 * 
	 * @param carona
	 *            Carona em qe será adicionada uma vaga
	 */
	public void adicionaVaga(Carona carona) {
		historicoVagas.add(carona);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
