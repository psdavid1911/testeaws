package FluxoDeArquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FluxoBeans<T> {
	GerenciadorDeArquivo arquivo;

	public FluxoBeans(String caminhoNomeDoArquivo) {
		arquivo = new GerenciadorDeArquivo(caminhoNomeDoArquivo);
	}

	public void escreve(T objeto) {
		try {
			FileOutputStream     fos = new FileOutputStream(arquivo);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream   oos = new ObjectOutputStream(bos);
			oos.writeObject(objeto);
			oos.close();
		} catch(Exception e) {} finally {}
	}

	public T le() {
		try {
			FileInputStream     fis     = new FileInputStream(arquivo);
			BufferedInputStream bis     = new BufferedInputStream(fis);
			ObjectInputStream   ois     = new ObjectInputStream(bis);
			@SuppressWarnings("unchecked") T entrada = (T) ois.readObject();
			ois.close();
			return entrada;
		} catch(Exception e) {} finally {}
		return null;
	}

	public void apaga() {
		arquivo.apaga();
	}

	public boolean existe() {
		return arquivo.existe();
	}

	// PODE VIRAR ATRIBUTO
	public String caminho() {
		return arquivo.caminhoCompleto();
	}

}
