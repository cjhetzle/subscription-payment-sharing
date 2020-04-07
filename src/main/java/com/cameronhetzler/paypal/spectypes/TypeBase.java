package com.cameronhetzler.paypal.spectypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.paypal.base.rest.JSONFormatter;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Cameron Hetzler
 *
 * @param <T>
 */
public abstract class TypeBase<T> {

	@Getter @Setter
	protected T instance;
	
	public TypeBase(T instance) {
		this.instance = instance;
	}
	
	protected <C> C load(String jsonFile, Class<C> clazz) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					getClass().getClassLoader().getResource(jsonFile).getFile())));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
		
			while (line != null) {
				sb.append(line);
				sb.append(System.getProperty("line.separator"));
				line = br.readLine();
			}
			return (C)JSONFormatter.fromJSON(sb.toString(), clazz);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
